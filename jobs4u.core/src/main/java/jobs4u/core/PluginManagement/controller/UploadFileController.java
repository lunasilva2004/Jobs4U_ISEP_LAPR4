package jobs4u.core.PluginManagement.controller;

import Other.InterviewModel_EX1;
import Other.JobRequirementsSpecification_EX1;
import eapli.framework.application.UseCaseController;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import jakarta.transaction.Transactional;
import jobs4u.core.PluginManagement.FileService;
import jobs4u.core.jobapplicationmanagement.domain.FileJobApp;
import jobs4u.core.jobapplicationmanagement.domain.JobApplication;
import jobs4u.core.jobapplicationmanagement.repositories.JobApplicationRepository;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;
import jobs4u.core.jobopeningmanagement.repositories.JobOpeningRepository;
import jobs4u.core.infrastructure.persistence.PersistenceContext;
import jobs4u.core.usermanagement.domain.BaseRoles;
import jobs4u.core.jobopeningmanagement.domain.PhaseType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This controller is responsible for handling file uploads related to job applications and job openings.
 * It also provides methods to retrieve job openings and job applications based on different criteria.
 */
@UseCaseController
public class UploadFileController {

    // Transactional context
    private final TransactionalContext autoTx = PersistenceContext.repositories().newTransactionalContext();
    // Authorization service
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    // Repository for job openings
    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings(autoTx);
    // Repository for job applications
    private final JobApplicationRepository jobApplicationRepository = PersistenceContext.repositories().jobApplications(autoTx);
    // An instance of the InterviewModel_EX1 class. This class is responsible for checking the syntax of the interview model files.
    private final InterviewModel_EX1 interviewModel_ex1 = new InterviewModel_EX1();
    // An instance of the JobRequirementsSpecification_EX1 class. This class is responsible for checking the syntax of the job requirements specification files.
    private final JobRequirementsSpecification_EX1 jobRequirementsSpecification_ex1 = new JobRequirementsSpecification_EX1();
    // An instance of the FileService class. This class provides methods for file operations such as creating directories and moving files.
    private final FileService fileService = new FileService();

    /**
     * Retrieves all job openings that are in the interview phase.
     *
     * @return a list of job openings in the interview phase.
     */
    public List<JobOpening> getAllInterviewsJobOpenings() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        Iterable<JobOpening> jobOpenings = jobOpeningRepository.findJobOpeningsByPhase(PhaseType.INTERVIEWS);
        List<JobOpening> jobOpeningList = new ArrayList<>();
        jobOpenings.forEach(jobOpeningList::add);
        return jobOpeningList;
    }

    /**
     * Retrieves a job opening in the interview phase by its index in the list of all job openings in the interview phase.
     *
     * @param index the index of the job opening in the list.
     * @return the job opening at the specified index.
     */
    public JobOpening getInterviewsJobOpeningByIndex(int index) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        return getAllInterviewsJobOpenings().get(index);
    }

    /**
     * Retrieves all job openings that are in the screening phase.
     *
     * @return a list of job openings in the screening phase.
     */
    public List<JobOpening> getAllScreeningJobOpenings() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.OPERATOR);
        Iterable<JobOpening> jobOpenings = jobOpeningRepository.findJobOpeningsByPhase(PhaseType.SCREENING);
        List<JobOpening> jobOpeningList = new ArrayList<>();
        jobOpenings.forEach(jobOpeningList::add);
        return jobOpeningList;
    }

    /**
     * Retrieves a job opening in the screening phase by its index in the list of all job openings in the screening phase.
     *
     * @param index the index of the job opening in the list.
     * @return the job opening at the specified index.
     */
    public JobOpening getScreeningJobOpeningByIndex(int index) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.OPERATOR);
        return getAllScreeningJobOpenings().get(index);
    }

    /**
     * Retrieves all job applications for a specific job reference.
     *
     * @param jobReference the job reference.
     * @return a list of job applications for the specified job reference.
     */
    public List<JobApplication> getJobApplicationsByJobReference(Designation jobReference) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.OPERATOR);
        Iterable<JobApplication> jobApplications = jobApplicationRepository.findByJobReference(jobReference);
        List<JobApplication> jobApplicationsList = new ArrayList<>();
        jobApplications.forEach(jobApplicationsList::add);
        return jobApplicationsList;
    }

    /**
     * Retrieves a job application by its index in the list of all job applications for a specific job reference.
     *
     * @param index        the index of the job application in the list.
     * @param jobReference the job reference.
     * @return the job application at the specified index.
     */
    public JobApplication getJobApplicationByIndex(int index, Designation jobReference) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.OPERATOR);
        return getJobApplicationsByJobReference(jobReference).get(index);
    }

    /**
     * Uploads an interview file for a specific job opening and job application.
     *
     * @param filePath               the path of the file to upload.
     * @param selectedJobOpening     the job opening for which the file is being uploaded.
     * @param selectedJobApplication the job application for which the file is being uploaded.
     * @return true if the file was uploaded successfully, false otherwise.
     */
    public boolean uploadInterviewsFile(String filePath, JobOpening selectedJobOpening, JobApplication selectedJobApplication) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);

        // Create a directory for the selected job opening if it doesn't exist
        try {
            fileService.createDirectoryIfNotExistsJP(selectedJobOpening);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        // Create a directory for the selected job application inside the job opening directory
        try {
            fileService.createDirectoryIfNotExistsJA(selectedJobOpening, selectedJobApplication);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        // Move the file to the job application directory
        try {
            String newPath = fileService.moveFileJA(filePath, selectedJobOpening, selectedJobApplication);

            // Save the new FileJobApp into the database and associate it with the JobApplication
            saveFileJobApp(selectedJobApplication, newPath);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * Verifies the syntax of an interview file.
     *
     * @param filePath the path of the file to verify.
     * @return true if the file syntax is correct, false otherwise.
     */
    public boolean verifyInterviewSyntax(String filePath) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        return interviewModel_ex1.isFileSyntaxCorrect(filePath);
    }

    /**
     * Verifies the syntax of a job requirements file.
     *
     * @param filePath the path of the file to verify.
     * @return true if the file syntax is correct, false otherwise.
     */
    public boolean verifyRequirementsSyntax(String filePath) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.OPERATOR);
        return jobRequirementsSpecification_ex1.isFileSyntaxCorrect(filePath);
    }

    /**
     * Uploads a job requirements file for a specific job opening and job application.
     *
     * @param filePath               the path of the file to upload.
     * @param selectedJobOpening     the job opening for which the file is being uploaded.
     * @param selectedJobApplication the job application for which the file is being uploaded.
     * @return true if the file was uploaded successfully, false otherwise.
     */
    public boolean uploadRequirementsFile(String filePath, JobOpening selectedJobOpening, JobApplication selectedJobApplication) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.OPERATOR);
        // Create a directory for the selected job opening if it doesn't exist
        try {
            fileService.createDirectoryIfNotExistsJPRequirements(selectedJobOpening);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        // Create a directory for the selected job application inside the job opening directory
        try {
            fileService.createDirectoryIfNotExistsJARequirements(selectedJobOpening, selectedJobApplication);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        // Move the file to the job application directory
        try {
            String newPath = fileService.moveFileJARequirements(filePath, selectedJobOpening, selectedJobApplication);

            // Save the new FileJobApp into the database and associate it with the JobApplication
            saveFileJobApp(selectedJobApplication, newPath);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * This method is responsible for saving a file associated with a job application.
     * It creates a new FileJobApp instance with the provided file path and adds it to the job application's list of files.
     * The updated job application is then saved in the job application repository.
     *
     * @param selectedJobApplication The job application for which the file is being saved.
     * @param newPath                The new path of the file after it has been moved to the job application directory.
     */
    @Transactional
    public void saveFileJobApp(JobApplication selectedJobApplication, String newPath) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.OPERATOR);
        FileJobApp fileJobApp = new FileJobApp(newPath);

        selectedJobApplication.toDTO().getFile().add(fileJobApp);
        jobApplicationRepository.save(selectedJobApplication);
    }
}
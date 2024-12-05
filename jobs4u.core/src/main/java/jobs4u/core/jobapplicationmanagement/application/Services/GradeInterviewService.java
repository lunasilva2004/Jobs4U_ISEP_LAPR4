package jobs4u.core.jobapplicationmanagement.application.Services;

import Other.InterviewModel_EX1;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import jakarta.transaction.Transactional;
import jobs4u.core.jobapplicationmanagement.domain.InterviewGrade;
import jobs4u.core.jobapplicationmanagement.domain.JobApplication;
import jobs4u.core.jobapplicationmanagement.repositories.JobApplicationRepository;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;
import jobs4u.core.jobopeningmanagement.domain.PhaseType;
import jobs4u.core.jobopeningmanagement.repositories.JobOpeningRepository;
import jobs4u.core.usermanagement.domain.BaseRoles;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Grade interview service.
 */
public class GradeInterviewService {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final InterviewModel_EX1 interviewModel_ex1;
    private final JobApplicationRepository jobApplicationRepository;

    private final JobOpeningRepository jobOpeningRepository;

    /**
     * Instantiates a new Grade interview service.
     *
     * @param jobApplicationRepository the job application repository
     * @param interviewModel_ex1       the interview model ex 1
     * @param jobOpeningRepository     the job opening repository
     */
    public GradeInterviewService(JobApplicationRepository jobApplicationRepository, InterviewModel_EX1 interviewModel_ex1, JobOpeningRepository jobOpeningRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
        this.interviewModel_ex1 = interviewModel_ex1;
        this.jobOpeningRepository = jobOpeningRepository;
    }

    @Transactional
    /**
     * Grade interview boolean.
     *
     * @param jobReference the job reference
     * @return the boolean
     */
    public boolean gradeInterview(Designation jobReference) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);

        boolean evaluated = false;

        List<JobOpening> jobOpeningByPhase = jobOpeningRepository.findJobOpeningsByPhase(PhaseType.ANALYSIS);

        if (!jobOpeningByPhase.isEmpty()) {
            for (JobOpening jobOpening : jobOpeningByPhase) {

                if (jobOpening.getJobReference().equals(jobReference)) {

                    if (jobOpening.getInterview() != null) {

                        List<JobApplication> jobApplications = jobApplicationRepository.findByJobReference(jobReference);

                        for (JobApplication jobApplication : jobApplications) {
                            String candidateAnswersFolder = "docs/CandidateAnswers/" + jobReference + "/" + jobApplication.identity();

                            File folder = new File(candidateAnswersFolder);

                            if (folder.exists() && folder.isDirectory()) {

                                File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));
                                if (files != null) {

                                    for (File file : files) {
                                        Path candidateFilePath = file.toPath();

                                        try {
                                            if (!interviewModel_ex1.isFileSyntaxCorrect(candidateFilePath.toString())) {
                                                throw new RuntimeException("Syntax error in candidate answers file: " + candidateFilePath);
                                            }

                                            String correctAnswersFilePath = "InterviewModelExample.txt";

                                            List<String> candidateAnswersFilePaths = new ArrayList<>();
                                            candidateAnswersFilePaths.add(candidateFilePath.toString());

                                            List<String> evaluationResults = interviewModel_ex1.evaluateMultipleFiles(correctAnswersFilePath, candidateAnswersFilePaths);

                                            String evaluationResult = evaluationResults.get(0);
                                            int grade = Integer.parseInt(evaluationResult.replaceAll("[^0-9]", ""));

                                            jobApplication.setInterviewGrade(new InterviewGrade(grade));
                                            jobApplicationRepository.save(jobApplication);

                                            evaluated = true;

                                        } catch (Exception e) {
                                            throw new RuntimeException("Error processing candidate answers file: " + candidateFilePath, e);
                                        }
                                    }
                                } else {
                                    String errorMsg = "No .txt files found in directory: " + candidateAnswersFolder;
                                    throw new IllegalArgumentException(errorMsg);
                                }
                            } else {
                                String errorMsg = "Candidate answers folder not found or not a directory for job application: " + jobApplication.identity();
                                throw new IllegalArgumentException(errorMsg);
                            }
                        }
                    } else {
                        String errorMsg = "This job opening doesn't have an interview model: " + jobOpening.identity();
                        throw new IllegalArgumentException(errorMsg);
                    }
                }
            }
        } else {
            String errorMsg = "There are no job openings in the ANALYSIS phase.";
            throw new IllegalArgumentException(errorMsg);
        }

        return evaluated;

    }
}


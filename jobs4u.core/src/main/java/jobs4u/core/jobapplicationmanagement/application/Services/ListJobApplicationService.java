package jobs4u.core.jobapplicationmanagement.application.Services;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.Designation;
import jakarta.transaction.Transactional;
import jobs4u.core.customerusermanagement.domain.Email;
import jobs4u.core.infrastructure.persistence.PersistenceContext;
import jobs4u.core.jobapplicationmanagement.domain.JobApplication;
import jobs4u.core.jobapplicationmanagement.domain.State;
import jobs4u.core.jobapplicationmanagement.dto.JobApplicationDTO;
import jobs4u.core.jobapplicationmanagement.repositories.JobApplicationRepository;
import jobs4u.core.jobopeningmanagement.dto.JobOpeningDTO;
import jobs4u.core.jobopeningmanagement.repositories.JobOpeningRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The type List job application service.
 */
@Service
public class ListJobApplicationService {

    private final TransactionalContext autoTx = PersistenceContext.repositories().newTransactionalContext();
    private final JobApplicationRepository jobApplicationRepository = PersistenceContext.repositories().jobApplications(autoTx);
    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings(autoTx);

    /**
     * List job applications for candidate list.
     *
     * @param email the email
     * @return the list
     */
    public List<String> listJobApplicationsForCandidate(Email email) {
        List<JobApplication> candidateApplications = jobApplicationRepository.findByCandidateEmail(email);
        if (candidateApplications.isEmpty()) {
            return Collections.singletonList("No job applications found for this candidate.");
        }
        return addApplicationDetails(candidateApplications);
    }

    private List<String> addApplicationDetails(List<JobApplication> candidateApplications) {
        List<String> applicationDetails = new ArrayList<>();
        for (JobApplication application : candidateApplications) {
            JobApplicationDTO applicationDTO = application.toDTO();
            JobOpeningDTO jobOpeningDTO = applicationDTO.getJobOpening().toDTO();

            State applicationState = applicationDTO.getState();
            Designation jobReference = jobOpeningDTO.getJobReference();
            int numberOfApplicants = jobOpeningRepository.countApplicationsByJobReference(jobReference);

            applicationDetails.add("Application ID: " + applicationDTO.getID() + " (" + jobReference + ")");
            applicationDetails.add("State: " + applicationState);
            applicationDetails.add("Number of Applicants: " + numberOfApplicants);
            applicationDetails.add("--------------------------------");
        }
        return applicationDetails;
    }

    /**
     * All job applications list.
     *
     * @param jobReference the job reference
     * @return the list
     */
    public List<JobApplication> allJobApplications(Designation jobReference) {
        List<JobApplication> result = new ArrayList<>();

        for (JobApplication apps : jobApplicationRepository.findAll()) {
            if (apps.toDTO().getJobOpening().toDTO().getJobReference().equals(jobReference)){
                result.add(apps);
            }
        }

        return result;
    }

}
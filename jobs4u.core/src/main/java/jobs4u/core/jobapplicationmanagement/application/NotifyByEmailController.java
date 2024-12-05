package jobs4u.core.jobapplicationmanagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import jobs4u.core.infrastructure.persistence.PersistenceContext;
import jobs4u.core.jobapplicationmanagement.domain.JobApplication;
import jobs4u.core.jobapplicationmanagement.domain.State;
import jobs4u.core.jobapplicationmanagement.repositories.JobApplicationRepository;
import jobs4u.core.usermanagement.domain.BaseRoles;
import lapr4.emailService.EmailService;
import lapr4.emailService.EmailServiceInterface;


import java.util.ArrayList;
import java.util.List;

/**
 * The type Notify by email controller.
 */
public class NotifyByEmailController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final JobApplicationRepository jobApplicationRepository = PersistenceContext.repositories().jobApplications();
    private final EmailServiceInterface emailService = new EmailService();
    private List<JobApplication> jobApplications;

    /**
     * Find verified applications list.
     *
     * @return the list
     */
    public List<JobApplication> findVerifiedApplications() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);

        jobApplications = jobApplicationRepository.findVerifiedApplications(List.of(State.CONFIRMED, State.REJECTED));

        return jobApplications;
    }

    /**
     * Notify candidates list.
     *
     * @return the list
     */
    public List<String> notifyCandidates() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        List<String> returnMessages = new ArrayList<>();
        for (JobApplication jobApplication : jobApplications) {
            boolean isSent = emailService.sendEmail(String.valueOf(jobApplication.toDTO().getCandidate().getEmail()), "Job Application State Update", "Your application for job " + jobApplication.toDTO().getJobOpening().toDTO().getJobReference() + " is now " + jobApplication.toDTO().getState() + ". Thank you for your application. \n Jobs4U Team", false, false);
            if (!isSent) {
                returnMessages.add("An error occurred while trying to notify the candidate " + jobApplication.toDTO().getCandidate().getEmail() + ". Please verify the email service is running on a ISEP Network node or connected to the VPN.");
            }
        }
        return returnMessages;
    }
}



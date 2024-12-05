package jobs4u.core.jobapplicationmanagement.application.Services;
import eapli.framework.domain.repositories.TransactionalContext;
import jakarta.transaction.Transactional;
import jobs4u.core.customerusermanagement.domain.Email;
import jobs4u.core.infrastructure.persistence.PersistenceContext;
import jobs4u.core.jobapplicationmanagement.domain.JobApplication;
import jobs4u.core.jobapplicationmanagement.domain.State;
import jobs4u.core.jobapplicationmanagement.repositories.JobApplicationRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * The type List notification job application service.
 */
@Service
public class ListNotificationJobApplicationService {

    private final TransactionalContext autoTx = PersistenceContext.repositories().newTransactionalContext();
    private final JobApplicationRepository jobApplicationRepository = PersistenceContext.repositories().jobApplications(autoTx);

    /**
     * List notification job applications list.
     *
     * @param email the email
     * @return the list
     */
    public List<String> listNotificationJobApplications(Email email) {
        // Query the database to get the job applications for the candidate
        List<JobApplication> jobApplications = jobApplicationRepository.findByCandidateEmail(email);

        // Filter the job applications based on their state and generate notifications
        List<String> notifications = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (JobApplication jobApplication : jobApplications) {
            String notification;
            if (jobApplication.getState() == State.CONFIRMED) {
                notification = "Congratulations! Your application for job " + jobApplication.getJobOpening().getJobReference()
                        + " submitted on " + sdf.format(jobApplication.getDate())
                        + " has passed to the next phase. Thank you for your patience.";
            } else if (jobApplication.getState() == State.REJECTED) {
                notification = "We're sorry, but your application for job " + jobApplication.getJobOpening().getJobReference()
                        + " submitted on " + sdf.format(jobApplication.getDate())
                        + " has not been successful. Thank you for your interest.";
            } else {
                continue;
            }
            notifications.add(notification);
        }

        if (notifications.isEmpty()) {
            notifications.add("There have been no changes to any of your applications.");
        }

        return notifications;
    }
}
package jobs4u.app.backoffice.console.presentation.applications.UI;

import eapli.framework.presentation.console.AbstractUI;
import jobs4u.core.jobapplicationmanagement.application.NotifyByEmailController;
import jobs4u.core.jobapplicationmanagement.domain.JobApplication;

import java.util.List;
import java.util.Scanner;

/**
 * The type Notify by email ui.
 */
public class NotifyByEmailUI extends AbstractUI {

    /**
     * The The controller.
     */
    NotifyByEmailController theController = new NotifyByEmailController();
    /**
     * The Return messages.
     */
    List<String> returnMessages;

    @Override
    protected boolean doShow() {
        List<JobApplication> jobApplications = showVerifiedApplications();
        if (jobApplications.isEmpty()) {
            return true;
        }
        if (userWantsToNotify()) {
            notifyCandidates();
        } else {
            System.out.println("Notification cancelled.");
        }
        return false;
    }

    private List<JobApplication> showVerifiedApplications() {
        List<JobApplication> jobApplications = theController.findVerifiedApplications();
        if (jobApplications.isEmpty()) {
            System.out.println("No Candidates to notify");
        } else {
            System.out.println("Candidates to notify:");
            for (JobApplication jobApplication : jobApplications) {
                System.out.println("Candidate: " + jobApplication.toDTO().getCandidate() + " - Application: " + jobApplication.toDTO().getID());
            }
        }
        return jobApplications;
    }

    private boolean userWantsToNotify() {
        System.out.println("Do you want to notify the candidates? (yes/no)");
        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine();
        return response.equalsIgnoreCase("yes");
    }

    private void notifyCandidates() {
        returnMessages = theController.notifyCandidates();
        if (returnMessages.isEmpty()) {
            System.out.println("All candidates were notified successfully.");
        } else {
            System.out.println("Some candidates were not notified successfully:");
            for (String returnMessage : returnMessages) {
                System.out.println(returnMessage);
            }
        }
    }



    @Override
    public String headline() {
        return "Notify Candidates About Application State by Email";
    }
}
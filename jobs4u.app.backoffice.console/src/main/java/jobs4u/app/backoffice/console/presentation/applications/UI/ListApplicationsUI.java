package jobs4u.app.backoffice.console.presentation.applications.UI;

import eapli.framework.general.domain.model.Designation;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.core.jobapplicationmanagement.application.ListJobApplicationController;
import jobs4u.core.jobapplicationmanagement.domain.JobApplication;
import jobs4u.core.jobapplicationmanagement.domain.FileJobApp;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The type List applications ui.
 */
public class ListApplicationsUI extends AbstractUI {

    private final ListJobApplicationController theController = new ListJobApplicationController();
    @Override
    protected boolean doShow() {

        final String jobOpeningReference = Console.readNonEmptyLine("Job Opening Reference", "Please enter the job opening reference");

        final List<JobApplication> jobApplicationList = this.theController.allJobApplications(Designation.valueOf(jobOpeningReference));

        if (jobApplicationList.isEmpty()) {
            System.out.println("There is no Job Applications");
        } else {

            System.out.println("Job Applications By Job Opening\n");

            for (final JobApplication jobApplication : jobApplicationList) {
                List<FileJobApp> files = jobApplication.toDTO().getFile();
                String filesPaths = files.stream()
                        .map(FileJobApp::getValue)
                        .collect(Collectors.joining(", "));

                System.out.printf("%-30s%-30s%-30s%-30s%-30s%-30s%n", jobApplication.identity(), jobApplication.toDTO().getCandidate().getEmail(), jobApplication.toDTO().getDate(), jobApplication.toDTO().getState(), filesPaths,jobApplication.toDTO().getInterviewGrade());
            }
        }
        return true;
    }
    @Override
    public String headline() {
        return "List Job Applications By Job Opening";
    }
}
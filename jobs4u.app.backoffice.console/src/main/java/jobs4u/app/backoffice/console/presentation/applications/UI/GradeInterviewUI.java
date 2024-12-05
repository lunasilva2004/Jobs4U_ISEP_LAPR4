package jobs4u.app.backoffice.console.presentation.applications.UI;

import eapli.framework.general.domain.model.Designation;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.core.jobapplicationmanagement.application.GradeInterviewController;
import jobs4u.core.jobapplicationmanagement.domain.State;

/**
 * The type Grade interview ui.
 */
public class GradeInterviewUI extends AbstractUI {


    private final GradeInterviewController theController = new GradeInterviewController();

    @Override
    protected boolean doShow() {


        final String jobOpeningReference = Console.readNonEmptyLine("Job Opening Reference", "Please enter the job opening reference");


        try {

            if(!this.theController.gradeInterview(Designation.valueOf(jobOpeningReference))) {
                System.out.println("\nFailed to grade interviews\n");
            }else {
                System.out.println("\nInterview was evaluated successfully.\n");
            }

        } catch (final IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error grading interview: " + e.getMessage());
        }


        return true;
    }

    @Override
    public String headline() {
        return "Grade Interviews for a job opening";
    }
}

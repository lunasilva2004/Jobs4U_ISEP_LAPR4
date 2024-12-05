package jobs4u.app.backoffice.console.presentation.applications.UI;

import eapli.framework.general.domain.model.Designation;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.core.jobopeningmanagement.application.PublishResultsController;

/**
 * The type Publish results ui.
 */
public class PublishResultsUI extends AbstractUI {

    private final PublishResultsController theController = new PublishResultsController();



    @Override
    protected boolean doShow() {


        final String jobOpeningReference = Console.readNonEmptyLine("Job Opening Reference", "Please enter the job opening reference");


        try {
            if(!this.theController.publishResults(Designation.valueOf(jobOpeningReference))) {
                System.out.println("\nFailed to sent email\n");
            }else {
                System.out.println("\nEmail sent successfully.\n");
            }
        } catch (final IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error publishing results: " + e.getMessage());
        }


        return true;
    }

    @Override
    public String headline() {
        return "Grade Interviews for a job opening";
    }
}

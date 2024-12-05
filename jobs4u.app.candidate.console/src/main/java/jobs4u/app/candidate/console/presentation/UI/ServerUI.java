package jobs4u.app.candidate.console.presentation.UI;

import eapli.framework.presentation.console.AbstractUI;
import jobs4u.core.serverManagement.application.CommunicationController;

import java.util.List;

/**
 * The type Server ui.
 */
public class ServerUI extends AbstractUI {
    private final CommunicationController communicationController = new CommunicationController();

    @Override
    protected boolean doShow() {
        System.out.println("Fetching your Job Applications... Please wait a second...");
        System.out.println();
        List<String> jobApplications = communicationController.listAllJobApplications();
        jobApplications.forEach(System.out::println);
        return false;
    }

    @Override
    public String headline() {
        return "List All Customer Job Applications with Server";
    }
}

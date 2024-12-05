package jobs4u.app.customer.console.presentation.UI;

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
        System.out.println("Fetching your job openings... Please wait a second...");
        System.out.println();
        List<String> jobOpenings = communicationController.listAllJobOpenings();
        jobOpenings.forEach(System.out::println);
        return false;
    }

    @Override
    public String headline() {
        return "List All Customer Job Openings with server";
    }
}
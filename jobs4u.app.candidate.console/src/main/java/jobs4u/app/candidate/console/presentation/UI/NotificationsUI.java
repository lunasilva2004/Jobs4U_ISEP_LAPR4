package jobs4u.app.candidate.console.presentation.UI;

import eapli.framework.presentation.console.AbstractUI;
import jobs4u.core.serverManagement.application.CommunicationController;

import java.util.List;

/**
 * The type Notifications ui.
 */
public class NotificationsUI extends AbstractUI {

    private final CommunicationController communicationController = new CommunicationController();

    @Override
    protected boolean doShow() {
        System.out.println("Fetching any changes in your Applications State... Please wait a second...");
        System.out.println();
        List<String> notifications = communicationController.listAllNotificationJobApplication();
        notifications.forEach(System.out::println);
        return false;
    }

    @Override
    public String headline() {
        return "List All Notifications with Server";
    }
}

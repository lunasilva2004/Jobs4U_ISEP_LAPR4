package jobs4u.app.customer.console.presentation.myuser.Login;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.core.serverManagement.application.CommunicationController;

/**
 * The type Server login ui.
 */
public class ServerLoginUI extends AbstractUI {

    private final static CommunicationController controller = new CommunicationController();

    @Override
    protected boolean doShow() {
        final String userEmail = Console.readNonEmptyLine("Email:", "Please provide a valid email address");
        final String password = Console.readLine("Password:");

        boolean result = controller.login(userEmail, password);

        if (result) {
            System.out.println("Login successful!");
            return true;

        } else {
            System.out.println("Login failed!");
            return false;
        }
    }

    @Override
    public String headline() {
        return "Login";
    }
}

package jobs4u.app.candidate.console.presentation.myUser;

import eapli.framework.actions.Action;
import jobs4u.app.candidate.console.presentation.MainMenu;
import jobs4u.core.serverManagement.application.CommunicationController;

/**
 * The type Server login action.
 */
public class ServerLoginAction implements Action {

    private final static CommunicationController controller = new CommunicationController();

    @Override
    public boolean execute() {
        ServerLoginUI serverLoginUI = new ServerLoginUI();

        boolean connected;
        int tries = 0;

        do {
            tries++;
            connected = serverLoginUI.show();
        } while (!connected && tries < 3);

        if (connected) {
            final MainMenu menu = new MainMenu();
            menu.mainLoop();
            return true;

        } else {
            System.out.println("Exceeded number of tries!");
            DisconnectAction disconectAction = new DisconnectAction();
            disconectAction.execute();
            return false;
        }

    }
}

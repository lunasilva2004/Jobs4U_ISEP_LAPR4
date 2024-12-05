package jobs4u.app.customer.console.presentation.myuser.Login;

import eapli.framework.actions.Action;
import jobs4u.core.serverManagement.application.CommunicationController;
import jobs4u.core.serverManagement.domain.MessageCode;

/**
 * The type Disconnect action.
 */
public class DisconnectAction implements Action {

    private final static CommunicationController controller = new CommunicationController();

    @Override
    public boolean execute() {
        int code = controller.disconnect();

        if (code == MessageCode.ACK.getCode()) {
            System.out.println("Connection closed!");
            return true;

        } else if (code == MessageCode.ERR.getCode()) {
            System.out.println("Error while closing connection! (ERR)");
            return false;

        } else {
            System.out.println("Unknown response!");
            return false;
        }

    }
}

package jobs4u.app.customer.console.presentation.Actions;

import eapli.framework.actions.Action;
import jobs4u.app.customer.console.presentation.UI.ServerUI;

/**
 * The type Server action.
 */
public class ServerAction implements Action {
    @Override
    public boolean execute() {
        return new ServerUI().show();
    }
}

package jobs4u.app.backoffice.console.presentation.applications.Actions;

import eapli.framework.actions.Action;
import jobs4u.app.backoffice.console.presentation.applications.UI.RegisterApplicationUI;

/**
 * The type Register application action.
 */
public class RegisterApplicationAction implements Action {

    public boolean execute() {
        return new RegisterApplicationUI().show();
    }

}

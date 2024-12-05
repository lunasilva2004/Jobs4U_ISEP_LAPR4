package jobs4u.app.backoffice.console.presentation.applications.Actions;

import eapli.framework.actions.Action;
import jobs4u.app.backoffice.console.presentation.applications.UI.NotifyByEmailUI;

/**
 * The type Notify by email action.
 */
public class NotifyByEmailAction implements Action {
    @Override
    public boolean execute() {return new NotifyByEmailUI().show();}
}

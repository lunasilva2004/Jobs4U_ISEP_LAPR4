package jobs4u.app.backoffice.console.presentation.applications.Actions;


import eapli.framework.actions.Action;
import jobs4u.app.backoffice.console.presentation.applications.UI.ListApplicationsUI;


/**
 * The type List applications action.
 */
public class ListApplicationsAction implements Action {
    @Override
    public boolean execute() {
        return new ListApplicationsUI().show();
    }
}


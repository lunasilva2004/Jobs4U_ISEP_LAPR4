package jobs4u.app.backoffice.console.presentation.applications.Actions;

import eapli.framework.actions.Action;
import jobs4u.app.backoffice.console.presentation.applications.UI.ManagePhasesUI;

/**
 * The type Manage phases action.
 */
public class ManagePhasesAction implements Action {

    @Override
    public boolean execute() {
        return new ManagePhasesUI().show();
    }
}

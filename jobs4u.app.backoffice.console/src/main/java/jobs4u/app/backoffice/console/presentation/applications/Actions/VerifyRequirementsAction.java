package jobs4u.app.backoffice.console.presentation.applications.Actions;

import eapli.framework.actions.Action;
import jobs4u.app.backoffice.console.presentation.applications.UI.SetupPhasesUI;
import jobs4u.app.backoffice.console.presentation.applications.UI.VerifyRequirementsUI;

/**
 * The type Verify requirements action.
 */
public class VerifyRequirementsAction implements Action{

        @Override
        public boolean execute() {
            return new VerifyRequirementsUI().show();
        }
}

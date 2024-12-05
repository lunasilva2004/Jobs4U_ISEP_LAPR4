package jobs4u.app.backoffice.console.presentation.applications.Actions;

import eapli.framework.actions.Action;
import jobs4u.app.backoffice.console.presentation.applications.UI.SetupPhasesUI;

/**
 * The type Setup phases action.
 */
public class SetupPhasesAction implements Action{

        @Override
        public boolean execute() {
            return new SetupPhasesUI().show();
        }
}

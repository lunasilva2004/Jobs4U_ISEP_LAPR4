package jobs4u.app.candidate.console.presentation.Actions;

import eapli.framework.actions.Action;
import jobs4u.app.candidate.console.presentation.UI.NotificationsUI;

/**
 * The type Notifications action.
 */
public class NotificationsAction implements Action {

    @Override
    public boolean execute() {
        return new NotificationsUI().show();
    }
}

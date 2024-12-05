package jobs4u.app.backoffice.console.presentation.PluginManagement.Actions;

import eapli.framework.actions.Action;
import jobs4u.app.backoffice.console.presentation.PluginManagement.UploadInterviewModelFileUI;

/**
 * The type Upload interview model file action.
 */
public class UploadInterviewModelFileAction implements Action {
    @Override
    public boolean execute() {
        return new UploadInterviewModelFileUI().show();
    }
}

package jobs4u.app.backoffice.console.presentation.PluginManagement;

import Other.InterviewModel_EX1;
import eapli.framework.presentation.console.AbstractUI;

/**
 * The type Generate im template ui.
 */
public class GenerateIMTemplateUI extends AbstractUI {

    private final InterviewModel_EX1 interviewModelEX1 = new InterviewModel_EX1();

    @Override
    protected boolean doShow() {
        System.out.println("Generating Interview Model Template...");
        interviewModelEX1.generateTemplate();
        return false;
    }

    @Override
    public String headline() {
        return "Generate Interview Model Template";
    }
}

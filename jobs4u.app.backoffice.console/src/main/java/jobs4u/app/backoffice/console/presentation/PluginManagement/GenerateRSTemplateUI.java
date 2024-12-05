package jobs4u.app.backoffice.console.presentation.PluginManagement;

import Other.JobRequirementsSpecification_EX1;
import eapli.framework.presentation.console.AbstractUI;

/**
 * The type Generate rs template ui.
 */
public class GenerateRSTemplateUI extends AbstractUI {

    private final JobRequirementsSpecification_EX1 requirementsSpecification = new JobRequirementsSpecification_EX1();

    @Override
    protected boolean doShow() {
        System.out.println("Generating Requirement Specification Template...");
        requirementsSpecification.generateTemplate();
        return false;
    }

    @Override
    public String headline() {
        return "Generate Requirement Specification Template";
    }
}

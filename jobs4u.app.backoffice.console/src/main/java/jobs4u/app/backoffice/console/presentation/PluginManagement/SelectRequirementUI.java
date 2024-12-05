package jobs4u.app.backoffice.console.presentation.PluginManagement;

import eapli.framework.presentation.console.AbstractUI;
import jobs4u.core.PluginManagement.RequirementsSpecificationManagement.controller.SelectRequirementController;
import jobs4u.core.PluginManagement.RequirementsSpecificationManagement.domain.RequirementSpecification;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;

import java.util.List;
import java.util.Scanner;

/**
 * The type Select requirement ui.
 */
public class SelectRequirementUI extends AbstractUI {

    private final SelectRequirementController controller = new SelectRequirementController();

    protected boolean doShow() {
        List<JobOpening> jobOpeningList = controller.getAllJobOpenings();

        System.out.println("Please select the number of the Job Opening:");
        for (int i = 0; i < jobOpeningList.size(); i++) {
            System.out.println((i + 1) + ". " + jobOpeningList.get(i).identity());
        }
        int jobOpeningIndex = new Scanner(System.in).nextInt() - 1;
        JobOpening selectedJobOpening = controller.getJobOpeningByIndex(jobOpeningIndex);

        List<RequirementSpecification> requirementList = controller.getAllRequirements();

        System.out.println("Please select the number of the Requirement Specification:");
        for (int i = 0; i < requirementList.size(); i++) {
            System.out.println((i + 1) + ". " + requirementList.get(i).getName().getValue());
        }
        int requirementIndex = new Scanner(System.in).nextInt() - 1;
        RequirementSpecification selectedRequirement = controller.getRequirementByIndex(requirementIndex);

        if (selectedJobOpening != null && selectedRequirement != null) {
            controller.associateRequirementToJobOpening(selectedRequirement.getName(), selectedJobOpening.identity());
        } else {
            System.out.println("Job Opening or Requirement Specification not found.");
        }
        return false;
    }

    @Override
    public String headline() {
        return "Select Requirement Specification";
    }
}
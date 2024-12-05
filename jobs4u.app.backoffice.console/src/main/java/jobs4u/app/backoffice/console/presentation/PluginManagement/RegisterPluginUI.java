package jobs4u.app.backoffice.console.presentation.PluginManagement;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.core.PluginManagement.Description;
import jobs4u.core.PluginManagement.FQClassName;
import jobs4u.core.PluginManagement.InterviewModelManagement.controller.InterviewModelController;
import jobs4u.core.PluginManagement.InterviewModelManagement.domain.InterviewModel;
import jobs4u.core.PluginManagement.RequirementsSpecificationManagement.controller.RequirementController;
import jobs4u.core.PluginManagement.RequirementsSpecificationManagement.domain.RequirementSpecification;
import jobs4u.core.customerusermanagement.domain.Name;

import java.io.Console;

/**
 * The type Register plugin ui.
 */
public class RegisterPluginUI extends AbstractUI {

    private final InterviewModelController interviewModelController = new InterviewModelController();
    private final RequirementController requirementController = new RequirementController();
    private final Console console = System.console();

    @Override
    protected boolean doShow() {

        boolean shouldContinue = true;

        while (shouldContinue) {
            System.out.println("1 - Register a Interview Model");
            System.out.println("2 - Register a Requirements Specification");
            System.out.println("0 - Back");
            System.out.print("Choose an option: ");

            int option = Integer.parseInt(console.readLine()); // Read option from console

            switch (option) {
                case 1:
                    registerInterviewModel();
                    break;
                case 2:
                    registerRequirements();
                    break;
                case 0:
                    shouldContinue = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        return false;
    }

    private void registerInterviewModel() {
        System.out.println("Enter the name of the Interview Model: ");
        String name = console.readLine();

        System.out.println("Enter the description of the Interview Model: ");
        String description = console.readLine();

        System.out.println("Enter the class name of the Interview Model: ");
        String className = console.readLine();

        try {
            interviewModelController.registerInterviewModel(name, description, className);
            System.out.println("\nInterview Model registered successfully!\n");
        } catch (final IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            System.out.println("Error occurred while adding the Interview Model.");
        }
    }

    private void registerRequirements() {
        System.out.println("Enter the name of the Requirements Specification: ");
        String name = console.readLine();

        System.out.println("Enter the description of the Requirements Specification: ");
        String description = console.readLine();

        System.out.println("Enter the class name of the Requirements Specification: ");
        String className = console.readLine();

        try {
            requirementController.registerRequirementSpecification(name, description, className);
            System.out.println("\nRequirements Specification registered successfully!\n");
        } catch (final IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            System.out.println("Error occurred while adding the requirement.");
        }
    }

    @Override
    public String headline() {
        return "Register Plugin";
    }
}

package jobs4u.app.backoffice.console.presentation.authz;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.core.candidateusermanagement.application.AddCandidateController;

/**
 * The type Add candidate ui.
 */
public class AddCandidateUI extends AbstractUI {

    private final AddCandidateController addCandidateController = new AddCandidateController();

    @Override
    protected boolean doShow() {
        String firstName = Console.readLine("First Name");
        String lastName = Console.readLine("Last Name");
        String email = Console.readLine("E-Mail");
        String phoneNumber = Console.readLine("Phone Number");

        try {
            addCandidateController.registerNewCandidate(firstName, lastName, email, phoneNumber);
            System.out.println("\nCandidate registered successfully!\n");

        } catch (IllegalArgumentException | IntegrityViolationException | ConcurrencyException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    @Override
    public String headline() {
        return "Add Candidate";
    }

}
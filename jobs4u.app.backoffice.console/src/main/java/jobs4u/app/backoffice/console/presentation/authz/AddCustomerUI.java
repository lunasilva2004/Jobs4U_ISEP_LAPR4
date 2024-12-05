package jobs4u.app.backoffice.console.presentation.authz;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import jobs4u.core.customerusermanagement.application.AddCustomerController;

/**
 * The type Add customer ui.
 */
public class AddCustomerUI extends AbstractUI {

    // Controller to handle customer related operations
    private final AddCustomerController addCustomerController = new AddCustomerController();

    @Override
    protected boolean doShow() {
        // Prompt the user to enter the customer details
        String firstName = Console.readLine("First Name");
        String lastName = Console.readLine("Last Name");
        String email = Console.readLine("E-Mail");
        String phoneNumber = Console.readLine("Phone Number");
        String address = Console.readLine("Address");

        try {
            // Register the new customer
            addCustomerController.registerNewCustomer(firstName, lastName, email, phoneNumber, address);
            System.out.println("\nCustomer registered successfully!\n");

        } catch (IllegalArgumentException | IntegrityViolationException | ConcurrencyException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    @Override
    public String headline() {
        return "Add Customer";
    }
}
package jobs4u.core.customerusermanagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jakarta.transaction.Transactional;
import jobs4u.core.candidateusermanagement.LoginInfoWriter;
import jobs4u.core.customerusermanagement.domain.*;
import jobs4u.core.infrastructure.persistence.PersistenceContext;
import jobs4u.core.usermanagement.application.AddUserController;
import jobs4u.core.usermanagement.domain.BaseRoles;
import jobs4u.core.usermanagement.domain.UserBuilderHelper;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Add customer controller.
 */
@UseCaseController
public class AddCustomerController {

    private final AddUserController addUserController = new AddUserController();
    private final LoginInfoWriter loginInfoWriter = new LoginInfoWriter();

    /**
     * Register new customer.
     *
     * @param firstName   the first name
     * @param lastName    the last name
     * @param email       the email
     * @param phoneNumber the phone number
     * @param address     the address
     */
    @Transactional
    public void registerNewCustomer(String firstName, String lastName, String email, String phoneNumber, String address) {
        AuthzRegistry.authorizationService().ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);

        String fullName = firstName + " " + lastName;

        Customer newCustomer = new CustomerBuilder()
                .withName(new Name(fullName))
                .withEmail(new Email(email))
                .withPhoneNumber(new PhoneNumber(phoneNumber))
                .withAddress(new Address(address))
                .build();

        String password = addUserController.generatePassword();

        Set<Role> roles = new HashSet<>(Collections.singletonList(BaseRoles.CUSTOMER));

        SystemUser newUser = UserBuilderHelper.builder()
                .withUsername(email)
                .withPassword(password)
                .withName(firstName, lastName)
                .withEmail(email)
                .withRoles(roles)
                .build();

        PersistenceContext.repositories().users().save(newUser);
        loginInfoWriter.writeLoginInfoToFile(email, password);

        PersistenceContext.repositories().customers().save(newCustomer);
    }

}
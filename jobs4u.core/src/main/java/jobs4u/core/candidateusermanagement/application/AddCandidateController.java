package jobs4u.core.candidateusermanagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jakarta.transaction.Transactional;
import jobs4u.core.candidateusermanagement.LoginInfoWriter;
import jobs4u.core.candidateusermanagement.domain.Candidate;
import jobs4u.core.candidateusermanagement.domain.CandidateBuilder;
import jobs4u.core.customerusermanagement.domain.*;
import jobs4u.core.infrastructure.persistence.PersistenceContext;
import jobs4u.core.usermanagement.application.AddUserController;
import jobs4u.core.usermanagement.domain.BaseRoles;
import jobs4u.core.usermanagement.domain.UserBuilderHelper;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Add candidate controller.
 */
@UseCaseController
public class AddCandidateController {

    private final AddUserController addUserController = new AddUserController();
    private final LoginInfoWriter loginInfoWriter = new LoginInfoWriter();

    /**
     * Register new candidate.
     *
     * @param firstName   the first name
     * @param lastName    the last name
     * @param email       the email
     * @param phoneNumber the phone number
     */
    @Transactional
    public void registerNewCandidate(String firstName, String lastName, String email, String phoneNumber) {
        AuthzRegistry.authorizationService().ensureAuthenticatedUserHasAnyOf(BaseRoles.OPERATOR);

        String fullName = firstName + " " + lastName;

        Candidate newCandidate = new CandidateBuilder()
                .withName(new Name(fullName))
                .withEmail(new Email(email))
                .withPhoneNumber(new PhoneNumber(phoneNumber))
                .build();

        String password = addUserController.generatePassword();

        Set<Role> roles = new HashSet<>(Collections.singletonList(BaseRoles.CANDIDATE));

        SystemUser newUser = UserBuilderHelper.builder()
                .withUsername(email)
                .withPassword(password)
                .withName(firstName, lastName)
                .withEmail(email)
                .withRoles(roles)
                .build();

        PersistenceContext.repositories().users().save(newUser);
        loginInfoWriter.writeLoginInfoToFile(email, password);

        PersistenceContext.repositories().candidates().save(newCandidate);
    }
}
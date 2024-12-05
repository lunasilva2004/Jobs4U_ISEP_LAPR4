package jobs4u.core.jobopeningmanagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import jobs4u.core.customerusermanagement.domain.Email;
import jobs4u.core.jobopeningmanagement.application.Services.ListJobOpeningService;
import jobs4u.core.usermanagement.domain.BaseRoles;

import java.util.List;

/**
 * The type List job opening controller.
 */
@UseCaseController
public class ListJobOpeningController {
    private final ListJobOpeningService jobOpeningService = new ListJobOpeningService();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    /**
     * List job openings for customer list.
     *
     * @return the list
     */
    public List<String> listJobOpeningsForCustomer() {
        authz.isAuthenticatedUserAuthorizedTo(BaseRoles.CUSTOMER);
        String emailInput = authz.session().get().authenticatedUser().username().toString();
        Email email = new Email(emailInput);
        return jobOpeningService.listJobOpeningsForCustomer(email);
    }
}
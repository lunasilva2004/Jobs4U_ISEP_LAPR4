package jobs4u.core.jobapplicationmanagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import jobs4u.core.customerusermanagement.domain.Email;
import jobs4u.core.jobapplicationmanagement.application.Services.ListNotificationJobApplicationService;
import jobs4u.core.usermanagement.domain.BaseRoles;

import java.util.List;

/**
 * The type List notification job application controller.
 */
@UseCaseController
public class ListNotificationJobApplicationController {

    private final ListNotificationJobApplicationService listNotificationJobApplications = new ListNotificationJobApplicationService();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    /**
     * List notification job applications list.
     *
     * @return the list
     */
    public List<String> listNotificationJobApplications() {
        authz.isAuthenticatedUserAuthorizedTo(BaseRoles.CUSTOMER);
        String emailInput = authz.session().get().authenticatedUser().username().toString();
        Email email = new Email(emailInput);
        return listNotificationJobApplications.listNotificationJobApplications(email);
    }
}

package jobs4u.core.usermanagement.application;

import jobs4u.core.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

/**
 * The type Activate user controller.
 *
 * @author Fernando
 */
@UseCaseController
public class ActivateUserController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final UserManagementService userSvc = AuthzRegistry.userService();

    /**
     * Deactived users iterable.
     *
     * @return the iterable
     */
    public Iterable<SystemUser> deactivedUsers() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN);

        return userSvc.deactivatedUsers();
    }

    /**
     * Activate user system user.
     *
     * @param user the user
     * @return the system user
     */
    public SystemUser activateUser(final SystemUser user) {
        authz.ensureAuthenticatedUserHasAnyOf( BaseRoles.ADMIN);

        return userSvc.activateUser(user);
    }
}

package jobs4u.app.common.console.application;

import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.jpa.JpaAutoTxUserRepository;
import jobs4u.Application;

/**
 * The type Login controller.
 */
public class LoginControllerImpl implements LoginController {

    private final UserRepository repo = new JpaAutoTxUserRepository(Application.settings().getPersistenceUnitName(),
            Application.settings().getExtendedPersistenceProperties());

    @Override
    public String findUsernameByEmail(String email) {
        for (SystemUser user : repo.findAll()) {
            if (user.email().toString().equals(email)) {
                return user.username().toString();
            }
        }
        return null;
    }
}

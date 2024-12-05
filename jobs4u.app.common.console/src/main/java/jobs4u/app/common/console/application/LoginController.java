package jobs4u.app.common.console.application;

/**
 * The interface Login controller.
 */
public interface LoginController {

    /**
     * Find username by email string.
     *
     * @param email the email
     * @return the string
     */
    String findUsernameByEmail(String email);

}

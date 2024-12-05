package lapr4.emailService;

/**
 * The interface Email service interface.
 */
public interface EmailServiceInterface {
    /**
     * Send email boolean.
     *
     * @param to         the to
     * @param subject    the subject
     * @param msg        the msg
     * @param printInfo  the print info
     * @param printError the print error
     * @return the boolean
     */
    boolean sendEmail(String to, String subject, String msg, boolean printInfo, boolean printError);
}
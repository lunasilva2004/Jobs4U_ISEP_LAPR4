package jobs4u.core.serverManagement.application;

import java.net.Socket;
import java.util.List;

/**
 * The type Comunication controller.
 */
public class CommunicationController {
    private CommunicationService service = CommunicationService.getInstance();

    /**
     * Initialize comunication.
     *
     * @param socket the socket
     */
    public void initializeComunication(Socket socket) {
        service.initializeComunication(socket);
    }

    /**
     * Test connection int.
     *
     * @return the int
     */
    public int testConnection() {
        return service.testConnection();
    }

    /**
     * Login boolean.
     *
     * @param userEmail the user email
     * @param password  the password
     * @return the boolean
     */
    public boolean login(String userEmail, String password) {
        return service.login(userEmail, password);
    }

    /**
     * Disconnect int.
     *
     * @return the int
     */
    public int disconnect() {
        return service.disconnect();
    }

    /**
     * List all job openings list.
     *
     * @return the list
     */
    public List<String> listAllJobOpenings() {
        return service.listAllJobOpeningsForSpecificCustomer();
    }

    /**
     * List all job applications list.
     *
     * @return the list
     */
    public List<String> listAllJobApplications() {
        return service.listAllJobApplicationsForSpecificCandidate();
    }

    /**
     * List all notification job application list.
     *
     * @return the list
     */
    public List<String> listAllNotificationJobApplication() {
        return service.listAllNotificationJobApplication();
    }

}

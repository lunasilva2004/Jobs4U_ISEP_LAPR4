package jobs4u.core.serverManagement.application;

import jobs4u.core.serverManagement.domain.MessageCode;
import jobs4u.core.serverManagement.domain.Messenger;
import jobs4u.core.serverManagement.domain.Translator;

import java.io.IOException;
import java.net.Socket;
import java.util.List;

/**
 * The type Communication service.
 */
public class CommunicationService {

    private static CommunicationService instance;
    private Messenger serverMessenger;


    // Private constructor to prevent instantiation
    private CommunicationService() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
// Public method to provide access to the instance
    public static synchronized CommunicationService getInstance() {
        if (instance == null) {
            instance = new CommunicationService();
        }
        return instance;
    }

    /**
     * Initialize comunication.
     *
     * @param socket the socket
     */
    public void initializeComunication(Socket socket) {
        try {
            serverMessenger = new Messenger(socket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Test connection int.
     *
     * @return the int
     */
    public int testConnection() {
        try {
            byte[] message = Translator.encode(1, MessageCode.COMMTEST, null, null);
            serverMessenger.sendMessage(message);

            byte[] response = serverMessenger.receiveMessage();
            int code = Translator.decodeCode(response);
            return code;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * Login boolean.
     *
     * @param userEmail the user email
     * @param password  the password
     * @return the boolean
     */
    public boolean login(String userEmail, String password) {
        try {
            byte[] message = Translator.encode(1, MessageCode.AUTH, userEmail.getBytes(), password.getBytes());
            serverMessenger.sendMessage(message);

            byte[] response = serverMessenger.receiveMessage();

            int messageCode = Translator.decodeCode(response);
            if (messageCode == MessageCode.ACK.getCode()) {
                return true;
            } else if (messageCode == MessageCode.ERR.getCode()) {
                return false;
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    /**
     * Disconnect int.
     *
     * @return the int
     */
    public int disconnect() {
        byte[] message = Translator.encode(1, MessageCode.DISCONN, null, null);
        try {
            serverMessenger.sendMessage(message);
            byte[] response = serverMessenger.receiveMessage();
            return Translator.decodeCode(response);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * List all job openings for specific customer list.
     *
     * @return the list
     */
    public List<String> listAllJobOpeningsForSpecificCustomer() {
        byte[] message = Translator.encode(1, MessageCode.LIST_JOB_OPENINGS, null, null);
        try {
            serverMessenger.sendMessage(message);

            byte[] response = serverMessenger.receiveMessage();
            int code = Translator.decodeCode(response);

            if (code == MessageCode.SHOW_JOB_OPENINGS.getCode()) {
                // Assuming MessageTranslator.decodeData1(response) returns a byte array
                byte[] data = Translator.decodeData1(response);

                return Translator.deserializeListJobOpenings(data);

            } else {
                System.out.println("Error while listing job openings!");
                return null;
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * List all job applications for specific candidate list.
     *
     * @return the list
     */
    public List<String> listAllJobApplicationsForSpecificCandidate() {
        byte[] message = Translator.encode(1, MessageCode.LIST_JOB_APPLICATIONS, null, null);
        try {
            serverMessenger.sendMessage(message);

            byte[] response = serverMessenger.receiveMessage();
            int code = Translator.decodeCode(response);

            if (code == MessageCode.SHOW_JOB_APPLICATIONS.getCode()) {
                // Assuming MessageTranslator.decodeData1(response) returns a byte array
                byte[] data = Translator.decodeData1(response);

                return Translator.deserializeListJobApplications(data);
            } else {
                System.out.println("Error while listing Job Applications!");
                return null;
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * List all notification job application list.
     *
     * @return the list
     */
    public List<String> listAllNotificationJobApplication() {
        byte[] message = Translator.encode(1, MessageCode.LIST_NOTIF_JOB_APPLICATIONS, null, null);
        try {
            serverMessenger.sendMessage(message);

            byte[] response = serverMessenger.receiveMessage();
            int code = Translator.decodeCode(response);

            if (code == MessageCode.SHOW_NOTIF_JOB_APPLICATIONS.getCode()) {
                // Assuming MessageTranslator.decodeData1(response) returns a byte array
                byte[] data = Translator.decodeData1(response);

                return Translator.deserializeNotificationJobApplication(data);
            } else {
                System.out.println("Error while listing notifications!");
                return null;
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
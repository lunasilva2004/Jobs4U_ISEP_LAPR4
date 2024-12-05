package jobs4u.app.candidate.console;/*


import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import jobs4u.app.customer.console.presentation.FrontMenu;
import jobs4u.core.infrastructure.persistence.PersistenceContext;
import jobs4u.core.serverManagement.application.ComunicationController;
import jobs4u.core.serverManagement.domain.MessageCode;
import jobs4u.core.usermanagement.domain.BasePasswordPolicy;

import java.net.Socket;

/**
 * Base User App.
 */

import jobs4u.core.serverManagement.application.CommunicationController;
import jobs4u.core.serverManagement.domain.MessageCode;
import jobs4u.app.candidate.console.presentation.FrontMenu;

import java.net.Socket;

/**
 * The type Candidate app.
 */
@SuppressWarnings("squid:S106")
public final class CandidateApp {

    private CandidateApp() {
    }

    private static final CommunicationController theController = new CommunicationController();

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(final String[] args) {
        System.out.println("=====================================");
        System.out.println("Candidate User App - Jobs4U");
        System.out.println("(C) 2024");
        System.out.println("=====================================");

        try {
            Socket socket = new Socket("127.0.0.1", 2004);
            theController.initializeComunication(socket);

            int code = theController.testConnection();

            if (code == MessageCode.ACK.getCode()) {
                System.out.println("Connection Established!");

            } else if (code == MessageCode.ERR.getCode()) {
                System.out.println("Connection refused! (ERR)");
                System.exit(0);

            } else {
                System.out.println("Unknown response!");
                System.exit(0);
            }

            FrontMenu frontMenu = new FrontMenu();
            frontMenu.show();

            socket.close();
        } catch (Exception e) {
            System.out.println("Error in the connection!");
        }

        // exiting the application, closing all threads
        System.exit(0);
    }
}
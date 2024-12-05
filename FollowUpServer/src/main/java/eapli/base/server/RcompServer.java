package eapli.base.server;

import eapli.base.server.server.Server;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import jobs4u.Application;
import jobs4u.core.infrastructure.persistence.PersistenceContext;
import jobs4u.core.usermanagement.domain.BasePasswordPolicy;

import java.io.IOException;
import java.util.Scanner;

/**
 * The type Rcomp server.
 */
public class RcompServer {

    private static final int PORT = 2004;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        try {
            Server server = new Server(PORT);
            init();
            // Thread.sleep(5*1000); //Sleep for 5 seconds
            Thread thread = new Thread(server);
            thread.setDaemon(true);
            thread.start();
            Scanner sc = new Scanner(System.in);
            System.out.println("\nServer Initialized... \nPress ENTER to stop server!");
            sc.nextLine();
            server.stop();
            stop(thread);
        } catch (IOException e) {
            System.out.println("Could not bind to port " + PORT);
            System.out.println("Exiting the application...");
        }
    }


    /**
     * Init.
     */
    public static void init() {
        System.out.println("Initializing server...");
        try {
            AuthzRegistry.configure(PersistenceContext.repositories().users(), new BasePasswordPolicy(),
                    new PlainTextEncoder());
            Application.settings();
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
            if (e.getCause() instanceof ClassNotFoundException) {
                System.out.println("The application is trying to load a class that doesn't exist in the classpath. " +
                        "Please check your configuration and classpath.");
            }
            System.exit(1);
        }
    }

    /**
     * Stop.
     *
     * @param thread the thread
     */
    public static void stop(Thread thread) {
        thread.interrupt();
    }
}
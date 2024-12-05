package eapli.base.server.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * The type Handler.
 */
public abstract class Handler implements Runnable {

    private static final Logger DATABASE_LOGGER = LoggerFactory.getLogger(Handler.class);

    private final Socket serverSocket;
    /**
     * The S in.
     */
    protected ObjectInputStream sIn;
    /**
     * The S out.
     */
    protected ObjectOutputStream sOut;

    /**
     * Instantiates a new Handler.
     *
     * @param socket the socket
     * @throws IOException the io exception
     */
    public Handler(Socket socket) throws IOException {
        this.serverSocket = socket;
        this.sIn = new ObjectInputStream(socket.getInputStream());
        this.sOut = new ObjectOutputStream(socket.getOutputStream());
    }


    /**
     * Handle.
     */
    public abstract void handle();

    @Override
    public void run() {
        try {
            handle();
            SemaphoreForServer.instance().deactivateCriticalSection();
        } catch (Exception e) {
            System.out.println();
            DATABASE_LOGGER.error("Error while executing handler. Closing connection...");
            try {
                serverSocket.close();
                SemaphoreForServer.instance().deactivateCriticalSection();
            } catch (IOException ex) {
                DATABASE_LOGGER.error("There was an error closing socket. Ignoring closing...");
                return;
            }
            DATABASE_LOGGER.info("Socket closed successfully!");
            System.out.printf("Server Connetions: (%d/%d)\n", SemaphoreForServer.instance().availablePermits(), SemaphoreForServer.instance().getMaxPermits());

        }
    }
}

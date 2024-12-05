package eapli.base.server.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The type Server.
 */
public class Server implements Runnable {
    private static final ThreadGroup serverThreadGroup = new ThreadGroup("server-thread-group");
    private final ServerSocket serverSocket;
    private boolean executing;

    /**
     * Instantiates a new Server.
     *
     * @param port the port
     * @throws IOException the io exception
     */
    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        executing = false;
    }

    /**
     * Execute.
     */
    public void execute() {
        executing = true;
        while (executing) {
            try {
                Socket serverSocketConnection = serverSocket.accept();
                if (!executing)
                    return; //Force exit new connections TODO: Add exit handler to communicate server shutdown
                boolean available = SemaphoreForServer.instance().activateCriticalSection();
                if (available) {
                    Thread thread = new Thread(serverThreadGroup, new SimpleHandler(serverSocketConnection));
                    thread.start();
                } else {
                    System.out.println("Could not accept new connection. The server is full!");
                    serverSocketConnection.close();
                }
            } catch (IOException e) {
                System.out.println("Could not accept new connection! Please try again.");
            } catch (InterruptedException e) {
                System.out.println("Could not wait for connection. Listening to new ones... Please try again later.");
            }
        }
    }

    /**
     * Stop.
     */
    public void stop() {
        this.executing = false;
    }


    @Override
    public void run() {
        execute();
        try {
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

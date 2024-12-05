package jobs4u.core.serverManagement.domain;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * The type Messenger.
 */
public class Messenger {
    private static Socket socket;
    private static ObjectOutputStream out;
    private static ObjectInputStream in;


    /**
     * Instantiates a new Messenger.
     *
     * @param socket the socket
     * @throws IOException the io exception
     */
    public Messenger(Socket socket) throws IOException {
        Messenger.socket = socket;
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
    }

    /**
     * Send message.
     *
     * @param message the message
     * @throws IOException the io exception
     */
    public void sendMessage(byte[] message) throws IOException {
        out.writeObject(message);
    }

    /**
     * Receive message byte [ ].
     *
     * @return the byte [ ]
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public byte[] receiveMessage() throws IOException, ClassNotFoundException {
        return (byte[]) in.readObject();
    }


}

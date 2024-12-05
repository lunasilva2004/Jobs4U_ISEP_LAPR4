package lapr4.emailService;

import lombok.SneakyThrows;

import java.io.*;
import java.net.Socket;

/**
 * The type Email service.
 */
@SuppressWarnings("FieldCanBeLocal")
public class EmailService implements EmailServiceInterface {
    private final String smtpServer = "frodo.dei.isep.ipp.pt";
    private final int smtpPort = 25;
    private final String publicEmail = "team@jobs4u.org";
    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;

    /**
     * Connect.
     *
     * @param isToPrintError the is to print error
     * @throws IOException the io exception
     */
    public void connect(boolean isToPrintError) throws IOException {
        try {
            socket = new Socket(smtpServer, smtpPort);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            if (isToPrintError) {
                System.out.println("Error connecting to the server: " + e.getMessage());
            }
        }
    }

    /**
     * Disconnect.
     *
     * @param isToShowDebug the is to show debug
     * @throws IOException the io exception
     */
    public void disconnect(boolean isToShowDebug) throws IOException {
        writer.write("QUIT\r\n");
        writer.flush();
        if (isToShowDebug) {
            System.out.println(reader.readLine());
        }

        reader.close();
        writer.close();
        socket.close();
    }

    @SneakyThrows
    @Override
    public boolean sendEmail(String to, String subject, String body, boolean isToShowDebug, boolean isToPrintError) {
        boolean isSent = true;
        // The ISEP Email Server only accepts domains that are equals to "@isep.ipp.pt"
        if (!to.endsWith("@isep.ipp.pt")) {
            return false;
        }
        try {
            connect(isToPrintError);
            if (isToShowDebug) {
                System.out.println(reader.readLine());
            }

            if (sendCommand("HELO " + smtpServer, isToShowDebug)) {
                return false;
            }
            if (sendCommand("MAIL FROM:<" + publicEmail + ">", isToShowDebug)) {
                return false;
            }
            if (sendCommand("RCPT TO:<" + to + ">", isToShowDebug)) {
                return false;
            }
            if (sendCommand("DATA", isToShowDebug)) {
                return false;
            }

            // Send the email headers and body
            writer.write("From: <" + publicEmail + ">\r\n");
            writer.write("To: <" + to + ">\r\n");
            writer.write("Subject: " + subject + "\r\n");
            writer.write("\r\n");
            writer.write(body + "\r\n");
            writer.write(".\r\n");
            writer.flush();

            if (isToShowDebug) {
                System.out.println(reader.readLine()); // Server response to DATA
            }

            disconnect(isToShowDebug);
        } catch (IOException e) {
            isSent = false;
        }
        return isSent;
    }

    private boolean sendCommand(String command, boolean isToShowDebug) throws IOException {
        writer.write(command + "\r\n");
        writer.flush();
        String response = reader.readLine();
        if (isToShowDebug) {
            System.out.println(response);
        }
        return response.startsWith("4") || response.startsWith("5");
    }
}

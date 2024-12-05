package jobs4u.core.candidateusermanagement;

import java.io.FileWriter;
import java.io.IOException;

/**
 * The type Login info writer.
 */
public class LoginInfoWriter {

    /**
     * Writes the login information to a text file.
     *
     * @param username The username to write to the file.
     * @param password The password to write to the file.
     */
    public void writeLoginInfoToFile(String username, String password) {
        try (FileWriter writer = new FileWriter("login_info.txt", true)) {
            writer.write("Username: " + username + "\n");
            writer.write("Password: " + password + "\n\n");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
package jobs4u.core.candidateusermanagement.domain;

import java.security.SecureRandom;

/**
 * Utility class for generating random passwords.
 */
public class PasswordGenerator {

    private static final String CAP_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String SMALL_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_+=<>?";
    private static final String ALL_CHARS = CAP_LETTERS + SMALL_LETTERS + NUMBERS + SYMBOLS;

    private static final SecureRandom RANDOM = new SecureRandom();

    /**
     * Generates a random password.
     *
     * @return The randomly generated password.
     */
    public static String generatePassword() {
        StringBuilder password = new StringBuilder();

        // Add at least one capital letter
        password.append(CAP_LETTERS.charAt(RANDOM.nextInt(CAP_LETTERS.length())));

        // Add at least one number
        password.append(NUMBERS.charAt(RANDOM.nextInt(NUMBERS.length())));

        // Add at least one symbol
        password.append(SYMBOLS.charAt(RANDOM.nextInt(SYMBOLS.length())));

        // Fill the rest of the password with random characters
        for (int i = 0; i < 4; i++) {
            char randomChar = ALL_CHARS.charAt(RANDOM.nextInt(ALL_CHARS.length()));
            password.append(randomChar);
        }

        // Shuffle the password characters to randomize their positions
        return shuffleString(password.toString());
    }

    /**
     * Shuffles the characters in a string to randomize their order.
     *
     * @param str The input string to shuffle.
     * @return The shuffled string.
     */
    private static String shuffleString(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int randomIndex = RANDOM.nextInt(charArray.length);
            char temp = charArray[i];
            charArray[i] = charArray[randomIndex];
            charArray[randomIndex] = temp;
        }
        return new String(charArray);
    }
}

package jobs4u.core.jobapplicationmanagement.domain;


import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;


/**
 * The type File job app.
 */
@Embeddable
public class FileJobApp {

    // The path of the file
    @Column(name = "file_path")
    private String value;

    /**
     * Default constructor required by JPA.
     * It is protected to prevent direct instantiation.
     */
    protected FileJobApp() {
    }

    /**
     * Constructor for FileJobApp.
     * It validates the input and throws an IllegalArgumentException if the input is null or empty.
     *
     * @param filePath The path of the file.
     * @throws IllegalArgumentException if the input is null or empty.
     */
    public FileJobApp(String filePath) {
        Preconditions.ensure(filePath != null && !filePath.trim().isEmpty(), "File path cannot be null or empty.");
        this.value = filePath;
    }

    /**
     * Overrides the equals method from Object.
     * Two FileJobApp objects are considered equal if their value fields are equal.
     *
     * @param o The object to compare this FileJobApp to.
     * @return true if the given object is a FileJobApp with the same value, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileJobApp fileJobApp = (FileJobApp) o;
        return value.equals(fileJobApp.value);
    }

    /**
     * Overrides the hashCode method from Object.
     * The hash code of a FileJobApp object is the hash code of its value field.
     *
     * @return The hash code of the value field.
     */
    @Override
    public int hashCode() {
        return value.hashCode();
    }

    /**
     * Overrides the toString method from Object.
     * The string representation of a FileJobApp object includes its value field.
     *
     * @return A string representation of this FileJobApp.
     */
    @Override
    public String toString() {
        return "File Job App - " +
                "\n\t File Path = " + value;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public String getValue() {
        return this.value;
    }
}

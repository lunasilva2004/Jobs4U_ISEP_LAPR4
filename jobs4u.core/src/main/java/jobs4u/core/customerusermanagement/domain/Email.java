package jobs4u.core.customerusermanagement.domain;

import eapli.framework.validations.Preconditions;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

/**
 * This class represents an Email in the customer user management domain.
 * It is marked as Embeddable, which means it is not an entity but it can be embedded in an entity.
 * It has a single field, value, which represents the email string.
 */
@Embeddable
public class Email implements Serializable {

    // The value of the email
    @Column(name = "email")
    private String value;

    /**
     * Default constructor required by JPA.
     * It is protected to prevent direct instantiation.
     */
    protected Email() {
    }

    /**
     * Constructor for Email.
     * It validates the input and throws an IllegalArgumentException if the input is null or does not match the email pattern.
     *
     * @param value The email string.
     * @throws IllegalArgumentException if the input is null or does not match the email pattern.
     */
    public Email(String value) {
        Preconditions.noneNull(value);
        if (value == null || !value.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            throw new IllegalArgumentException("Invalid email");
        }
        this.value = value;
    }

    /**
     * Overrides the equals method from Object.
     * Two Email objects are considered equal if their value fields are equal.
     *
     * @param o The object to compare this Email to.
     * @return true if the given object is an Email with the same value, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return value.equals(email.value);
    }

    /**
     * Overrides the hashCode method from Object.
     * The hash code of an Email object is the hash code of its value field.
     *
     * @return The hash code of the value field.
     */
    @Override
    public int hashCode() {
        return value.hashCode();
    }

    /**
     * Overrides the toString method from Object.
     * The string representation of an Email object includes its value field.
     *
     * @return A string representation of this Email.
     */
    @Override
    public String toString() {
        return this.value;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }
}
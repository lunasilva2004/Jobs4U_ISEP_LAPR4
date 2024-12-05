package jobs4u.core.customerusermanagement.domain;

import eapli.framework.validations.Preconditions;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * This class represents a PhoneNumber in the customer user management domain.
 * It is marked as Embeddable, which means it is not an entity but it can be embedded in an entity.
 * It has a single field, value, which represents the phone number string.
 */
@Embeddable
public class PhoneNumber {

    // The value of the phone number
    @Column(name = "phone_number")
    private String value;

    /**
     * Default constructor required by JPA.
     * It is protected to prevent direct instantiation.
     */
    protected PhoneNumber() {
    }

    /**
     * Constructor for PhoneNumber.
     * It validates the input and throws an IllegalArgumentException if the input is null or does not match the phone number pattern.
     *
     * @param value The phone number string.
     * @throws IllegalArgumentException if the input is null or does not match the phone number pattern.
     */
    public PhoneNumber(String value) {
        Preconditions.noneNull(value);
        if (value == null || !value.matches("\\d{9}")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.value = value;
    }

    /**
     * Overrides the equals method from Object.
     * Two PhoneNumber objects are considered equal if their value fields are equal.
     *
     * @param o The object to compare this PhoneNumber to.
     * @return true if the given object is a PhoneNumber with the same value, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber phoneNumber = (PhoneNumber) o;
        return value.equals(phoneNumber.value);
    }

    /**
     * Overrides the hashCode method from Object.
     * The hash code of a PhoneNumber object is the hash code of its value field.
     *
     * @return The hash code of the value field.
     */
    @Override
    public int hashCode() {
        return value.hashCode();
    }

    /**
     * Overrides the toString method from Object.
     * The string representation of a PhoneNumber object includes its value field.
     *
     * @return A string representation of this PhoneNumber.
     */
    @Override
    public String toString() {
        return "Phone Number - " +
                "\n\t Value = " + value;
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
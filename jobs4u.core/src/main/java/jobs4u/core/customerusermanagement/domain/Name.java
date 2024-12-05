package jobs4u.core.customerusermanagement.domain;

import eapli.framework.validations.Preconditions;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

/**
 * This class represents a Name in the customer user management domain.
 * It is marked as Embeddable, which means it is not an entity but it can be embedded in an entity.
 * It has a single field, value, which represents the name string.
 */
@Embeddable
public class Name {

    // The value of the name
    @Column(name = "name")
    private String value;

    /**
     * Default constructor required by JPA.
     * It is protected to prevent direct instantiation.
     */
    protected Name() {
    }

    /**
     * Constructor for Name.
     * It validates the input and throws an IllegalArgumentException if the input is null or does not match the name pattern.
     *
     * @param value The name string.
     * @throws IllegalArgumentException if the input is null or does not match the name pattern.
     */
    public Name(String value) {
        Preconditions.noneNull(value);
        if (value == null || !value.matches("[a-zA-Z ]+")) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.value = value;
    }

    /**
     * Value of name.
     *
     * @param name the name
     * @return the name
     */
    public static Name valueOf(String name) {
        return new Name(name);
    }

    /**
     * Overrides the equals method from Object.
     * Two Name objects are considered equal if their value fields are equal.
     *
     * @param o The object to compare this Name to.
     * @return true if the given object is a Name with the same value, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    /**
     * Overrides the hashCode method from Object.
     * The hash code of a Name object is the hash code of its value field.
     *
     * @return The hash code of the value field.
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    /**
     * Overrides the toString method from Object.
     * The string representation of a Name object includes its value field.
     *
     * @return A string representation of this Name.
     */
    @Override
    public String toString() {
        return  value;
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
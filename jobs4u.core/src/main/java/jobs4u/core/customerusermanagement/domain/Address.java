package jobs4u.core.customerusermanagement.domain;

import eapli.framework.validations.Preconditions;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * This class represents an Address in the customer user management domain.
 * It is marked as Embeddable, which means it is not an entity but it can be embedded in an entity.
 * It has a single field, value, which represents the address string.
 */
@Embeddable
public class Address {

    // The value of the address
    @Column(name = "address")
    private String value;

    /**
     * Default constructor required by JPA.
     * It is protected to prevent direct instantiation.
     */
    protected Address() {
    }

    /**
     * Constructor for Address.
     * It validates the input and throws an IllegalArgumentException if the input is null or empty.
     *
     * @param value The address string.
     * @throws IllegalArgumentException if the input is null or empty.
     */
    public Address(String value) {
        Preconditions.noneNull(value);
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.value = value;
    }

    /**
     * Overrides the equals method from Object.
     * Two Address objects are considered equal if their value fields are equal.
     *
     * @param o The object to compare this Address to.
     * @return true if the given object is an Address with the same value, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return value.equals(address.value);
    }

    /**
     * Overrides the hashCode method from Object.
     * The hash code of an Address object is the hash code of its value field.
     *
     * @return The hash code of the value field.
     */
    @Override
    public int hashCode() {
        return value.hashCode();
    }

    /**
     * Overrides the toString method from Object.
     * The string representation of an Address object includes its value field.
     *
     * @return A string representation of this Address.
     */
    @Override
    public String toString() {
        return "Address - " +
                "\n\t Value = " + value;
    }
}
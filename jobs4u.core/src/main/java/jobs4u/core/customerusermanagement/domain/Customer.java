package jobs4u.core.customerusermanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * The type Customer.
 */
@Setter
@Getter
@Entity
public class Customer implements AggregateRoot<String>, DTOable<CustomerDTO> {

    private static final long serialVersionUID = 1L;

    private Name name;
    @Id
    private Email email;
    private PhoneNumber phoneNumber;
    private Address address;

    /**
     * Instantiates a new Customer.
     *
     * @param name        the name
     * @param email       the email
     * @param phoneNumber the phone number
     * @param address     the address
     */
    public Customer(Name name, Email email, PhoneNumber phoneNumber, Address address) {
        Preconditions.noneNull(name, email, phoneNumber, address);
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    /**
     * Instantiates a new Customer.
     */
    protected Customer() {
        // for ORM only
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) && Objects.equals(email, customer.email) && Objects.equals(phoneNumber, customer.phoneNumber) && Objects.equals(address, customer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, phoneNumber, address);
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public String toString() {
        return "Customer - " +
                "\n\t Name = " + name +
                "\n\t Email = " + email +
                "\n\t Phone Number = " + phoneNumber +
                "\n\t Address = " + address;
    }

    @Override
    public String identity() {
        return this.email.toString();
    }

    @Override
    public CustomerDTO toDTO() {
        return new CustomerDTO(name, email, phoneNumber, address);
    }
}
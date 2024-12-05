package jobs4u.core.customerusermanagement.domain;

import eapli.framework.domain.model.DomainFactory;

/**
 * This class is a builder for the Customer class.
 * It implements the DomainFactory interface with the product being a Customer.
 * It has fields for name, email, phone number, and address, which are all components of a Customer.
 * It provides a fluent interface for setting these fields and building a Customer.
 */
public class CustomerBuilder implements DomainFactory<Customer> {
    // The name of the customer to be built
    private Name name;
    // The email of the customer to be built
    private Email email;
    // The phone number of the customer to be built
    private PhoneNumber phoneNumber;
    // The address of the customer to be built
    private Address address;

    /**
     * Sets the name field of this builder.
     *
     * @param name The name to set.
     * @return This builder, to allow method chaining.
     */
    public CustomerBuilder withName(Name name) {
        this.name = name;
        return this;
    }

    /**
     * Sets the email field of this builder.
     *
     * @param email The email to set.
     * @return This builder, to allow method chaining.
     */
    public CustomerBuilder withEmail(Email email) {
        this.email = email;
        return this;
    }

    /**
     * Sets the phone number field of this builder.
     *
     * @param phoneNumber The phone number to set.
     * @return This builder, to allow method chaining.
     */
    public CustomerBuilder withPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    /**
     * Sets the address field of this builder.
     *
     * @param address The address to set.
     * @return This builder, to allow method chaining.
     */
    public CustomerBuilder withAddress(Address address) {
        this.address = address;
        return this;
    }

    /**
     * Builds a Customer with the fields of this builder.
     *
     * @return A new Customer with the fields of this builder.
     */
    public Customer build() {
        return new Customer(name, email, phoneNumber, address);
    }
}
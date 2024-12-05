package jobs4u.core.customerusermanagement.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {

    private Customer customer;
    private Email email;
    private Name name;
    private PhoneNumber phoneNumber;
    private Address address;

    @BeforeEach
    void setUp() {
        email = new Email("isep@this.app");
        name = new Name("ISEP");
        phoneNumber = new PhoneNumber("912345678");
        address = new Address("Rua Dr. António Bernardino de Almeida 431 4200-072 Porto, Portugal");
        customer = new Customer(name, email, phoneNumber, address);
    }

    @Test
    void testEquals_SameObject() {
        assertEquals(customer, customer);
    }

    @Test
    void testEquals_DifferentType() {
        assertNotEquals(customer, new Object());
    }

    @Test
    void testEquals_Null() {
        assertNotEquals(customer, null);
    }

    @Test
    void testEquals_DifferentObject() {
        Customer customer2 = new Customer(new Name("FEUP"), email, phoneNumber, address);
        assertNotEquals(customer, customer2);
    }

    @Test
    void ensureMustHaveName() {
        assertThrows(IllegalArgumentException.class, () -> new Customer(null, email, phoneNumber, address));
    }

    @Test
    void ensureMustHaveEmail() {
        assertThrows(IllegalArgumentException.class, () -> new Customer(name, null, phoneNumber, address));
    }

    @Test
    void ensureMustHavePhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Customer(name, email, null, address));
    }

    @Test
    void ensureMustHaveAddress() {
        assertThrows(IllegalArgumentException.class, () -> new Customer(name, email, phoneNumber, null));
    }

    @Test
    void ensureMustMatchEmailPattern() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Email("invalid_email");
        });

        String expectedMessage = "Invalid email";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void ensureMustMatchPhoneNumberPattern() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new PhoneNumber("invalid_phone_number");
        });

        String expectedMessage = "Invalid phone number";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void ensureMustMatchNamePattern() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Name("123_invalid_name");
        });

        String expectedMessage = "Invalid name";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
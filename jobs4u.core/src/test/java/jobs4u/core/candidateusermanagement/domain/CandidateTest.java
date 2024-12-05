
package jobs4u.core.candidateusermanagement.domain;

import jobs4u.core.customerusermanagement.domain.Email;
import jobs4u.core.customerusermanagement.domain.Name;
import jobs4u.core.customerusermanagement.domain.PhoneNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CandidateTest {
    private Candidate candidate;
    private Email email;
    private Name name;
    private PhoneNumber phoneNumber;

    @BeforeEach
    void setUp() {
        email = new Email("tin@this.app");
        name = new Name("Tintin");
        phoneNumber = new PhoneNumber("912345678");
        candidate = new Candidate(name, email, phoneNumber);
    }

    @Test
    void testEquals_SameObject() {
        assertTrue(candidate.equals(candidate));
    }

    @Test
    void testEquals_DifferentType() {
        assertFalse(candidate.equals(new Object()));
    }

    @Test
    void testEquals_Null() {
        assertFalse(candidate.equals(null));
    }

    @Test
    void testEquals_DifferentObject() {
        Candidate candidate2 = new Candidate(new Name("Snowy"), email, phoneNumber);
        assertFalse(candidate.equals(candidate2));
    }

    @Test
    void ensureMustHaveName() {
        assertThrows(IllegalArgumentException.class, () -> new Candidate(null, email, phoneNumber));
    }

    @Test
    void ensureMustHaveEmail() {
        assertThrows(IllegalArgumentException.class, () -> new Candidate(name, null, phoneNumber));
    }

    @Test
    void ensureMustHavePhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Candidate(name, email, null));
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



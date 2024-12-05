package jobs4u.core.rankmanagement.domain;

import jobs4u.core.candidateusermanagement.domain.Candidate;
import jobs4u.core.customerusermanagement.domain.*;
import jobs4u.core.jobapplicationmanagement.domain.JobApplication;
import jobs4u.core.jobapplicationmanagement.domain.State;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    private Order order1;
    private Order order2;
    private JobOpening jobOpening;
    private JobApplication jobApplication;
    List<Order> orders;

    @BeforeEach
    public void setUp() {
        Customer customer = new Customer(
                new Name("Isep"),
                new Email("isep@this.app"),
                new PhoneNumber("912345678"),
                new Address("Rua Alberto")
        );

        String addressString = "Rua Alberto";
        Address address = new Address(addressString);

        jobOpening = new JobOpening(
                "ISEP-01",
                address,
                "ISEP Company",
                customer,
                "FullTime",
                "Engineer",
                "Presential",
                "2",
                Date.valueOf("2021-10-01"),
                Date.valueOf("2021-10-31")
        );
        Candidate candidate = new Candidate(
                new Name("Tintin"),
                new Email("tin@this.app"),
                new PhoneNumber("912345678")
        );
        jobApplication = new JobApplication(
                candidate,
                new ArrayList<>(),
                State.PENDING,
                Date.valueOf("2021-10-01"),
                jobOpening
        );
        order1 = new Order(1, jobApplication);
        order2 = new Order(2, jobApplication);
        orders = new ArrayList<>();
        orders.add(order1);
    }


    @Test
    void testEquals_SameObject() {
        assertTrue(order1.equals(order1));
    }

    @Test
    void testEquals_DifferentType() {
        assertFalse(order1.equals(new Object()));
    }

    @Test
    void testEquals_Null() {
        assertFalse(order1.equals(null));
    }

    @Test
    void testEquals_DifferentObject() {
        Order order3 = new Order(3, jobApplication);
        assertFalse(order1.equals(order3));
    }

    @Test
    void ensureMustHaveApplication() {
        assertThrows(IllegalArgumentException.class, () -> new Order(1, null));
    }


}
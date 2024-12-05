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

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    private Rank rank;
    private Order order1;
    private Order order2;
    private JobOpening jobOpening;
    private JobApplication jobApplication;
    List<Order> orders;


    @BeforeEach
    void setUp() {
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
        rank = new Rank(orders, jobOpening);
    }

    @Test
    void addOrder() {
        rank.addOrder(order2);
        assertTrue(rank.getRankOrders().contains(order2));
    }

    @Test
    void ensureRank() {
        assertEquals(rank.getJobOpening(), jobOpening);
        assertTrue(rank.getRankOrders().contains(order1));
    }

    @Test
    void ensureOrder() {
        rank.addOrder(order2);
        assertTrue(rank.getRankOrders().contains(order2));
    }

    @Test
    void testEquals_SameObject() {
        assertTrue(rank.equals(rank));
    }

    @Test
    void testEquals_DifferentType() {
        assertFalse(rank.equals(new Object()));
    }

    @Test
    void testEquals_Null() {
        assertFalse(rank.equals(null));
    }

    @Test
    void testEquals_DifferentObject() {
        List<Order> orders = new ArrayList<>();
        orders.add(order2);
        Rank rank2 = new Rank(orders, jobOpening);
        assertFalse(rank.equals(rank2));
    }

    @Test
    void testHashCode() {
        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        Rank rank2 = new Rank(orders, jobOpening);
        assertEquals(rank.hashCode(), rank2.hashCode());
    }

    @Test
    void testToString() {
        String expected = "Rank{" +
                "id=" + rank.getId() +
                ", orders=" + rank.getRankOrders() +
                '}';
        assertEquals(expected, rank.toString());
    }

    @Test
    void givenEverythingIsOkThenARankIsCreated() {
        final var subject = new Rank(orders, jobOpening);
        assertNotNull(subject);
    }

    @Test
    void ensureMustHaveOrde() {
        assertThrows(IllegalArgumentException.class, () -> new Rank(null, jobOpening));
    }

    @Test
    void ensureMustHaveJobOpening() {
        assertThrows(IllegalArgumentException.class, () -> new Rank(orders, null));
    }

}

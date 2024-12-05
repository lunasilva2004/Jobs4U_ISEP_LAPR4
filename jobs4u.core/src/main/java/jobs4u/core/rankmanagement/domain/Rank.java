package jobs4u.core.rankmanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Rank.
 */
@Entity
@Getter
@Setter
public class Rank implements AggregateRoot<Designation> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<Order> rankOrders = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "name")
    private JobOpening jobOpening;

    /**
     * Instantiates a new Rank.
     */
    public Rank() {
    }

    /**
     * Instantiates a new Rank.
     *
     * @param rankOrders the rank orders
     * @param jobOpening the job opening
     */
    public Rank(List<Order> rankOrders, JobOpening jobOpening) {
        Preconditions.noneNull(jobOpening, rankOrders);
        this.rankOrders = rankOrders;
        this.jobOpening = jobOpening;
    }

    /**
     * Add order.
     *
     * @param order the order
     */
    public void addOrder(Order order) {
        rankOrders.add(order);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rank rank = (Rank) o;
        return Objects.equals(id, rank.id) && Objects.equals(rankOrders, rank.rankOrders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rankOrders);
    }

    @Override
    public String toString() {
        return "Rank{" +
                "id=" + id +
                ", orders=" + rankOrders +
                '}';
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public Designation identity() {
        return this.jobOpening.identity();
    }
}
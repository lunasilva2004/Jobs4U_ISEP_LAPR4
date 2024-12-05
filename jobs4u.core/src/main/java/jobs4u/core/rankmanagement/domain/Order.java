package jobs4u.core.rankmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToOne;
import jobs4u.core.jobapplicationmanagement.domain.JobApplication;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;

/**
 * The type Order.
 */
@Embeddable
@Getter
@Setter
public class Order implements ValueObject, Comparable<Order> {

    @Column(name = "RankOrder", unique = true)
    private Integer value;

    @OneToOne
    private JobApplication jobApplication;

    /**
     * Instantiates a new Order.
     */
    public Order() {
        // Default constructor for JPA
    }

    /**
     * Instantiates a new Order.
     *
     * @param value          the value
     * @param jobApplication the job application
     */
    public Order(Integer value, JobApplication jobApplication) {
        Preconditions.noneNull(jobApplication);
        this.value = value;
        this.jobApplication = jobApplication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(value, order.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Order{" +
                "value=" + value +
                '}';
    }


    @Override
    public int compareTo(Order o) {
        return 0;
    }

}
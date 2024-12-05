package jobs4u.core.candidateusermanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.representations.Representationable;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jobs4u.core.customerusermanagement.domain.Email;
import jobs4u.core.customerusermanagement.domain.Name;
import jobs4u.core.customerusermanagement.domain.PhoneNumber;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * The type Candidate.
 */
@Setter
@Getter
@Entity
public class Candidate implements AggregateRoot<String>, DTOable<CandidateDTO>{
    private static final long serialVersionUID = 1L;

    private Name name;
    @Id
    private Email email;
    private PhoneNumber phoneNumber;


    /**
     * Instantiates a new Candidate.
     *
     * @param name        the name
     * @param email       the email
     * @param phoneNumber the phone number
     */
    public Candidate(Name name, Email email, PhoneNumber phoneNumber) {
        Preconditions.noneNull(name, email, phoneNumber);

        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Instantiates a new Candidate.
     */
    protected Candidate() {
        // for ORM only
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return Objects.equals(name, candidate.name) && Objects.equals(email, candidate.email) && Objects.equals(phoneNumber, candidate.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, phoneNumber);
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "firstName='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public String identity() {
        return this.email.toString();
    }

    @Override
    public CandidateDTO toDTO() {
        return new CandidateDTO(name, email, phoneNumber);
    }

}

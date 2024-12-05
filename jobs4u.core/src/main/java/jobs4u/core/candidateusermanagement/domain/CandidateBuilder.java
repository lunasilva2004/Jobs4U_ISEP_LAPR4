package jobs4u.core.candidateusermanagement.domain;

import eapli.framework.domain.model.DomainFactory;
import jobs4u.core.customerusermanagement.domain.Email;
import jobs4u.core.customerusermanagement.domain.Name;
import jobs4u.core.customerusermanagement.domain.PhoneNumber;

import java.util.regex.Pattern;

/**
 * The type Candidate builder.
 */
public class CandidateBuilder implements DomainFactory<Candidate> {
    private Name name;
    private Email email;
    private PhoneNumber phoneNumber;

    /**
     * With name candidate builder.
     *
     * @param name the name
     * @return the candidate builder
     */
    public CandidateBuilder withName(Name name) {
        this.name = name;
        return this;
    }

    /**
     * With email candidate builder.
     *
     * @param email the email
     * @return the candidate builder
     */
    public CandidateBuilder withEmail(Email email) {
        this.email = email;
        return this;
    }

    /**
     * With phone number candidate builder.
     *
     * @param phoneNumber the phone number
     * @return the candidate builder
     */
    public CandidateBuilder withPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Candidate build() {
        return new Candidate(name, email, phoneNumber);
    }
}
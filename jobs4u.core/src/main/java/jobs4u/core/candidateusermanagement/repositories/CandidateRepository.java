package jobs4u.core.candidateusermanagement.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import jobs4u.core.candidateusermanagement.domain.Candidate;
import jobs4u.core.customerusermanagement.domain.Email;

import java.util.Optional;


/**
 * The interface Candidate repository.
 */
public interface CandidateRepository extends DomainRepository<String, Candidate> {

    /**
     * Find by email optional.
     *
     * @param email the email
     * @return the optional
     */
    Optional<Candidate> findByEmail(Email email);
}


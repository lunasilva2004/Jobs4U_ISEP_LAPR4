package jobs4u.persistence.impl.jpa;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import jobs4u.Application;
import jobs4u.core.candidateusermanagement.domain.Candidate;
import jobs4u.core.candidateusermanagement.repositories.CandidateRepository;
import jobs4u.core.customerusermanagement.domain.Email;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * The type Candidate jpa repository.
 */
public class CandidateJpaRepository extends JpaAutoTxRepository<Candidate, String, String> implements CandidateRepository {

    /**
     * Instantiates a new Candidate jpa repository.
     *
     * @param autoTx the auto tx
     */
    public CandidateJpaRepository(final TransactionalContext autoTx) {
        super(autoTx, "email");
    }

    /**
     * Instantiates a new Candidate jpa repository.
     *
     * @param puname the puname
     */
    public CandidateJpaRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),"email");
    }

    @Override
    public Optional<Candidate> findByEmail(Email email) {
        final Map<String, Object> params = new HashMap<>();
        params.put("email", email);
        return matchOne("e.email = :email", params);
    }
}


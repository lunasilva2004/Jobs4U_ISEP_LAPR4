package jobs4u.persistence.impl.jpa;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import jobs4u.Application;
import jobs4u.core.interviewmanagement.domain.Interview;
import jobs4u.core.interviewmanagement.repository.InterviewRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * The type Jpa interview repository.
 */
public class JpaInterviewRepository extends JpaAutoTxRepository<Interview, String, String> implements InterviewRepository {

    /**
     * Instantiates a new Jpa interview repository.
     *
     * @param autoTx the auto tx
     */
    public JpaInterviewRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    /**
     * Instantiates a new Jpa interview repository.
     *
     * @param puname the puname
     */
    public JpaInterviewRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    @Override
    public Optional<Interview> findById(Long id) {
        final Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return matchOne("e.id = :id", params);
    }
}

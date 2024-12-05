package jobs4u.persistence.impl.jpa;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import jobs4u.Application;
import jobs4u.core.PluginManagement.InterviewModelManagement.domain.InterviewModel;
import jobs4u.core.PluginManagement.InterviewModelManagement.repository.InterviewModelRepository;
import jobs4u.core.customerusermanagement.domain.Name;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * The type Jpa interview model repository.
 */
public class JpaInterviewModelRepository extends JpaAutoTxRepository<InterviewModel, String, String> implements InterviewModelRepository {

    /**
     * Instantiates a new Jpa interview model repository.
     *
     * @param autoTx the auto tx
     */
    public JpaInterviewModelRepository(final TransactionalContext autoTx) {
        super(autoTx, "name");
    }

    /**
     * Instantiates a new Jpa interview model repository.
     *
     * @param puname the puname
     */
    public JpaInterviewModelRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "name");
    }

    @Override
    public Optional<InterviewModel> findByName(Name name) {
        final Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return matchOne("e.name = :name", params);
    }
}

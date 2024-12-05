package jobs4u.persistence.impl.jpa;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import jobs4u.Application;
import jobs4u.core.PluginManagement.RequirementsSpecificationManagement.domain.RequirementSpecification;
import jobs4u.core.PluginManagement.RequirementsSpecificationManagement.repository.RequirementRepo;
import jobs4u.core.customerusermanagement.domain.Name;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * The type Jpa requirements repository.
 */
public class JpaRequirementsRepository extends JpaAutoTxRepository<RequirementSpecification, String, String> implements RequirementRepo{

    /**
     * Instantiates a new Jpa requirements repository.
     *
     * @param autoTx the auto tx
     */
    public JpaRequirementsRepository(final TransactionalContext autoTx) {
        super(autoTx, "name");
    }

    /**
     * Instantiates a new Jpa requirements repository.
     *
     * @param puname the puname
     */
    public JpaRequirementsRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),"name");
    }
    @Override
    public Optional<RequirementSpecification> findByName(Name name) {
        final Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return matchOne("e.name = :name", params);
    }

}

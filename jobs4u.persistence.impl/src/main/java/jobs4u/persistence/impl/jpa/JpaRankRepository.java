package jobs4u.persistence.impl.jpa;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import jobs4u.Application;
import jobs4u.core.rankmanagement.domain.Rank;
import jobs4u.core.rankmanagement.repository.RankRepository;

import java.util.Optional;

/**
 * The type Jpa rank repository.
 */
public class JpaRankRepository extends JpaAutoTxRepository<Rank, Designation, Designation> implements RankRepository {
    /**
     * Instantiates a new Jpa rank repository.
     *
     * @param autoTx the auto tx
     */
    public JpaRankRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    /**
     * Instantiates a new Jpa rank repository.
     *
     * @param puname the puname
     */
    public JpaRankRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),"id");
    }


    @Override
    public Iterable<Rank> findAll() {
        return super.findAll();
    }

    @Override
    public Optional<Rank> ofIdentity(Designation id) {
        return Optional.empty();
    }

    @Override
    public void deleteOfIdentity(Designation entityId) {
        super.deleteOfIdentity(entityId);
    }

}
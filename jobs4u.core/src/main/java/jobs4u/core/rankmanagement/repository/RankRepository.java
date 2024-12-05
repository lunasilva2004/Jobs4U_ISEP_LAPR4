package jobs4u.core.rankmanagement.repository;

import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.Designation;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;
import jobs4u.core.rankmanagement.domain.Rank;

/**
 * The interface Rank repository.
 */
public interface RankRepository extends DomainRepository<Designation, Rank> {

    Iterable<Rank> findAll();

}

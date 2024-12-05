package jobs4u.core.interviewmanagement.repository;

import eapli.framework.domain.repositories.DomainRepository;
import jobs4u.core.PluginManagement.InterviewModelManagement.domain.InterviewModel;
import jobs4u.core.interviewmanagement.domain.Interview;

import java.util.Optional;

/**
 * The interface Interview repository.
 */
public interface InterviewRepository extends DomainRepository<String, Interview> {

    Iterable<Interview> findAll();

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<Interview> findById(Long id);
}

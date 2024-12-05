package jobs4u.core.PluginManagement.InterviewModelManagement.repository;

import eapli.framework.domain.repositories.DomainRepository;
import jobs4u.core.PluginManagement.InterviewModelManagement.domain.InterviewModel;
import jobs4u.core.customerusermanagement.domain.Name;

import java.util.Optional;

/**
 * The interface Interview model repository.
 */
public interface InterviewModelRepository extends DomainRepository<String, InterviewModel> {
    /**
     * Find by name optional.
     *
     * @param name the name
     * @return the optional
     */
    Optional<InterviewModel> findByName(Name name);
    Iterable<InterviewModel> findAll();
}

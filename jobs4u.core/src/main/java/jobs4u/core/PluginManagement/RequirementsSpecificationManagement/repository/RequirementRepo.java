package jobs4u.core.PluginManagement.RequirementsSpecificationManagement.repository;

import eapli.framework.domain.repositories.DomainRepository;
import jobs4u.core.PluginManagement.RequirementsSpecificationManagement.domain.RequirementSpecification;
import jobs4u.core.customerusermanagement.domain.Name;

import java.util.Optional;

public interface RequirementRepo extends DomainRepository<String, RequirementSpecification> {
    Iterable<RequirementSpecification> findAll();

    Optional<RequirementSpecification> findByName(Name name);
}

package jobs4u.core.PluginManagement.RequirementsSpecificationManagement.controller;

import jobs4u.core.PluginManagement.FQClassName;
import jobs4u.core.PluginManagement.RequirementsSpecificationManagement.domain.RequirementBuilder;
import jobs4u.core.PluginManagement.RequirementsSpecificationManagement.domain.RequirementSpecification;
import jobs4u.core.PluginManagement.RequirementsSpecificationManagement.repository.RequirementRepo;
import jobs4u.core.infrastructure.persistence.PersistenceContext;

public class RequirementController {
    private final RequirementRepo requirementRepo = PersistenceContext.repositories().requirement();

    public RequirementSpecification registerRequirementSpecification(final String name, final String description, final String className) {
        if (!className.equals("Other.JobRequirementsSpecification_EX1")) {
            throw new IllegalArgumentException("Invalid class name. Only Other.JobRequirementsSpecification_EX1 path is allowed.");
        }

        final var requirementBuilder = new RequirementBuilder()
                .withName(name)
                .withDescription(description)
                .withClassName(FQClassName.valueOf(className));
        final var newRequirement = requirementBuilder.build();

        return requirementRepo.save(newRequirement);
    }

    public Iterable<RequirementSpecification> getAllRequirementSpecifications() {
        return requirementRepo.findAll();
    }
}

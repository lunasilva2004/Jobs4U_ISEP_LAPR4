package jobs4u.core.PluginManagement.RequirementsSpecificationManagement.domain;

import eapli.framework.domain.model.DomainFactory;
import jobs4u.core.PluginManagement.Description;
import jobs4u.core.PluginManagement.FQClassName;
import jobs4u.core.customerusermanagement.domain.Name;

public class RequirementBuilder implements DomainFactory<RequirementSpecification> {

    private Name name;
    private Description description;
    private FQClassName className;

    public RequirementBuilder withName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = new Name(name);
        }
        return this;
    }

    public RequirementBuilder withDescription(String description) {
        if (description != null && !description.isEmpty()) {
            this.description = new Description(description);
        }
        return this;
    }

    public RequirementBuilder withClassName(FQClassName className) {
        this.className = className;
        return this;
    }

    @Override
    public RequirementSpecification build() {
        return new RequirementSpecification(name, description, className);
    }
}

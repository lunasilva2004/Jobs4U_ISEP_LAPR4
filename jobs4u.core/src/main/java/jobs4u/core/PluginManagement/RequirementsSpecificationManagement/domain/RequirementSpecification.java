package jobs4u.core.PluginManagement.RequirementsSpecificationManagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jobs4u.core.PluginManagement.Description;
import jobs4u.core.PluginManagement.FQClassName;
import jobs4u.core.customerusermanagement.domain.Name;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
public class RequirementSpecification implements AggregateRoot <String>{
    @Id
    private Name name;
    private Description description;
    private FQClassName className;

    public RequirementSpecification(Name name, Description description, FQClassName className) {
        this.name = name;
        this.description = description;
        this.className = className;
    }

    public RequirementSpecification() {
        // for ORM only
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequirementSpecification that = (RequirementSpecification) o;
        return Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(className, that.className);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, className);
    }

    @Override
    public String toString() {
        return "RequirementsSpecification{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", className='" + className + '\'' +
                '}';
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public int compareTo(String other) {
        return AggregateRoot.super.compareTo(other);
    }


    @Override
    public String identity() {
        return name.getValue();
    }

    @Override
    public boolean hasIdentity(String id) {
        return AggregateRoot.super.hasIdentity(id);
    }
}

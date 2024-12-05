package jobs4u.core.PluginManagement.InterviewModelManagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jobs4u.core.PluginManagement.Description;
import jobs4u.core.PluginManagement.FQClassName;
import jobs4u.core.customerusermanagement.domain.Name;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * The type Interview model.
 */
@Getter
@Setter
@Entity
public class InterviewModel implements AggregateRoot<String> {

    @Id
    private Name name;
    private Description description;
    private FQClassName className;

    /**
     * Instantiates a new Interview model.
     *
     * @param name        the name
     * @param description the description
     * @param className   the class name
     */
    public InterviewModel(Name name, Description description, FQClassName className) {
        this.name = name;
        this.description = description;
        this.className = className;
    }

    /**
     * Instantiates a new Interview model.
     */
    public InterviewModel() {
        // for ORM purposes only
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InterviewModel that = (InterviewModel) o;
        return Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(className, that.className);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, className);
    }

    @Override
    public String toString() {
        return "InterviewModel{" +
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
        return this.name.getValue();
    }

    @Override
    public boolean hasIdentity(String id) {
        return AggregateRoot.super.hasIdentity(id);
    }
}

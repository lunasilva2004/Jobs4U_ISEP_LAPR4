package jobs4u.core.PluginManagement.InterviewModelManagement.domain;

import eapli.framework.domain.model.DomainFactory;
import jobs4u.core.PluginManagement.Description;
import jobs4u.core.PluginManagement.FQClassName;
import jobs4u.core.customerusermanagement.domain.Name;


/**
 * The type Interview model builder.
 */
public class InterviewModelBuilder implements DomainFactory<InterviewModel>{
    private Name name;
    private Description description;
    private FQClassName className;

    /**
     * With name interview model builder.
     *
     * @param name the name
     * @return the interview model builder
     */
    public InterviewModelBuilder withName(Name name) {
        this.name = name;
        return this;
    }

    /**
     * With description interview model builder.
     *
     * @param description the description
     * @return the interview model builder
     */
    public InterviewModelBuilder withDescription(Description description) {
        this.description = description;
        return this;
    }

    /**
     * With class name interview model builder.
     *
     * @param className the class name
     * @return the interview model builder
     */
    public InterviewModelBuilder withClassName(FQClassName className) {
        this.className = className;
        return this;
    }

    @Override
    public InterviewModel build() {
        return new InterviewModel(name, description, className);
    }
}

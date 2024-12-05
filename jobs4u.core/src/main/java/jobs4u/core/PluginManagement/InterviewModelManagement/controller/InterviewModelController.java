package jobs4u.core.PluginManagement.InterviewModelManagement.controller;

import jobs4u.core.PluginManagement.Description;
import jobs4u.core.PluginManagement.FQClassName;
import jobs4u.core.PluginManagement.InterviewModelManagement.domain.InterviewModel;
import jobs4u.core.PluginManagement.InterviewModelManagement.domain.InterviewModelBuilder;
import jobs4u.core.PluginManagement.InterviewModelManagement.repository.InterviewModelRepository;
import jobs4u.core.customerusermanagement.domain.Name;
import jobs4u.core.infrastructure.persistence.PersistenceContext;

/**
 * The type Interview model controller.
 */
public class InterviewModelController {
    private final InterviewModelRepository interviewModelRepository = PersistenceContext.repositories().interviewModel();

    /**
     * Register interview model interview model.
     *
     * @param name        the name
     * @param description the description
     * @param className   the class name
     * @return the interview model
     */
    public InterviewModel registerInterviewModel(final String name, final String description, final String className) {
        if (!className.equals("Other.InterviewModel_EX1")) {
            throw new IllegalArgumentException("Invalid class name. Only Other.InterviewModel_EX1 path is allowed.");
        }

        final var interviewBuilder = new InterviewModelBuilder()
                .withName(Name.valueOf(name))
                .withDescription(Description.valueOf(description))
                .withClassName(FQClassName.valueOf(className));
        final var newInterview = interviewBuilder.build();

        return interviewModelRepository.save(newInterview);
    }

    /**
     * Gets all interview models.
     *
     * @return the all interview models
     */
    public Iterable<InterviewModel> getAllInterviewModels() {
        return interviewModelRepository.findAll();
    }
}


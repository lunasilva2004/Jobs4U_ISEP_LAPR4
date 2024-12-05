package jobs4u.core.interviewmanagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import jobs4u.core.PluginManagement.InterviewModelManagement.domain.InterviewModel;
import jobs4u.core.infrastructure.persistence.PersistenceContext;
import jobs4u.core.interviewmanagement.domain.Interview;
import jobs4u.core.interviewmanagement.repository.InterviewRepository;
import jobs4u.core.usermanagement.domain.BaseRoles;

/**
 * The type Interview controller.
 */
public class InterviewController {

    private final InterviewRepository interviewRepository = PersistenceContext.repositories().interview();

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    /**
     * All interviews iterable.
     *
     * @return the iterable
     */
    public Iterable<Interview> allInterviews() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        return interviewRepository.findAll();
    }
}

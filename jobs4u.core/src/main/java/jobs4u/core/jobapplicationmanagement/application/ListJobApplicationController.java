package jobs4u.core.jobapplicationmanagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import jobs4u.core.customerusermanagement.domain.Email;
import jobs4u.core.jobapplicationmanagement.application.Services.ListJobApplicationService;
import jobs4u.core.jobapplicationmanagement.domain.JobApplication;
import jobs4u.core.usermanagement.domain.BaseRoles;

import java.util.List;

/**
 * The type List job application controller.
 */
@UseCaseController
public class ListJobApplicationController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ListJobApplicationService jobApplicationService = new ListJobApplicationService();

    /**
     * All job applications list.
     *
     * @param jobReference the job reference
     * @return the list
     */
    public List<JobApplication> allJobApplications(Designation jobReference) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        return jobApplicationService.allJobApplications(jobReference);
    }

    /**
     * List job applications for candidate list.
     *
     * @return the list
     */
    public List<String> listJobApplicationsForCandidate() {
        authz.isAuthenticatedUserAuthorizedTo(BaseRoles.CANDIDATE);
        String emailInput = authz.session().get().authenticatedUser().username().toString();
        Email email = new Email(emailInput);
        return jobApplicationService.listJobApplicationsForCandidate(email);
    }
}
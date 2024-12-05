package jobs4u.core.jobapplicationmanagement.application;

import Other.InterviewModel_EX1;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import jobs4u.core.infrastructure.persistence.PersistenceContext;
import jobs4u.core.jobapplicationmanagement.application.Services.GradeInterviewService;
import jobs4u.core.jobapplicationmanagement.repositories.JobApplicationRepository;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;
import jobs4u.core.jobopeningmanagement.repositories.JobOpeningRepository;
import jobs4u.core.usermanagement.domain.BaseRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * The type Grade interview controller.
 */
@Controller
public class GradeInterviewController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final JobApplicationRepository jobApplicationRepository = PersistenceContext.repositories().jobApplications();

    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();
    private final InterviewModel_EX1 interviewModel_ex1 = new InterviewModel_EX1();


    /**
     * Instantiates a new Grade interview controller.
     */
    @Autowired
    public GradeInterviewController() {}

    /**
     * Grade interview boolean.
     *
     * @param jobReference the job reference
     * @return the boolean
     */
    public boolean gradeInterview(Designation jobReference) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);

        GradeInterviewService gradeInterviewService = new GradeInterviewService(jobApplicationRepository, interviewModel_ex1, jobOpeningRepository);
        return gradeInterviewService.gradeInterview(jobReference);
    }
}
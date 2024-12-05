package jobs4u.core.jobapplicationmanagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Designation;
import jobs4u.core.infrastructure.persistence.PersistenceContext;
import jobs4u.core.jobapplicationmanagement.application.Services.ListCandidatesByInterviewGradeService;
import jobs4u.core.jobapplicationmanagement.dto.JobApplicationDTO;
import jobs4u.core.jobapplicationmanagement.repositories.JobApplicationRepository;
import jobs4u.core.jobopeningmanagement.repositories.JobOpeningRepository;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * The type List candidates by interviews grade controller.
 */
@UseCaseController
public class ListCandidatesByInterviewsGradeController {

    private final JobApplicationRepository jobApplicationRepository = PersistenceContext.repositories().jobApplications();

    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();


    /**
     * Instantiates a new List candidates by interviews grade controller.
     */
    public ListCandidatesByInterviewsGradeController() {
    }


    /**
     * All candidates by interview grade map.
     *
     * @param jobReference the job reference
     * @return the map
     * @throws IOException the io exception
     */
    public Map<JobApplicationDTO, String> allCandidatesByInterviewGrade(Designation jobReference) throws IOException {

        ListCandidatesByInterviewGradeService service = new ListCandidatesByInterviewGradeService(jobApplicationRepository, jobOpeningRepository);

        return service.allCandidatesByInterviewGrade(jobReference);
    }
}

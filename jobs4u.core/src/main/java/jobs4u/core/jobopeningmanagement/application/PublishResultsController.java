package jobs4u.core.jobopeningmanagement.application;

import eapli.framework.general.domain.model.Designation;
import jobs4u.core.infrastructure.persistence.PersistenceContext;
import jobs4u.core.jobopeningmanagement.application.Services.PublishResultsService;

import jobs4u.core.jobopeningmanagement.repositories.JobOpeningRepository;
import jobs4u.core.rankmanagement.repository.RankRepository;
import lapr4.emailService.EmailService;


/**
 * The type Publish results controller.
 */
public class PublishResultsController {

    private final RankRepository rankRepository = PersistenceContext.repositories().ranks();

    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();

    private final EmailService emailService = new EmailService();


    /**
     * Instantiates a new Publish results controller.
     */
    public PublishResultsController() {
    }


    /**
     * Publish results boolean.
     *
     * @param jobReference the job reference
     * @return the boolean
     */
    public boolean publishResults(Designation jobReference) {

        PublishResultsService publishResultsService = new PublishResultsService(rankRepository,emailService, jobOpeningRepository);

        return publishResultsService.notifyCandidatesAndCustomers(jobReference);
    }
}

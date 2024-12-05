package jobs4u.core.jobopeningmanagement.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.Designation;
import jobs4u.core.jobapplicationmanagement.domain.JobApplication;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;
import jobs4u.core.jobopeningmanagement.domain.JobOpeningPhase;
import jobs4u.core.jobopeningmanagement.domain.PhaseType;

import java.util.List;
import java.util.Optional;

/**
 * The interface Job opening repository.
 */
public interface JobOpeningRepository extends DomainRepository<Designation, JobOpening> {

    Iterable<JobOpening> findAll();

    /**
     * Find by reference optional.
     *
     * @param reference the reference
     * @return the optional
     */
    Optional<JobOpening> findByReference(Designation reference);

    /**
     * Find by job application optional.
     *
     * @param jobApplication the job application
     * @return the optional
     */
    Optional<JobOpening> findByJobApplication(JobApplication jobApplication);

    /**
     * Find by customer email list.
     *
     * @param email the email
     * @return the list
     */
    List<JobOpening> findByCustomerEmail(String email);

    /**
     * Count applications by job reference int.
     *
     * @param jobReference the job reference
     * @return the int
     */
    int countApplicationsByJobReference(Designation jobReference);

    /**
     * Find job openings by phase list.
     *
     * @param phase the phase
     * @return the list
     */
    List<JobOpening> findJobOpeningsByPhase(PhaseType phase);
}

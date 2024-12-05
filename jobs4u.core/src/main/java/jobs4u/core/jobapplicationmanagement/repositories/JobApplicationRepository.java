package jobs4u.core.jobapplicationmanagement.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.Designation;
import jobs4u.core.customerusermanagement.domain.Email;
import jobs4u.core.jobapplicationmanagement.domain.JobApplication;
import jobs4u.core.jobapplicationmanagement.domain.State;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;

import java.util.List;
import java.util.Optional;

/**
 * The interface Job application repository.
 */
public interface JobApplicationRepository extends DomainRepository<Long, JobApplication> {

    Iterable<JobApplication> findAll();

    /**
     * Find by job opening list.
     *
     * @param jobOpening the job opening
     * @return the list
     */
    List<JobApplication> findByJobOpening(JobOpening jobOpening);

    /**
     * Find by job reference list.
     *
     * @param jobReference the job reference
     * @return the list
     */
    List<JobApplication> findByJobReference(Designation jobReference);

    /**
     * Find pendings by job opening list.
     *
     * @param jobOpening the job opening
     * @param state      the state
     * @return the list
     */
    List<JobApplication> findPendingsByJobOpening(Designation jobOpening, State state);

    /**
     * Find verified applications list.
     *
     * @param states the states
     * @return the list
     */
    List<JobApplication> findVerifiedApplications(List<State> states);

    /**
     * Find by candidate email list.
     *
     * @param email the email
     * @return the list
     */
    List<JobApplication> findByCandidateEmail(Email email);

    /**
     * Find job application by id optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<JobApplication> findJobApplicationById(Long id);
}

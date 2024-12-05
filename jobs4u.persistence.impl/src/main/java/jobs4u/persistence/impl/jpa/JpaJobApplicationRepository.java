package jobs4u.persistence.impl.jpa;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import jobs4u.Application;
import jobs4u.core.customerusermanagement.domain.Email;
import jobs4u.core.jobapplicationmanagement.domain.JobApplication;
import jobs4u.core.jobapplicationmanagement.domain.State;
import jobs4u.core.jobapplicationmanagement.repositories.JobApplicationRepository;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;


import java.util.*;

/**
 * The type Jpa job application repository.
 */
public class JpaJobApplicationRepository extends JpaAutoTxRepository<JobApplication, Long, Long> implements JobApplicationRepository {

    /**
     * Instantiates a new Jpa job application repository.
     *
     * @param autoTx the auto tx
     */
    public JpaJobApplicationRepository(final TransactionalContext autoTx) {
        super(autoTx, "iD");
    }

    /**
     * Instantiates a new Jpa job application repository.
     *
     * @param puname the puname
     */
    public JpaJobApplicationRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),"iD");
    }

    @Override
    public Optional<JobApplication> ofIdentity(Long  id) {
        return Optional.empty();
    }

    @Override
    public void delete(JobApplication entity) {

    }

    @Override
    public void deleteOfIdentity(Long entityId) {

    }

    @Override
    public long count() {
        return 0;
    }

    public List<JobApplication> findByJobReference(Designation jobReference) {
        final Map<String, Object> params = new HashMap<>();
        params.put("jobReference", jobReference);
        return match("e.jobOpening.jobReference = :jobReference", params);
    }

    @Override
    public List<JobApplication> findByJobOpening(JobOpening jobOpening) {
        return List.of();
    }

    @Override
    public List<JobApplication> findPendingsByJobOpening(Designation jobOpening, State state) {
        final Map<String, Object> params = new HashMap<>();
        params.put("jobOpening", jobOpening);
        params.put("state", state);
        return match("e.jobOpening.jobReference = :jobOpening AND e.state = :state", params);
    }

    @Override
    public Optional<JobApplication> findJobApplicationById(Long id) {
        final Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return matchOne("e.iD = :id", params);
    }

    @Override
    public List<JobApplication> findVerifiedApplications(List<State> states) {
        final Map<String, Object> params = new HashMap<>();
        params.put("states", states);
        return match("e.state IN :states", params);
    }

    @Override
    public List<JobApplication> findByCandidateEmail(Email email) {
        final Map<String, Object> params = new HashMap<>();
        params.put("email", email.getValue());
        return match("e.candidate.email.value = :email", params);
    }
}
package jobs4u.persistence.impl.jpa;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import jakarta.persistence.TypedQuery;
import jobs4u.Application;
import jobs4u.core.jobapplicationmanagement.domain.JobApplication;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;
import jobs4u.core.jobopeningmanagement.domain.PhaseType;
import jobs4u.core.jobopeningmanagement.repositories.JobOpeningRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * The type Jpa job opening repository.
 */
public class JpaJobOpeningRepository extends JpaAutoTxRepository<JobOpening, Designation, Designation> implements JobOpeningRepository {

    /**
     * Instantiates a new Jpa job opening repository.
     *
     * @param autoTx the auto tx
     */
    public JpaJobOpeningRepository(final TransactionalContext autoTx) {
        super(autoTx, "JobReference");
    }

    /**
     * Instantiates a new Jpa job opening repository.
     *
     * @param puname the puname
     */
    public JpaJobOpeningRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),"JobReference");
    }

    @Override
    public Optional<JobOpening> ofIdentity(Designation id) {
        return Optional.empty();
    }

    @Override
    public void delete(JobOpening entity) {
        super.delete(entity);
    }

    @Override
    public void deleteOfIdentity(Designation entityId) {
        super.deleteOfIdentity(entityId);
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Iterable<JobOpening> findAll() {
        return super.findAll();
    }

    @Override
    public Optional<JobOpening> findByReference(Designation reference) {
        final Map<String, Object> params = new HashMap<>();
        params.put("jobReference", reference);
        return matchOne("e.jobReference = :jobReference", params);
    }

    @Override
    public Optional<JobOpening> findByJobApplication(JobApplication jobApplication) {
        final Map<String, Object> params = new HashMap<>();
        params.put("jobApplication", jobApplication);
        return matchOne("e.jobApplications = :jobApplication", params);
    }

    @Override
    public List<JobOpening> findByCustomerEmail(String email) {
        final Map<String, Object> params = new HashMap<>();
        params.put("email", email);
        return match("e.customer.email.value = :email", params);
    }

    @Override
    public int countApplicationsByJobReference(Designation jobReference) {
        final Map<String, Object> params = new HashMap<>();
        params.put("jobReference", jobReference);
        TypedQuery<Long> query = entityManager().createQuery(
                "SELECT COUNT(ja) FROM JobApplication ja WHERE ja.jobOpening.jobReference = :jobReference", Long.class);
        query.setParameter("jobReference", jobReference);
        return query.getSingleResult().intValue();
    }

    @Override
    public List<JobOpening> findJobOpeningsByPhase(PhaseType phase) {
        final Map<String, Object> params = new HashMap<>();
        params.put("phase", phase);
        return match("e.currentPhase.phaseType = :phase", params);
    }

}

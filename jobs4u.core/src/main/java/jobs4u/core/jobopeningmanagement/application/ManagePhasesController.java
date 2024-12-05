package jobs4u.core.jobopeningmanagement.application;

import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import jakarta.transaction.Transactional;
import jobs4u.core.infrastructure.persistence.PersistenceContext;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;
import jobs4u.core.jobopeningmanagement.domain.JobOpeningPhase;
import jobs4u.core.jobopeningmanagement.repositories.JobOpeningRepository;
import jobs4u.core.usermanagement.domain.BaseRoles;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Manage phases controller.
 */
public class ManagePhasesController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();

    /**
     * Gets job openings.
     *
     * @return the job openings
     */
    public Iterable<JobOpening> getJobOpenings() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);

        Iterable<JobOpening> jobOpenings;
        jobOpenings = jobOpeningRepository.findAll();

        return jobOpenings;
    }

    /**
     * Gets job opening phases.
     *
     * @param jobReference the job reference
     * @return the job opening phases
     */
    public List<JobOpeningPhase> getJobOpeningPhases(Designation jobReference) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);

        JobOpening jobOpening1;
        jobOpening1 = jobOpeningRepository.findByReference(jobReference).orElseThrow(() -> new IllegalArgumentException("Job opening not found"));

        return jobOpening1.toDTO().getPhase();
    }

    /**
     * Gets current phase.
     *
     * @param jobReference the job reference
     * @return the current phase
     */
    public JobOpeningPhase getCurrentPhase(Designation jobReference) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);

        JobOpening jobOpening1;
        jobOpening1 = jobOpeningRepository.findByReference(jobReference).orElseThrow(() -> new IllegalArgumentException("Job opening not found"));

        return jobOpening1.toDTO().getCurrentPhase();
    }

    /**
     * Start phases.
     *
     * @param jobReference the job reference
     */
    @Transactional
    public void startPhases(Designation jobReference) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);

        JobOpening jobOpening1;
        jobOpening1 = jobOpeningRepository.findByReference(jobReference).orElseThrow(() -> new IllegalArgumentException("Job opening not found"));

        jobOpening1.setCurrentPhase(jobOpening1.toDTO().getPhase().get(0));
        jobOpeningRepository.save(jobOpening1);
    }

    /**
     * Previous phase list.
     *
     * @param jobReference the job reference
     * @return the list
     */
    @Transactional
    public List<String> previousPhase(Designation jobReference) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        List<String> executionMessages = new ArrayList<>();

        JobOpening jobOpening1;
        jobOpening1 = jobOpeningRepository.findByReference(jobReference).orElseThrow(() -> new IllegalArgumentException("Job opening not found"));

        boolean isOperationSuccessfully = jobOpening1.previousPhase();
        if (isOperationSuccessfully) {
            jobOpeningRepository.save(jobOpening1);
        }else {
            executionMessages.add("This is the first phase, you can't go back.");
        }
        return executionMessages;
    }

    /**
     * Next phase list.
     *
     * @param jobReference the job reference
     * @return the list
     */
    @Transactional
    public List<String> nextPhase(Designation jobReference) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        List<String> executionMessages = new ArrayList<>();

        JobOpening jobOpening1;
        jobOpening1 = jobOpeningRepository.findByReference(jobReference).orElseThrow(() -> new IllegalArgumentException("Job opening not found"));

        boolean isOperationSuccessfully = jobOpening1.nextPhase();
        if (isOperationSuccessfully) {
            jobOpeningRepository.save(jobOpening1);
        }else {
            executionMessages.add("This is the last phase, you can't go forward.");
        }
        return executionMessages;
    }

    /**
     * Sets current phase.
     *
     * @param jobReference  the job reference
     * @param selectedPhase the selected phase
     */
    @Transactional
    public void setCurrentPhase(Designation jobReference, JobOpeningPhase selectedPhase) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);

        JobOpening jobOpening1;
        jobOpening1 = jobOpeningRepository.findByReference(jobReference).orElseThrow(() -> new IllegalArgumentException("Job opening not found"));

        jobOpening1.setCurrentPhase(selectedPhase);
        jobOpeningRepository.save(jobOpening1);
    }

    /**
     * Update phases based on date.
     */
    @Transactional
    public void updatePhasesBasedOnDate() {
        Iterable<JobOpening> jobOpenings = getJobOpenings();

        for (JobOpening jobOpening : jobOpenings) {
            List<JobOpeningPhase> phases = getJobOpeningPhases(jobOpening.toDTO().getJobReference());

            for (JobOpeningPhase phase : phases) {
                if (isCurrentDateWithinPhaseRange(phase)) {
                    setCurrentPhase(jobOpening.toDTO().getJobReference(), phase);
                    break;
                }
            }
        }
    }

    private boolean isCurrentDateWithinPhaseRange(JobOpeningPhase phase) {
        Date currentDate = new Date(System.currentTimeMillis());
        return !currentDate.before(phase.getStartDate()) && !currentDate.after(phase.getEndDate());
    }
}
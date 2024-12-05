package jobs4u.core.jobopeningmanagement.application;

import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import jakarta.transaction.Transactional;
import jobs4u.core.infrastructure.persistence.PersistenceContext;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;
import jobs4u.core.jobopeningmanagement.domain.JobOpeningPhase;
import jobs4u.core.jobopeningmanagement.domain.PhaseType;
import jobs4u.core.jobopeningmanagement.repositories.JobOpeningRepository;
import jobs4u.core.usermanagement.domain.BaseRoles;

import java.sql.Date;
import java.util.ArrayList;

/**
 * The type Setup phases controller.
 */
public class SetupPhasesController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();

    /**
     * List job openings iterable.
     *
     * @return the iterable
     */
    public Iterable<JobOpening> listJobOpenings() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);

        Iterable<JobOpening> jobOpenings;
        jobOpenings = jobOpeningRepository.findAll();

        return jobOpenings;
    }

    /**
     * Add phases to job opening.
     *
     * @param jobReference the job reference
     * @param phaseType    the phase type
     * @param startDate    the start date
     * @param endDate      the end date
     */
    @Transactional
    public void addPhasesToJobOpening(Designation jobReference, PhaseType phaseType, Date startDate, Date endDate) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);

        JobOpening jobOpening1;
        jobOpening1 = jobOpeningRepository.findByReference(jobReference).orElseThrow(() -> new IllegalArgumentException("Job opening not found"));

        // Verificar se as datas da nova fase se sobrepõem com as de qualquer fase existente
        for (JobOpeningPhase existingPhase : jobOpening1.toDTO().getPhase()) {
            if ((startDate.before(existingPhase.getEndDate()) && endDate.after(existingPhase.getStartDate())) ||
                    (startDate.equals(existingPhase.getStartDate()) || endDate.equals(existingPhase.getEndDate()))) {
                throw new IllegalArgumentException("As fases não podem se sobrepor.");
            }
        }

        JobOpeningPhase phase = new JobOpeningPhase(phaseType, startDate, endDate, jobOpening1);
        jobOpening1.addPhase(phase);
        jobOpeningRepository.save(jobOpening1);
    }
}
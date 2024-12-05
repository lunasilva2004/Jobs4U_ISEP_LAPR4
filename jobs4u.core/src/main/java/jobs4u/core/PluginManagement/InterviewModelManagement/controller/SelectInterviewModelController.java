package jobs4u.core.PluginManagement.InterviewModelManagement.controller;

import eapli.framework.application.UseCaseController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import jakarta.transaction.Transactional;
import jobs4u.core.PluginManagement.InterviewModelManagement.domain.InterviewModel;
import jobs4u.core.PluginManagement.InterviewModelManagement.repository.InterviewModelRepository;
import jobs4u.core.customerusermanagement.domain.Name;
import jobs4u.core.infrastructure.persistence.PersistenceContext;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;
import jobs4u.core.jobopeningmanagement.repositories.JobOpeningRepository;
import jobs4u.core.usermanagement.domain.BaseRoles;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Select interview model controller.
 */
@UseCaseController
public class SelectInterviewModelController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();
    private final InterviewModelRepository interviewModelRepository = PersistenceContext.repositories().interviewModel();

    /**
     * Find job openingt by reference optional.
     *
     * @param reference the reference
     * @return the optional
     */
    public Optional<JobOpening> findJobOpeningtByReference(Designation reference) {
        return jobOpeningRepository.findByReference(reference);
    }

    /**
     * Associate interview model to job opening.
     *
     * @param name         the name
     * @param jobReference the job reference
     */
    @Transactional
    public void associateInterviewModelToJobOpening(Name name, Designation jobReference) {

        Optional<InterviewModel> optionalInterviewModel = interviewModelRepository.findByName(name);
        if (optionalInterviewModel.isEmpty()) {
            System.out.println("InterviewModel not found.");
            return;
        }
        InterviewModel interviewModel = optionalInterviewModel.get();

        Optional<JobOpening> optionalJobOpening = findJobOpeningtByReference(jobReference);

        if (optionalJobOpening.isPresent()) {
            JobOpening jobOpening = optionalJobOpening.get();

            // Log the name of the InterviewModel that is being associated
            System.out.println("Associating InterviewModel with name: " + interviewModel.getName().getValue());

            // Change the interview model of the job opening
            jobOpening.updateInterviewModel(interviewModel);

            try {
                jobOpeningRepository.save(jobOpening);
                System.out.println("Interview model updated successfully for the selected job opening.");
            } catch (ConcurrencyException | IntegrityViolationException e) {
                System.out.println("Error occurred while updating the interview model.");
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        } else {
            System.out.println("Job opening not found.");
        }
    }

    /**
     * Gets all job openings.
     *
     * @return the all job openings
     */
    public List<JobOpening> getAllJobOpenings() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        Iterable<JobOpening> jobOpenings = jobOpeningRepository.findAll();
        List<JobOpening> jobOpeningList = new ArrayList<>();
        jobOpenings.forEach(jobOpeningList::add);
        return jobOpeningList;
    }

    /**
     * Gets job opening by index.
     *
     * @param index the index
     * @return the job opening by index
     */
    public JobOpening getJobOpeningByIndex(int index) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        return getAllJobOpenings().get(index);
    }

    /**
     * Gets all interview models.
     *
     * @return the all interview models
     */
    public List<InterviewModel> getAllInterviewModels() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        Iterable<InterviewModel> interviewModels = interviewModelRepository.findAll();
        List<InterviewModel> interviewModelList = new ArrayList<>();
        interviewModels.forEach(interviewModelList::add);
        return interviewModelList;
    }

    /**
     * Gets interview model by index.
     *
     * @param index the index
     * @return the interview model by index
     */
    public InterviewModel getInterviewModelByIndex(int index) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        return getAllInterviewModels().get(index);
    }

}
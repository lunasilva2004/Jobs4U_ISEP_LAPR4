package jobs4u.core.PluginManagement.RequirementsSpecificationManagement.controller;

import eapli.framework.application.UseCaseController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import jakarta.transaction.Transactional;
import jobs4u.core.PluginManagement.RequirementsSpecificationManagement.domain.RequirementSpecification;
import jobs4u.core.PluginManagement.RequirementsSpecificationManagement.repository.RequirementRepo;
import jobs4u.core.customerusermanagement.domain.Name;
import jobs4u.core.infrastructure.persistence.PersistenceContext;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;
import jobs4u.core.jobopeningmanagement.repositories.JobOpeningRepository;
import jobs4u.core.usermanagement.domain.BaseRoles;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@UseCaseController
public class SelectRequirementController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final RequirementRepo requirementRepo = PersistenceContext.repositories().requirement();
    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();

    public Optional<JobOpening> findJobOpeningtByReference(Designation reference) {
        return jobOpeningRepository.findByReference(reference);
    }

    @Transactional
    public void associateRequirementToJobOpening(Name name, Designation jobReference) {

        Optional<RequirementSpecification> optionalRequirement = requirementRepo.findByName(name);
        if (optionalRequirement.isEmpty()) {
            System.out.println("Requirement not found.");
            return;
        }
        RequirementSpecification requirement = optionalRequirement.get();

        Optional<JobOpening> optionalJobOpening = findJobOpeningtByReference(jobReference);

        if (optionalJobOpening.isPresent()) {
            JobOpening jobOpening = optionalJobOpening.get();

            // Log the name of the Requirement that is being associated
            System.out.println("Associating Requirement with name: " + requirement.getName().getValue());

            // Change the requirement of the job opening
            jobOpening.updateRequirement(requirement);

            try {
                jobOpeningRepository.save(jobOpening);
                System.out.println("Requirement updated successfully for the selected job opening.");
            } catch (ConcurrencyException | IntegrityViolationException e) {
                System.out.println("Error occurred while updating the requirement.");
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        } else {
            System.out.println("Job opening not found.");
        }
    }

    public List<JobOpening> getAllJobOpenings() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        Iterable<JobOpening> jobOpenings = jobOpeningRepository.findAll();
        List<JobOpening> jobOpeningList = new ArrayList<>();
        jobOpenings.forEach(jobOpeningList::add);
        return jobOpeningList;
    }

    public JobOpening getJobOpeningByIndex(int index) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        return getAllJobOpenings().get(index);
    }

    public List<RequirementSpecification> getAllRequirements() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        Iterable<RequirementSpecification> requirements = requirementRepo.findAll();
        List<RequirementSpecification> requirementList = new ArrayList<>();
        requirements.forEach(requirementList::add);
        return requirementList;
    }

    public RequirementSpecification getRequirementByIndex(int index) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        return getAllRequirements().get(index);
    }

}
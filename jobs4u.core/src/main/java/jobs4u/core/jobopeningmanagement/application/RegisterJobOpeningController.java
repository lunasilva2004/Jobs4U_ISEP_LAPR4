package jobs4u.core.jobopeningmanagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import jobs4u.core.PluginManagement.RequirementsSpecificationManagement.repository.RequirementRepo;
import jobs4u.core.customerusermanagement.domain.Address;
import jobs4u.core.infrastructure.persistence.PersistenceContext;
import jobs4u.core.interviewmanagement.repository.InterviewRepository;
import jobs4u.core.jobapplicationmanagement.domain.JobApplication;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;
import jobs4u.core.jobopeningmanagement.domain.JobOpeningBuilder;
import jobs4u.core.jobopeningmanagement.repositories.JobOpeningRepository;
import jobs4u.core.usermanagement.domain.BaseRoles;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Register job opening controller.
 */
@UseCaseController
public class RegisterJobOpeningController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();
    private final RequirementRepo requirementRepo = PersistenceContext.repositories().requirement();
    private final InterviewRepository interviewRepository = PersistenceContext.repositories().interview();

    /**
     * Register job opening job opening.
     *
     * @param jobReference the job reference
     * @param address      the address
     * @param company      the company
     * @param contractType the contract type
     * @param jobFunction  the job function
     * @param mode         the mode
     * @param vacancies    the vacancies
     * @param startDate    the start date
     * @param endDate      the end date
     * @return the job opening
     */
    @SuppressWarnings("UnusedReturnValue")
    public JobOpening registerJobOpening(String jobReference, Address address, String company, String contractType, String jobFunction, String mode, String vacancies, Date startDate, Date endDate){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        JobOpeningBuilder builder = new JobOpeningBuilder();

        List<JobApplication> jobApplicationList = new ArrayList<>();

        JobOpening theJobOpening = builder
                .withJobReference(Designation.valueOf(jobReference))
                .withAddress(address)
                .withCompany(company)
                .withContractType(contractType)
                .withFunction(jobFunction)
                .withMode(mode)
                .withVacancies(vacancies)
                .withStartDate(startDate)
                .withEndDate(endDate)
                .withJobApplication(jobApplicationList)
                .build();

        return save(theJobOpening);
    }

    /**
     * Save job opening.
     *
     * @param jobOpening the job opening
     * @return the job opening
     */
    public JobOpening save(JobOpening jobOpening) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);

        jobOpening = jobOpeningRepository.save(jobOpening);

        return jobOpening;
    }

}

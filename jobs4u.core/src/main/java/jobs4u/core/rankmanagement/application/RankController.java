package jobs4u.core.rankmanagement.application;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import jobs4u.core.candidateusermanagement.domain.Candidate;
import jobs4u.core.customerusermanagement.domain.Email;
import jobs4u.core.infrastructure.persistence.PersistenceContext;
import jobs4u.core.jobapplicationmanagement.domain.JobApplication;
import jobs4u.core.jobapplicationmanagement.repositories.JobApplicationRepository;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;
import jobs4u.core.jobopeningmanagement.domain.PhaseType;
import jobs4u.core.jobopeningmanagement.repositories.JobOpeningRepository;
import jobs4u.core.rankmanagement.domain.Order;
import jobs4u.core.rankmanagement.domain.RankService;
import jobs4u.core.usermanagement.domain.BaseRoles;

import java.util.*;

/**
 * The type Rank controller.
 */
public class RankController {

    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();
    private final JobApplicationRepository jobApplicationRepository = PersistenceContext.repositories().jobApplications();
    private final RankService rankService = new RankService(PersistenceContext.repositories().ranks());
    private final AuthorizationService authz = AuthzRegistry.authorizationService();


    /**
     * Gets all analysis job openings.
     *
     * @return the all analysis job openings
     */
    public List<JobOpening> getAllAnalysisJobOpenings() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        Iterable<JobOpening> jobOpenings = jobOpeningRepository.findJobOpeningsByPhase(PhaseType.ANALYSIS);
        List<JobOpening> jobOpeningList = new ArrayList<>();
        jobOpenings.forEach(jobOpeningList::add);
        return jobOpeningList;
    }


    /**
     * Gets job applications by job reference.
     *
     * @param jobOpening the job opening
     * @return the job applications by job reference
     */
    public List<JobApplication> getJobApplicationsByJobReference(JobOpening jobOpening) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        Iterable<JobApplication> jobApplications = jobApplicationRepository.findByJobReference(jobOpening.identity());
        List<JobApplication> jobApplicationsList = new ArrayList<>();
        jobApplications.forEach(jobApplicationsList::add);
        return jobApplicationsList;
    }

    /**
     * Gets vacancies.
     *
     * @param jobOpening the job opening
     * @return the vacancies
     */
    public int getVacancies(JobOpening jobOpening) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        return Integer.parseInt(jobOpening.toDTO().getVacancies());
    }


    /**
     * Gets candidate details.
     *
     * @param jobApplication the job application
     * @return the candidate details
     */
    public Map<String, Object> getCandidateDetails(JobApplication jobApplication) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        Candidate candidate = jobApplication.toDTO().getCandidate();
        Email candidateEmail = candidate.toDTO().getEmail();
        Long jobApplicationId = jobApplication.toDTO().getID();

        Map<String, Object> candidateDetails = new HashMap<>();
        candidateDetails.put("email", candidateEmail);
        candidateDetails.put("id", jobApplicationId);

        return candidateDetails;
    }

    /**
     * Save ranking.
     *
     * @param jobOpening the job opening
     * @param orders     the orders
     */
    public void saveRanking(JobOpening jobOpening, List<Order> orders) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        rankService.saveRanking(jobOpening, orders);
    }


    /**
     * Add order to list.
     *
     * @param orders         the orders
     * @param order          the order
     * @param jobApplication the job application
     */
    public void addOrderToList(List<Order> orders, int order, JobApplication jobApplication) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        orders.add(new Order(order, jobApplication));
    }

    /**
     * Add null order to list.
     *
     * @param orders         the orders
     * @param jobApplication the job application
     */
    public void addNullOrderToList(List<Order> orders, JobApplication jobApplication) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        orders.add(new Order(null, jobApplication));
    }


}

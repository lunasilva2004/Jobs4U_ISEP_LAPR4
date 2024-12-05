package jobs4u.core.jobapplicationmanagement.application;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import jobs4u.core.infrastructure.persistence.PersistenceContext;
import jobs4u.core.jobapplicationmanagement.application.Services.JobApplicationDistributor;
import jobs4u.core.jobapplicationmanagement.application.Services.JobApplicationEvaluatorService;
import jobs4u.core.jobapplicationmanagement.domain.JobApplication;
import jobs4u.core.jobapplicationmanagement.domain.State;
import jobs4u.core.jobapplicationmanagement.repositories.JobApplicationRepository;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;
import jobs4u.core.jobopeningmanagement.repositories.JobOpeningRepository;
import jobs4u.core.usermanagement.domain.BaseRoles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Verify requirements controller.
 */
@SuppressWarnings("CallToPrintStackTrace")
public class VerifyRequirementsController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    /**
     * The Transactional context.
     */
    TransactionalContext transactionalContext = PersistenceContext.repositories().newTransactionalContext();
    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings(transactionalContext);
    private final JobApplicationRepository jobApplicationRepository = PersistenceContext.repositories().jobApplications(transactionalContext);


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
     * Gets job applications by job reference.
     *
     * @param jobReference the job reference
     * @return the job applications by job reference
     */
    public List<JobApplication> getJobApplicationsByJobReference(Designation jobReference) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        State state = State.PENDING;

        List<JobApplication> jobApplicationsList;
        jobApplicationsList = jobApplicationRepository.findPendingsByJobOpening(jobReference, state);

        return jobApplicationsList;
    }


    /**
     * Verify requirements concurrently list.
     *
     * @param jobReference the job reference
     * @return the list
     */
    public List<String> verifyRequirementsConcurrently(Designation jobReference) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);

        List<JobApplication> jobApplications = getJobApplicationsByJobReference(jobReference);
        List<Long> jobApplicationIds = jobApplications.stream().map(JobApplication::identity).collect(Collectors.toList());

        int THREAD_COUNT = 10;
        if (jobApplications.size() < THREAD_COUNT) {
            THREAD_COUNT = jobApplications.size();
        }
        List<List<Long>> partitions = JobApplicationDistributor.distributeJobApplicationsAmongThreads(jobApplicationIds, THREAD_COUNT);

        List<String> allExecutionMessages = Collections.synchronizedList(new ArrayList<>());
        List<Thread> threads = new ArrayList<>();
        for (List<Long> partition : partitions) {
            Thread thread = new Thread(() -> {
                List<String> executionMessages = new ArrayList<>();
                for (Long jobApplicationId : partition) {
                    JobApplicationEvaluatorService jobApplicationEvaluatorService = new JobApplicationEvaluatorService(jobReference);
                    List<String> messages = jobApplicationEvaluatorService.verifyRequirements(jobApplicationId);
                    if (messages != null) {
                        executionMessages.addAll(messages);
                    }
                }
                synchronized (allExecutionMessages) {
                    allExecutionMessages.addAll(executionMessages);
                }
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return allExecutionMessages;
    }
}
package jobs4u.core.candidateusermanagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import jobs4u.core.candidateusermanagement.domain.Candidate;
import jobs4u.core.candidateusermanagement.repositories.CandidateRepository;
import jobs4u.core.customerusermanagement.domain.Email;
import jobs4u.core.infrastructure.persistence.PersistenceContext;
import jobs4u.core.jobapplicationmanagement.application.Services.MostUsedWordsService;
import jobs4u.core.jobapplicationmanagement.domain.FileJobApp;
import jobs4u.core.jobapplicationmanagement.domain.JobApplication;
import jobs4u.core.jobapplicationmanagement.repositories.JobApplicationRepository;
import jobs4u.core.usermanagement.domain.BaseRoles;

import java.util.*;

/**
 * The type See candidate info controller.
 */
public class SeeCandidateInfoController {
    private final JobApplicationRepository jobApplicationRepository = PersistenceContext.repositories().jobApplications();
    private final CandidateRepository candidateRepository = PersistenceContext.repositories().candidates();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final MostUsedWordsService mostUsedWordsService = new MostUsedWordsService();

    /**
     * Find candidate by email candidate.
     *
     * @param email the email
     * @return the candidate
     */
    public Candidate findCandidateByEmail(Email email) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        if (candidateRepository.findByEmail(email).isEmpty()) {
            return null;
        }
        return candidateRepository.findByEmail(email).get();
    }

    /**
     * Process top words for candidate map.
     *
     * @param candidateEmail the candidate email
     * @return the map
     */
    public Map<String, Map<String, Map<String, Integer>>> processTopWordsForCandidate(Email candidateEmail) {
        Map<String, Map<String, Map<String, Integer>>> topWords = new HashMap<>();
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);

        List<JobApplication> jobApplications = jobApplicationRepository.findByCandidateEmail(candidateEmail);

        for (JobApplication jobApplication : jobApplications) {
            List<FileJobApp> files = jobApplication.getFile();
            if (files == null || files.isEmpty()) {
                continue;
            }
            Map<String, Map<String, Integer>> fileTopWords = mostUsedWordsService.processFiles(files);
            topWords.put(jobApplication.toDTO().getID().toString(), fileTopWords);
        }
        return topWords;
    }
}

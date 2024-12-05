package jobs4u.core.jobapplicationmanagement.application.Services;

import Other.InterviewModel_EX1;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import jobs4u.core.jobapplicationmanagement.domain.JobApplication;
import jobs4u.core.jobapplicationmanagement.dto.JobApplicationDTO;
import jobs4u.core.jobapplicationmanagement.repositories.JobApplicationRepository;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;
import jobs4u.core.jobopeningmanagement.domain.PhaseType;
import jobs4u.core.jobopeningmanagement.repositories.JobOpeningRepository;
import jobs4u.core.usermanagement.domain.BaseRoles;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

/**
 * The type List candidates by interview grade service.
 */
@Service
public class ListCandidatesByInterviewGradeService {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final JobApplicationRepository jobApplicationRepository;

    private final JobOpeningRepository jobOpeningRepository;

    /**
     * Instantiates a new List candidates by interview grade service.
     *
     * @param jobApplicationRepository the job application repository
     * @param jobOpeningRepository     the job opening repository
     */
    public ListCandidatesByInterviewGradeService(JobApplicationRepository jobApplicationRepository, JobOpeningRepository jobOpeningRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
        this.jobOpeningRepository = jobOpeningRepository;
    }

    /**
     * All candidates by interview grade map.
     *
     * @param jobReference the job reference
     * @return the map
     * @throws IOException the io exception
     */
    public Map<JobApplicationDTO, String> allCandidatesByInterviewGrade(Designation jobReference) throws IOException {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);

        List<JobOpening> jobOpeningByPhase = jobOpeningRepository.findJobOpeningsByPhase(PhaseType.ANALYSIS);
        if (jobOpeningByPhase == null || jobOpeningByPhase.isEmpty()) {
            throw new IllegalArgumentException("There is no job openings to list check the phase state.");
        }

        InterviewModel_EX1 evaluator = new InterviewModel_EX1();
        Map<JobApplicationDTO, String> candidateJustifications = new HashMap<>();

            for (JobOpening jobOpening : jobOpeningByPhase) {
                if (jobOpening.getJobReference().equals(jobReference)) {
                    Iterable<JobApplication> allApplications = jobApplicationRepository.findAll();

                    for (JobApplication application : allApplications) {
                        if (application.toDTO().getInterviewGrade() != null) {
                            JobApplicationDTO applicationDTO = application.toDTO();
                            String justification = getCandidateJustification(jobReference, application, evaluator);
                            candidateJustifications.put(applicationDTO, justification);
                        }
                    }

                    List<JobApplicationDTO> sortedApplications = new ArrayList<>(candidateJustifications.keySet());
                    Collections.sort(sortedApplications, Comparator.comparingInt(o -> o.getInterviewGrade().getValue()));
                    Collections.reverse(sortedApplications);

                    Map<JobApplicationDTO, String> sortedCandidateJustifications = new LinkedHashMap<>();
                    for (JobApplicationDTO applicationDTO : sortedApplications) {
                        sortedCandidateJustifications.put(applicationDTO, candidateJustifications.get(applicationDTO));
                    }

                    return sortedCandidateJustifications;
                }
            }

        return Collections.emptyMap();
    }


    private String getCandidateJustification(Designation jobReference, JobApplication application, InterviewModel_EX1 evaluator) throws IOException {
        String candidateAnswersFolder = "docs/CandidateAnswers/" + jobReference + "/" + application.identity();
        File folder = new File(candidateAnswersFolder);

        StringBuilder justification = new StringBuilder();
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));
            if (files != null) {
                for (File file : files) {
                    Path candidateFilePath = file.toPath();
                    String correctAnswersFilePath = "InterviewModelExample.txt";

                    Map<String, String> correctAnswers = evaluator.getAnswersFromFilePath(correctAnswersFilePath);
                    Map<String, String> candidateAnswers = evaluator.getAnswersFromFilePath(candidateFilePath.toString());

                    justification.append("Candidate: ").append(application.getCandidate().getEmail()).append("\n");

                    for (Map.Entry<String, String> entry : correctAnswers.entrySet()) {
                        String question = entry.getKey();
                        String correctAnswer = entry.getValue();
                        String candidateAnswer = candidateAnswers.get(question);

                        justification.append("Question: ").append(question).append("\n");
                        justification.append("Correct Answer: ").append(correctAnswer).append("\n");
                        justification.append("Candidate Answer: ").append(candidateAnswer).append("\n");
                        justification.append("\n");
                    }
                }
            }
        }
        return justification.toString();
    }
}

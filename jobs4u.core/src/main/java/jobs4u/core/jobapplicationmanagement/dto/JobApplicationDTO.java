package jobs4u.core.jobapplicationmanagement.dto;

import eapli.framework.representations.dto.DTO;
import jobs4u.core.candidateusermanagement.domain.Candidate;
import jobs4u.core.candidateusermanagement.domain.CandidateDTO;
import jobs4u.core.interviewmanagement.domain.Interview;
import jobs4u.core.jobapplicationmanagement.domain.FileJobApp;
import jobs4u.core.jobapplicationmanagement.domain.InterviewGrade;
import jobs4u.core.jobapplicationmanagement.domain.State;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * The type Job application dto.
 */
@DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobApplicationDTO extends CandidateDTO {
    private Long iD;
    private Candidate candidate;
    private List<FileJobApp> file;
    private State state;

    private String rank;

    private java.util.Date date;

    private JobOpening jobOpening;

    private InterviewGrade interviewGrade;
}

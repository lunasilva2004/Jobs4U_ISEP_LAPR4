/*package jobs4u.core.jobapplicationmanagement.domain;

import jobs4u.core.candidateusermanagement.domain.Candidate;
import jobs4u.core.candidateusermanagement.domain.CandidateBuilder;
import jobs4u.core.customerusermanagement.domain.Customer;
import jobs4u.core.customerusermanagement.domain.CustomerBuilder;
import jobs4u.core.interviewmanagement.domain.Interview;
import jobs4u.core.interviewmanagement.domain.InterviewBuilder;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class JobApplicationBuilderTest {

    @Test
    void build() {
        String iD = "Application - 1";
        Candidate candidate = new Candidate("Jonh","Doe","jonhdoe@email.com","961234567");
        String filesPath = "docs/output_US2001/IBM-000123/1";
        State state = State.CONFIRMED;
        String rank = "Excellent";
        Date date = new Date();
        File file = new File("Files- Application 1",filesPath);

        JobApplicationBuilder builder = new JobApplicationBuilder();
         JobApplication jobApplication = builder.withiD(iD)
                .withCandidate(candidate)
                .withfile(file)
                .withState(state)
                 .withrank(rank)
                 .withDate(date)
                .build();

        assertEquals(iD, jobApplication.toDTO().getID());
        assertEquals(candidate.getEmail(), jobApplication.toDTO().getCandidate().getEmail());
        assertEquals(filesPath, jobApplication.toDTO().getFile().getFilesPath());
        assertEquals("Files- Application 1", jobApplication.toDTO().getFile().getName());
        assertEquals(State.CONFIRMED, jobApplication.toDTO().getState());
        assertEquals(rank, jobApplication.toDTO().getRank());
        assertEquals(date, jobApplication.toDTO().getDate());
    }



}

 */
package jobs4u.core.jobapplicationmanagement.domain;

import jobs4u.core.PluginManagement.Description;
import jobs4u.core.PluginManagement.FQClassName;
import jobs4u.core.PluginManagement.InterviewModelManagement.domain.InterviewModel;
import jobs4u.core.customerusermanagement.domain.*;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;
import jobs4u.core.candidateusermanagement.domain.Candidate;

import jobs4u.core.jobapplicationmanagement.dto.JobApplicationDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class JobApplicationTest {

    private JobApplication jobApplication;
    private Candidate candidate;

    private InterviewModel interviewModel;
    private JobOpening jobOpening;
    private final Date currentDate = new Date();

    @BeforeEach
    void setUp() {
        Name name = new Name("John Doe");
        Email email = new Email("teste@this.app");
        PhoneNumber phoneNumber = new PhoneNumber("123456789");
        String jobReference = "JUNIOR_DEVELOPER";
        Address address = new Address("123 Main St");
        String company = "TechCorp";
        Customer customer = new Customer(name, email, phoneNumber, address);
        String contractType = "Full-time";
        String jobFunction = "Software Development";
        String mode = "Remote";
        String vacancies = "5";
        java.sql.Date startDate = java.sql.Date.valueOf("2024-01-01");
        java.sql.Date endDate = new java.sql.Date(startDate.getTime() + (1000L * 60 * 60 * 24 * 30)); // 30 dias a partir da data de início

        jobOpening = new JobOpening(jobReference, address, company, customer, contractType, jobFunction, mode, vacancies, startDate, endDate);
        candidate = new Candidate(name, email, phoneNumber);
        jobApplication = new JobApplication(candidate, Arrays.asList(new FileJobApp("file1"), new FileJobApp("file2")), State.PENDING, currentDate, jobOpening);
        interviewModel = new InterviewModel(new Name("Technical Interview"), new Description("Technical skills evaluation"), new FQClassName("com.techcorp.interview.TechnicalInterview"));

    }

    @Test
    void testCreation() {
        assertEquals(candidate, jobApplication.getCandidate());
        assertEquals(2, jobApplication.getFile().size());
        assertEquals(State.PENDING, jobApplication.getState());
        assertEquals(currentDate, jobApplication.getDate());
        assertEquals(jobOpening, jobApplication.getJobOpening());
    }

    @Test
    void testUpdateStateBasedOnVerificationResultRejected() {
        jobApplication.updateStateBasedOnVerificationResult(30);
        assertEquals(State.REJECTED, jobApplication.getState());
    }

    @Test
    void testUpdateStateBasedOnVerificationResultConfirmed() {
        jobApplication.updateStateBasedOnVerificationResult(70);
        assertEquals(State.CONFIRMED, jobApplication.getState());
    }

    @Test
    void testUpdateStateBasedOnVerificationResultInvalidLowerBound() {
        assertThrows(IllegalArgumentException.class, () -> jobApplication.updateStateBasedOnVerificationResult(-10));
    }

    @Test
    void testUpdateStateBasedOnVerificationResultInvalidUpperBound() {
        assertThrows(IllegalArgumentException.class, () -> jobApplication.updateStateBasedOnVerificationResult(110));
    }


    @Test
    void testEquals() {
        JobApplication sameJobApplication = new JobApplication(candidate, Arrays.asList(new FileJobApp("file1"), new FileJobApp("file2")), State.PENDING, currentDate, jobOpening);
        assertEquals(jobApplication, sameJobApplication);
    }

    @Test
    void testBuildRepresentation() {
        JobApplicationDTO dto = jobApplication.toDTO();
        assertEquals(candidate.getEmail(), dto.getCandidate().getEmail());
        assertEquals("file1", dto.getFile().get(0).getValue());
        assertEquals(State.PENDING, dto.getState());
        assertEquals(currentDate.toString(), dto.getDate().toString());
    }

    @Test
    void testSetInterviewGrade() {
        InterviewGrade grade = new InterviewGrade(90);
        jobApplication.setInterviewGrade(grade);
        assertEquals(grade, jobApplication.getInterviewGrade());
    }

    @Test
    void testAssociateInterviewModel() {
        jobApplication.getJobOpening().setInterview(interviewModel);
        assertEquals(interviewModel, jobApplication.getJobOpening().getInterview());
    }

    @Test
    void testCandidateAssociationInJobApplication() {
        Name name = new Name("John Doe");
        Email email = new Email("teste@this.app");
        PhoneNumber phoneNumber = new PhoneNumber("123456789");
        Candidate candidate1 = new Candidate(name, email, phoneNumber);

        assertEquals(candidate1, jobApplication.getCandidate());
    }

    @Test
    void testJobOpeningAssociationInJobApplication() {
        Name name = new Name("John Doe");
        Email email = new Email("teste@this.app");
        PhoneNumber phoneNumber = new PhoneNumber("123456789");
        String jobReference = "JUNIOR_DEVELOPER";
        Address address = new Address("123 Main St");
        String company = "TechCorp";
        Customer customer = new Customer(name, email, phoneNumber, address);
        String contractType = "Full-time";
        String jobFunction = "Software Development";
        String mode = "Remote";
        String vacancies = "5";
        java.sql.Date startDate = java.sql.Date.valueOf("2024-01-01");
        java.sql.Date endDate = new java.sql.Date(startDate.getTime() + (1000L * 60 * 60 * 24 * 30)); // 30 dias a partir da data de início
        JobOpening jobOpening1 = new JobOpening(jobReference, address, company, customer, contractType, jobFunction, mode, vacancies, startDate, endDate);

        assertEquals(jobOpening1, jobApplication.getJobOpening());
    }


}

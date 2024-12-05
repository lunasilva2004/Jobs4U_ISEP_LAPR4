/*
package jobs4u.core.jobapplicationmanagement.domain;

import jobs4u.core.candidateusermanagement.domain.Candidate;
import jobs4u.core.customerusermanagement.domain.*;
import jobs4u.core.jobapplicationmanagement.application.Services.JobApplicationEvaluatorService;
import jobs4u.core.jobapplicationmanagement.repositories.JobApplicationRepository;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;
import jobs4u.core.jobopeningmanagement.repositories.JobOpeningRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JobApplicationEvaluatorServiceTest {

    private JobApplicationEvaluatorService jobApplicationEvaluatorService;
    private JobApplicationRepository jobApplicationRepository;
    private JobOpeningRepository jobOpeningRepository;
    private JobApplication jobApplication;
    private JobOpening jobOpening;
    private final java.util.Date currentDate = new java.util.Date();


    @BeforeEach
    void setUp() {
        String jobReference = "JUNIOR_DEVELOPER";
        Address address = new Address("123 Main St");
        String company = "TechCorp";
        PhoneNumber phoneNumber = new PhoneNumber("123456789");
        Email email = new Email("john.doe@this.app");
        Name name = new Name("John Doe");
        Customer customer = new Customer(name, email, phoneNumber, address);
        String contractType = "Full-time";
        String jobFunction = "Software Development";
        String mode = "Remote";
        String vacancies = "5";
        Date startDate = Date.valueOf("2024-01-01");
        Date endDate = new Date(startDate.getTime() + (1000L * 60 * 60 * 24 * 30)); // 30 dias a partir da data de início
        Candidate candidate = new Candidate(name, email, phoneNumber);
        jobOpening = new JobOpening(jobReference, address, company, customer, contractType, jobFunction, mode, vacancies, startDate, endDate);

        jobApplicationRepository = mock(JobApplicationRepository.class);
        jobOpeningRepository = mock(JobOpeningRepository.class);

        jobApplicationEvaluatorService = new JobApplicationEvaluatorService(jobOpening.toDTO().getJobReference());
        ReflectionTestUtils.setField(jobApplicationEvaluatorService, "jobApplicationRepository", jobApplicationRepository);
        ReflectionTestUtils.setField(jobApplicationEvaluatorService, "jobOpeningRepository", jobOpeningRepository);

        jobApplication = new JobApplication(candidate, Arrays.asList(new FileJobApp("file1"), new FileJobApp("file2")), State.PENDING, currentDate, jobOpening);
        jobApplication.setState(State.PENDING);

    }

    @Disabled
    @Test
    void testVerifyRequirementsJobApplicationNotFound() {
        when(jobApplicationRepository.findJobApplicationById(any())).thenReturn(null);
        List<String> result = jobApplicationEvaluatorService.verifyRequirements(1L);
        assertEquals("Job application not found", result.get(0));
    }

    @Disabled
    @Test
    void testVerifyRequirementsJobOpeningNotFound() {
        when(jobApplicationRepository.findJobApplicationById(any())).thenReturn(Optional.ofNullable(jobApplication));
        when(jobOpeningRepository.findByReference(any())).thenReturn(null);
        List<String> result = jobApplicationEvaluatorService.verifyRequirements(1L);
        assertEquals("Job opening not found", result.get(0));
    }

    @Disabled
    @Test
    void testVerifyRequirementsNoCandidateFilesFound() {
        when(jobApplicationRepository.findJobApplicationById(any())).thenReturn(Optional.ofNullable(jobApplication));
        when(jobOpeningRepository.findByReference(any())).thenReturn(Optional.ofNullable(jobOpening));
        List<String> result = jobApplicationEvaluatorService.verifyRequirements(1L);
        assertEquals("No candidate files found for job application null for job opening Test Job", result.get(0));
    }
}
*/

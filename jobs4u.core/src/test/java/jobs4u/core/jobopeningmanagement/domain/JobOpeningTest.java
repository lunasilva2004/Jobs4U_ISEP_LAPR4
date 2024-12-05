package jobs4u.core.jobopeningmanagement.domain;

import eapli.framework.representations.RepresentationBuilder;
import jobs4u.core.PluginManagement.Description;
import jobs4u.core.PluginManagement.FQClassName;
import jobs4u.core.PluginManagement.InterviewModelManagement.domain.InterviewModel;
import jobs4u.core.PluginManagement.RequirementsSpecificationManagement.domain.RequirementSpecification;
import jobs4u.core.customerusermanagement.domain.*;
import jobs4u.core.jobopeningmanagement.dto.JobOpeningDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

public class JobOpeningTest {

    private JobOpening jobOpening;

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

        jobOpening = new JobOpening(jobReference, address, company, customer, contractType, jobFunction, mode, vacancies, startDate, endDate);
    }

    @Test
    void testAddPhase() {
        // Testar a adição de uma nova fase a um JobOpening
        JobOpeningPhase phase1 = new JobOpeningPhase(PhaseType.ANALYSIS, Date.valueOf("2024-02-01"), Date.valueOf("2024-03-01"), jobOpening);
        JobOpeningPhase phase2 = new JobOpeningPhase(PhaseType.APPLICATION, Date.valueOf("2024-03-01"), Date.valueOf("2024-04-01"), jobOpening);
        JobOpeningPhase phase3 = new JobOpeningPhase(PhaseType.INTERVIEWS, Date.valueOf("2024-04-01"), Date.valueOf("2024-05-01"), jobOpening);
        JobOpeningPhase phase4 = new JobOpeningPhase(PhaseType.RESULT, Date.valueOf("2024-05-01"), Date.valueOf("2024-06-01"), jobOpening);
        JobOpeningPhase phase5 = new JobOpeningPhase(PhaseType.SCREENING, Date.valueOf("2024-06-01"), Date.valueOf("2024-07-01"), jobOpening);

        jobOpening.addPhase(phase1);
        jobOpening.addPhase(phase2);
        jobOpening.addPhase(phase3);
        jobOpening.addPhase(phase4);
        jobOpening.addPhase(phase5);

        // Verificar se as fases foram adicionadas corretamente
        assertEquals(5, jobOpening.getPhases().size());
    }

    @Test
    void testSetCurrentPhase() {
        JobOpeningPhase phase1 = new JobOpeningPhase(PhaseType.ANALYSIS, Date.valueOf("2024-02-01"), Date.valueOf("2024-03-01"), jobOpening);
        JobOpeningPhase phase2 = new JobOpeningPhase(PhaseType.APPLICATION, Date.valueOf("2024-03-01"), Date.valueOf("2024-04-01"), jobOpening);

        jobOpening.addPhase(phase1);
        jobOpening.addPhase(phase2);
        jobOpening.setCurrentPhase(phase1);

        assertEquals(phase1, jobOpening.getCurrentPhase());
    }

    @Test
    void testPreviousPhaseFail(){
        // Testar a adição de uma nova fase a um JobOpening
        JobOpeningPhase phase1 = new JobOpeningPhase(PhaseType.ANALYSIS, Date.valueOf("2024-02-01"), Date.valueOf("2024-03-01"), jobOpening);
        JobOpeningPhase phase2 = new JobOpeningPhase(PhaseType.APPLICATION, Date.valueOf("2024-03-01"), Date.valueOf("2024-04-01"), jobOpening);
        JobOpeningPhase phase3 = new JobOpeningPhase(PhaseType.INTERVIEWS, Date.valueOf("2024-04-01"), Date.valueOf("2024-05-01"), jobOpening);
        JobOpeningPhase phase4 = new JobOpeningPhase(PhaseType.RESULT, Date.valueOf("2024-05-01"), Date.valueOf("2024-06-01"), jobOpening);
        JobOpeningPhase phase5 = new JobOpeningPhase(PhaseType.SCREENING, Date.valueOf("2024-06-01"), Date.valueOf("2024-07-01"), jobOpening);

        jobOpening.addPhase(phase1);
        jobOpening.addPhase(phase2);
        jobOpening.addPhase(phase3);
        jobOpening.addPhase(phase4);
        jobOpening.addPhase(phase5);

        jobOpening.setCurrentPhase(phase1);

        // Verificar se a fase anterior a uma fase inexistente é retornada corretamente
        assertNotEquals(true, jobOpening.previousPhase());
    }

    @Test
    void testPreviousPhaseSuccess(){
        // Testar a adição de uma nova fase a um JobOpening
        JobOpeningPhase phase1 = new JobOpeningPhase(PhaseType.ANALYSIS, Date.valueOf("2024-02-01"), Date.valueOf("2024-03-01"), jobOpening);
        JobOpeningPhase phase2 = new JobOpeningPhase(PhaseType.APPLICATION, Date.valueOf("2024-03-01"), Date.valueOf("2024-04-01"), jobOpening);
        JobOpeningPhase phase3 = new JobOpeningPhase(PhaseType.INTERVIEWS, Date.valueOf("2024-04-01"), Date.valueOf("2024-05-01"), jobOpening);
        JobOpeningPhase phase4 = new JobOpeningPhase(PhaseType.RESULT, Date.valueOf("2024-05-01"), Date.valueOf("2024-06-01"), jobOpening);
        JobOpeningPhase phase5 = new JobOpeningPhase(PhaseType.SCREENING, Date.valueOf("2024-06-01"), Date.valueOf("2024-07-01"), jobOpening);

        jobOpening.addPhase(phase1);
        jobOpening.addPhase(phase2);
        jobOpening.addPhase(phase3);
        jobOpening.addPhase(phase4);
        jobOpening.addPhase(phase5);

        jobOpening.setCurrentPhase(phase3);

        // Verificar se a fase anterior a uma fase existente é retornada corretamente
        assertEquals(true, jobOpening.previousPhase());
    }


    @Test
    void testNextPhaseFail(){
        // Testar a adição de uma nova fase a um JobOpening
        JobOpeningPhase phase1 = new JobOpeningPhase(PhaseType.ANALYSIS, Date.valueOf("2024-02-01"), Date.valueOf("2024-03-01"), jobOpening);
        JobOpeningPhase phase2 = new JobOpeningPhase(PhaseType.APPLICATION, Date.valueOf("2024-03-01"), Date.valueOf("2024-04-01"), jobOpening);
        JobOpeningPhase phase3 = new JobOpeningPhase(PhaseType.INTERVIEWS, Date.valueOf("2024-04-01"), Date.valueOf("2024-05-01"), jobOpening);
        JobOpeningPhase phase4 = new JobOpeningPhase(PhaseType.RESULT, Date.valueOf("2024-05-01"), Date.valueOf("2024-06-01"), jobOpening);
        JobOpeningPhase phase5 = new JobOpeningPhase(PhaseType.SCREENING, Date.valueOf("2024-06-01"), Date.valueOf("2024-07-01"), jobOpening);

        jobOpening.addPhase(phase1);
        jobOpening.addPhase(phase2);
        jobOpening.addPhase(phase3);
        jobOpening.addPhase(phase4);
        jobOpening.addPhase(phase5);

        jobOpening.setCurrentPhase(phase5);

        // Verificar se a fase seguinte a uma fase inexistente é retornada corretamente
        assertNotEquals(true, jobOpening.nextPhase());
    }

    @Test
    void testNextPhaseSuccess(){
        // Testar a adição de uma nova fase a um JobOpening
        JobOpeningPhase phase1 = new JobOpeningPhase(PhaseType.ANALYSIS, Date.valueOf("2024-02-01"), Date.valueOf("2024-03-01"), jobOpening);
        JobOpeningPhase phase2 = new JobOpeningPhase(PhaseType.APPLICATION, Date.valueOf("2024-03-01"), Date.valueOf("2024-04-01"), jobOpening);
        JobOpeningPhase phase3 = new JobOpeningPhase(PhaseType.INTERVIEWS, Date.valueOf("2024-04-01"), Date.valueOf("2024-05-01"), jobOpening);
        JobOpeningPhase phase4 = new JobOpeningPhase(PhaseType.RESULT, Date.valueOf("2024-05-01"), Date.valueOf("2024-06-01"), jobOpening);
        JobOpeningPhase phase5 = new JobOpeningPhase(PhaseType.SCREENING, Date.valueOf("2024-06-01"), Date.valueOf("2024-07-01"), jobOpening);

        jobOpening.addPhase(phase1);
        jobOpening.addPhase(phase2);
        jobOpening.addPhase(phase3);
        jobOpening.addPhase(phase4);
        jobOpening.addPhase(phase5);

        jobOpening.setCurrentPhase(phase3);

        // Verificar se a fase seguinte a uma fase existente é retornada corretamente
        assertEquals(true, jobOpening.nextPhase());
    }

    @Test
    void testPhaseDateOverlap() {
        JobOpeningPhase phase1 = new JobOpeningPhase(PhaseType.ANALYSIS, Date.valueOf("2024-02-01"), Date.valueOf("2024-03-01"), jobOpening);
        JobOpeningPhase phase2 = new JobOpeningPhase(PhaseType.APPLICATION, Date.valueOf("2024-02-15"), Date.valueOf("2024-03-15"), jobOpening);
        jobOpening.addPhase(phase1);
        assertThrows(IllegalArgumentException.class, () -> {
            jobOpening.addPhase(phase2); // Tentativa de adicionar uma fase com sobreposição de datas
        }, "Phase with overlapping dates should throw an exception");
    }

    @Test
    void testUpdateRequirement() {
        Name name = new Name("John Doe");
        Description description = new Description("Description");
        FQClassName className = new FQClassName("Other.JobRequirementsSpecification_EX1.java");
        RequirementSpecification requirements = new RequirementSpecification(name, description, className);
        jobOpening.updateRequirement(requirements);
        assertEquals(requirements, jobOpening.getRequirements());
    }

    @Test
    void testUpdateInterviewModel() {
        Name name = new Name("John Doe");
        Description description = new Description("Description");
        FQClassName className = new FQClassName("Other.InterviewModel_EX1.java");
        InterviewModel interviewModel = new InterviewModel(name, description, className);
        jobOpening.updateInterviewModel(interviewModel);
        assertEquals(interviewModel, jobOpening.getInterview());
    }

    @Test
    void testToDTO() {
        JobOpeningDTO dto = jobOpening.toDTO();
        assertNotNull(dto);
        assertEquals("JUNIOR_DEVELOPER", dto.getJobReference().toString());
    }

    @Test
    void testConstructorNullArguments() {
        assertThrows(IllegalArgumentException.class, () -> {
            new JobOpening(null, null, null, null, null, null, null, null, null, null);
        });
    }
    @Test
    void testCustomerAssociation() {
        Address address = new Address("123 Main St");
        PhoneNumber phoneNumber = new PhoneNumber("123456789");
        Email email = new Email("john.doe@this.app");
        Name name = new Name("John Doe");
        Customer customer = new Customer(name, email, phoneNumber, address);

        assertEquals(customer, jobOpening.getCustomer());
    }

}

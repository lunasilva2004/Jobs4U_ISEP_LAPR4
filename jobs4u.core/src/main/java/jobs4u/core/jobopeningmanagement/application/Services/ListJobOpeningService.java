package jobs4u.core.jobopeningmanagement.application.Services;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.Designation;
import jakarta.transaction.Transactional;
import jobs4u.core.customerusermanagement.domain.Email;
import jobs4u.core.infrastructure.persistence.PersistenceContext;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;
import jobs4u.core.jobopeningmanagement.dto.JobOpeningDTO;
import jobs4u.core.jobopeningmanagement.repositories.JobOpeningRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The type List job opening service.
 */
@Service
public class ListJobOpeningService {
    /**
     * The Auto tx.
     */
    TransactionalContext autoTx = PersistenceContext.repositories().newTransactionalContext();
    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings(autoTx);

    /**
     * List job openings for customer list.
     *
     * @param email the email
     * @return the list
     */
    public List<String> listJobOpeningsForCustomer(Email email) {
        List<JobOpening> customerJobOpenings = jobOpeningRepository.findByCustomerEmail(email.toString());
        if (customerJobOpenings.isEmpty()) {
            return Collections.singletonList("No job openings found for this customer.");
        }
        return addJobOpeningDetails(customerJobOpenings);
    }

    private List<String> addJobOpeningDetails(List<JobOpening> customerJobOpenings) {
        List<String> jobOpeningDetails = new ArrayList<>();
        for (JobOpening jobOpening : customerJobOpenings) {
            JobOpeningDTO jobOpeningDTO = jobOpening.toDTO();

            Designation jobReference = jobOpeningDTO.getJobReference();
            String function = jobOpeningDTO.getFunction();
            Date startDate = jobOpeningDTO.getStartDate();
            int numberOfApplications = jobOpeningRepository.countApplicationsByJobReference(jobReference);

            jobOpeningDetails.add("Job Reference: " + jobReference);
            jobOpeningDetails.add("Function: " + function);
            jobOpeningDetails.add("Start Date: " + startDate);
            jobOpeningDetails.add("Number of Applications: " + numberOfApplications);
            jobOpeningDetails.add("--------------------------------");
        }
        return jobOpeningDetails;
    }


}
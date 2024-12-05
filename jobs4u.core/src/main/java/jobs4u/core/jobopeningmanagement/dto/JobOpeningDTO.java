package jobs4u.core.jobopeningmanagement.dto;

import eapli.framework.general.domain.model.Designation;
import eapli.framework.representations.dto.DTO;
import jakarta.persistence.ManyToOne;
import jobs4u.core.PluginManagement.InterviewModelManagement.domain.InterviewModel;
import jobs4u.core.PluginManagement.RequirementsSpecificationManagement.domain.RequirementSpecification;
import jobs4u.core.customerusermanagement.domain.Address;
import jobs4u.core.customerusermanagement.domain.CustomerDTO;
import jobs4u.core.jobopeningmanagement.domain.JobOpeningPhase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;


/**
 * The type Job opening dto.
 */
@DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobOpeningDTO extends CustomerDTO implements Serializable {
    private Designation jobReference;
    private String company;
    private String contractType;
    private String function;
    private Address address;
    private String mode;
    private List<JobOpeningPhase> phase;
    private JobOpeningPhase currentPhase;
    private String vacancies;
    private Date startDate;
    private Date endDate;
    private InterviewModel interview;
    private RequirementSpecification requirements;
}


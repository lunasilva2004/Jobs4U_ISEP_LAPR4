package jobs4u.core.jobopeningmanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.representations.RepresentationBuilder;
import eapli.framework.representations.Representationable;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import javax.xml.bind.annotation.XmlRootElement;
import jobs4u.core.PluginManagement.InterviewModelManagement.domain.InterviewModel;
import jobs4u.core.PluginManagement.RequirementsSpecificationManagement.domain.RequirementSpecification;
import jobs4u.core.customerusermanagement.domain.Address;
import jobs4u.core.customerusermanagement.domain.Customer;
import jobs4u.core.jobopeningmanagement.dto.JobOpeningDTO;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

/**
 * The type Job opening.
 */
@Entity
@XmlRootElement
@Getter
@Setter
public class JobOpening implements AggregateRoot<Designation>, DTOable<JobOpeningDTO>, Representationable {

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    @EmbeddedId
    private Designation jobReference;

    private String company;
    private String contractType;
    private String function;
    private Address address;
    private String mode;
    private String numberOfVacancies;

    @ManyToOne
    private RequirementSpecification requirements;
    @ManyToOne
    private InterviewModel interview;
    private Date startDate;
    private Date EndDate;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "jobOpening", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JobOpeningPhase> phases = new ArrayList<>();

    @Setter
    @OneToOne
    private JobOpeningPhase currentPhase;

    /**
     * Instantiates a new Job opening.
     *
     * @param jobReference the job reference
     * @param address      the address
     * @param company      the company
     * @param customer     the customer
     * @param contractType the contract type
     * @param jobFunction  the job function
     * @param mode         the mode
     * @param vacancies    the vacancies
     * @param startDate    the start date
     * @param endDate      the end date
     */
    public JobOpening(String jobReference, Address address, String company, Customer customer, String contractType, String jobFunction, String mode, String vacancies, Date startDate, Date endDate) {
        Preconditions.noneNull(jobReference, address, company, contractType, jobFunction, mode, vacancies, startDate, endDate);

        this.customer = customer;
        this.company = company;
        this.jobReference = Designation.valueOf(jobReference);
        this.contractType = contractType;
        this.function = jobFunction;
        this.address = address;
        this.mode = mode;
        this.numberOfVacancies = vacancies;
        this.startDate = startDate;
        this.EndDate = endDate;
    }

    /**
     * Instantiates a new Job opening.
     */
    public JobOpening() {
        // for ORM only.
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(final Object other) {
        if (!(other instanceof JobOpening)) {
            return false;
        }

        final JobOpening that = (JobOpening) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }

    /**
     * Update requirement.
     *
     * @param requirements the requirements
     */
    @Transactional
    public void updateRequirement(RequirementSpecification requirements) {
        this.requirements = requirements;
    }

    /**
     * Update interview model.
     *
     * @param interview the interview
     */
    @Transactional
    public void updateInterviewModel(InterviewModel interview) {
        this.interview = interview;
    }

    @Override
    public Designation identity() {
        return this.jobReference;
    }

    @Override
    public <R> R buildRepresentation(RepresentationBuilder<R> builder) {
        builder.startObject("JobOpening")
                .withProperty("JobReference", jobReference)
                .withProperty("Company", company)
                .withProperty("ContractType", contractType)
                .withProperty("Function", function)
                .withProperty("Address", String.valueOf(address))
                .withProperty("Mode", mode)
                .withProperty("Vacancies", numberOfVacancies)
                .withProperty("Requirements", valueOf(requirements))
                .withProperty("Interview", valueOf(interview))
                .withProperty("StartDate", startDate.getTime())
                .withProperty("EndDate", EndDate.getTime())
                .endObject();
        return builder.build();
    }

    @Override
    public JobOpeningDTO toDTO() {
        return new JobOpeningDTO(jobReference, company, contractType, function, address, mode, phases, currentPhase, numberOfVacancies, startDate, EndDate,interview, requirements);
    }

    private boolean isOverlapping(JobOpeningPhase newPhase) {
        for (JobOpeningPhase existingPhase : this.phases) {
            if (newPhase.getStartDate().before(existingPhase.getEndDate()) &&
                    newPhase.getEndDate().after(existingPhase.getStartDate())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Add phase.
     *
     * @param phase the phase
     */
    public void addPhase(JobOpeningPhase phase) {
        if (isOverlapping(phase)) {
            throw new IllegalArgumentException("The new phase overlaps with an existing phase.");
        }
        phase.setJobOpening(this); // Set the jobOpening in JobOpeningPhase
        this.phases.add(phase);
    }

    /**
     * Previous phase boolean.
     *
     * @return the boolean
     */
    public boolean previousPhase() {
        JobOpeningPhase currentPhase = this.currentPhase;
        if (this.toDTO().getPhase().indexOf(currentPhase) == 0) {
            return false;
        }
        this.setCurrentPhase(this.toDTO().getPhase().get(this.toDTO().getPhase().indexOf(currentPhase) - 1));
        return true;
    }

    /**
     * Next phase boolean.
     *
     * @return the boolean
     */
    public boolean nextPhase() {
        JobOpeningPhase currentPhase = this.currentPhase;
        if (this.toDTO().getPhase().indexOf(currentPhase) == this.toDTO().getPhase().size() - 1) {
            return false;
        }
        this.setCurrentPhase(this.toDTO().getPhase().get(this.toDTO().getPhase().indexOf(currentPhase) + 1));
        return true;
    }

}

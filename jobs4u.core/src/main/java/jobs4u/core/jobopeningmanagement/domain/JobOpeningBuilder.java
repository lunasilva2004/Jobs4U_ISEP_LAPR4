package jobs4u.core.jobopeningmanagement.domain;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.Designation;
import jobs4u.core.PluginManagement.InterviewModelManagement.domain.InterviewModel;
import jobs4u.core.PluginManagement.RequirementsSpecificationManagement.domain.RequirementSpecification;
import jobs4u.core.customerusermanagement.domain.Address;
import jobs4u.core.customerusermanagement.domain.Customer;
import jobs4u.core.interviewmanagement.domain.Interview;
import jobs4u.core.jobapplicationmanagement.domain.JobApplication;

import java.sql.Date;
import java.util.List;

/**
 * The type Job opening builder.
 */
public class JobOpeningBuilder implements DomainFactory<JobOpening> {

    private Designation jobReference;
    private String company;
    private Customer customer;
    private String contractType;
    private String function;
    private Address address;
    private String mode;
    private String vacancies;
    private RequirementSpecification requirements;
    private Interview interview;
    private Date startDate;
    private Date endDate;

    private List<JobApplication> jobApplicationList;

    /**
     * With job application job opening builder.
     *
     * @param jobApplicationList the job application list
     * @return the job opening builder
     */
    public JobOpeningBuilder withJobApplication(List<JobApplication> jobApplicationList) {
        this.jobApplicationList = jobApplicationList;
        return this;
    }

    /**
     * With job reference job opening builder.
     *
     * @param jobReference the job reference
     * @return the job opening builder
     */
    public JobOpeningBuilder withJobReference(Designation jobReference) {
        this.jobReference = jobReference;
        return this;
    }

    /**
     * With company job opening builder.
     *
     * @param company the company
     * @return the job opening builder
     */
    public JobOpeningBuilder withCompany(String company) {
        this.company = company;
        return this;
    }

    /**
     * With contract type job opening builder.
     *
     * @param contractType the contract type
     * @return the job opening builder
     */
    public JobOpeningBuilder withContractType(String contractType) {
        this.contractType = contractType;
        return this;
    }

    /**
     * With function job opening builder.
     *
     * @param function the function
     * @return the job opening builder
     */
    public JobOpeningBuilder withFunction(String function) {
        this.function = function;
        return this;
    }

    /**
     * With address job opening builder.
     *
     * @param address the address
     * @return the job opening builder
     */
    public JobOpeningBuilder withAddress(Address address) {
        this.address = address;
        return this;
    }

    /**
     * With mode job opening builder.
     *
     * @param mode the mode
     * @return the job opening builder
     */
    public JobOpeningBuilder withMode(String mode) {
        this.mode = mode;
        return this;
    }

    /**
     * With vacancies job opening builder.
     *
     * @param vacancies the vacancies
     * @return the job opening builder
     */
    public JobOpeningBuilder withVacancies(String vacancies) {
        this.vacancies = vacancies;
        return this;
    }

    /**
     * With requirements job opening builder.
     *
     * @param requirements the requirements
     * @return the job opening builder
     */
    public JobOpeningBuilder withRequirements(RequirementSpecification requirements) {
        this.requirements = requirements;
        return this;
    }

    /**
     * With customer job opening builder.
     *
     * @param customer the customer
     * @return the job opening builder
     */
    public JobOpeningBuilder withCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    /**
     * With interview job opening builder.
     *
     * @param interview the interview
     * @return the job opening builder
     */
    public JobOpeningBuilder withInterview(Interview interview) {
        this.interview = interview;
        return this;
    }

    /**
     * With start date job opening builder.
     *
     * @param startDate the start date
     * @return the job opening builder
     */
    public JobOpeningBuilder withStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * With end date job opening builder.
     *
     * @param endDate the end date
     * @return the job opening builder
     */
    public JobOpeningBuilder withEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    @Override
    public JobOpening build() {
        return new JobOpening(String.valueOf(jobReference), address, company,customer, contractType, function, mode, vacancies, startDate, endDate);
    }
}

/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package jobs4u.infrastructure.bootstrapers;

import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.domain.model.Role;
import jobs4u.core.PluginManagement.Description;
import jobs4u.core.PluginManagement.FQClassName;
import jobs4u.core.PluginManagement.InterviewModelManagement.domain.InterviewModel;
import jobs4u.core.PluginManagement.InterviewModelManagement.repository.InterviewModelRepository;
import jobs4u.core.PluginManagement.RequirementsSpecificationManagement.domain.RequirementSpecification;
import jobs4u.core.PluginManagement.RequirementsSpecificationManagement.repository.RequirementRepo;
import jobs4u.core.candidateusermanagement.domain.Candidate;
import jobs4u.core.candidateusermanagement.repositories.CandidateRepository;
import jobs4u.core.customerusermanagement.domain.*;
import jobs4u.core.customerusermanagement.repositories.CustomerRepository;
import jobs4u.core.jobapplicationmanagement.domain.JobApplication;
import jobs4u.core.jobapplicationmanagement.domain.State;
import jobs4u.core.jobapplicationmanagement.repositories.JobApplicationRepository;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;
import jobs4u.core.jobopeningmanagement.repositories.JobOpeningRepository;
import jobs4u.core.rankmanagement.domain.Rank;
import jobs4u.core.rankmanagement.repository.RankRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jobs4u.core.infrastructure.persistence.PersistenceContext;
import jobs4u.core.usermanagement.domain.BaseRoles;
import jobs4u.core.usermanagement.domain.UserBuilderHelper;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthenticationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.validations.Invariants;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Bootstrapping data app
 */
@SuppressWarnings("squid:S106")
public class Bootstrapper implements Action {
    private static final Logger LOGGER = LoggerFactory.getLogger(
            Bootstrapper.class);


    // Predefined users and their passwords
    private static final String[] ADMIN_USERS = {"admin1@this.app"};
    private static final String[] ADMIN_PWDS = {"adminA1"};
    private static final String[] OPERATOR_USERS = {"operator1@this.app"};
    private static final String[] OPERATOR_PWDS = {"operatorA1"};
    private static final String[] CUSTOMER_MANAGER_USERS = {"manager1@this.app"};
    private static final String[] CUSTOMER_MANAGER_PWDS = {"managerA1"};
    private static final String[] LANGUAGE_ENGINEER_USERS = {"language1@this.app"};
    private static final String[] LANGUAGE_ENGINEER_PWDS = {"languageA1"};
    private static final String[] CUSTOMER_USERS = {"isep@this.app", "worten@this.app"};
    private static final String[] CUSTOMER_PWDS = {"customerA1", "customerA2"};
    private static final String[] CANDIDATE_USERS = {"janedoe@email.com", "johndoe@email.com", "tin@this.app"};
    private static final String[] CANDIDATE_PWDS = {"candidateA1", "candidateA2", "candidateA3"};

    // Predefined requirement specification and interview model
    private static final RequirementSpecification requirementSpecification = new RequirementSpecification(
            new Name("Front End Junior Programmer"),
            new Description("Work hard and get nothing."),
            FQClassName.valueOf("Other.JobRequirementsSpecification_EX1")
    );
    private static final InterviewModel interviewModel = new InterviewModel(
            new Name("Formula One"),
            new Description("Formula One Quiz."),
            FQClassName.valueOf("Other.InterviewModel_EX1")
    );

    // Predefined customer and job openings
    private static final Customer customer = new Customer(
            new Name("Isep"),
            new Email("isep@this.app"),
            new PhoneNumber("912345678"),
            new Address("Rua Alberto")
    );
    private static final Customer customer1 = new Customer(
            new Name("Worten"),
            new Email("worten@this.app"),
            new PhoneNumber("912344678"),
            new Address("Rua Alberto")
    );

    /**
     * The Address string.
     */
    static String addressString = "Rua Alberto";
    /**
     * The Address.
     */
    static Address address = new Address(addressString);

    private static final JobOpening jobOpening1 = new JobOpening(
            "ISEP-01",
            address,
            "ISEP Company",
            customer,
            "FullTime",
            "Engineer",
            "Presential",
            "2",
            Date.valueOf("2021-10-01"),
            Date.valueOf("2021-10-31")
    );
    private static final JobOpening jobOpening2 = new JobOpening(
            "IBM-000123",
            address,
            "ISEP Company",
            customer,
            "FullTime",
            "Engineer",
            "Remote",
            "5",
            Date.valueOf("2021-01-01"),
            Date.valueOf("2021-01-31")
    );


   /* private static final JobOpening jobOpening3 = new JobOpening(
            "IBM-20",
            "Rua Alberto",
            "ISEP Company",
            customer,
            "FullTime",
            "Worker",
            "Presential",
            "2",
            Date.valueOf("2021-11-01"),
            Date.valueOf("2021-12-31")
    );*/

    // Predefined candidates
    private static final Candidate candidate1 = new Candidate(
            new Name("jane"),
            new Email("janedoeo@gmail.com"),
            new PhoneNumber("912345678")
    );
    private static final Candidate candidate2 = new Candidate(
            new Name("john"),
            new Email("johndoe@email.com"),
            new PhoneNumber("912345678")
    );
    private static final Candidate candidate = new Candidate(
            new Name("Tintin"),
            new Email("tin@this.app"),
            new PhoneNumber("912345678")
    );

    //Predefined rank


    // Services and repositories
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final AuthenticationService authenticationService = AuthzRegistry.authenticationService();
    private final UserRepository userRepository = PersistenceContext.repositories().users();
    private final RequirementRepo requirementSpecificationRepository = PersistenceContext.repositories().requirement();
    private final InterviewModelRepository interviewModelRepository = PersistenceContext.repositories().interviewModel();
    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();
    private final CustomerRepository customerRepository = PersistenceContext.repositories().customers();
    private final CandidateRepository candidateRepository = PersistenceContext.repositories().candidates();
    private final RankRepository rankRepository = PersistenceContext.repositories().ranks();
    private final JobApplicationRepository jobApplicationRepository = PersistenceContext.repositories().jobApplications();


    /**
     * Executes all bootstrapping processes.
     *
     * @return boolean indicating success or failure.
     */
    @Override
    public boolean execute() {
        boolean ret = true;

        // Bootstrapping Admin Users
        System.out.println("\nBootstrapping Admin Users Data...");
        for (int i = 0; i < ADMIN_USERS.length; i++) {
            registerUser(ADMIN_USERS[i], ADMIN_PWDS[i], BaseRoles.ADMIN);
            authenticateForBootstrapping(ADMIN_USERS[i], ADMIN_PWDS[i]);
        }

        // Bootstrapping Operator Users
        System.out.println("\nBootstrapping Operator Users Data...");
        for (int i = 0; i < OPERATOR_USERS.length; i++) {
            registerUser(OPERATOR_USERS[i], OPERATOR_PWDS[i], BaseRoles.OPERATOR);
            authenticateForBootstrapping(OPERATOR_USERS[i], OPERATOR_PWDS[i]);
        }

        // Bootstrapping Customer Manager Users
        System.out.println("\nBootstrapping Customer Manager Users Data...");
        for (int i = 0; i < CUSTOMER_MANAGER_USERS.length; i++) {
            registerUser(CUSTOMER_MANAGER_USERS[i], CUSTOMER_MANAGER_PWDS[i], BaseRoles.CUSTOMER_MANAGER);
            authenticateForBootstrapping(CUSTOMER_MANAGER_USERS[i], CUSTOMER_MANAGER_PWDS[i]);
        }

        // Bootstrapping Language Engineer Users
        System.out.println("\nBootstrapping Language Engineer Users Data...");
        for (int i = 0; i < LANGUAGE_ENGINEER_USERS.length; i++) {
            registerUser(LANGUAGE_ENGINEER_USERS[i], LANGUAGE_ENGINEER_PWDS[i], BaseRoles.LANGUAGE_ENGINEER);
            authenticateForBootstrapping(LANGUAGE_ENGINEER_USERS[i], LANGUAGE_ENGINEER_PWDS[i]);
        }

        // Bootstrapping Customer Users
        System.out.println("\nBootstrapping Customer Users Data...");
        for (int i = 0; i < CUSTOMER_USERS.length; i++) {
            registerUser(CUSTOMER_USERS[i], CUSTOMER_PWDS[i], BaseRoles.CUSTOMER);
            authenticateForBootstrapping(CUSTOMER_USERS[i], CUSTOMER_PWDS[i]);
        }

        // Bootstrapping Candidate Users
        System.out.println("\nBootstrapping Candidate Users Data...");
        for (int i = 0; i < CANDIDATE_USERS.length; i++) {
            registerUser(CANDIDATE_USERS[i], CANDIDATE_PWDS[i], BaseRoles.CANDIDATE);
            authenticateForBootstrapping(CANDIDATE_USERS[i], CANDIDATE_PWDS[i]);
        }

        // Bootstrapping Customers
        registerCustomer(customer);
        registerCustomer(customer1);

        // Bootstrapping Candidates
        registerCandidate(candidate);
        registerCandidate(candidate1);
        registerCandidate(candidate2);

        // Bootstrapping Job Openings
        registerJobOpenings(jobOpening1);
        registerJobOpenings(jobOpening2);
        //registerJobOpenings(jobOpening3);

        // Bootstrapping Requirement Specification
        registerRequirementsSpecification(requirementSpecification);

        JobOpening jobOpening1 = jobOpeningRepository.findByReference(Designation.valueOf("ISEP-01")).get();
        JobOpening jobOpening2 = jobOpeningRepository.findByReference(Designation.valueOf("IBM-000123")).get();

        JobApplication jobApplication1 = new JobApplication(

                candidate,
                new ArrayList<>(),
                State.PENDING,
                Date.valueOf("2021-10-01"),
                jobOpening1
        );

        JobApplication jobApplication3 = new JobApplication(

                candidate1,
                new ArrayList<>(),
                State.PENDING,
                Date.valueOf("2021-10-01"),
                jobOpening1
        );


        JobApplication jobApplication2 = new JobApplication(

                candidate2,
                new ArrayList<>(),
                State.PENDING,
                Date.valueOf("2021-10-01"),
                jobOpening1
        );

        JobApplication jobApplication4 = new JobApplication(

                candidate,
                new ArrayList<>(),
                State.PENDING,
                Date.valueOf("2021-10-01"),
                jobOpening2
        );

        JobApplication jobApplication5 = new JobApplication(

                candidate1,
                new ArrayList<>(),
                State.PENDING,
                Date.valueOf("2021-10-01"),
                jobOpening2
        );

        /* JobApplication jobApplication4 = new JobApplication(

                candidate2,
                new ArrayList<>(),
                State.PENDING,
                Date.valueOf("2021-10-01"),
                jobOpening3
        );

        JobApplication jobApplication5 = new JobApplication(

                candidate,
                new ArrayList<>(),
                State.PENDING,
                Date.valueOf("2021-10-01"),
                jobOpening3
        );*/



        // Predefined job applications
        // Bootstrapping Job Applications
        registerJobApplications(jobApplication1);
        registerJobApplications(jobApplication2);
        registerJobApplications(jobApplication3);
        registerJobApplications(jobApplication4);
        registerJobApplications(jobApplication5);

        // Bootstrapping Interview Model
        regusterInterviewModel(interviewModel);

        List<JobApplication> app1 = jobApplicationRepository.findByJobReference(Designation.valueOf("ISEP-01"));

        /*Order order1 = new Order(1, app1.get(0));
        Order order2 = new Order(2, app1.get(1));
        List<Order> orders1 = new ArrayList<>();
        orders1.add(order1);
        orders1.add(order2);
        // Bootstrapping Rank
        registerRank(new Rank(orders1, jobOpening1));*/

        return ret;
    }

    /**
     * Registers a user directly in the persistence layer.
     *
     * @param username the username
     * @param password the password
     * @param role     the role
     * @return boolean indicating success or failure.
     */
    private boolean registerUser(String username, String password, Role role) {
        final SystemUserBuilder userBuilder = UserBuilderHelper.builder();
        userBuilder.withUsername(username).withPassword(password).withName("First Name", "Last Name")
                .withEmail(username).withRoles(role);
        final SystemUser newUser = userBuilder.build();

        SystemUser poweruser;
        try {
            poweruser = userRepository.save(newUser);
            assert poweruser != null;
            return true;
        } catch (ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", newUser.username());
            LOGGER.trace("Assuming existing record", e);
            return false;
        }
    }

    /**
     * Authenticates a super user for bootstrapping.
     *
     * @param username the username
     * @param password the password
     */
    protected void authenticateForBootstrapping(String username, String password) {
        authenticationService.authenticate(username, password);
        Invariants.ensure(authz.hasSession());
    }

    /**
     * Registers a requirement specification.
     *
     * @param requirementSpecification the requirement specification
     * @return boolean indicating success or failure.
     */
    private boolean registerRequirementsSpecification(RequirementSpecification requirementSpecification) {
        RequirementSpecification requirementSpecification1 = null;
        try {
            requirementSpecification1 = requirementSpecificationRepository.save(requirementSpecification);
            assert requirementSpecification1 != null;
            return true;
        } catch (ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", requirementSpecification1.getName());
            LOGGER.trace("Assuming existing record", e);
            return false;
        }
    }

    /**
     * Registers an interview model.
     *
     * @param interviewModel the interview model
     * @return boolean indicating success or failure.
     */
    private boolean regusterInterviewModel(InterviewModel interviewModel) {
        InterviewModel interviewModel1 = null;
        try {
            interviewModel1 = interviewModelRepository.save(interviewModel);
            assert interviewModel1 != null;
            return true;
        } catch (ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", interviewModel1.getName());
            LOGGER.trace("Assuming existing record", e);
            return false;
        }
    }

    /**
     * Registers a customer.
     *
     * @param customer the customer
     * @return boolean indicating success or failure.
     */
    private boolean registerCustomer(Customer customer) {
        Customer customer1 = null;
        try {
            customer1 = customerRepository.save(customer);
            assert customer1 != null;
            return true;
        } catch (ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", customer1.getName());
            LOGGER.trace("Assuming existing record", e);
            return false;
        }
    }

    /**
     * Registers a candidate.
     *
     * @param candidate the candidate
     * @return boolean indicating success or failure.
     */
    private boolean registerCandidate(Candidate candidate) {
        Candidate candidate1 = null;
        try {
            candidate1 = candidateRepository.save(candidate);
            assert candidate1 != null;
            return true;
        } catch (ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", candidate1.getName());
            LOGGER.trace("Assuming existing record", e);
            return false;
        }
    }


    /**
     * Registers a job opening.
     *
     * @param jobOpening the job opening
     * @return boolean indicating success or failure.
     */
    private boolean registerJobOpenings(JobOpening jobOpening) {
        JobOpening jobOpening1 = null;
        try {
            jobOpening1 = jobOpeningRepository.save(jobOpening);
            assert jobOpening1 != null;
            return true;
        } catch (ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", jobOpening1.toDTO().getJobReference());
            LOGGER.trace("Assuming existing record", e);
            return false;
        }
    }


    /**
     * Registers a job application.
     *
     * @param jobapplication the job application
     * @return boolean indicating success or failure.
     */
    private boolean registerJobApplications(JobApplication jobapplication) {
        JobApplication jobapp1 = null;
        try {
            jobapp1 = jobApplicationRepository.save(jobapplication);
            assert jobapp1 != null;
            return true;
        } catch (ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", jobapp1.toDTO().getID());
            LOGGER.trace("Assuming existing record", e);
            return false;
        }
    }


    /**
     * Registers a rank
     *
     * @param rank the rank to be registered
     * @return boolean indicating success or failure of the rank registration
     */
    private boolean registerRank(Rank rank) {
        Rank savedRank = null;
        try {
            // Save the JobOpening object before saving the Rank object
            savedRank = rankRepository.save(rank);
            assert savedRank != null;
            return true;
        } catch (ConcurrencyException | IntegrityViolationException e) {
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", savedRank.getId());
            LOGGER.trace("Assuming existing record", e);
            return false;
        }
    }




}

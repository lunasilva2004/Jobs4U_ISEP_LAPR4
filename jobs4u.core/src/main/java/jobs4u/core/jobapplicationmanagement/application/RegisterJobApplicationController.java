package jobs4u.core.jobapplicationmanagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.time.util.CurrentTimeCalendars;
import jobs4u.core.candidateusermanagement.domain.Candidate;
import jobs4u.core.candidateusermanagement.domain.CandidateBuilder;
import jobs4u.core.candidateusermanagement.domain.PasswordGenerator;
import jobs4u.core.candidateusermanagement.repositories.CandidateRepository;
import jobs4u.core.customerusermanagement.domain.Email;
import jobs4u.core.customerusermanagement.domain.Name;
import jobs4u.core.customerusermanagement.domain.PhoneNumber;
import jobs4u.core.infrastructure.persistence.PersistenceContext;
import jobs4u.core.jobapplicationmanagement.domain.FileJobApp;
import jobs4u.core.jobapplicationmanagement.domain.JobApplication;
import jobs4u.core.jobapplicationmanagement.domain.JobApplicationBuilder;
import jobs4u.core.jobapplicationmanagement.domain.State;
import jobs4u.core.jobapplicationmanagement.repositories.JobApplicationRepository;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;
import jobs4u.core.jobopeningmanagement.repositories.JobOpeningRepository;
import jobs4u.core.usermanagement.domain.BaseRoles;

import java.util.*;


/**
 * The type Register job application controller.
 */
@UseCaseController
public class RegisterJobApplicationController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final JobApplicationRepository jobApplicationRepository = PersistenceContext.repositories().jobApplications();

    private final UserManagementService userSvc = AuthzRegistry.userService();
    private final CandidateRepository candidateRepository = PersistenceContext.repositories().candidates();
    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();

    /**
     * Register job application job application.
     *
     * @param jobReference      the job reference
     * @param emailString       the email string
     * @param iD                the d
     * @param files             the files
     * @param state             the state
     * @param firstNameString   the first name string
     * @param lastNameString    the last name string
     * @param phoneNumberString the phone number string
     * @return the job application
     */
    @SuppressWarnings("UnusedReturnValue")
    public JobApplication registerJobApplication(Designation jobReference, String emailString, String iD, List<FileJobApp> files, State state, String firstNameString, String lastNameString, String phoneNumberString) {

        JobApplicationBuilder builder = new JobApplicationBuilder();

        Email email = new Email(emailString);

        Name firstName = new Name(firstNameString + " " + lastNameString);

        PhoneNumber phoneNumber = new PhoneNumber(phoneNumberString);

        Candidate candidate = candidateRepository.findByEmail(email).orElse(null);

        if (candidate == null) {
            CandidateBuilder candidateBuilder = new CandidateBuilder()
                    .withName(firstName)
                    .withEmail(email)
                    .withPhoneNumber(phoneNumber);
            Candidate newCandidate = candidateBuilder.build();
            candidate = newCandidate;
            candidateRepository.save(newCandidate);

            authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.OPERATOR);

            Set<Role> roles = new HashSet<>();
            roles.add(BaseRoles.CANDIDATE);

            userSvc.registerNewUser(emailString, PasswordGenerator.generatePassword(), firstNameString, lastNameString, emailString, roles, CurrentTimeCalendars.now());
        }


        JobOpening jobOpening = jobOpeningRepository.findByReference(jobReference).orElse(null);
        if (jobOpening == null) {
            throw new IllegalArgumentException("Job Opening not found!");
        }

        JobApplication theJobApplication = builder
                .withCandidate(candidate)
                .withiD(iD)
                .withfile(files)
                .withState(state)
                .withJobOpening(jobOpening)
                .withDate(CurrentTimeCalendars.now().getTime())
                .build();

        return save(theJobApplication);
    }


    /**
     * Save job application.
     *
     * @param jobApplication the job application
     * @return the job application
     */
    public JobApplication save(JobApplication jobApplication) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.OPERATOR, BaseRoles.CUSTOMER_MANAGER);


        jobApplication = jobApplicationRepository.save(jobApplication);

        return jobApplication;
    }


}

package jobs4u.core.jobopeningmanagement.application.Services;

import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import jobs4u.core.candidateusermanagement.domain.Candidate;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;
import jobs4u.core.jobopeningmanagement.domain.PhaseType;
import jobs4u.core.jobopeningmanagement.repositories.JobOpeningRepository;
import jobs4u.core.rankmanagement.domain.Order;
import jobs4u.core.rankmanagement.domain.Rank;
import jobs4u.core.rankmanagement.repository.RankRepository;
import jobs4u.core.usermanagement.domain.BaseRoles;
import lapr4.emailService.EmailService;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Publish results service.
 */
public class PublishResultsService {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final EmailService emailService;

    private final RankRepository rankRepository;

    private final JobOpeningRepository jobOpeningRepository;


    /**
     * Instantiates a new Publish results service.
     *
     * @param rankRepository       the rank repository
     * @param emailService         the email service
     * @param jobOpeningRepository the job opening repository
     */
    public PublishResultsService(RankRepository rankRepository, EmailService emailService, JobOpeningRepository jobOpeningRepository) {
        this.rankRepository = rankRepository;
        this.emailService = emailService;
        this.jobOpeningRepository = jobOpeningRepository;
    }

    /**
     * Notify candidates and customers boolean.
     *
     * @param jobReference the job reference
     * @return the boolean
     */
    public boolean notifyCandidatesAndCustomers(Designation jobReference) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);

        boolean emailSent = false;

        List<Candidate> candidatesAccepted = new ArrayList<>();

        List<JobOpening> jobOpeningByPhase = jobOpeningRepository.findJobOpeningsByPhase(PhaseType.RESULT);
        if (jobOpeningByPhase == null || jobOpeningByPhase.isEmpty()) {
            throw new IllegalArgumentException("There is no job openings to list check the phase state.");
        }

        for (JobOpening jobOpening : jobOpeningByPhase) {

            if (jobOpening.getJobReference().equals(jobReference)) {

                for (Rank rankings : rankRepository.findAll()) {

                    for (Order order : rankings.getRankOrders()) {
                        if (order != null) {

                            String candidateEmail = order.getJobApplication().getCandidate().getEmail().getValue();
                            String subject = "Congratulations on Your Job Application for " + rankings.getJobOpening().getJobReference();
                            String message = "Dear " + order.getJobApplication().getCandidate().getName() + ",\n\n" +
                                    "We are thrilled to inform you that your application " + order.getJobApplication().getID() + " for the job opening " + rankings.getJobOpening().getJobReference() + " has been accepted. " +
                                    "Congratulations on this achievement! We are impressed with your qualifications and are excited to have you move forward in the selection process.\n\n" +
                                    "You will soon be contacted by our team to discuss the next steps and provide further details about the job position. " +
                                    "Thank you for your interest in joining our company.\n\n" +
                                    "Best regards,\n" +
                                    "The Jobs4U Team";

                            emailService.sendEmail(
                                    candidateEmail,
                                    subject,
                                    message
                                    , false, false);


                            candidatesAccepted.add(order.getJobApplication().getCandidate());

                            saveEmailMessage(candidateEmail, subject, message);

                            emailSent = true;

                        }
                    }

                    if (!candidatesAccepted.isEmpty()) {

                        String acceptedCandidatesList = candidatesAccepted.stream()
                                .map(candidate -> "- " + candidate.getName() + " (" + candidate.getEmail().getValue() + ")")
                                .collect(Collectors.joining("\n"));

                        String customerEmail = rankings.getJobOpening().getCustomer().getEmail().getValue();
                        String subject = "List of Accepted Candidates for Job Opening " + rankings.getJobOpening().getJobReference();
                        String message = "Dear " + rankings.getJobOpening().getCustomer().getName() + ",\n\n" +
                                "We are pleased to inform you that the following candidates have been accepted for the job opening " + rankings.getJobOpening().getJobReference() + ":\n\n" +
                                acceptedCandidatesList + "\n\n" +
                                "We are excited about the potential these candidates bring to your organization. " +
                                "Thank you for choosing Jobs4U.\n\n" +
                                "Best regards,\n" +
                                "The Jobs4U Team";


                        emailService.sendEmail(
                                customerEmail,
                                subject,
                                message
                                , false, false);

                        saveEmailMessage(customerEmail, subject, message);

                    }

                }
            }
        }

        return emailSent;
    }

    private void saveEmailMessage(String recipient, String subject, String message) {
        File file = new File("messageEmailsSent.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write("To: " + recipient);
            writer.newLine();
            writer.write("Subject: " + subject);
            writer.newLine();
            writer.write(message);
            writer.newLine();
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error saving email message: " + e.getMessage());
        }
    }




}

package jobs4u.app.backoffice.console.presentation.applications.UI;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.core.candidateusermanagement.application.SeeCandidateInfoController;
import jobs4u.core.candidateusermanagement.domain.Candidate;
import jobs4u.core.customerusermanagement.domain.Email;

import java.util.Map;

/**
 * The type See candidate info ui.
 */
public class SeeCandidateInfoUI extends AbstractUI {
    private final SeeCandidateInfoController candidateInfoController;

    /**
     * Instantiates a new See candidate info ui.
     *
     * @param candidateInfoController the candidate info controller
     */
    public SeeCandidateInfoUI(SeeCandidateInfoController candidateInfoController) {
        this.candidateInfoController = candidateInfoController;
    }

    @Override
    protected boolean doShow() {
        String emailStr = promptForEmail();
        Email email = new Email(emailStr);

        Candidate candidate = candidateInfoController.findCandidateByEmail(email);
        if (candidate == null) {
            System.out.println("Candidate not found.");
            return false;
        }else {
            Map<String, Map<String, Map<String, Integer>>> executionMessages = candidateInfoController.processTopWordsForCandidate(email);
            displayCandidateInfo(candidate);
            displayTopWords(executionMessages);
        }
        return true;
    }

    private String promptForEmail() {
        return Console.readLine("Enter candidate's email: ");
    }

    private void displayCandidateInfo(Candidate candidate) {
        System.out.println("Candidate Information:\n");
        System.out.println("Name: " + candidate.getName());
        System.out.println("Email: " + candidate.getEmail());
        System.out.println("Phone Number: " + candidate.toDTO().getPhoneNumber().getValue());
        System.out.println();
    }

    private void displayTopWords(Map<String, Map<String, Map<String, Integer>>> executionMessages) {
        for (Map.Entry<String, Map<String, Map<String, Integer>>> applicationEntry : executionMessages.entrySet()) {
            System.out.println("Application " + applicationEntry.getKey());
            for (Map.Entry<String, Map<String, Integer>> fileEntry : applicationEntry.getValue().entrySet()) {
                System.out.println("\tFile " + fileEntry.getKey() + " - Top Twenty Words: ");
                for (Map.Entry<String, Integer> wordEntry : fileEntry.getValue().entrySet()) {
                    System.out.println("\t\t" + wordEntry.getKey() + ": " + wordEntry.getValue());
                }
            }
        }
    }

    @Override
    public String headline() {
        return "View Candidate Information";
    }
}

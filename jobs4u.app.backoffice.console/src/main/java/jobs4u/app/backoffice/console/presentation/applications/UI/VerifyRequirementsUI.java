package jobs4u.app.backoffice.console.presentation.applications.UI;

import eapli.framework.general.domain.model.Designation;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.core.jobapplicationmanagement.application.VerifyRequirementsController;
import jobs4u.core.jobapplicationmanagement.domain.JobApplication;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;

import java.util.*;

/**
 * The type Verify requirements ui.
 */
public class VerifyRequirementsUI extends AbstractUI {

    private final VerifyRequirementsController theController = new VerifyRequirementsController();
    private final List<JobOpening> jobOpeningList = new ArrayList<>();

    @Override
    protected boolean doShow() {

        listJobOpenings();

        Designation jobReference = selectJobOpening();

        listJobApplications(jobReference);

        System.out.println("Do you want to proceed with the verification? (y/n)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("y")) {
            List<String> executionMessages = theController.verifyRequirementsConcurrently(jobReference);
            executionMessages.forEach(System.out::println);
        }else {
            System.out.println("Verification process cancelled.");
            return false;
        }

        return false;
    }

    /**
     * List job openings.
     */
    public void listJobOpenings(){
        Iterable<JobOpening> jobOpenings = theController.getJobOpenings();
        jobOpenings.forEach(jobOpeningList::add);

        for (int i = 0; i < jobOpeningList.size(); i++) {
            System.out.println((i + 1) + ". " + jobOpeningList.get(i).toDTO().getJobReference());
        }
    }

    /**
     * List job applications.
     *
     * @param jobReference the job reference
     */
    public void listJobApplications(Designation jobReference){
        List<JobApplication> jobApplicationList = theController.getJobApplicationsByJobReference(jobReference);
        for (int i = 0; i < jobApplicationList.size(); i++) {
            System.out.println((i + 1) + ".  Candidate Name: " + jobApplicationList.get(i).toDTO().getCandidate().toDTO().getName());
        }
    }

    /**
     * Select job opening designation.
     *
     * @return the designation
     */
    public Designation selectJobOpening(){
        System.out.println("Please, select a Job Opening:");
        Scanner scanner = new Scanner(System.in);
        try {
            int index = scanner.nextInt();
            if (index < 1 || index > jobOpeningList.size()) {
                System.out.println("Invalid index. Please, try again.");
                return null;
            }

            JobOpening selectedJobOpening = jobOpeningList.get(index - 1);

            return selectedJobOpening.toDTO().getJobReference();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please, enter a number.");
        } catch (NoSuchElementException e) {
            System.out.println("No input provided. Please, try again.");
        }
        return null;
    }

    @Override
    public String headline() {
        return "Evaluate Interviews";
    }
}

package jobs4u.app.backoffice.console.presentation.applications.UI;

import eapli.framework.general.domain.model.Designation;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.core.jobopeningmanagement.application.ManagePhasesController;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;
import jobs4u.core.jobopeningmanagement.domain.JobOpeningPhase;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static com.fasterxml.jackson.databind.cfg.CoercionInputShape.Array;

/**
 * The type Manage phases ui.
 */
public class ManagePhasesUI extends AbstractUI {

    private final ManagePhasesController theController = new ManagePhasesController();
    private final List<JobOpening> jobOpeningList = new ArrayList<>();

    @Override
    protected boolean doShow() {

        listJobOpenings();

        Designation jobReference = selectJobOpening();
        if (jobReference != null) {
            if (theController.getJobOpeningPhases(jobReference).isEmpty()) {
                System.out.println("No Phases Found! Please Setup Phases First!");
                return true;
            }
            JobOpeningPhase currentPhase = getCurrentPhase(jobReference);
            if(currentPhase == null){
                System.out.println("No current phase defined for Job Opening " + jobReference);
                if (askUserToStartPhases()) {
                    theController.startPhases(jobReference);
                    System.out.println("Phases started for Job Opening " + jobReference);
                }
            } else {
                System.out.println("Current Phase for Job Opening " + jobReference + ": " + currentPhase);
                String action = askUserForPhaseAction();
                try {
                    if (action.equals("Next Phase")) {
                        theController.nextPhase(jobReference);
                        System.out.println("New Selected Phase : " + theController.getCurrentPhase(jobReference));
                    } else if (action.equals("Previous Phase")) {
                        theController.previousPhase(jobReference);
                        System.out.println("New Selected Phase : " + theController.getCurrentPhase(jobReference));
                    } else {
                        System.out.println("Action cancelled by the user.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return false;
    }

    @Override
    public String headline() {
        return "Manage Phases";
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

    /**
     * Ask user to start phases boolean.
     *
     * @return the boolean
     */
    public boolean askUserToStartPhases() {
        System.out.println("Do you want to start the phases? (y/n)");
        return scanResponseFromConsole();
    }

    /**
     * Ask user for phase action string.
     *
     * @return the string
     */
    public String askUserForPhaseAction() {
        List<String> options = List.of("Next Phase", "Previous Phase", "Cancel Action");
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
        System.out.println("Please, select an option:");
        Scanner scanner = new Scanner(System.in);
        int response = scanner.nextInt();

        while (response < 1 || response > options.size()) {
            System.out.println("Invalid input. Please, enter a number between 1 and " + options.size() + ".");
            response = scanner.nextInt();
        }

        return options.get(response - 1);
    }

    private boolean scanResponseFromConsole() {
        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine().toLowerCase();

        while (!response.equals("y") && !response.equals("n")) {
            System.out.println("Invalid input. Please, enter 'y' for yes or 'n' for no.");
            response = scanner.nextLine().toLowerCase();
        }

        return response.equals("y");
    }

    /**
     * Get current phase job opening phase.
     *
     * @param jobReference the job reference
     * @return the job opening phase
     */
    public JobOpeningPhase getCurrentPhase(Designation jobReference){
        return theController.getCurrentPhase(jobReference);
    }


}
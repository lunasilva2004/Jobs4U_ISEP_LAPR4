package jobs4u.app.backoffice.console.presentation.applications.UI;

import eapli.framework.presentation.console.AbstractUI;
import jobs4u.core.jobapplicationmanagement.domain.JobApplication;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;
import jobs4u.core.rankmanagement.application.RankController;
import jobs4u.core.rankmanagement.domain.Order;

import java.util.*;

/**
 * The type Rankk ui.
 */
public class RankkUI extends AbstractUI {
    private final RankController rankController = new RankController();

    /**
     * Instantiates a new Rankk ui.
     */
    public RankkUI() {
    }

    @Override
    protected boolean doShow() {
        Scanner scanner = new Scanner(System.in);

        List<JobOpening> jobOpenings = rankController.getAllAnalysisJobOpenings();

        if (jobOpenings.isEmpty()) {
            System.out.println("No job openings found.");
            return false;
        }

        System.out.println("Select a job opening:");
        int i = 1;
        for (JobOpening jobOpening : jobOpenings) {
            System.out.println(i + ". " + jobOpening.identity());
            i++;
        }

        int jobOpeningIndex = scanner.nextInt() - 1;
        JobOpening selectedJobOpening = jobOpenings.get(jobOpeningIndex);

        List<JobApplication> jobApplicationsList = rankController.getJobApplicationsByJobReference(selectedJobOpening);

        int vacancies = rankController.getVacancies(selectedJobOpening);

        List<JobApplication> selectedApplications = new ArrayList<>();
        if (jobApplicationsList.size() > vacancies) {
            System.out.println("There are more applications than vacancies. Please select which applications to rank:");

            for (i = 0; i < jobApplicationsList.size(); i++) {
                Map<String, Object> candidateDetails = rankController.getCandidateDetails(jobApplicationsList.get(i));
                System.out.println((i + 1) + ". Application ID: " + candidateDetails.get("id") + ", Candidate Email: " + candidateDetails.get("email"));
            }

            for (i = 0; i < vacancies; i++) {
                System.out.println("Enter the number of the application to rank:");
                int applicationIndex = scanner.nextInt() - 1;
                selectedApplications.add(jobApplicationsList.get(applicationIndex));
            }
        }

        // Ask for the order of the selected applications
        List<Order> orders = new ArrayList<>();
        Set<Integer> usedOrders = new HashSet<>();


        for (JobApplication jobApplication : selectedApplications) {
            Map<String, Object> candidateDetails = rankController.getCandidateDetails(jobApplication);
            int order;
            while (true) {
                System.out.println("Enter the order for application with ID " + candidateDetails.get("id") + " for candidate with email " + candidateDetails.get("email") + ":");
                order = scanner.nextInt();
                if (!usedOrders.contains(order)) {
                    usedOrders.add(order);
                    break;
                } else {
                    System.out.println("Order " + order + " has already been used. Please enter a different order.");
                }
            }
            rankController.addOrderToList(orders, order, jobApplication);
        }

        // Set the order of the unselected applications to null
        for (JobApplication jobApplication : jobApplicationsList) {
            if (!selectedApplications.contains(jobApplication)) {
                rankController.addNullOrderToList(orders, jobApplication);
            }
        }

        rankController.saveRanking(selectedJobOpening, orders);
        System.out.println("Ranking saved successfully.");
        return true;
    }

    @Override
    public String headline() {
        return "Rank Job Applications";
    }
}
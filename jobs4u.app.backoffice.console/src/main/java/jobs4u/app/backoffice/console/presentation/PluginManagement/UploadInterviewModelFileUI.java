package jobs4u.app.backoffice.console.presentation.PluginManagement;

import eapli.framework.presentation.console.AbstractUI;
import jobs4u.core.PluginManagement.controller.UploadFileController;
import jobs4u.core.jobapplicationmanagement.domain.JobApplication;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;

import java.util.List;
import java.util.Scanner;

/**
 * This class provides a user interface for uploading interview model files.
 * It extends the AbstractUI class and overrides the doShow and headline methods.
 */
public class UploadInterviewModelFileUI extends AbstractUI {

    // Controller to handle file upload operations
    private final UploadFileController controller = new UploadFileController();

    /**
     * This method is responsible for displaying the user interface and handling user input.
     * It fetches all job openings, asks the user to select a job opening and a job application,
     * and then asks the user to enter the path to the file to be uploaded.
     * If the file is syntactically correct, it is uploaded.
     *
     * @return false after the operation is completed.
     */
    @Override
    protected boolean doShow() {
        // Fetch all job openings
        List<JobOpening> jobOpeningList = controller.getAllInterviewsJobOpenings();
        if (jobOpeningList.isEmpty()) {
            System.out.println("No job openings found on Interview Phase.");
            return false;
        }

        // Ask the user to select a job opening
        System.out.println("Select a job opening:");
        int i = 1;
        for (JobOpening jobOpening : jobOpeningList) {
            System.out.println((i++) + ". " + jobOpening.identity());
        }

        Scanner scanner = new Scanner(System.in);
        int jobOpeningIndex = scanner.nextInt() - 1;
        JobOpening selectedJobOpening = controller.getInterviewsJobOpeningByIndex(jobOpeningIndex);

        // Fetch all job applications for the selected job opening
        List<JobApplication> jobApplicationsList = controller.getJobApplicationsByJobReference(selectedJobOpening.toDTO().getJobReference());
        if (jobApplicationsList.isEmpty()) {
            System.out.println("No job applications found for the selected job opening.");
            return false;
        }

        // Ask the user to select a job application
        System.out.println("Select a job application:");
        i = 1;
        for (JobApplication jobApplication : jobApplicationsList) {
            System.out.println((i++) + ". Application " + jobApplication.identity());
        }

        int jobApplicationIndex = scanner.nextInt() - 1;
        JobApplication selectedJobApplication = controller.getJobApplicationByIndex(jobApplicationIndex, selectedJobOpening.toDTO().getJobReference());

        // Ask the user for the file path
        System.out.println("Enter the path to your file:");
        scanner.nextLine();  // Consume newline left-over
        String filePath = scanner.nextLine();

        // Test if is syntactically correct
        if (!controller.verifyInterviewSyntax(filePath)) {
            System.out.println("The file is not syntactically correct. Please try again.");
        } else {
            // Call the controller to upload the file
            boolean success = controller.uploadInterviewsFile(filePath, selectedJobOpening, selectedJobApplication);

            if (success) {
                System.out.println("File moved successfully");
            } else {
                System.out.println("An error occurred while uploading the file.");
            }
        }

        return false;
    }

    /**
     * This method returns the headline for this user interface.
     *
     * @return the headline string.
     */
    @Override
    public String headline() {
        return "Upload Candidate's Answers";
    }
}
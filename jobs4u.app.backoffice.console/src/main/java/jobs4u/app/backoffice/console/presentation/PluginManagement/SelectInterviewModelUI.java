package jobs4u.app.backoffice.console.presentation.PluginManagement;

import eapli.framework.presentation.console.AbstractUI;
import jobs4u.core.PluginManagement.InterviewModelManagement.controller.SelectInterviewModelController;
import jobs4u.core.PluginManagement.InterviewModelManagement.domain.InterviewModel;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;

import java.util.List;
import java.util.Scanner;

/**
 * The type Select interview model ui.
 */
public class SelectInterviewModelUI extends AbstractUI {

    private final SelectInterviewModelController controller = new SelectInterviewModelController();

    protected boolean doShow() {
        List<JobOpening> jobOpeningList = controller.getAllJobOpenings();

        System.out.println("Please select the number of the Job Opening:");
        for (int i = 0; i < jobOpeningList.size(); i++) {
            System.out.println((i + 1) + ". " + jobOpeningList.get(i).identity());
        }
        int jobOpeningIndex = new Scanner(System.in).nextInt() - 1;
        JobOpening selectedJobOpening = controller.getJobOpeningByIndex(jobOpeningIndex);

        List<InterviewModel> interviewModelList = controller.getAllInterviewModels();

        System.out.println("Please select the number of the Interview Model:");
        for (int i = 0; i < interviewModelList.size(); i++) {
            System.out.println((i + 1) + ". " + interviewModelList.get(i).getName().getValue());
        }
        int interviewModelIndex = new Scanner(System.in).nextInt() - 1;
        InterviewModel selectedInterviewModel = controller.getInterviewModelByIndex(interviewModelIndex);

        if (selectedJobOpening != null && selectedInterviewModel != null) {
            controller.associateInterviewModelToJobOpening(selectedInterviewModel.getName(), selectedJobOpening.identity());
        } else {
            System.out.println("Job Opening or Interview Model not found.");
        }
        return false;
    }

    @Override
    public String headline() {
        return "Select Interview Model";
    }
}
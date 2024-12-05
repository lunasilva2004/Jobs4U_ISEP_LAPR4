package jobs4u.app.backoffice.console.presentation.applications.UI;


import eapli.framework.general.domain.model.Designation;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.core.jobapplicationmanagement.application.ListCandidatesByInterviewsGradeController;
import jobs4u.core.jobapplicationmanagement.dto.JobApplicationDTO;


import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * The type List candidates by interview grades ui.
 */
public class ListCandidatesByInterviewGradesUI extends AbstractUI {

    private final ListCandidatesByInterviewsGradeController theController = new ListCandidatesByInterviewsGradeController();


    @Override
    protected boolean doShow() {

        final String jobOpeningReference = Console.readNonEmptyLine("Job Opening Reference", "Please enter the job opening reference");

        Map<JobApplicationDTO,String> jobApplicationDTOS;
        try {
            jobApplicationDTOS = theController.allCandidatesByInterviewGrade(Designation.valueOf(jobOpeningReference));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (!jobApplicationDTOS.isEmpty()){
            displayInformation(jobApplicationDTOS);
        }else {
            System.out.println("Fail to list the candidates by interview points");
        }


        return true;

    }

    /**
     * Display information.
     *
     * @param jobApplicationDTOS the job application dtos
     */
    public void displayInformation(Map<JobApplicationDTO, String> jobApplicationDTOS) {

        System.out.println("Nome | Email | Grade");

        for (Map.Entry<JobApplicationDTO, String> entry : jobApplicationDTOS.entrySet()) {
            JobApplicationDTO application = entry.getKey();
            String justification = entry.getValue();

            String name = application.getCandidate().getName().getValue();
            String email = application.getCandidate().getEmail().getValue();
            Integer grade = application.getInterviewGrade().getValue();

            System.out.println(name + " | " + email + " | " + grade);
            System.out.println("Justification: \n" + justification);
            System.out.println("-------------------------------------------------");
        }
    }

    @Override
    public String headline() {
        return "List Candidates By Interviews Grades ";
    }

}

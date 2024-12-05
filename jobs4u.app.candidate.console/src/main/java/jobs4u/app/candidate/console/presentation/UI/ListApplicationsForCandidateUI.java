//package jobs4u.app.candidate.console.presentation.UI;
//
//import eapli.framework.presentation.console.AbstractUI;
//import jobs4u.core.jobapplicationmanagement.application.ListJobApplicationController;
//
//import java.util.List;
//
//public class ListApplicationsForCandidateUI extends AbstractUI {
//
//    private final ListJobApplicationController jobApplicationController = new ListJobApplicationController();
//
//    @Override
//    protected boolean doShow() {
//        System.out.println("Fetching your job applications...");
//        System.out.println();
//        List<String> applications = jobApplicationController.listJobApplicationsForCandidate();
//        applications.forEach(System.out::println);
//        return true;
//    }
//
//    @Override
//    public String headline() {
//        return "List Applications For Candidate";
//    }
//}
//package jobs4u.app.customer.console.presentation.UI;
//
//import eapli.framework.presentation.console.AbstractUI;
//import jobs4u.core.jobopeningmanagement.application.ListJobOpeningController;
//
//import java.util.List;
//
//public class ListJobOpeningsForCustomerUI extends AbstractUI {
//    private final ListJobOpeningController jobOpeningController = new ListJobOpeningController();
//
//    @Override
//    protected boolean doShow() {
//        System.out.println("Fetching your job openings... Please wait a second...");
//        System.out.println();
//        List<String> jobOpenings = jobOpeningController.listJobOpeningsForCustomer();
//        jobOpenings.forEach(System.out::println);
//        return true;
//    }
//
//    @Override
//    public String headline() {
//        return "List Job Openings";
//    }
//}
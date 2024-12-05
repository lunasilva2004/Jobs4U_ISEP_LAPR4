import Other.JobRequirementsSpecification_EX1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        JobRequirementsSpecification_EX1 jobRequirementsSpecificationEX1 = new JobRequirementsSpecification_EX1();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the path to your file:");
        String filePath1 = scanner.nextLine();

        System.out.println("Enter the path to your file:");
        String filePath2 = scanner.nextLine();

        // Call the generateTemplate method
        //jobRequirementsSpecificationEX1.generateTemplate();

        // Call the isFileSyntaxCorrect method with the file path
       // boolean isSyntaxCorrect = jobRequirementsSpecificationEX1.isFileSyntaxCorrect(filePath);
        //System.out.println("Is file syntax correct: " + isSyntaxCorrect);

        // Call the evaluateFile method with the file path
        int evaluationResult = jobRequirementsSpecificationEX1.evaluateFile(filePath1, filePath2);
        System.out.println("Evaluation result: " + evaluationResult);
    }
}
import Other.InterviewModel_EX1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InterviewModel_EX1 interviewModelEX1 = new InterviewModel_EX1();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the path to your file:");
        String filePath1 = scanner.nextLine();

        System.out.println("Enter the path to your file:");
        String filePath2 = scanner.nextLine();

        // Call the generateTemplate method with the output directory
        //interviewModelEX1.generateTemplate();

        // Call the isFileSyntaxCorrect method with the file path
        boolean isSyntaxCorrect = interviewModelEX1.isFileSyntaxCorrect(filePath1);
        System.out.println("Is file syntax correct: " + isSyntaxCorrect);

        // Call the evaluateFile method with the file path
        String evaluationResult = interviewModelEX1.evaluateFile(filePath1,filePath2);
        System.out.println("Evaluation result: " + evaluationResult);
    }
}
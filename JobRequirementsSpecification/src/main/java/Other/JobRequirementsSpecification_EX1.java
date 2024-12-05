package Other;

import GeneratedClasses.JobRequirementsSpecificationLexer;
import GeneratedClasses.JobRequirementsSpecificationListenerImpl;
import GeneratedClasses.JobRequirementsSpecificationParser;
import Interface.JobRequirementsSpecificationInterface;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JobRequirementsSpecification_EX1 implements JobRequirementsSpecificationInterface {

    @Override
    public void generateTemplate() {

        try {
            // Generate a unique filename using the current timestamp
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");
            String timestamp = LocalDateTime.now().format(formatter1);
            String templateFilePath = "front_end_junior_programmer_" + timestamp + ".txt";

            // Create a PrintWriter to write to the template text file
            PrintWriter writer = new PrintWriter(new FileWriter(templateFilePath));

            // Write the job requirements specification details
            writer.println("TITLE: Front End Junior Programmer");
            writer.println("COMPANY: WORTEN");
            writer.println("ABOUT THIS JOB: Work hard and get nothing.");
            writer.println("EMAIL: ");
            writer.println();

            // Write the job requirements and questions to the template text file
            writer.println("REQUIREMENT 1");
            writer.println("NUMBER QUESTION: How many years of experience do you have in Java?");
            writer.println("ANSWER: ");
            writer.println();

            writer.println("REQUIREMENT 2");
            writer.println("TEXT QUESTION: What is your academic degree?");
            writer.println("ANSWER: ");
            writer.println();

            writer.println("REQUIREMENT 3");
            writer.println("MULTIPLE MULTIPLE-CHOICE QUESTION: Select the programing languages that you know.");
            writer.println("a) Java");
            writer.println("b) C#");
            writer.println("c) Python");
            writer.println("d) Ruby");
            writer.println("ANSWER: ");
            writer.println();

            // Close the PrintWriter
            writer.close();

            System.out.println("Template text file generated successfully: " + templateFilePath);
        } catch (IOException e) {
            System.err.println("Error generating template text file: " + e.getMessage());
        }

    }


    @Override
    public boolean isFileSyntaxCorrect(String filePath) {
        try {

            // Step 1: Create a CharStream that reads from the file
            CharStream input = CharStreams.fromFileName(filePath);

            // Step 2: Create an instance of the lexer with the CharStream
            JobRequirementsSpecificationLexer lexer = new JobRequirementsSpecificationLexer(input);

            // Step 3: Create a CommonTokenStream using the lexer
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            // Step 4: Create an instance of the parser with the CommonTokenStream
            JobRequirementsSpecificationParser parser = new JobRequirementsSpecificationParser(tokens);

            // Step 5: Add an error listener to the parser
            parser.removeErrorListeners(); // remove the default ConsoleErrorListener
            BaseErrorListener errorListener = new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                    throw new IllegalStateException("Failed to parse at line " + line + " due to " + msg, e);
                }
            };
            parser.addErrorListener(errorListener);

            // Step 6: Start the parsing process
            parser.start();

            // Step 7: If no errors are caught, return true. Otherwise, return false
            return true;
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int evaluateFile(String correctAnswersFilePath, String candidateAnswersFilePath) {
        try {
            Map<String, String> correctAnswers = getAnswersFromFilePath(correctAnswersFilePath);
            Map<String, String> candidateAnswers = getAnswersFromFilePath(candidateAnswersFilePath);

            int score = 0;
            for (Map.Entry<String, String> entry : correctAnswers.entrySet()) {
                String question = entry.getKey();
                String correctAnswer = entry.getValue();
                String candidateAnswer = candidateAnswers.get(question);

                if (correctAnswer.equals(candidateAnswer)) {
                    score++;
                }
            }
            return Math.round((float) score / correctAnswers.size() * 100);
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    private Map<String, String> getAnswersFromFilePath(String filePath) throws IOException {
        CharStream input = CharStreams.fromFileName(filePath);
        JobRequirementsSpecificationLexer lexer = new JobRequirementsSpecificationLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JobRequirementsSpecificationParser parser = new JobRequirementsSpecificationParser(tokens);
        JobRequirementsSpecificationListenerImpl listener = new JobRequirementsSpecificationListenerImpl();

        ParseTreeWalker.DEFAULT.walk(listener, parser.start());

        return listener.getCorrectAnswers();
    }

    public List<Integer> evaluateMultipleFiles(String correctAnswersFilePath, List<String> candidateAnswersFilePaths) {
        List<Integer> evaluationResults = new ArrayList<>();
        for (String candidateAnswersFilePath : candidateAnswersFilePaths) {
            int evaluationResult = evaluateFile(correctAnswersFilePath, candidateAnswersFilePath);
            evaluationResults.add(evaluationResult);
        }
        return evaluationResults;
    }

    public String generateTemplateResponses() {
        String templateFilePath = "requirementsResponseTemplate.txt";

        try {
            // Generate a unique filename using the current timestamp
            // Create a PrintWriter to write to the template text file
            PrintWriter writer = new PrintWriter(new FileWriter(templateFilePath));

            // Write the job requirements specification details
            writer.println("TITLE: Front End Junior Programmer");
            writer.println("COMPANY: WORTEN");
            writer.println("ABOUT THIS JOB: Work hard and get nothing.");
            writer.println("EMAIL: 1220858@isep.ipp.pt");
            writer.println();

            // Write the job requirements and questions to the template text file
            writer.println("REQUIREMENT 1");
            writer.println("NUMBER QUESTION: How many years of experience do you have in Java?");
            writer.println("ANSWER: 4");
            writer.println();

            writer.println("REQUIREMENT 2");
            writer.println("TEXT QUESTION: What is your academic degree?");
            writer.println("ANSWER: Computer Science.");
            writer.println();

            writer.println("REQUIREMENT 3");
            writer.println("MULTIPLE MULTIPLE-CHOICE QUESTION: Select the programing languages that you know.");
            writer.println("a) Java");
            writer.println("b) C#");
            writer.println("c) Python");
            writer.println("d) Ruby");
            writer.println("ANSWER: a), c)");
            writer.println();

            // Close the PrintWriter
            writer.close();

        } catch (IOException e) {
            System.err.println("Error generating template text file: " + e.getMessage());
        }

        return templateFilePath;
    }
}
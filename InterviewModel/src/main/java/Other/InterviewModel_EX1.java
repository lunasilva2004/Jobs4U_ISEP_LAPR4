package Other;

import GeneratedClasses.*;
import Interface.InterviewModelInterface;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InterviewModel_EX1 implements InterviewModelInterface {


    @Override
    public void generateTemplate() {

        try {
            // Generate a unique filename using the current timestamp
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");
            String timestamp = LocalDateTime.now().format(formatter1);
            String templateFilePath = "formula_one_quiz_template_" + timestamp + ".txt";

            // Create a PrintWriter to write to the template text file
            PrintWriter writer = new PrintWriter(new FileWriter(templateFilePath));

            // Write the quiz details
            writer.println("INTERVIEW: FORMULA ONE QUIZ");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String formattedDate = LocalDate.now().format(formatter);
            writer.println("DATE: " + formattedDate);
            writer.println("ABOUT: This quiz is about Formula One, the highest class of international auto racing for SS formula racing cars sanctioned by the FIA.");
            writer.println("EMAIL: ");
            writer.println();

            // Write the requirements/questions and answers to the template text file
            writer.println("REQUIREMENT 1");
            writer.println("SHORT_ANSWER_QUESTION: WHAT IS FORMULA ONE?");
            writer.println("ANSWER: ");
            writer.println();

            writer.println("REQUIREMENT 2");
            writer.println("SINGLE_CHOICE_QUESTION: HOW OLD DO YOU NEED TO BE ABLE TO RACE IN FORMULA ONE?");
            writer.println("a) Eighteen");
            writer.println("b) Twenty");
            writer.println("c) Twenty One");
            writer.println("d) Twenty Two");
            writer.println("ANSWER: ");
            writer.println();

            writer.println("REQUIREMENT 3");
            writer.println("MULTIPLE_CHOICE_QUESTION: WHICH OF THE FOLLOWING ARE FORMER FORMULA ONE DRIVERS?");
            writer.println("a) Fernando Alonso");
            writer.println("b) Sebastian Vettel");
            writer.println("c) Kimi Raikkonen");
            writer.println("d) Michael Schumacher");
            writer.println("ANSWER: ");
            writer.println();

            writer.println("REQUIREMENT 4");
            writer.println("INTEGER_QUESTION: HOW MANY WORLD CHAMPIONSHIPS HAS LEWIS HAMILTON WON?");
            writer.println("ANSWER: ");
            writer.println();

            writer.println("REQUIREMENT 5");
            writer.println("DECIMAL_QUESTION: WHAT IS THE LENGTH OF SPA IN KILOMETERS?");
            writer.println("ANSWER:");
            writer.println();

            writer.println("REQUIREMENT 6");
            writer.println("DATE_QUESTION: WHEN WAS THE FIRST FORMULA ONE WORLD CHAMPIONSHIP HELD?");
            writer.println("ANSWER: ");
            writer.println();

            writer.println("REQUIREMENT 7");
            writer.println("TIME_QUESTION: HOW LONG DOES AN AVERAGE FORMULA ONE RACE LAST?");
            writer.println("ANSWER: ");
            writer.println();

            writer.println("REQUIREMENT 8");
            writer.println("NUMERIC_SCALE_QUESTION: HOW WOULD YOU RATE VERSTAPPEN DRIVING SKILLS (1 THROUGH 10)?");
            writer.println("ANSWER: ");
            writer.println();

            writer.println("REQUIREMENT 9");
            writer.println("T_F_QUESTION: WAS MAX VERSTAPPEN THE YOUNGEST DRIVER TO WIN A FORMULA ONE RACE?");
            writer.println("a) True");
            writer.println("b) False");
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
            InterviewModelLexer lexer = new InterviewModelLexer(input);

            // Step 3: Create a CommonTokenStream using the lexer
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            // Step 4: Create an instance of the parser with the CommonTokenStream
            InterviewModelParser parser = new InterviewModelParser(tokens);

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
    public String evaluateFile(String correctAnswersFilePath, String candidateAnswersFilePath) {
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

            int percentageScore = Math.round((float) score / correctAnswers.size() * 100);

            return "Evaluation result: " + percentageScore + "%";
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }


    public Map<String, String> getAnswersFromFilePath(String filePath) throws IOException {
        CharStream input = CharStreams.fromFileName(filePath);
        InterviewModelLexer lexer = new InterviewModelLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        InterviewModelParser parser = new InterviewModelParser(tokens);
        InterviewModelListenerImpl listener = new InterviewModelListenerImpl();

        ParseTreeWalker.DEFAULT.walk(listener, parser.start());

        return listener.getCorrectAnswers();
    }

    public List<String> evaluateMultipleFiles(String correctAnswersFilePath, List<String> candidateAnswersFilePaths) {
        List<String> evaluationResults = new ArrayList<>();
        for (String candidateAnswersFilePath : candidateAnswersFilePaths) {
            String evaluationResult = evaluateFile(correctAnswersFilePath, candidateAnswersFilePath);
            evaluationResults.add(evaluationResult);
        }
        return evaluationResults;
    }
}
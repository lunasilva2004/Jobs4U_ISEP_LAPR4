package Interface;

public interface InterviewModelInterface {

    void generateTemplate();

    boolean isFileSyntaxCorrect(String filePath);

    String evaluateFile(String correctAnswersFilePath, String candidateAnswersFilePath);
}
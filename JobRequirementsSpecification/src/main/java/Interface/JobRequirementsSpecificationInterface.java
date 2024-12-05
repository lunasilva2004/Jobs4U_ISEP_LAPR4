package Interface;

public interface JobRequirementsSpecificationInterface {

    void generateTemplate();

    boolean isFileSyntaxCorrect(String filePath);

    int evaluateFile(String correctAnswersFilePath, String candidateAnswersFilePath);
}
package GeneratedClasses;

import java.util.HashMap;
import java.util.Map;

public class JobRequirementsSpecificationListenerImpl extends JobRequirementsSpecificationBaseListener {

    private final Map<String, String> correctAnswers = new HashMap<>();
    private String currentQuestion;

    @Override
    public void enterNumber(GeneratedClasses.JobRequirementsSpecificationParser.NumberContext ctx) {
        currentQuestion = ctx.DESCRIPTION().getText();

    }

    @Override
    public void exitNumber(GeneratedClasses.JobRequirementsSpecificationParser.NumberContext ctx) {
        String correctAnswer;
        if (ctx.NUMBER() != null) {
            correctAnswer = ctx.NUMBER().getText();
        } else {
            throw new IllegalStateException("No valid answer found for integer question");
        }
        correctAnswers.put(currentQuestion, correctAnswer);
    }

    @Override
    public void enterMultiple(GeneratedClasses.JobRequirementsSpecificationParser.MultipleContext ctx) {
        currentQuestion = ctx.DESCRIPTION().getText();
    }

    @Override
    public void exitMultiple(GeneratedClasses.JobRequirementsSpecificationParser.MultipleContext ctx) {
        String correctAnswer = ctx.MULTIPLANSEWER().getText();
        correctAnswers.put(currentQuestion, correctAnswer);
    }

    @Override
    public void enterText(GeneratedClasses.JobRequirementsSpecificationParser.TextContext ctx) {
        currentQuestion = ctx.DESCRIPTION(0).getText();
    }

    @Override
    public void exitText(JobRequirementsSpecificationParser.TextContext ctx) {
        String correctAnswer = ctx.DESCRIPTION(1) != null ? ctx.DESCRIPTION(1).getText() : null;
        if (correctAnswer == null) {
            throw new IllegalStateException("No valid answer found for short answer question");
        }
        correctAnswers.put(currentQuestion, correctAnswer);
    }


    public Map<String, String> getCorrectAnswers() {
        return correctAnswers;
    }

}

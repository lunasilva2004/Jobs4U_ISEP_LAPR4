package GeneratedClasses;

import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.Map;

public class InterviewModelListenerImpl extends InterviewModelBaseListener {

    private final Map<String, String> correctAnswers = new HashMap<>();
    private String currentQuestion;

    @Override
    public void enterTrue_false_question(GeneratedClasses.InterviewModelParser.True_false_questionContext ctx) {
        currentQuestion = ctx.DESCRIPTION_TEXT().getText();
    }

    @Override
    public void exitTrue_false_question(GeneratedClasses.InterviewModelParser.True_false_questionContext ctx) {
        String correctAnswer = ctx.CHOICE_ANSWER().getText();
        correctAnswers.put(currentQuestion, correctAnswer);
    }

    @Override
    public void enterShort_answer_question(GeneratedClasses.InterviewModelParser.Short_answer_questionContext ctx) {
        currentQuestion = ctx.DESCRIPTION_TEXT(0).getText();
    }

    @Override
    public void exitShort_answer_question(GeneratedClasses.InterviewModelParser.Short_answer_questionContext ctx) {
        String correctAnswer = ctx.DESCRIPTION_TEXT(1) != null ? ctx.DESCRIPTION_TEXT(1).getText() : null;
        if (correctAnswer == null) {
            throw new IllegalStateException("No valid answer found for short answer question");
        }
        correctAnswers.put(currentQuestion, correctAnswer);
    }

    @Override
    public void enterSingle_choice_question(GeneratedClasses.InterviewModelParser.Single_choice_questionContext ctx) {
        currentQuestion = ctx.DESCRIPTION_TEXT().getText();
    }

    @Override
    public void exitSingle_choice_question(GeneratedClasses.InterviewModelParser.Single_choice_questionContext ctx) {
        String correctAnswer = ctx.CHOICE_ANSWER().getText();
        correctAnswers.put(currentQuestion, correctAnswer);
    }

    @Override
    public void enterMultiple_choice_question(GeneratedClasses.InterviewModelParser.Multiple_choice_questionContext ctx) {
        currentQuestion = ctx.DESCRIPTION_TEXT().getText();
    }

    @Override
    public void exitMultiple_choice_question(GeneratedClasses.InterviewModelParser.Multiple_choice_questionContext ctx) {
        String correctAnswer = ctx.CHOICE_ANSWER().getText();
        correctAnswers.put(currentQuestion, correctAnswer);
    }

    @Override
    public void enterInteger_question(GeneratedClasses.InterviewModelParser.Integer_questionContext ctx) {
        currentQuestion = ctx.DESCRIPTION_TEXT().getText();
    }

    @Override
    public void exitInteger_question(GeneratedClasses.InterviewModelParser.Integer_questionContext ctx) {
        String correctAnswer;
        if (ctx.INTEIRO() != null) {
            correctAnswer = ctx.INTEIRO().getText();
        } else if (ctx.DIGITO() != null) {
            correctAnswer = ctx.DIGITO().getText();
        } else {
            throw new IllegalStateException("No valid answer found for integer question");
        }
        correctAnswers.put(currentQuestion, correctAnswer);
    }

    @Override
    public void enterDecimal_question(GeneratedClasses.InterviewModelParser.Decimal_questionContext ctx) {
        currentQuestion = ctx.DESCRIPTION_TEXT().getText();
    }

    @Override
    public void exitDecimal_question(GeneratedClasses.InterviewModelParser.Decimal_questionContext ctx) {
        String correctAnswer = ctx.DECIMAL() != null ? ctx.DECIMAL().getText() : null;
        if (correctAnswer == null) {
            throw new IllegalStateException("No valid answer found for decimal question");
        }
        correctAnswers.put(currentQuestion, correctAnswer);
    }

    @Override
    public void enterDate_question(GeneratedClasses.InterviewModelParser.Date_questionContext ctx) {
        currentQuestion = ctx.DESCRIPTION_TEXT().getText();
    }

    @Override
    public void exitDate_question(GeneratedClasses.InterviewModelParser.Date_questionContext ctx) {
        String correctAnswer = ctx.DATE() != null ? ctx.DATE().getText() : null;
        if (correctAnswer == null) {
            throw new IllegalStateException("No valid answer found for date question");
        }
        correctAnswers.put(currentQuestion, correctAnswer);
    }

    @Override
    public void enterTime_question(GeneratedClasses.InterviewModelParser.Time_questionContext ctx) {
        currentQuestion = ctx.DESCRIPTION_TEXT().getText();
    }

    @Override
    public void exitTime_question(GeneratedClasses.InterviewModelParser.Time_questionContext ctx) {
        String correctAnswer = ctx.TIME() != null ? ctx.TIME().getText() : null;
        if (correctAnswer == null) {
            throw new IllegalStateException("No valid answer found for time question");
        }
        correctAnswers.put(currentQuestion, correctAnswer);
    }

    @Override
    public void enterNumeric_scale_question(GeneratedClasses.InterviewModelParser.Numeric_scale_questionContext ctx) {
        StringBuilder questionText = new StringBuilder();
        for (TerminalNode node : ctx.DESCRIPTION_TEXT()) {
            questionText.append(node.getText()).append(" ");
        }
        currentQuestion = questionText.toString().trim();
    }

    @Override
    public void exitNumeric_scale_question(InterviewModelParser.Numeric_scale_questionContext ctx) {
        String correctAnswer = ctx.DIGITO(ctx.DIGITO().size() - 1).getText();
        correctAnswers.put(currentQuestion, correctAnswer);
    }

    public Map<String, String> getCorrectAnswers() {
        return correctAnswers;
    }
}


package GeneratedClasses;// Generated from /Users/pedrom2004_/Desktop/sem4pi-23-24-2dh2/InterviewModel/src/main/java/InterviewModel.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link InterviewModelParser}.
 */
public interface InterviewModelListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link InterviewModelParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(InterviewModelParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(InterviewModelParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelParser#template}.
	 * @param ctx the parse tree
	 */
	void enterTemplate(InterviewModelParser.TemplateContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelParser#template}.
	 * @param ctx the parse tree
	 */
	void exitTemplate(InterviewModelParser.TemplateContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(InterviewModelParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(InterviewModelParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelParser#interview_title_line}.
	 * @param ctx the parse tree
	 */
	void enterInterview_title_line(InterviewModelParser.Interview_title_lineContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelParser#interview_title_line}.
	 * @param ctx the parse tree
	 */
	void exitInterview_title_line(InterviewModelParser.Interview_title_lineContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelParser#date_line}.
	 * @param ctx the parse tree
	 */
	void enterDate_line(InterviewModelParser.Date_lineContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelParser#date_line}.
	 * @param ctx the parse tree
	 */
	void exitDate_line(InterviewModelParser.Date_lineContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelParser#description_line}.
	 * @param ctx the parse tree
	 */
	void enterDescription_line(InterviewModelParser.Description_lineContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelParser#description_line}.
	 * @param ctx the parse tree
	 */
	void exitDescription_line(InterviewModelParser.Description_lineContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelParser#email_line}.
	 * @param ctx the parse tree
	 */
	void enterEmail_line(InterviewModelParser.Email_lineContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelParser#email_line}.
	 * @param ctx the parse tree
	 */
	void exitEmail_line(InterviewModelParser.Email_lineContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelParser#requirements}.
	 * @param ctx the parse tree
	 */
	void enterRequirements(InterviewModelParser.RequirementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelParser#requirements}.
	 * @param ctx the parse tree
	 */
	void exitRequirements(InterviewModelParser.RequirementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelParser#requirement}.
	 * @param ctx the parse tree
	 */
	void enterRequirement(InterviewModelParser.RequirementContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelParser#requirement}.
	 * @param ctx the parse tree
	 */
	void exitRequirement(InterviewModelParser.RequirementContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelParser#true_false_question}.
	 * @param ctx the parse tree
	 */
	void enterTrue_false_question(InterviewModelParser.True_false_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelParser#true_false_question}.
	 * @param ctx the parse tree
	 */
	void exitTrue_false_question(InterviewModelParser.True_false_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelParser#short_answer_question}.
	 * @param ctx the parse tree
	 */
	void enterShort_answer_question(InterviewModelParser.Short_answer_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelParser#short_answer_question}.
	 * @param ctx the parse tree
	 */
	void exitShort_answer_question(InterviewModelParser.Short_answer_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelParser#single_choice_question}.
	 * @param ctx the parse tree
	 */
	void enterSingle_choice_question(InterviewModelParser.Single_choice_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelParser#single_choice_question}.
	 * @param ctx the parse tree
	 */
	void exitSingle_choice_question(InterviewModelParser.Single_choice_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelParser#multiple_choice_question}.
	 * @param ctx the parse tree
	 */
	void enterMultiple_choice_question(InterviewModelParser.Multiple_choice_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelParser#multiple_choice_question}.
	 * @param ctx the parse tree
	 */
	void exitMultiple_choice_question(InterviewModelParser.Multiple_choice_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelParser#integer_question}.
	 * @param ctx the parse tree
	 */
	void enterInteger_question(InterviewModelParser.Integer_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelParser#integer_question}.
	 * @param ctx the parse tree
	 */
	void exitInteger_question(InterviewModelParser.Integer_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelParser#decimal_question}.
	 * @param ctx the parse tree
	 */
	void enterDecimal_question(InterviewModelParser.Decimal_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelParser#decimal_question}.
	 * @param ctx the parse tree
	 */
	void exitDecimal_question(InterviewModelParser.Decimal_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelParser#date_question}.
	 * @param ctx the parse tree
	 */
	void enterDate_question(InterviewModelParser.Date_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelParser#date_question}.
	 * @param ctx the parse tree
	 */
	void exitDate_question(InterviewModelParser.Date_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelParser#time_question}.
	 * @param ctx the parse tree
	 */
	void enterTime_question(InterviewModelParser.Time_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelParser#time_question}.
	 * @param ctx the parse tree
	 */
	void exitTime_question(InterviewModelParser.Time_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelParser#numeric_scale_question}.
	 * @param ctx the parse tree
	 */
	void enterNumeric_scale_question(InterviewModelParser.Numeric_scale_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelParser#numeric_scale_question}.
	 * @param ctx the parse tree
	 */
	void exitNumeric_scale_question(InterviewModelParser.Numeric_scale_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelParser#option}.
	 * @param ctx the parse tree
	 */
	void enterOption(InterviewModelParser.OptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelParser#option}.
	 * @param ctx the parse tree
	 */
	void exitOption(InterviewModelParser.OptionContext ctx);
}
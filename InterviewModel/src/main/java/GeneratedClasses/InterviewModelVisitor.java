package GeneratedClasses;// Generated from /Users/pedrom2004_/Desktop/sem4pi-23-24-2dh2/InterviewModel/src/main/java/InterviewModel.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link InterviewModelParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface InterviewModelVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link InterviewModelParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(InterviewModelParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelParser#template}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplate(InterviewModelParser.TemplateContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader(InterviewModelParser.HeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelParser#interview_title_line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterview_title_line(InterviewModelParser.Interview_title_lineContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelParser#date_line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate_line(InterviewModelParser.Date_lineContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelParser#description_line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescription_line(InterviewModelParser.Description_lineContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelParser#email_line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmail_line(InterviewModelParser.Email_lineContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelParser#requirements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRequirements(InterviewModelParser.RequirementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelParser#requirement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRequirement(InterviewModelParser.RequirementContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelParser#true_false_question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue_false_question(InterviewModelParser.True_false_questionContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelParser#short_answer_question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShort_answer_question(InterviewModelParser.Short_answer_questionContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelParser#single_choice_question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingle_choice_question(InterviewModelParser.Single_choice_questionContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelParser#multiple_choice_question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple_choice_question(InterviewModelParser.Multiple_choice_questionContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelParser#integer_question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger_question(InterviewModelParser.Integer_questionContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelParser#decimal_question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimal_question(InterviewModelParser.Decimal_questionContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelParser#date_question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate_question(InterviewModelParser.Date_questionContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelParser#time_question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTime_question(InterviewModelParser.Time_questionContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelParser#numeric_scale_question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumeric_scale_question(InterviewModelParser.Numeric_scale_questionContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelParser#option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption(InterviewModelParser.OptionContext ctx);
}
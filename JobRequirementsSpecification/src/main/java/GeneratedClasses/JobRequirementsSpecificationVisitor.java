package GeneratedClasses;// Generated from /Users/josemendes/Documents/IdeaProjects/sem4pi-23-24-2dh2/JobRequirementsSpecification/src/main/java/JobRequirementsSpecification.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JobRequirementsSpecificationParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JobRequirementsSpecificationVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JobRequirementsSpecificationParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(JobRequirementsSpecificationParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link JobRequirementsSpecificationParser#specification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecification(JobRequirementsSpecificationParser.SpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JobRequirementsSpecificationParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader(JobRequirementsSpecificationParser.HeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link JobRequirementsSpecificationParser#title}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTitle(JobRequirementsSpecificationParser.TitleContext ctx);
	/**
	 * Visit a parse tree produced by {@link JobRequirementsSpecificationParser#company_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompany_name(JobRequirementsSpecificationParser.Company_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JobRequirementsSpecificationParser#description}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescription(JobRequirementsSpecificationParser.DescriptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JobRequirementsSpecificationParser#email}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmail(JobRequirementsSpecificationParser.EmailContext ctx);
	/**
	 * Visit a parse tree produced by {@link JobRequirementsSpecificationParser#requirements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRequirements(JobRequirementsSpecificationParser.RequirementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JobRequirementsSpecificationParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(JobRequirementsSpecificationParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JobRequirementsSpecificationParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(JobRequirementsSpecificationParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link JobRequirementsSpecificationParser#multiple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple(JobRequirementsSpecificationParser.MultipleContext ctx);
	/**
	 * Visit a parse tree produced by {@link JobRequirementsSpecificationParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(JobRequirementsSpecificationParser.TextContext ctx);
	/**
	 * Visit a parse tree produced by {@link JobRequirementsSpecificationParser#options}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptions(JobRequirementsSpecificationParser.OptionsContext ctx);
}
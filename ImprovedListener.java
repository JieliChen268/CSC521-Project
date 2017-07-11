// Generated from Improved.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ImprovedParser}.
 */
public interface ImprovedListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ImprovedParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ImprovedParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImprovedParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ImprovedParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classDeclaration}
	 * labeled alternative in {@link ImprovedParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(ImprovedParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classDeclaration}
	 * labeled alternative in {@link ImprovedParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(ImprovedParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImprovedParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(ImprovedParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImprovedParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(ImprovedParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableDeclaration}
	 * labeled alternative in {@link ImprovedParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(ImprovedParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableDeclaration}
	 * labeled alternative in {@link ImprovedParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(ImprovedParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImprovedParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(ImprovedParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImprovedParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(ImprovedParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statementRecall}
	 * labeled alternative in {@link ImprovedParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementRecall(ImprovedParser.StatementRecallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statementRecall}
	 * labeled alternative in {@link ImprovedParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementRecall(ImprovedParser.StatementRecallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statementPrint}
	 * labeled alternative in {@link ImprovedParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementPrint(ImprovedParser.StatementPrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statementPrint}
	 * labeled alternative in {@link ImprovedParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementPrint(ImprovedParser.StatementPrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link ImprovedParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssign(ImprovedParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link ImprovedParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssign(ImprovedParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayAssign}
	 * labeled alternative in {@link ImprovedParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterArrayAssign(ImprovedParser.ArrayAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayAssign}
	 * labeled alternative in {@link ImprovedParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitArrayAssign(ImprovedParser.ArrayAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parens}
	 * labeled alternative in {@link ImprovedParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(ImprovedParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link ImprovedParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(ImprovedParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mod}
	 * labeled alternative in {@link ImprovedParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMod(ImprovedParser.ModContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mod}
	 * labeled alternative in {@link ImprovedParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMod(ImprovedParser.ModContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link ImprovedParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(ImprovedParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link ImprovedParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(ImprovedParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functioncall}
	 * labeled alternative in {@link ImprovedParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFunctioncall(ImprovedParser.FunctioncallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functioncall}
	 * labeled alternative in {@link ImprovedParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFunctioncall(ImprovedParser.FunctioncallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code strtt}
	 * labeled alternative in {@link ImprovedParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterStrtt(ImprovedParser.StrttContext ctx);
	/**
	 * Exit a parse tree produced by the {@code strtt}
	 * labeled alternative in {@link ImprovedParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitStrtt(ImprovedParser.StrttContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link ImprovedParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(ImprovedParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link ImprovedParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(ImprovedParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link ImprovedParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterId(ImprovedParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link ImprovedParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitId(ImprovedParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Powe}
	 * labeled alternative in {@link ImprovedParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPowe(ImprovedParser.PoweContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Powe}
	 * labeled alternative in {@link ImprovedParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPowe(ImprovedParser.PoweContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link ImprovedParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(ImprovedParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link ImprovedParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(ImprovedParser.IntContext ctx);
}

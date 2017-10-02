// Generated from Improved.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ImprovedParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ImprovedVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ImprovedParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(ImprovedParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classDeclaration}
	 * labeled alternative in {@link ImprovedParser#classDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(ImprovedParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ImprovedParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(ImprovedParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableDeclaration}
	 * labeled alternative in {@link ImprovedParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(ImprovedParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ImprovedParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(ImprovedParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementRecall}
	 * labeled alternative in {@link ImprovedParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementRecall(ImprovedParser.StatementRecallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementPrint}
	 * labeled alternative in {@link ImprovedParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementPrint(ImprovedParser.StatementPrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link ImprovedParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(ImprovedParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayAssign}
	 * labeled alternative in {@link ImprovedParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAssign(ImprovedParser.ArrayAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link ImprovedParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(ImprovedParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mod}
	 * labeled alternative in {@link ImprovedParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMod(ImprovedParser.ModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link ImprovedParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDiv(ImprovedParser.MulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functioncall}
	 * labeled alternative in {@link ImprovedParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctioncall(ImprovedParser.FunctioncallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code strtt}
	 * labeled alternative in {@link ImprovedParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrtt(ImprovedParser.StrttContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link ImprovedParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(ImprovedParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code id}
	 * labeled alternative in {@link ImprovedParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(ImprovedParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Powe}
	 * labeled alternative in {@link ImprovedParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowe(ImprovedParser.PoweContext ctx);
	/**
	 * Visit a parse tree produced by the {@code int}
	 * labeled alternative in {@link ImprovedParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(ImprovedParser.IntContext ctx);
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.tree.TerminalNode;

public class IVisitor extends ImprovedBaseVisitor<Integer> {
	
	 Map<String,Set<String>> classMap = new HashMap<String,Set<String>>();

	 Map<String,Integer> symTable = new HashMap<String, Integer>();
	
	 Set<String> set = new HashSet<String> (); 


	    /* prog :  classDecl+   */
	/*	@Override 
		public Integer visitProg(LabeledParser.ProgContext ctx) { 
			return visit((org.antlr.v4.runtime.tree.ParseTree) ctx.classDecl()); }  */ 
	
		
		/* classDecl: 'class' ID '{' block '}' */
	 
		@Override 
		public Integer visitClassDeclaration(LabeledParser.ClassDeclarationContext ctx) { 
			String name = ctx.ID().getText();
			
			if (classMap.containsKey(name)) {
				System.out.println("Class '" + name + "' is already defined!");
				System.exit(-1);
			}
			
		    classMap.put(name, set);
		/*	System.out.println("Class '" + name + "' is created!");
		    System.out.println();*/
		    
		    /*  code injection  */
		  //  IR.addCode("Class " + name + " { " );
		  IR.addCode("public static void main(String[] args) {");
			return visit(ctx.block()); 
		}
		
	/*	@Override public Integer visitVdecl(LabeledParser.VdeclContext ctx) {
			
			return visitChildren(ctx); 
			
		}*/
		
	/*	@Override public Integer visitStat(MiniJavaParser.StatContext ctx) { 
			
			return visitChildren(ctx); 
			} */
		
		/* varDecl : type ID ';'  */
		@Override 
		public Integer visitVariableDeclaration(LabeledParser.VariableDeclarationContext ctx) { 
			String id = ctx.ID().getText();
//			System.out.println("id :" + id);
		
			
			
			set.add(id);
				
			symTable.put(id, null);
//			System.out.println("Variable '" + id + "' is created!");
//			System.out.println();	
			
			 /*  code injection  */
		    IR.addCode("int " + id + "; " );
		    IR.addCode(" ");
			return 0;

		}
		
		@Override 
		public Integer visitType(LabeledParser.TypeContext ctx) { return 0; }
		
		/*statement :   '{' statement* '}'*/
		@Override 
		public Integer visitStatementRecall(LabeledParser.StatementRecallContext ctx) { 
			return 0; 
			
		}
		
		
		/*statement : 'System.out.println' '(' expr ')' ';' */
		@Override 
		public Integer visitStatementPrint(LabeledParser.StatementPrintContext ctx) { 
			
			int value = visit(ctx.expr());
/*			System.out.println("Expression value: " + value);
			System.out.println();     
			                                          */
		  /*  code injection  */
		    IR.addCode("System.out.println("  + value + ");" );	
		    IR.addCode(" ");	
			return 0;		
			
		}
		
		/*statement : ID '=' expr ';'*/
		@Override 
		public Integer visitAssign(LabeledParser.AssignContext ctx) { 
			
			String id = ctx.ID().getText();
			
			if (!symTable.containsKey(id)) {
				System.out.println("undeclared variable " + id);
				System.out.println();
				System.exit(-1);
			}
			
			int value = visit(ctx.expr()); 
/*			System.out.println(visit(ctx.expr()));
			System.out.println("Assignment has been defined :" + "< "+ id + " = " + value + " >");			
			System.out.println();                                                                    */
			
			symTable.put(id, value);
			
			/*  code injection  */
		    IR.addCode(id + " = "  + value + ";" );	
		    IR.addCode(" ");
			return value;
			
		}
		
		
		/*expr: '(' expr ')'  */
		@Override 
		public Integer visitParens(LabeledParser.ParensContext ctx) { 
			
			/*  code injection  */
		    IR.addCode("System.out.println("  + visit(ctx.expr()) + ");");	
		    
			return visit(ctx.expr());
			
		}
		
		/* expr:expr '%' expr */
		@Override 
		public Integer visitMod(LabeledParser.ModContext ctx) { 
			
		//	int left = 0;     
		//	int right = 1;    	
			int left = visit(ctx.expr(0));	
			int right = visit(ctx.expr(1));
			/*  code injection  */
			String leftStr = ctx.expr(0).getText();
			String rightStr = ctx.expr(1).getText();
			IR.addCode( "System.out.println(" +  leftStr + " % " + rightStr +  ");");
			
			
			return left % right;
			
		 }
		
		/* expr:expr ( '/' | '*') expr */
		@Override 
		public Integer visitMulDiv(LabeledParser.MulDivContext ctx) { 
			//int left = 0;  //	int left = visit(ctx.expr(0));
		//	int right = 1; //	int right = visit(ctx.expr(1));
			int left = visit(ctx.expr(0));
			int right = visit(ctx.expr(1));
			if ( ctx.op.getType() == LabeledParser.MUL) {
				
				/*  code injection  */
				String leftStr = ctx.expr(0).getText();
				String rightStr = ctx.expr(1).getText();
				IR.addCode( "System.out.println(" +  leftStr + " * " + rightStr +  ");");
				
				return left * right;   
			} else {
				
				/*  code injection  */
				String leftStr = ctx.expr(0).getText();
				String rightStr = ctx.expr(1).getText();
				IR.addCode( "System.out.println(" +  leftStr + " / " + rightStr +  ");");
				
				return left / right;
			}
			
	}
	
		
		/*     expr: 'fun' f=('Max'|'Min'|'Avg'|'Sort') '(' ID (',' ID)+ ')'    */
		@Override 
		public Integer visitFunctioncall(LabeledParser.FunctioncallContext ctx) { 
			
			int result = 0;
			
			java.util.List<TerminalNode> idList = new ArrayList();
			
			idList =  ctx.ID();
			String[] id = new String[idList.size()];
			int[] value = new int[id.length];
			
			for (int i = 0; i < idList.size(); i++) {
				
				id[i] = idList.get(i).toString();
				
//				System.out.println("id " + i +" is : " + id[i]);
			}
			/*check id is declared and has value*/
			for (int i = 0; i < id.length; i++) {
				
				if (symTable.containsKey(id[i])) {
					
					 if (symTable.get(id[i]) != null) {
						 
						 value[i] = symTable.get(id[i]);
						 
					 } else {
						 System.out.println("id " + id[i] + " has not been assigned valued");
					 }
				} else {
					System.out.println("id " + id[i] + " has not been declared");
				   }
			}
			
			int max = 0, min = 0, avg = 0;
			
			/*Max function*/
			
			if (ctx.f.getType() == LabeledParser.MAX) {

				for (int i = 0; i < id.length; i++) {
					max = value[0];
					if (value[i] >= max) {
						max = value[i];
					}
				}
				
				/*  code injection  */
				StringBuilder sb = new StringBuilder();
				sb.append("System.out.println(Math.max(");

				for (int i = 0; i < id.length - 1; i++) {
					sb.append(id[i].toString() + ", ");
				}
				sb.append(id[id.length - 1] + "));");
				IR.addCode(sb.toString());
				
				result = max;
			}
			
			/*Min function*/
			if (ctx.f.getType() == LabeledParser.MIN) {
				
				for (int i = 0; i < id.length; i++) {
					min = value[0];
					if (value[i] <= max) {
						min = value[i];
					}
				}
				
				/*  code injection  */
				StringBuilder sb = new StringBuilder();
				sb.append("System.out.println(Math.min(");
//				IR.addCode( "fun Min (");
				for (int i = 0; i < id.length - 1; i++) {
					sb.append(id[i].toString() + ", ");
//					IR.addCode(id[i].toString() + ", ");
				}
				
		//		IR.addCode(id[id.length - 1] + ");");
				sb.append(id[id.length - 1] + "));");
				IR.addCode(sb.toString());
				result = min;
			}
			
			/*Avg function*/
		
			
			if (ctx.f.getType() == LabeledParser.AVG) {
				
				for (int i = 0; i < id.length; i++) {
					  avg += value[i];
					}
				
				/*  code injection  */
				StringBuilder sb = new StringBuilder();
				sb.append("fun Avg (");
	//			IR.addCode( "fun Avg (");
				for (int i = 0; i < id.length - 1; i++) {
					sb.append(id[i].toString() + ", ");
//					IR.addCode(id[i].toString() + ", ");
				}
//				IR.addCode(id[id.length - 1] + ");");
				sb.append(id[id.length - 1] + ");");
				IR.addCode(sb.toString());
				
				result = avg/id.length;
			}

		return result;		
			
	  }
		
		
		/*expr:expr ( '+' | '-') expr */
		@Override 
		public Integer visitAddSub(LabeledParser.AddSubContext ctx) { 
			
		//	int left = 0;  // int left = visit(ctx.expr(0));
		//	int right = 0; // int right = visit(ctx.expr(1));
			int left = visit(ctx.expr(0));
			 int right = visit(ctx.expr(1));
			String leftStr = ctx.expr(0).getText();
			String rightStr = ctx.expr(1).getText();
		
			if ( ctx.op.getType() == LabeledParser.ADD) {
				
				/*  code injection  */
				IR.addCode( "System.out.println(" +  leftStr + " + " + rightStr +  ");");
				IR.addCode(" ");
				
				return left + right;
				
			} else {
				
				/*   code injection   */
				IR.addCode( "System.out.println(" +  leftStr + " - " + rightStr +  ");");
				return left - right; 
			}
			
			}
	      
		
		/*expr: id*/
		@Override 
		public Integer visitId(LabeledParser.IdContext ctx) {
			
			String id = ctx.ID().getText();
			if (symTable.containsKey(id)) {
				return symTable.get(id);
			}
			return 0;
		}
		
		/* expr: int */
		@Override 
		public Integer visitInt(LabeledParser.IntContext ctx) { 
			
			return Integer.valueOf(ctx.INT().getText());
			}
		
		/*  'sqrt' '(' expr ')'  */
		@Override 
		public Integer visitStrtt(LabeledParser.StrttContext ctx) { 
			int str = visit(ctx.expr());
			
			/*   code injection   */
			IR.addCode( "System.out.println(Math.sqrt(" + str +  ")"+  ");");
			
			return (int) Math.sqrt(str); }

    /*  expr op='^' expr */ 
	@Override 
	public Integer visitPowe(LabeledParser.PoweContext ctx) { 
		
		//int left = 0;    //  int left = visit(ctx.expr(0));
	//	int right = 0;   //  int right = visit(ctx.expr(1));
		int left = visit(ctx.expr(0));
		int right = visit(ctx.expr(1));
		String leftStr = ctx.expr(0).getText();
		String rightStr = ctx.expr(1).getText();
		
		/*  code injection  */
		IR.addCode( "System.out.println(" +  leftStr + " ^ " + rightStr +  ");");
		
		
		return (int) Math.pow(left,right); 
		
		}
	
		
}

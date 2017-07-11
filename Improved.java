import java.io.FileInputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Improved {

	
		public static void main(String[] args) throws Exception {
			
			String className = "MyInput";
			
			IR.init( className );
			IR.setup();
			
			FileInputStream inputFile = new FileInputStream("MyInput.txt");
		
			ANTLRInputStream input = new ANTLRInputStream(inputFile);
			LabeledLexer lexer = new LabeledLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			LabeledParser parser = new LabeledParser(tokens);
			ParseTree tree = parser.prog();
			IVisitor eval = new IVisitor();
			eval.visit(tree);
			
			IR.tearDown();
			IR.dump();
	
			
			//System.out.println( tree.toStringTree(parser) );
		}

	

}

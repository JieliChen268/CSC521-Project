import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class IR {
	private static ArrayList<String> buffer = new ArrayList<String>();
	private static String className;
	private static String filename;
	
	public static void init(final String f) {
		className = f;
		filename = className + ".java";
	}
	
	public static void setup() {
		buffer.add("/* setup imports */");
		buffer.add( "public class " + className + " {");
//		buffer.add( "public static void output(int a) { System.out.println(a); }");
//		buffer.add( "public static void main(String[] args) {");
	}
	
	public static void addCode(String line) {
		buffer.add( line );
	}
	
	public static void tearDown() {
//		buffer.add( "} /* end main */" ); 
		buffer.add( "} /* end class " + className + " */" );
		buffer.add( "}/* end of " + filename + " */" );
	}
	
	public static void dump() {
		File file = new File( filename );
		
		try {
		  PrintWriter out = new PrintWriter(file);
		  for (String line : buffer) {
			  out.println( line );
			  System.out.println(line);
		  }
		  out.close();
		} catch (Exception e) {
			
		}
	}
	
}

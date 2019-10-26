package starter;

import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner; 

public class Narrative {
	
	private static int start = 0;
	private static int end = 0;
	private static Character c;
	
	public Narrative(Character c, int start, int end)
	{
		
	}
	
	public static Character getC() {
		return c;
	}
	
	public static void setC(Character c) {
		Narrative.c = c;
	}
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public void read(Character c, int s, int e) throws FileNotFoundException {
		
		
            // Create a new Scanner object which will read the data
            // from the file passed in. To check if there are more 
            // line to read from it we check by calling the 
            // scanner.hasNextLine() method. We then read line one 
            // by one till all lines is read.
            
            if(c.isHostile() == true) {
            	
            	File file = new File("/Users/djcriley/git/group-project-code-avalanche/Text Files/Enemy");
            	Scanner scanner = new Scanner(file);
            	
	            for (int i = start; i <= end; i++) {
	                String line = scanner.nextLine();
	                System.out.println(line);
	            }
            }
            else if(c.isHostile() == false) {
            	
            	File file = new File("/Users/djcriley/git/group-project-code-avalanche/Text Files/NPC");
            	Scanner scanner = new Scanner(file);
            	
	            for (int i = start; i <= end; i++) {
	                String line = scanner.nextLine();
	                System.out.println(line);
	            }
            }
            else if(c.isKing() == true) {
            	
            	File file = new File("/Users/djcriley/git/group-project-code-avalanche/Text Files/King");
            	Scanner scanner = new Scanner(file);
            	
	            for (int i = start; i <= end; i++) {
	                String line = scanner.nextLine();
	                System.out.println(line);
	            }
            }
            
            /// then we can split the different class types of characters into separate files so this will simplify 
            // so this would be for warrior
//            else if(c.getCharacterType() == type) { 
//            	
//            	File file = new File("/Users/djcriley/git/group-project-code-avalanche/Text Files/King");
//            	Scanner scanner = new Scanner(file);
//            	
//	            for (int i = start; i < end; i++) {
//	                String line = scanner.nextLine();
//	                System.out.println(line);
//	            }
//            }
            //another for rouge
            //another for mage
		
		
	}
	
	
}

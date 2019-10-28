package starter;

import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner; 

public class Narrative {
	
	private static int start = 0;
	private static int end = 0;
	private static Character c;
	//private CharacterType warrior = ;
	
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
            
		//files for if the character is hostile (enemies before fights)
            if(c.isHostile() == true) {
            	
            	File file = new File("/Users/djcriley/git/group-project-code-avalanche/Text Files/Enemy");
            	Scanner scanner = new Scanner(file);
            	
	            for (int i = start; i <= end; i++) {
	                String line = scanner.nextLine();
	                System.out.println(line);
	            }
            }
            // files for if the character is not hostile (dialouge characters)
            else if(c.isHostile() == false) {
            	
            	File file = new File("/Users/djcriley/git/group-project-code-avalanche/Text Files/NPC");
            	Scanner scanner = new Scanner(file);
            	
	            for (int i = start; i <= end; i++) {
	                String line = scanner.nextLine();
	                System.out.println(line);
	            }
            }
            //files for if the character is the king
            else if(c.isKing() == true) {
            	
            	File file = new File("/Users/djcriley/git/group-project-code-avalanche/Text Files/King");
            	Scanner scanner = new Scanner(file);
            	
	            for (int i = start; i <= end; i++) {
	                String line = scanner.nextLine();
	                System.out.println(line);
	            }
            }
            // file for if the character is the player
            else if(c.isPlayer == true)
            {
            	File file = new File("/Users/djcriley/git/group-project-code-avalanche/Text Files/Player");
            	Scanner scanner = new Scanner(file);
            	
	            for (int i = start; i < end; i++) {
                    String line = scanner.nextLine();
	                System.out.println(line);
	            }
            }
	}
	
	
}

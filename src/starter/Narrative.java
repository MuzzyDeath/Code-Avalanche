package starter;

import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner; 

public class Narrative {
	
	private int start;
	private int end;
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Narrative.read(0, 3);
		
    }
	public Narrative(int start, int end)
	{
		
	}
	/**
	 * @return the start
	 */
	public int getStart() {
		return start;
	}
	/**
	 * @param start the start to set
	 */
	public void setStart(int start) {
		this.start = start;
	}
	/**
	 * @return the end
	 */
	public int getEnd() {
		return end;
	}
	/**
	 * @param end the end to set
	 */
	public void setEnd(int end) {
		this.end = end;
	}
	public static void read(int start, int end) throws FileNotFoundException {
		
		File file = new File("/Users/djcriley/git/group-project-code-avalanche/Text Files/NPC");
            // Create a new Scanner object which will read the data
            // from the file passed in. To check if there are more 
            // line to read from it we check by calling the 
            // scanner.hasNextLine() method. We then read line one 
            // by one till all lines is read.
            Scanner scanner = new Scanner(file);
            
            for (int i = start; i < end; i++)
            {
                String line = scanner.nextLine();
                System.out.println(line);
            }
		
		
	}
	
}

// inputs for start line and end line to get the correct lines to output. 

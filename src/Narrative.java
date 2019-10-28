import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner; 

public class Narrative {
	public static void main(String[] args) {
        
		// Create an instance of File for data.txt file.
		
		

        File file = new File("/Users/Pranav/git/group-project-code-avalanche/Text Files/NPC");
        try {
            // Create a new Scanner object which will read the data
            // from the file passed in. To check if there are more 
            // line to read from it we check by calling the 
            // scanner.hasNextLine() method. We then read line one 
            // by one till all lines is read.
            Scanner scanner = new Scanner(file);
            
            for (int i = 0; i < 2; i++)
            {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

// inputs for start line and end line to get the correct lines to output. 

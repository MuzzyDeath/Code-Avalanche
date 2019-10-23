import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner; 

public class Narrative {
	public static void main(String[] args) throws FileNotFoundException { 
		File file = new File("/Users/djcriley/git/group-project-code-avalanche/Text Files/NPC"); 
		Scanner sc = new Scanner(file); 
		
		// we just need to use \\Z as delimiter 
		sc.useDelimiter("\\Z"); 
		
		System.out.println(sc.next()); 
	} 
}

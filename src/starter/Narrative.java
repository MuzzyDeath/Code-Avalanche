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
		
		if(c.isHostile == true) {
			if(c.isKing() == true) {

				File file = new File("Text Files/King");
				Scanner scanner = new Scanner(file);

				for (int i = start; i <= end; i++) {
					String line = scanner.nextLine();
					System.out.println(line);
				}
			}
			else {

				File file = new File("Text Files/Enemy");
				Scanner scanner = new Scanner(file);

				for (int i = start; i <= end; i++) {
					String line = scanner.nextLine();
					System.out.println(line);
				}
			} 
		}
		else if(c.isHostile == false) {
			if(c.isPlayer == true) {
				
				File file = new File("/Users/djcriley/git/group-project-code-avalanche/Text Files/Player");
				Scanner scanner = new Scanner(file);

				for (int i = start; i < end; i++) {
					String line = scanner.nextLine();
					System.out.println(line);
				}
			}
			else {

				File file = new File("Text Files/NPC");
				Scanner scanner = new Scanner(file);

				for (int i = start; i <= end; i++) {
					String line = scanner.nextLine();
					System.out.println(line);
				}
			}

		}

	}


}

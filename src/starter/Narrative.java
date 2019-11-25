//package starter;
//
//import java.io.File; 
//import java.io.FileNotFoundException;
//import java.net.URL;
//import java.util.Scanner; 
//
//public class Narrative {
//
//
//
//	private static int start = 0;
//	private static int end = 0;
//	private static Character c;
//	//private CharacterType warrior = ;
//
//	public Narrative(Character c, int start, int end)
//	{
//
//	}
//
//	public static Character getC() {
//		return c;
//	}
//
//	public static void setC(Character c) {
//		Narrative.c = c;
//	}
//
//	public int getStart() {
//		return start;
//	}
//	public void setStart(int start) {
//		this.start = start;
//	}
//	public int getEnd() {
//		return end;
//	}
//	public void setEnd(int end) {
//		this.end = end;
//	}
//	public void read(Character c, int s, int e) throws FileNotFoundException {
//
//            
//		//files for if the character is hostile (enemies before fights)
//            if(c.isHostile() == true) {
//            	
//            	URL url = Narrative.class.getClassLoader().getResource("Enemy.txt");
//                System.out.println(url.getPath());
//	            }
//            
//            // files for if the character is not hostile (dialogue characters)
//            else if(c.isHostile() == false) {
//            	
//            	URL url = Narrative.class.getClassLoader().getResource("NPC.txt");
//                System.out.println(url.getPath());
//	            }
//            
//            //files for if the character is the king
//             else if(c.isKing() == true) {
//            	
//            	URL url = Narrative.class.getClassLoader().getResource("King.txt");
//                System.out.println(url.getPath());
//	            }
//            
//            // file for if the character is the player
//             else if(c.isPlayer == true)
//            {
//            	URL url = Narrative.class.getClassLoader().getResource("Player.txt");
//                System.out.println(url.getPath());
//	            }
//            }
//}

package starter;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Narrative {
	
	private static ArrayList<String> lines;
	private static String line;

	public static void print(String arg) throws IOException {
		if (arg == "NPC-1")
			NPC();
	}
	
	public static ArrayList<String> sendString() {
		return lines;
	}

	private static void NPC() throws IOException {
		// TODO Auto-generated method stub
		InputStream stream = Narrative.class.getResourceAsStream("/text/NPC");
		if (stream == null) JOptionPane.showMessageDialog(null, "Resource not located.");
		Scanner input = null;
		lines = new ArrayList<String>();
		try {
			input = new Scanner (stream);
			boolean tokenFound = false;
			while (input.hasNextLine()) {
				line = input.nextLine().trim();

				if (line.equals("NPC-1-START")) {
					tokenFound = true;
				} 
				else if (line.equals("NPC-1-END")) {
					tokenFound = false;
				}

				//Prints female-male section
				if ((tokenFound) && (!line.equals("NPC-1-START"))) {
					//JOptionPane.showMessageDialog(null, line);
					lines.add(line);
					MainApplication.speech = sendString();
				}
			}
		} 

		catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Scanner error");
		}

		while (input.hasNextLine()) 
			JOptionPane.showMessageDialog(null, input.nextLine());
	}
}
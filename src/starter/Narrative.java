package starter;

import java.io.File; 
import java.io.FileNotFoundException;
import java.net.URL;
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
            	
            	URL url = Narrative.class.getClassLoader().getResource("Enemy.txt");
                System.out.println(url.getPath());
	            }
            
            // files for if the character is not hostile (dialogue characters)
            else if(c.isHostile() == false) {
            	
            	URL url = Narrative.class.getClassLoader().getResource("NPC.txt");
                System.out.println(url.getPath());
	            }
            
            //files for if the character is the king
             else if(c.isKing() == true) {
            	
            	URL url = Narrative.class.getClassLoader().getResource("King.txt");
                System.out.println(url.getPath());
	            }
            
            // file for if the character is the player
             else if(c.isPlayer == true)
            {
            	URL url = Narrative.class.getClassLoader().getResource("Player.txt");
                System.out.println(url.getPath());
	            }
            }
	}
	
	

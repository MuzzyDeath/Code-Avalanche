package starter;
import java.io.File; 
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner; 
import java.awt.Color;
import java.awt.event.KeyEvent;

public class Interactions {
	
	public static void setC(Character c) {
		Narrative.setC(c);
	}

	private int start;
	private int end;
	
	public int getStart() {
		return getStart();
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
	
	
	public void keyPressed(KeyEvent e) {

	    int key = e.getKeyCode();
		
		
	    if (key == KeyEvent.VK_E) {
	    }
	}
	
			 public void read(Character c, int s, int e) throws FileNotFoundException {
         
			//files for if the character is hostile (enemies before fights)
	            if(c.isHostile() == true) {
	            	
	                URL url = Narrative.class.getClassLoader().getResource("Enemy.txt");
	                System.out.println(url.getPath());
	                
		            }
	            
	            // files for if the character is not hostile (dialouge characters)
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
	             else if(c.isPlayer == true) {
	            	 URL url = Narrative.class.getClassLoader().getResource("Player.txt");
		                System.out.println(url.getPath());
		            }
			 }
	    }
	            
   
	

	 
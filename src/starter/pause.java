/**
 * This class is for generally testing in the pause functionality, please do not touch it!
 * @author GregV
 */
package starter;

import java.awt.Color;

import acm.graphics.*;

public class pause {
	
	//Battle Stuff
	private static GImage background;
	private static GLabel attack;
	//End Battle Stuff
	
	//Pause Stuff
	public static GButton play = new GButton("Resume", MainApplication.WINDOW_WIDTH/3, 200, 300, 75);
	public static GButton controls = new GButton("Controls", MainApplication.WINDOW_WIDTH/3, 300, 300, 75);
	public static GButton quit = new GButton("Quit", MainApplication.WINDOW_WIDTH/3 , 400, 300, 75);
	private static GRect square = new GRect(MainApplication.WINDOW_WIDTH/4, 150, 400, 400);
	private static GImage controlsImage = new GImage("controlsImage.jpg");
	//End Pause Stuff
	
	public static void battleScene(MainApplication app) {
		background = new GImage("images/BattleStyle.png");
		attack = new GLabel("Attack", 10, 10);
		
		app.add(background);
		app.add(attack);
	}
	
	public static void battleOver(MainApplication app) {
		app.remove(background);
		app.remove(attack);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	
	public static void pause(MainApplication app) {
		square.setFillColor(Color.BLACK);
		square.setFilled(true);
		app.add(square);
		app.add(play);
		app.add(controls);
		app.add(quit);
	}
	
	public static void unpause(MainApplication app) {
		app.remove(square);
		app.remove(play);
		app.remove(controls);
		app.remove(quit);
		app.remove(controlsImage);
	}

}

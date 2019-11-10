/**
 * This class is for generally testing in the pause functionality, please do not touch it!
 * @author GregV
 */
package starter;

import acm.graphics.GImage;
import acm.graphics.GLabel;

public class pause {
	private static GImage background;
	private static GLabel attack;
	
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

}

/**
 * This class is for generally testing in the pause functionality, please do not touch it!
 * @author GregV
 */
package starter;

import java.awt.Color;
import java.awt.Font;
import acm.graphics.*;
public class pause {
	private static GImage background, pPic, ePic;
	private static GLabel attack, block, screech, cStrenght, cDefense, cCharisma, eStrength, eDefense, eCharisma;
	
	public static void battleScene(MainApplication app) {
		background = new GImage("images/BattleStyle.png");
		app.add(background);
		
		attack = new GLabel("1) Attack", 50, 490);
		attack.setFont(new Font("Monotype Corsiva", 1, 30));
		attack.setColor(Color.black);
		block = new GLabel("2) Block", 50, 530);
		block.setFont(new Font("Monotype Corsiva", 1, 30));
		block.setColor(Color.black);
		screech = new GLabel("3) Screech", 50, 565);
		screech.setFont(new Font("Monotype Corsiva", 1, 30));
		screech.setColor(Color.black);
		
		app.add(attack);
		app.add(block);
		app.add(screech);
		
		//prints players stats
		
		cStrenght = new GLabel("Strength: ", 55, 300);
		cStrenght.setFont(new Font("Monotype Corsiva", 1, 15));
		cStrenght.setColor(Color.black);
		app.add(cStrenght);
		
		cDefense = new GLabel("Defense: " , 55, 330);
		cDefense.setFont(new Font("Monotype Corsiva", 1, 15));
		cDefense.setColor(Color.black);
		app.add(cDefense);
		
		cCharisma = new GLabel("Charisma: " , 55, 360);
		cCharisma.setFont(new Font("Monotype Corsiva", 1, 15));
		cCharisma.setColor(Color.black);
		app.add(cCharisma);
		
		
		// prints stats of enemy 
		// needs way to pass enemy stats
		
		eStrength = new GLabel("Strength: 3", 500, 300);
		eStrength.setFont(new Font("Monotype Corsiva", 1, 15));
		eStrength.setColor(Color.black);
		app.add(eStrength);
		
		eDefense = new GLabel("Defense: 3", 500, 330);
		eDefense.setFont(new Font("Monotype Corsiva", 1, 15));
		eDefense.setColor(Color.black);
		app.add(eDefense);
		
		eCharisma = new GLabel("Charisma: 3", 500, 360);
		eCharisma.setFont(new Font("Monotype Corsiva", 1, 15));
		eCharisma.setColor(Color.black);
		app.add(eCharisma);

		
		
	}
	
	public static void battleOver(MainApplication app) {
		app.remove(background);
		app.remove(attack);
		app.remove(block);
		app.remove(screech);
		app.remove(cStrenght);
		app.remove(cDefense);
		app.remove(cCharisma);
		app.remove(eStrength);
		app.remove(eDefense);
		app.remove(eCharisma);
		
//		app.remove(pPic);
//		app.remove(ePic);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}

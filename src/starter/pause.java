/**
 * This class is for generally testing in the pause functionality, please do not touch it!
 * @author GregV
 */
package starter;

import java.awt.Color;

import java.awt.Font;
import acm.graphics.*;


public class pause {
	
	//pictures
	private static final String MAGE = "Battle Image(Mage).png";
	private static final String WARRIOR = "Battle Image(Warrior).png";
	private static final String ROGUE = "Battle Image(Rogue).png";
	private static final String ENEMY = "Battle Image (Enemy).png";
	private static final String KING = "Battle Image(Boss).png";
	
	//Battle Stuff
	private static GImage background, pPic, ePic;
	private static GLabel attack, block, screech, cStrenght, cDefense, cCharisma, eStrength, eDefense, eCharisma;
	private static Player Protagonist = MainApplication.user;
	private static Enemy opponent;
	//End Battle Stuff

	//Pause Stuff
	public static GButton play = new GButton("Resume", MainApplication.WINDOW_WIDTH/3, 200, 300, 75);
	public static GButton controls = new GButton("Controls", MainApplication.WINDOW_WIDTH/3, 300, 300, 75);
	public static GButton quit = new GButton("Quit", MainApplication.WINDOW_WIDTH/3 , 400, 300, 75);
	private static GRect square = new GRect(MainApplication.WINDOW_WIDTH/4, 150, 400, 400);
	private static GImage controlsImage = new GImage("controlsImage.jpg");
	//End Pause Stuff


	public static void battleScene(MainApplication app) {
		
		opponent = Board.CharacterAtSpace(Protagonist);

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

		cStrenght = new GLabel("Strength: " + Protagonist.getStrength(), 55, 300);
		cStrenght.setFont(new Font("Monotype Corsiva", 1, 15));
		cStrenght.setColor(Color.black);
		app.add(cStrenght);

		cDefense = new GLabel("Defense: " + Protagonist.getDefense(), 55, 330);
		cDefense.setFont(new Font("Monotype Corsiva", 1, 15));
		cDefense.setColor(Color.black);
		app.add(cDefense);

		cCharisma = new GLabel("Charisma: " + + Protagonist.getCharisma(), 55, 360);
		cCharisma.setFont(new Font("Monotype Corsiva", 1, 15));
		cCharisma.setColor(Color.black);
		app.add(cCharisma);


		// prints stats of enemy 
		// needs way to pass enemy stats

		eStrength = new GLabel("Strength: " + opponent.getStrength(), 500, 300);
		eStrength.setFont(new Font("Monotype Corsiva", 1, 15));
		eStrength.setColor(Color.black);
		app.add(eStrength);

		eDefense = new GLabel("Defense: " + opponent.getDefense(), 500, 330);
		eDefense.setFont(new Font("Monotype Corsiva", 1, 15));
		eDefense.setColor(Color.black);
		app.add(eDefense);

		eCharisma = new GLabel("Charisma: " + opponent.getCharisma(), 500, 360);
		eCharisma.setFont(new Font("Monotype Corsiva", 1, 15));
		eCharisma.setColor(Color.black);
		app.add(eCharisma);
		
	 // prints player pic
		
		if(Protagonist.cType == CharacterType.WARRIOR) {
			pPic = new GImage(WARRIOR);
			pPic.setLocation(20, 20);
			app.add(pPic);
					
		}
		else if(Protagonist.cType == CharacterType.ROGUE) {
			pPic = new GImage(ROGUE);
			pPic.setLocation(20, 20);
			app.add(pPic);
		}
		else {
			pPic = new GImage(MAGE);
			pPic.setLocation(20, 20);
			app.add(pPic);
		}
		
		//prints enemy pic
		
	
//		ePic = new GImage(ENEMY);
//		ePic.setLocation(400, 20);
//		app.add(ePic);
		if(opponent.isHostile == true) {
			if(opponent.isKing == true) { // prints king pic
				ePic = new GImage(KING);
				ePic.setLocation(400, 20);
				app.add(ePic);
			}
			
			ePic = new GImage(ENEMY);
			ePic.setLocation(400, 20);
			app.add(ePic);
		}


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
		app.remove(ePic);
		app.remove(pPic);
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

/**
 * This class is for generally testing in the pause functionality, please do not touch it!
 * @author GregV
 */
package starter;

import java.awt.Color;


import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import acm.graphics.*;

public class Overlay {
	
	//Textbox Stuff
		private static GImage textbox;
	//pictures
	
	
	//Inventory Stuff
	private static GImage inventory;
	//pictures
	private static final String MAGE = "Battle Image(Mage).png";
	private static final String WARRIOR = "Battle Image(Warrior).png";
	private static final String ROGUE = "Battle Image(Rogue).png";
	private static final String ENEMY = "Battle Image (Enemy).png";
	private static final String KING = "Battle Image(Boss).png";
	
	//Battle Stuff
	private static GImage background, pPic, ePic;
	private static GLabel attack, block, screech, cStrenght, cDefense, cCharisma, eStrength, eDefense, eCharisma, cTextBox;
	private static Player Protagonist;
	public static Enemy opponent;
	public static GLabel eHealth, cHealth;
	//End Battle Stuff

	//Pause Stuff
	public static GButton play = new GButton("Resume", MainApplication.WINDOW_WIDTH/3, 200, 300, 75);
	public static GButton controls = new GButton("Controls", MainApplication.WINDOW_WIDTH/3, 300, 300, 75);
	public static GButton quit = new GButton("Quit", MainApplication.WINDOW_WIDTH/3 , 400, 300, 75);
	private static GImage pauseScreen = new GImage("images/pauseMenu.png");
	private static GImage controlsImage = new GImage("images/controlsImage.jpg");
	//End Pause Stuff


	public static void battleScene(MainApplication app) {
		
		Protagonist = MainApplication.user;
		
		opponent = Board.CharacterAtSpace(Protagonist);

		background = new GImage("images/BattleStyle.png");
		app.add(background);

		attack = new GLabel("1) Attack", 50, 490);
		attack.setFont(new Font("Comic Sans", 1, 30));
		attack.setColor(Color.black);
		block = new GLabel("2) Block", 50, 530);
		block.setFont(new Font("Comic Sans", 1, 30));
		block.setColor(Color.black);
		screech = new GLabel("3) Screech", 50, 565);
		screech.setFont(new Font("Comic Sans", 1, 30));
		screech.setColor(Color.black);

		app.add(attack);
		app.add(block);
		app.add(screech);

		//prints players stats

		cStrenght = new GLabel("Strength: " + Protagonist.getStrength(), 55, 300);
		cStrenght.setFont(new Font("Comic Sans", 1, 15));
		cStrenght.setColor(Color.black);
		app.add(cStrenght);

		cDefense = new GLabel("Defense: " + Protagonist.getDefense(), 55, 330);
		cDefense.setFont(new Font("Comic Sans", 1, 15));
		cDefense.setColor(Color.black);
		app.add(cDefense);

		cCharisma = new GLabel("Charisma: " + Protagonist.getCharisma(), 55, 360);
		cCharisma.setFont(new Font("Comic Sans", 1, 15));
		cCharisma.setColor(Color.black);
		app.add(cCharisma);
		
		//make so it updates with the players health as battle goes on.
		cHealth = new GLabel("Health: " + Protagonist.getHealth(), 55, 390);
		cHealth.setFont(new Font("Comic Sans", 1, 15));
		cHealth.setColor(Color.black);
		app.add(cHealth);


		// prints stats of enemy 
		// needs way to pass enemy stats

		eStrength = new GLabel("Strength: " + opponent.getStrength(), 500, 300);
		eStrength.setFont(new Font("Comic Sans", 1, 15));
		eStrength.setColor(Color.black);
		app.add(eStrength);

		eDefense = new GLabel("Defense: " + opponent.getDefense(), 500, 330);
		eDefense.setFont(new Font("Comic Sans", 1, 15));
		eDefense.setColor(Color.black);
		app.add(eDefense);

		eCharisma = new GLabel("Charisma: " + opponent.getCharisma(), 500, 360);
		eCharisma.setFont(new Font("Comic Sans", 1, 15));
		eCharisma.setColor(Color.black);
		app.add(eCharisma);
		
		//make so it updates with the enemy health as battle goes on.
		eHealth = new GLabel("Health: " + opponent.getHealth(), 500, 390);
		eHealth.setFont(new Font("Comic Sans", 1, 15));
		eHealth.setColor(Color.black);
		app.add(eHealth);
		
		
	 // prints player pic
		
		if(Protagonist.cType == CharacterType.WARRIOR) {
			pPic = new GImage(WARRIOR);
			pPic.setLocation(20, 20);
			pPic.setSize(150, 240);
			app.add(pPic);
					
		}
		else if(Protagonist.cType == CharacterType.ROGUE) {
			pPic = new GImage(ROGUE);
			pPic.setLocation(20, 20);
			pPic.setSize(150, 240);
			app.add(pPic);
		}
		else {
			pPic = new GImage(MAGE);
			pPic.setLocation(20, 20);
			pPic.setSize(150, 240);
			app.add(pPic);
		}
		
		//prints enemy pic
		
	

		if(opponent.isHostile == true) {
			
			if(opponent.isKing == true) { // prints king pic
				ePic = new GImage(KING);
				ePic.setLocation(520, 20);
				ePic.setSize(200, 340);
				app.add(ePic);
			}
			
			// prints enemy pic
			
			ePic = new GImage(ENEMY);
			ePic.setLocation(520, 20);
			ePic.setSize(150, 240);
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
		app.remove(eHealth);
		app.remove(cHealth);
	}
	
	
	
	public static void pause(MainApplication app) {
		pauseScreen = new GImage("images/pauseMenu.png");
		app.add(pauseScreen);
		app.add(play);
		app.add(controls);
		app.add(quit);
		play.setVisible(false);
		controls.setVisible(false);
		quit.setVisible(false);
	}
	
	public static void unpause(MainApplication app) {
		app.remove(pauseScreen);
		app.remove(play);
		app.remove(controls);
		app.remove(quit);
		app.remove(controlsImage);
	}
	
	public static void showTextbox(MainApplication app, String text) {
		textbox = new GImage("images/TextBox.png");
		app.add(textbox);
		cTextBox = new GLabel(text, 50, 500);
		cTextBox.setFont(new Font("Monospaced", Font.PLAIN, 25));
		cTextBox.setColor(Color.BLACK);
		app.add(cTextBox);
	}

	public static void hideTextbox(MainApplication app) {
		app.remove(textbox);
		app.remove(cTextBox);
	}

	public static void showInventory(MainApplication app) {
		inventory = new GImage("images/InventoryBackground.png");
		app.add(inventory);
	}

	public static void hideInventory(MainApplication app) {
		app.remove(inventory);
	}
}
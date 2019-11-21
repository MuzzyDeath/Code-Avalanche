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
import java.awt.event.MouseEvent;

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
	public static GLabel eHealth, cHealth;
	//End Battle Stuff

	//Pause Stuff
	public static GButton play = new GButton("Resume", MainApplication.WINDOW_WIDTH/3, 200, 300, 75);
	public static GButton controls = new GButton("Controls", MainApplication.WINDOW_WIDTH/3, 300, 300, 75);
	public static GButton quit = new GButton("Quit", MainApplication.WINDOW_WIDTH/3 , 400, 300, 75);
	private static GImage pauseScreen = new GImage("images/pauseMenu.png");
	private static GImage controlsImage = new GImage("images/controlsImage.jpg");
	//End Pause Stuff

	// Levelup Stuff
	private static final String LU_BACKGROUND_IMAGE = "images/LevelUpPaneImage.jpg";
	private static final int LU_BASE_X = 475, LU_BASE_Y = 250, LU_LINE_SPACE=60;
	private static final int LU_MINUS_OFFSET = 250, LU_PLUS_OFFSET = 200, LU_BUTTON_WIDTH= 25, LU_BUTTON_HEIGHT = 30;

	private static final String LU_FONT = "Times Roman";
	private static final int LU_FONT_SIZE = 30;

	private static final String POINTS_TEXT   = "Available Points";
	private static final String STRENGTH_TEXT = "Strength";
	private static final String AGILITY_TEXT  = "Agility";
	private static final String DEFENSE_TEXT  = "Defense";
	private static final String CHARISMA_TEXT = "Charisma";
	private static final String HEALTH_TEXT   = "Health";
	private static final String PLUS_TEXT     = "[ + ]";
	private static final String MINUS_TEXT    = "[ - ]";
	private static final String DONE_TEXT     = "DONE";

	private static final int MIN_THRESHOLD = 1;

	private static GImage luBackground;
	public static GLabel luPoints, luStrength, luAgility, luDefense, luCharisma, luHealth;
	public static GButton luStrengthDown, luStrengthUp, luAgilityDown, luAgilityUp, luDefenseDown, luDefenseUp, luCharismaDown, luCharismaUp, luHealthDown, luHealthUp, luDone;
	
	// State
	private static boolean isLevelUp = false;
	private static LevelUp lvlUpObj;
	
	public static int battle;
	// End Levelup Stuff


	public static void battleScene(MainApplication app) {

		Protagonist = MainApplication.user;

		//		opponent = Board.CharacterAtSpace(Protagonist);

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

		eStrength = new GLabel("Strength " + LevelPane.opponent.getStrength(), 500, 300);
		eStrength.setFont(new Font("Comic Sans", 1, 15));
		eStrength.setColor(Color.black);
		app.add(eStrength);
		
		eDefense = new GLabel("Defense " + LevelPane.opponent.getDefense(), 500, 330);
		eDefense.setFont(new Font("Comic Sans", 1, 15));
		eDefense.setColor(Color.black);
		app.add(eDefense);

		eCharisma = new GLabel("Charisma " + LevelPane.opponent.getCharisma(), 500, 360);
		eCharisma.setFont(new Font("Comic Sans", 1, 15));
		eCharisma.setColor(Color.black);
		app.add(eCharisma);

		//make so it updates with the enemy health as battle goes on.
		eHealth = new GLabel("Health " + LevelPane.opponent.getHealth(), 500, 390);
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



		if(LevelPane.opponent.isHostile == true) {

			if(LevelPane.opponent.isKing == true) { // prints king pic
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
	
	public static boolean isLevelUpActive()
	{
		return isLevelUp;
	}

	public static void showLevelUp(MainApplication app) {
		
		// Set isLevelup flag to true;
		isLevelUp = true;

		// Get user so that his stats can be shown
		Player player = MainApplication.user; 
		
		// Create Levelup object with 3 points 
		lvlUpObj = new LevelUp(player, LevelUp.POINTS_PER_WIN);
		
		luBackground = new GImage(LU_BACKGROUND_IMAGE);
		app.add(luBackground); 
		
		luPoints =  new GLabel(POINTS_TEXT + " : " +  lvlUpObj.getPoints(), 75, LU_BASE_Y + 2 * LU_LINE_SPACE );
		luPoints.setFont(new Font(LU_FONT, 1, LU_FONT_SIZE));
		luPoints.setColor(Color.green);
		app.add(luPoints);

		luStrength = new GLabel(STRENGTH_TEXT + " : " +  player.getStrength(), LU_BASE_X, LU_BASE_Y);
		luStrength.setFont(new Font(LU_FONT, 1, LU_FONT_SIZE));
		luStrength.setColor(Color.black);
		app.add(luStrength);
		
		luStrengthUp = new GButton(PLUS_TEXT, LU_BASE_X + LU_PLUS_OFFSET, LU_BASE_Y - LU_FONT_SIZE , LU_BUTTON_WIDTH, LU_BUTTON_HEIGHT);
		luStrengthUp.setFillColor(Color.LIGHT_GRAY);
		luStrengthUp.setColor(Color.black);
		app.add(luStrengthUp);

		luStrengthDown = new GButton(MINUS_TEXT, LU_BASE_X + LU_MINUS_OFFSET, LU_BASE_Y - LU_FONT_SIZE , LU_BUTTON_WIDTH, LU_BUTTON_HEIGHT);
		luStrengthDown.setFillColor(Color.LIGHT_GRAY);
		luStrengthDown.setColor(Color.black);
		app.add(luStrengthDown);


		luAgility = new GLabel(AGILITY_TEXT + " : " +  player.getAgility(), LU_BASE_X, LU_BASE_Y + 1 * LU_LINE_SPACE);
		luAgility.setFont(new Font(LU_FONT, 1, LU_FONT_SIZE));
		luAgility.setColor(Color.black);
		app.add(luAgility);

		luAgilityDown = new GButton(MINUS_TEXT, LU_BASE_X + LU_MINUS_OFFSET, LU_BASE_Y + (1 * LU_LINE_SPACE)  - LU_FONT_SIZE , LU_BUTTON_WIDTH, LU_BUTTON_HEIGHT);
		luAgilityDown.setFillColor(Color.LIGHT_GRAY);
		luAgilityDown.setColor(Color.black);
		app.add(luAgilityDown);

		luAgilityUp = new GButton(PLUS_TEXT, LU_BASE_X + LU_PLUS_OFFSET, LU_BASE_Y + (1 * LU_LINE_SPACE) - LU_FONT_SIZE , LU_BUTTON_WIDTH, LU_BUTTON_HEIGHT);
		luAgilityUp.setFillColor(Color.LIGHT_GRAY);
		luAgilityUp.setColor(Color.black);
		app.add(luAgilityUp);

		luDefense = new GLabel(DEFENSE_TEXT + " : " + player.getDefense(), LU_BASE_X, LU_BASE_Y + 2 * LU_LINE_SPACE); 
		luDefense.setFont(new Font(LU_FONT, 1, 30));
		luDefense.setColor(Color.black);
		app.add(luDefense);

		luDefenseDown = new GButton(MINUS_TEXT, LU_BASE_X + LU_MINUS_OFFSET, LU_BASE_Y - LU_FONT_SIZE  + (2 * LU_LINE_SPACE), LU_BUTTON_WIDTH, LU_BUTTON_HEIGHT);
		luDefenseDown.setFillColor(Color.LIGHT_GRAY);
		luDefenseDown.setColor(Color.black);
		app.add(luDefenseDown);

		luDefenseUp = new GButton(PLUS_TEXT, LU_BASE_X + LU_PLUS_OFFSET, LU_BASE_Y - LU_FONT_SIZE  + (2 * LU_LINE_SPACE), LU_BUTTON_WIDTH, LU_BUTTON_HEIGHT);
		luDefenseUp.setFillColor(Color.LIGHT_GRAY);
		luDefenseUp.setColor(Color.black);
		app.add(luDefenseUp);


		luCharisma = new GLabel(CHARISMA_TEXT + " : " + player.getCharisma(), LU_BASE_X, LU_BASE_Y + 3 * LU_LINE_SPACE);
		luCharisma.setFont(new Font(LU_FONT, 1, 30));
		luCharisma.setColor(Color.black);
		app.add(luCharisma);

		luCharismaDown = new GButton(MINUS_TEXT, LU_BASE_X + LU_MINUS_OFFSET, LU_BASE_Y - LU_FONT_SIZE + 3 * LU_LINE_SPACE, LU_BUTTON_WIDTH, LU_BUTTON_HEIGHT);
		luCharismaDown.setFillColor(Color.LIGHT_GRAY);
		luCharismaDown.setColor(Color.black);
		app.add(luCharismaDown);

		luCharismaUp = new GButton(PLUS_TEXT, LU_BASE_X + LU_PLUS_OFFSET, LU_BASE_Y - LU_FONT_SIZE + (3 * LU_LINE_SPACE), LU_BUTTON_WIDTH, LU_BUTTON_HEIGHT);
		luCharismaUp.setFillColor(Color.LIGHT_GRAY);
		luCharismaUp.setColor(Color.black);
		app.add(luCharismaUp);


		luHealth  = new GLabel(HEALTH_TEXT + " : " + player.getHealth(), LU_BASE_X, LU_BASE_Y + 4 * LU_LINE_SPACE)	;
		luHealth.setFont(new Font(LU_FONT, 1, 30));
		luHealth.setColor(Color.black);	
		app.add(luHealth);

		luHealthDown = new GButton(MINUS_TEXT, LU_BASE_X + LU_MINUS_OFFSET, LU_BASE_Y - LU_FONT_SIZE + 4* LU_LINE_SPACE, LU_BUTTON_WIDTH, LU_BUTTON_HEIGHT);
		luHealthDown.setFillColor(Color.LIGHT_GRAY);
		luHealthDown.setColor(Color.black);
		app.add(luHealthDown);

		luHealthUp = new GButton(PLUS_TEXT, LU_BASE_X + LU_PLUS_OFFSET, LU_BASE_Y - LU_FONT_SIZE + 4* LU_LINE_SPACE, LU_BUTTON_WIDTH, LU_BUTTON_HEIGHT);
		luHealthUp.setFillColor(Color.LIGHT_GRAY);
		luHealthUp.setColor(Color.black);
		app.add(luHealthUp);
		
		luDone = new GButton(DONE_TEXT, LU_BASE_X + LU_PLUS_OFFSET, LU_BASE_Y - LU_FONT_SIZE + 5 * LU_LINE_SPACE + 20,  3 * LU_BUTTON_WIDTH,   LU_BUTTON_HEIGHT);
		luDone.setFillColor(Color.WHITE);
		luDone.setColor(Color.LIGHT_GRAY);  // Show disabled until points become 0
		
		// luDone.setVisible(false);  
		app.add(luDone);


	}

	public static void hideLevelUp(MainApplication app) {
		app.remove(luPoints);
		
		app.remove(luStrength);
		app.remove(luStrengthDown);
		app.remove(luStrengthUp);

		app.remove(luAgility);
		app.remove(luAgilityDown);
		app.remove(luAgilityUp);

		app.remove(luDefense);
		app.remove(luDefenseDown);
		app.remove(luDefenseUp);

		app.remove(luCharisma);
		app.remove(luCharismaDown);
		app.remove(luCharismaUp);

		app.remove(luHealth);
		app.remove(luHealthDown);
		app.remove(luHealthUp);

		app.remove(luBackground);
		app.remove(luDone);
		isLevelUp = false;
	}

	public static void processLevelupEvent(MainApplication app, MouseEvent e) {
		GObject obj = app.getElementAt(e.getX(), e.getY());
		if (obj != null) {
			Player player = MainApplication.user;

			// System.out.println(" Obj selected  = " + obj);
			if (obj == luStrengthDown) {
				// Decrement only when value is > min_threshold
				if (player.getStrength() > MIN_THRESHOLD )
				{
					lvlUpObj.strengthDown();
				}
				else
				{
					System.out.println("Not supported. Strength cannot be decremented below " + MIN_THRESHOLD);
				}
			}
			else if (obj == luStrengthUp) {
				lvlUpObj.strengthUp();
			}
			else if(obj == luAgilityDown)
			{
				if(player.getAgility() > MIN_THRESHOLD)
				{
					lvlUpObj.agilityDown();
				}
				else {
					System.out.println("Not supported. Defense cannot be decremented below " + MIN_THRESHOLD);
				}
			}
			else if(obj == luAgilityUp)
			{
				lvlUpObj.agilityUp();
			}
			else if (obj == luDefenseDown) {
				// Decrement only when value is > min_threshold
				if (player.getDefense() > MIN_THRESHOLD )
				{
					lvlUpObj.defenseDown();
				}
				else
				{
					System.out.println("Not supported. Defense cannot be decremented below " + MIN_THRESHOLD);
				}
			}
			else if (obj == luDefenseUp) {
				lvlUpObj.defenseUp();
			}
			else if (obj == luCharismaDown) {
				// Decrement only when value is > min_threshold
				if (player.getCharisma() > MIN_THRESHOLD )
				{
					lvlUpObj.charismaDown();
				}
				else
				{
					System.out.println("Not supported. Charisma cannot be decremented below " + MIN_THRESHOLD);
				}
			}
			else if (obj == luCharismaUp) {
				lvlUpObj.charismaUp();
			}
			else if (obj == luHealthDown) {
				// Decrement only when value is > min_threshold
				if (player.getHealth() > MIN_THRESHOLD )
				{
					lvlUpObj.healthDown();
				}
				else
				{
					System.out.println("Not supported. Health cannot be decremented below " + MIN_THRESHOLD);
				}
			}
			else if (obj == luHealthUp) {
				lvlUpObj.healthUp();
			}
			else if (obj == luDone)
			{
				if (lvlUpObj.getPoints() == 0)
				{
					hideLevelUp(app);
				}
				else
				{
					System.out.println("Cannot exit without allocating all the points");
				}
			}
			
			// Update all labels
			luPoints.setLabel(POINTS_TEXT + " : " +  lvlUpObj.getPoints());
			luStrength.setLabel(STRENGTH_TEXT + " : " +  player.getStrength());
			luAgility.setLabel(AGILITY_TEXT + " : " +  player.getAgility());
			luDefense.setLabel(DEFENSE_TEXT + " : " +  player.getDefense());
			luCharisma.setLabel(CHARISMA_TEXT + " : " +  player.getCharisma());
			luHealth.setLabel(HEALTH_TEXT + " : " +  player.getHealth());
			// Make the done button visible, only when points are 0
			if (lvlUpObj.getPoints() == 0) {
				luDone.setColor(Color.BLACK);
			}
			else
			{
				luDone.setColor(Color.LIGHT_GRAY);
			}
			//luDone.setVisible(lvlUpObj.getPoints() == 0);
			
		}
	}

}
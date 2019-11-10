package starter;

import acm.graphics.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class LevelPane extends GraphicsPane {
	private static final String BACKGROUND = "controlsImage.jpg";
	private static final String MAGE = "Battle Image(Mage).png";
	private static final String WARRIOR = "Battle Image(Warrior).png";
	private static final String ROGUE = "Battle Image(Rogue).png";
	private static final String ENEMY = "Battle Image(Enemy).png";
	private static final String KING = "Battle Image(Boss).png";


	private MainApplication program; // you will use program to get access to
	// all of the GraphicsProgram calls
	private GButton play, controls, quit;
	private GImage background, controlsImage, playerImage, enemyImage;
	private GLine line;
	private GRect square;
<<<<<<< Upstream, based on branch 'master' of https://github.com/comp55/group-project-code-avalanche.git
	private GLabel attack;
=======
	private GLabel attack, block, screech, cStrenght, cDefense, cAgility, cCharisma, eDefense, eStrength, eAgility, eCharisma;
>>>>>>> c67046b All class works just need enemy to be passed thru to display stats and picture

	//playerSprite Variables
	private GImage playerSprite;
	private int moveCount;
	private int escCount;

<<<<<<< Upstream, based on branch 'master' of https://github.com/comp55/group-project-code-avalanche.git
	private boolean battling;

=======
	private boolean isBattle;
	private Battle battle;
	
>>>>>>> c67046b All class works just need enemy to be passed thru to display stats and picture
	protected Player Protagonist;

	private Map map1, map2, map3;
	private Map current;
	protected Map[] world = { map1, map2, map3 };

	private int xWidth, yHeight;
	private int windowHeight = program.WINDOW_HEIGHT;
	private int windowWidth = program.WINDOW_WIDTH;

	public LevelPane(MainApplication app) {
		super();
		program = app;
		background = new GImage(BACKGROUND);

<<<<<<< Upstream, based on branch 'master' of https://github.com/comp55/group-project-code-avalanche.git
		battling = false;

=======
>>>>>>> c67046b All class works just need enemy to be passed thru to display stats and picture
		//Pause options
		play = new GButton("Resume", windowWidth/3, 200, 300, 75);
		controls = new GButton("Controls", windowWidth/3, 300, 300, 75);
		quit = new GButton("Quit", windowWidth/3 , 400, 300, 75);
		square = new GRect(windowWidth/4, 150, 200, 200);
		square.setFillColor(Color.BLACK);
		square.setFilled(true);
		controlsImage = new GImage("controlsImage.jpg");

		Protagonist = app.user;

		generateWorld();

		showContents();
	}

	@Override
	public void showContents() {
		loadMap(world[0]);

<<<<<<< Upstream, based on branch 'master' of https://github.com/comp55/group-project-code-avalanche.git
		//BattleScreen();
=======
		BattleScreen();
		//HideBattleScreen();
>>>>>>> c67046b All class works just need enemy to be passed thru to display stats and picture
	}

	@Override
	public void hideContents() {
		program.removeAll();
	}

	public void showPause() {
		escCount = 1;
		//Show Pause
		program.add(square);
		program.add(play);
		program.add(controls);
		program.add(quit);

		//Hides Level

	}

	public void hidePause() {
		escCount = 0;
		//Hides Pause
		program.remove(square);
		program.remove(play);
		program.remove(controls);
		program.remove(quit);
		program.remove(controlsImage);
		//Shows Level

	}

<<<<<<< Upstream, based on branch 'master' of https://github.com/comp55/group-project-code-avalanche.git
	/*
=======
>>>>>>> c67046b All class works just need enemy to be passed thru to display stats and picture
	public void BattleScreen() {

		isBattle = true;
		
		//prints background
		background = new GImage("images/BattleStyle.png");
		program.add(background);
		
		//prints attack screech and block for user battle choices
		attack = new GLabel("1) Attack", 50, 490);
		attack.setFont(new Font("Monotype Corsiva", 1, 30));
		attack.setColor(Color.black);
		block = new GLabel("2) Block", 50, 530);
		block.setFont(new Font("Monotype Corsiva", 1, 30));
		block.setColor(Color.black);
		screech = new GLabel("3) Screech", 50, 565);
		screech.setFont(new Font("Monotype Corsiva", 1, 30));
		screech.setColor(Color.black);
		
		program.add(attack);
		program.add(block);
		program.add(screech);
		
		
		// prints player and enemy images
		if(Protagonist.getCharacterType() == CharacterType.WARRIOR) {
			playerImage = new GImage(WARRIOR);
		}
		else if(Protagonist.getCharacterType() == CharacterType.MAGE) {
			playerImage = new GImage(MAGE);
					
		}
		else {
			playerImage = new GImage(ROGUE);
		}
		
		program.add(playerImage);
		
		//prints enemy if king or regular enemy
		
//		if(Antagonist == CharacterType.ENEMY  && Antagonist.isKing() == true) {
//			enemyImage = new GImage(KING);
//		}
//		else {
//			enemyImage = new GImage(ENEMY);
//		}
//		enemyImage = new GImage(ENEMY);
//		enemyImage.setLocation(400, 10);
//		program.add(enemyImage);
//		
		//prints players stats
		cStrenght = new GLabel("Strength: " + Protagonist.getStrength(), 55, 300);
		cStrenght.setFont(new Font("Monotype Corsiva", 1, 15));
		cStrenght.setColor(Color.black);
		program.add(cStrenght);
		
		cDefense = new GLabel("Defense: " + Protagonist.getDefense(), 55, 330);
		cDefense.setFont(new Font("Monotype Corsiva", 1, 15));
		cDefense.setColor(Color.black);
		program.add(cDefense);
		
		cCharisma = new GLabel("Charisma: " + Protagonist.getCharisma(), 55, 360);
		cCharisma.setFont(new Font("Monotype Corsiva", 1, 15));
		cCharisma.setColor(Color.black);
		program.add(cCharisma);
		
		
		// prints stats of enemy 
		// needs way to pass enemy stats
		
		eStrength = new GLabel("Strength: 3", 500, 300);
		eStrength.setFont(new Font("Monotype Corsiva", 1, 15));
		eStrength.setColor(Color.black);
		program.add(eStrength);
		
		eDefense = new GLabel("Defense: 3", 500, 330);
		eDefense.setFont(new Font("Monotype Corsiva", 1, 15));
		eDefense.setColor(Color.black);
		program.add(eDefense);
		
		eCharisma = new GLabel("Charisma: 3", 500, 360);
		eCharisma.setFont(new Font("Monotype Corsiva", 1, 15));
		eCharisma.setColor(Color.black);
		program.add(eCharisma);
		
		
		
		
	}
<<<<<<< Upstream, based on branch 'master' of https://github.com/comp55/group-project-code-avalanche.git
	 */
=======
	public void HideBattleScreen() {

		isBattle = false;
		
		// removes all images from battlescreen and allows input for character movement again
		
		program.remove(background);
		program.remove(attack);
		program.remove(block);
		program.remove(screech);
		program.remove(cStrenght);
		program.remove(cDefense);
		program.remove(cCharisma);
		program.remove(eStrength);
		program.remove(eDefense);
		program.remove(eCharisma);
		program.remove(playerImage);
		program.remove(enemyImage);
		
	}
>>>>>>> c67046b All class works just need enemy to be passed thru to display stats and picture

	@Override
	public void mouseClicked(MouseEvent e) {
		convertXYToSpace(e.getX(), e.getY());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == play) {
			play.setFillColor(Color.GRAY);
		}
		else if (obj == controls) {
			controls.setFillColor(Color.GRAY);
		}
		else if (obj == quit) {
			quit.setFillColor(Color.GRAY);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == play) {
			play.setFillColor(Color.WHITE);
			hidePause();
		}
		else if (obj == controls) {
			System.out.println("Print controls");
			controls.setFillColor(Color.WHITE);
			program.add(controlsImage);
			controlsImage.sendToFront();
		}
		else if (obj == quit) {
			System.out.println("Quit Game");
			quit.setFillColor(Color.WHITE);
			System.exit(0);
		}
	}

	//Really long and probably overly complicated, but it works.
	@Override
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

<<<<<<< Upstream, based on branch 'master' of https://github.com/comp55/group-project-code-avalanche.git
		//Overlay for the Battle Image
		//Press 0 to test.
		if(key == KeyEvent.VK_0) {
=======
		if(key == KeyEvent.VK_ESCAPE) {
			if(escCount == 0)
				showPause();
			else if(escCount == 1)
				hidePause();
		}
		if(isBattle == false) { // character movement
>>>>>>> c67046b All class works just need enemy to be passed thru to display stats and picture

<<<<<<< Upstream, based on branch 'master' of https://github.com/comp55/group-project-code-avalanche.git
			if(battling == false) {
				battling = true;
				pause.battleScene(program);
=======
			if(key == KeyEvent.VK_A || key == KeyEvent.VK_S || key == KeyEvent.VK_D || key == KeyEvent.VK_W) {
				if(moveCount == 8)
					moveCount = 0;
>>>>>>> c67046b All class works just need enemy to be passed thru to display stats and picture
			}

<<<<<<< Upstream, based on branch 'master' of https://github.com/comp55/group-project-code-avalanche.git
			else {
				battling = false;
				pause.battleOver(program);
			}
		}
=======
			if (key == KeyEvent.VK_A) {
				playerSprite.move(-5, 0);
>>>>>>> c67046b All class works just need enemy to be passed thru to display stats and picture

<<<<<<< Upstream, based on branch 'master' of https://github.com/comp55/group-project-code-avalanche.git
		if(key == KeyEvent.VK_ESCAPE) {
			if(escCount == 0)
				showPause();
			else if(escCount == 1)
				hidePause();
		}

		if(key == KeyEvent.VK_A || key == KeyEvent.VK_S || key == KeyEvent.VK_D || key == KeyEvent.VK_W) {
			if(moveCount == 8)
				moveCount = 0;
		}

		if (key == KeyEvent.VK_A) {
			playerSprite.move(-5, 0);

			if(Protagonist.getCharacterType() == CharacterType.WARRIOR) {
				playerSprite.setImage("knight/knight_" + moveCount + ".png");
				playerSprite.setSize(xWidth, yHeight);
				System.out.println(moveCount);
				moveCount++;
			}

			else if(Protagonist.getCharacterType() == CharacterType.ROGUE) {
				playerSprite.setImage("rogue/rogue_" + moveCount + ".png");
				playerSprite.setSize(xWidth, yHeight);
				System.out.println(moveCount);
				moveCount++;
			}

			else if(Protagonist.getCharacterType() == CharacterType.MAGE) {
				playerSprite.setImage("mage/mage_" + moveCount + ".png");
				playerSprite.setSize(xWidth, yHeight);
				System.out.println(moveCount);
				moveCount++;
			}

		}

		if (key == KeyEvent.VK_D) {
			playerSprite.move(5, 0);

			if(Protagonist.getCharacterType() == CharacterType.WARRIOR) {
				playerSprite.setImage("knight/knight_" + moveCount + ".png");
				playerSprite.setSize(xWidth, yHeight);
				System.out.println(moveCount);
				moveCount++;
			}

			else if(Protagonist.getCharacterType() == CharacterType.ROGUE) {
				playerSprite.setImage("rogue/rogue_" + moveCount + ".png");
				playerSprite.setSize(xWidth, yHeight);
				System.out.println(moveCount);
				moveCount++;
			}

			else if(Protagonist.getCharacterType() == CharacterType.MAGE) {
				playerSprite.setImage("mage/mage_" + moveCount + ".png");
				playerSprite.setSize(xWidth, yHeight);
				System.out.println(moveCount);
				moveCount++;
			}
		}

		if (key == KeyEvent.VK_W) {
			playerSprite.move(0, -5);

			if(Protagonist.getCharacterType() == CharacterType.WARRIOR) {
				playerSprite.setImage("knight/knight_" + moveCount + ".png");
				playerSprite.setSize(xWidth, yHeight);
				System.out.println(moveCount);
				moveCount++;
			}

			else if(Protagonist.getCharacterType() == CharacterType.ROGUE) {
				playerSprite.setImage("rogue/rogue_" + moveCount + ".png");
				playerSprite.setSize(xWidth, yHeight);
				System.out.println(moveCount);
				moveCount++;
			}

			else if(Protagonist.getCharacterType() == CharacterType.MAGE) {
				playerSprite.setImage("mage/mage_" + moveCount + ".png");
				playerSprite.setSize(xWidth, yHeight);
				System.out.println(moveCount);
				moveCount++;
			}
		}

		if (key == KeyEvent.VK_S) {
			playerSprite.move(0, 5);

			if(Protagonist.getCharacterType() == CharacterType.WARRIOR) {
				playerSprite.setImage("knight/knight_" + moveCount + ".png");
				playerSprite.setSize(xWidth, yHeight);
				System.out.println(moveCount);
				moveCount++;
			}

			else if(Protagonist.getCharacterType() == CharacterType.ROGUE) {
				playerSprite.setImage("rogue/rogue_" + moveCount + ".png");
				playerSprite.setSize(xWidth, yHeight);
				System.out.println(moveCount);
				moveCount++;
			}

			else if(Protagonist.getCharacterType() == CharacterType.MAGE) {
				playerSprite.setImage("mage/mage_" + moveCount + ".png");
				playerSprite.setSize(xWidth, yHeight);
				System.out.println(moveCount);
				moveCount++;
			}
		}

		characterLocation(Protagonist);
=======
				if(Protagonist.getCharacterType() == CharacterType.WARRIOR) {
					playerSprite.setImage("knight/knight_" + moveCount + ".png");
					playerSprite.setSize(xWidth, yHeight);
					System.out.println(moveCount);
					moveCount++;
				}

				else if(Protagonist.getCharacterType() == CharacterType.ROGUE) {
					playerSprite.setImage("rogue/rogue_" + moveCount + ".png");
					playerSprite.setSize(xWidth, yHeight);
					System.out.println(moveCount);
					moveCount++;
				}

				else if(Protagonist.getCharacterType() == CharacterType.MAGE) {
					playerSprite.setImage("mage/mage_" + moveCount + ".png");
					playerSprite.setSize(xWidth, yHeight);
					System.out.println(moveCount);
					moveCount++;
				}
			}

			if (key == KeyEvent.VK_D) {
				playerSprite.move(5, 0);

				if(Protagonist.getCharacterType() == CharacterType.WARRIOR) {
					playerSprite.setImage("knight/knight_" + moveCount + ".png");
					playerSprite.setSize(xWidth, yHeight);
					System.out.println(moveCount);
					moveCount++;
				}

				else if(Protagonist.getCharacterType() == CharacterType.ROGUE) {
					playerSprite.setImage("rogue/rogue_" + moveCount + ".png");
					playerSprite.setSize(xWidth, yHeight);
					System.out.println(moveCount);
					moveCount++;
				}

				else if(Protagonist.getCharacterType() == CharacterType.MAGE) {
					playerSprite.setImage("mage/mage_" + moveCount + ".png");
					playerSprite.setSize(xWidth, yHeight);
					System.out.println(moveCount);
					moveCount++;
				}
			}

			if (key == KeyEvent.VK_W) {
				playerSprite.move(0, -5);

				if(Protagonist.getCharacterType() == CharacterType.WARRIOR) {
					playerSprite.setImage("knight/knight_" + moveCount + ".png");
					playerSprite.setSize(xWidth, yHeight);
					System.out.println(moveCount);
					moveCount++;
				}

				else if(Protagonist.getCharacterType() == CharacterType.ROGUE) {
					playerSprite.setImage("rogue/rogue_" + moveCount + ".png");
					playerSprite.setSize(xWidth, yHeight);
					System.out.println(moveCount);
					moveCount++;
				}

				else if(Protagonist.getCharacterType() == CharacterType.MAGE) {
					playerSprite.setImage("mage/mage_" + moveCount + ".png");
					playerSprite.setSize(xWidth, yHeight);
					System.out.println(moveCount);
					moveCount++;
				}
			}

			if (key == KeyEvent.VK_S) {
				playerSprite.move(0, 5);

				if(Protagonist.getCharacterType() == CharacterType.WARRIOR) {
					playerSprite.setImage("knight/knight_" + moveCount + ".png");
					playerSprite.setSize(xWidth, yHeight);
					System.out.println(moveCount);
					moveCount++;
				}

				else if(Protagonist.getCharacterType() == CharacterType.ROGUE) {
					playerSprite.setImage("rogue/rogue_" + moveCount + ".png");
					playerSprite.setSize(xWidth, yHeight);
					System.out.println(moveCount);
					moveCount++;
				}

				else if(Protagonist.getCharacterType() == CharacterType.MAGE) {
					playerSprite.setImage("mage/mage_" + moveCount + ".png");
					playerSprite.setSize(xWidth, yHeight);
					System.out.println(moveCount);
					moveCount++;
				}
			}
		}

		else if(isBattle == true) { 
			// keyboard inputs for the player moves
			
			
				if(key == KeyEvent.VK_1) {
					// Battle.fight(1, Antagonist, Protagonist);
					System.out.print("You chose attack");
					
				}
				
				else if(key == KeyEvent.VK_2) {
					// Battle.fight(2, Antagonist, Protagonist);
					System.out.print("You chose block");
				}
				else if(key == KeyEvent.VK_3) {
					// Battle.fight(3, Antagonist, Protagonist);
					System.out.print("You chose defend");
				}
				
		}
>>>>>>> c67046b All class works just need enemy to be passed thru to display stats and picture
	}

	//New Code below this line//

<<<<<<< Upstream, based on branch 'master' of https://github.com/comp55/group-project-code-avalanche.git
	public void characterLocation(Character c) {
		Space currentLocation = convertXYToSpace(playerSprite.getX(),playerSprite.getY());
		c.setLocation(currentLocation.getRow(), currentLocation.getCol());

		//Testing line, remove after production is set.
		System.out.println("The character's location is now:\nRow: " + c.getLocation().getRow() + "\nColumn: " + c.getLocation().getCol());
	}

=======
>>>>>>> c67046b All class works just need enemy to be passed thru to display stats and picture
	private void drawPlayer(Player p) {
		// TODO implement drawPlayer
		if(p.getCharacterType() == CharacterType.WARRIOR) {
			playerSprite =  new GImage("knight/knight_0.png", p.startSpace.getRow() * xWidth, p.startSpace.getCol() * yHeight);
			playerSprite.setSize(xWidth, yHeight);
			playerSprite.sendToFront();
		}
		else if(p.getCharacterType() == CharacterType.ROGUE) {
			playerSprite =  new GImage("rogue/rogue_0.png", p.startSpace.getRow() * xWidth, p.startSpace.getCol() * yHeight);
			playerSprite.setSize(xWidth, yHeight);
		}
		else if(p.getCharacterType() == CharacterType.MAGE) {
			playerSprite =  new GImage("mage/mage_0.png", p.startSpace.getRow() * xWidth, p.startSpace.getCol() * yHeight);
			playerSprite.setSize(xWidth, yHeight);
		}

		//Actually implements the GImage!
		program.add(playerSprite);
	}

	private void generateWorld() {
		world[0] = Map.getMapForLevel(Map.LEVEL_BEGINNER);
		world[1] = Map.getMapForLevel(Map.LEVEL_INTERMEDIATE);
		world[2] = Map.getMapForLevel(Map.LEVEL_ADVANCED);
	}

	private void drawLevel(Map m) {
		drawGridLines(m);
	}

	private void loadMap(Map m) {
		drawLevel(m);
		current = m;

		drawPlayer(Protagonist);
	}

<<<<<<< Upstream, based on branch 'master' of https://github.com/comp55/group-project-code-avalanche.git
	public Space convertXYToSpace(double x, double y) {
=======
	private Space convertXYToSpace(double x, double y) {
>>>>>>> c67046b All class works just need enemy to be passed thru to display stats and picture
		// TODO write this implementation hint (use helper methods below)
		int r = (int) (y/xWidth);
		int c = (int) (x/yHeight);

		Space square = new Space(r, c);
		System.out.printf("Row:%d Column:%d\n", square.getRow(), square.getCol());
		return square;
	}

	private double spaceWidth(Map m) {
		// TODO fix this method
		xWidth = (windowWidth)/m.getRows();
		return xWidth;
	}
	private double spaceHeight(Map m) {
		// TODO fix this method
		yHeight = (windowHeight)/m.getColumns();
		return yHeight;
	}

	private void drawGridLines(Map m) {
		double total = 0;
		int j = 0;

		//horizontal grid lines
		while(total <= windowWidth) {
			double w = j * spaceHeight(m);
			total = total + spaceHeight(m);

			line = new GLine(w, 0, w, windowHeight-2);
			program.add(line);

			j++;
		}

		//vertical grid lines
		total = 0;
		j = 0;

		while(total <= windowHeight) {
			double h = j * spaceWidth(m);
			total = total + spaceWidth(m);

			line = new GLine(0, h, windowWidth-2, h);
			program.add(line);

			j++;
		}
	}
}
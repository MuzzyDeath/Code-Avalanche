package starter;

import acm.graphics.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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


	//playerSprite Variables
	private GImage playerSprite;
	private int moveCount;
	
	private static Enemy opponent;


	private boolean battling;
	private boolean paused;


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

		battling = false;
		paused = false;

		Protagonist = app.user;
		
		opponent = Board.CharacterAtSpace(Protagonist);
		
		test();

		generateWorld();

		showContents();
	}
	
	//For testing, feel free to use it, if other are not! :)
	private void test() {
		System.out.println("Is there an enemy showing from the Board.java? Find out below! :D");
		System.out.println("\nThe 'temp' enemy is at:\nRow: " + opponent.getLocation().getRow() + "\nCol: " + opponent.getLocation().getCol() + "\n");
	}

	@Override
	public void showContents() {
		loadMap(world[0]);
	}

	@Override
	public void hideContents() {
		program.removeAll();
	}

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
			paused = false;
			pause.unpause(program);
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

		//Overlay for the Battle Image
		//Press 0 to test.
		if(key == KeyEvent.VK_0) {

			if(battling == false) {
				battling = true;
				opponent = Board.CharacterAtSpace(Protagonist);
				pause.battleScene(program);

			}
			else {
				battling = false;
				pause.battleOver(program);
			}
		}

		if(key == KeyEvent.VK_ESCAPE) {
			if(!paused) {
				paused = true;
				pause.pause(program);
				play = pause.play;
				controls = pause.controls;
				quit = pause.quit;
			}
			else if(paused) {
				paused = false;
				pause.unpause(program);
			}
		}
		if(battling == false) {
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

		}
		else {
			
			if(key == KeyEvent.VK_1) {
				Battle.Fight(1, opponent, Protagonist);
				System.out.print("You chose attack");
				
			}
			
			else if(key == KeyEvent.VK_2) {
				Battle.Fight(2, opponent, Protagonist);
				System.out.print("You chose block");
			}
			else if(key == KeyEvent.VK_3) {
				Battle.Fight(3, opponent, Protagonist);
				System.out.print("You chose defend");
			}
		}

	}

	//New Code below this line//


	public void characterLocation(Character c) {
		Space currentLocation = convertXYToSpace(playerSprite.getX(),playerSprite.getY());
		c.setLocation(currentLocation.getRow(), currentLocation.getCol());

		//Testing line, remove after production is set.
		System.out.println("The character's location is now:\nRow: " + c.getLocation().getRow() + "\nColumn: " + c.getLocation().getCol());
	}


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
	public Space convertXYToSpace(double x, double y) {

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
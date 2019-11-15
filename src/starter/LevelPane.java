package starter;

import acm.graphics.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.ListIterator;
import java.awt.Font;

public class LevelPane extends GraphicsPane {
	private static final String BACKGROUND = "controlsImage.jpg";
	private static final String GROUND = "ground.png";
	private static final String MAGE = "Battle Image(Mage).png";
	private static final String WARRIOR = "Battle Image(Warrior).png";
	private static final String ROGUE = "Battle Image(Rogue).png";
	private static final String ENEMY = "Battle Image(Enemy).png";
	private static final String KING = "Battle Image(Boss).png";
	public static final String MUSIC_FOLDER = "music";
	private static final String[] SOUND_FILES = { "BattleMusic.mp3" };


	private AudioPlayer audio;

	private MainApplication program; // you will use program to get access to
	// all of the GraphicsProgram calls
	private GButton play, controls, quit;
	private GImage ground, background, controlsImage, playerImage, enemyImage;
	private GLine line;


	//playerSprite Variables
	private GImage playerSprite, sprite;
	private int moveCount;

	private static Enemy opponent;


	private boolean battling;
	private boolean paused;
	private boolean inventory;

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
		ground = new GImage(GROUND);

		battling = false;
		paused = false;
		inventory = false;

		MainApplication.user.cName = "Tester";
		Protagonist = MainApplication.user;
		Protagonist.printPlayer();

		opponent = Board.CharacterAtSpace(Protagonist);

		controlsImage = new GImage("controlsImage.jpg");

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
		if(obj != null) {
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
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if(obj != null) {
			if (obj == play) {
				play.setFillColor(Color.WHITE);
				paused = false;
				Overlay.unpause(program);
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
	}

	//Really long and probably overly complicated, but it works.
	@Override
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		//Overlay for the Inventory
		//Press I to test.
		if(key == KeyEvent.VK_I) {
			if(!inventory) {
				inventory = true;
				Overlay.showInventory(program);
				play = Overlay.play;
				controls = Overlay.controls;
			}
			else if(inventory) {
				inventory = false;
				Overlay.hideInventory(program);
			}
		}
		//Overlay for the Battle Image
		//Press 0 to test.
		if(key == KeyEvent.VK_0) {

			if(battling == false) {
				battling = true;

				opponent = Board.CharacterAtSpace(Protagonist);
				//				pause.battleScene(program);


				Overlay.battleScene(program);
				audio = AudioPlayer.getInstance();
				audio.playSound(MUSIC_FOLDER, SOUND_FILES[0]);

			}
			else {
				battling = false;
				Overlay.battleOver(program);
				audio.stopSound(MUSIC_FOLDER, SOUND_FILES[0]);

			}
		}

		if(key == KeyEvent.VK_ESCAPE) {
			if(!paused) {
				paused = true;
				Overlay.pause(program);
				play = Overlay.play;
				controls = Overlay.controls;
				quit = Overlay.quit;
				program.remove(controlsImage);
			}
			else if(paused) {
				paused = false;
				Overlay.unpause(program);
			}
		}
		if(!battling && !paused) {
			if(key == KeyEvent.VK_A || key == KeyEvent.VK_S || key == KeyEvent.VK_D || key == KeyEvent.VK_W) {
				if(moveCount == 8)
					moveCount = 0;

				double lastX, lastY;
				lastX = playerSprite.getX();
				lastY = playerSprite.getY();

				if (key == KeyEvent.VK_A) {
					if(checkBounds(playerSprite)) {
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
					else
						playerSprite.setLocation(0, lastY);
				}

				if (key == KeyEvent.VK_D) {
					if(checkBounds(playerSprite)) {
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
					else
						playerSprite.setLocation(windowWidth-xWidth, lastY);
				}

				if (key == KeyEvent.VK_W) {
					if(checkBounds(playerSprite)) {
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
					else
						playerSprite.setLocation(lastX, 0);
				}

				if (key == KeyEvent.VK_S) {
					if(checkBounds(playerSprite))  {
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
					else
						playerSprite.setLocation(lastX, windowHeight-yHeight);
				}
			}

			characterLocation(Protagonist);

		}
		else {

			if(key == KeyEvent.VK_1) {
				Battle.Fight(1, opponent, Protagonist);
				System.out.print("You chose attack \n");

			}

			else if(key == KeyEvent.VK_2) {
				Battle.Fight(2, opponent, Protagonist);
				System.out.print("You chose block \n");
			}
			else if(key == KeyEvent.VK_3) {
				Battle.Fight(3, opponent, Protagonist);
				System.out.print("You chose defend \n");
			}
		}

	}

	//New Code below this line//


	public void characterLocation(Character c) {
		Space currentLocation = convertXYToSpace(playerSprite.getX() + (xWidth / 2), playerSprite.getY() + (yHeight / 2));
		c.setLocation(currentLocation.getRow(), currentLocation.getCol());

		//Testing line, remove after production is set.
		System.out.println("The character's location is now:\nRow: " + c.getLocation().getRow() + "\nColumn: " + c.getLocation().getCol());
	}


	private void drawPlayer(Player p) {
		// TODO implement drawPlayer
		if(p.getCharacterType() == CharacterType.WARRIOR) {
			playerSprite =  new GImage("knight/knight_0.png", Character.startSpace.getRow() * xWidth, Character.startSpace.getCol() * yHeight);
			playerSprite.setSize(xWidth, yHeight);
			playerSprite.sendToFront();
		}
		else if(p.getCharacterType() == CharacterType.ROGUE) {
			playerSprite =  new GImage("rogue/rogue_0.png", Character.startSpace.getRow() * xWidth, Character.startSpace.getCol() * yHeight);
			playerSprite.setSize(xWidth, yHeight);
		}
		else if(p.getCharacterType() == CharacterType.MAGE) {
			playerSprite =  new GImage("mage/mage_0.png", Character.startSpace.getRow() * xWidth, Character.startSpace.getCol() * yHeight);
			playerSprite.setSize(xWidth, yHeight);
		}

		//Actually implements the GImage!
		program.add(playerSprite);
	}

	private void drawCharacters(Map m) {
		m.getBoard();
		ListIterator<Character> iterator = Board.getCharactersOnBoard().listIterator();

		while(iterator.hasNext()) {
			Character toAdd = iterator.next();
			if(toAdd.cType == CharacterType.NPC) {
				sprite =  new GImage("knight/knight_0.png", toAdd.getRow() * xWidth, toAdd.getCol() * yHeight);
				sprite.setSize(xWidth, yHeight);
				sprite.sendToFront();
			}
			//Actually implements the GImage!
			program.add(sprite);
		}

	}

	private boolean checkBounds(GImage obj) {
		if(checkLeft(obj) && checkRight(obj) && checkTop(obj) && checkBottom(obj))
			return true;
		else
			return false;
	}

	private boolean checkLeft(GImage obj) {
		if(obj.getX() >= 0)
			return true;
		else
			return false;
	}

	private boolean checkRight(GImage obj) {
		if((obj.getX() + xWidth) <= windowWidth)
			return true;
		else
			return false;
	}

	private boolean checkTop(GImage obj) {
		if(obj.getY() >= 0)
			return true;
		else
			return false;
	}

	private boolean checkBottom(GImage obj) {
		if((obj.getY() + yHeight) <= windowHeight)
			return true;
		else
			return false;
	}

	private void generateWorld() {
		world[0] = Map.getMap(Map.LEVEL_BEGINNER);
		//world[1] = Map.getMapForLevel(Map.LEVEL_INTERMEDIATE);
		//world[2] = Map.getMapForLevel(Map.LEVEL_ADVANCED);
	}

	private void drawLevel(Map m) {
		drawGridLines(m);
	}

	private void loadMap(Map m) {
		drawLevel(m);
		current = m;

		program.add(ground);
		ground.sendToBack();

		drawPlayer(Protagonist);
		drawCharacters(m);
	}
	public Space convertXYToSpace(double x, double y) {
		int r = (int) (y/xWidth);
		int c = (int) (x/yHeight);

		Space square = new Space(r, c);
		System.out.printf("Row:%d Column:%d\n", square.getRow(), square.getCol());
		return square;
	}

	private double spaceWidth(Map m) {
		m.getBoard();
		xWidth = (windowWidth)/Board.getNumRows();
		return xWidth;
	}
	private double spaceHeight(Map m) {
		m.getBoard();
		yHeight = (windowHeight)/Board.getNumCols();
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
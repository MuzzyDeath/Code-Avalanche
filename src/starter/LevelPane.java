package starter;

import acm.graphics.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
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

	// playerSprite Variables
	private GImage playerSprite, sprite;
	private int moveCount;

	private static Enemy opponent;

	private boolean battling;
	private boolean paused;
	private boolean inventory;
	private boolean textbox;
	private boolean levelup;

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

		//test();

		generateWorld();

		showContents();
	}

	// For testing, feel free to use it, if other are not! :)
	private void test() {
		System.out.println("Is there an enemy showing from the Board.java? Find out below! :D");
		System.out.println("\nThe 'temp' enemy is at:\nRow: " + opponent.getLocation().getRow() + "\nCol: "
				+ opponent.getLocation().getCol() + "\n");
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
		if (obj != null) {
			if (obj == play) {
				play.setFillColor(Color.GRAY);
			} else if (obj == controls) {
				controls.setFillColor(Color.GRAY);
			} else if (obj == quit) {
				quit.setFillColor(Color.GRAY);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj != null) {
			// System.out.println(" Obj selected  = " + obj);
			if (obj == play) {
				play.setFillColor(Color.WHITE);
				paused = false;
				Overlay.unpause(program);
			} else if (obj == controls) {
				System.out.println("Print controls");
				controls.setFillColor(Color.WHITE);
				program.add(controlsImage);
				controlsImage.sendToFront();
			} else if (obj == quit) {
				System.out.println("Quit Game");
				quit.setFillColor(Color.WHITE);
				System.exit(0);
			}
			else if (levelup) {
				Overlay.processLevelupEvent(program, e);
			}
				
		}
	}

	// Really long and probably overly complicated, but it works.
	@Override
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		System.out.println(world[0].getBoard());

		// Overlay for the Inventory
		// Press I to test.
		if (key == KeyEvent.VK_I) {
			if (!inventory) {
				inventory = true;
				Overlay.showInventory(program);
				play = Overlay.play;
				controls = Overlay.controls;
			} else if (inventory) {
				inventory = false;
				Overlay.hideInventory(program);
			}
		}
		//Textbox of the closest npc or character appears
		//set to only read npc file for now
		// Press E to test.
		if (key == KeyEvent.VK_E) {
			interactions(current.getCharactersOnMap());
		}
		
		// Overlay for the Level up Image
		// Press l to test.
		
		if (key == KeyEvent.VK_L) {
			
			if (!levelup)
			{
				levelup = true;
				Overlay.showLevelUp(program);
			}
			else
			{
				levelup = false;
				Overlay.hideLevelUp(program);
			}
		}
		
		// Overlay for the Battle Image
		// Press 0 to test.
		if (key == KeyEvent.VK_0) {
			// change 0 key to E key later after the implementation is done with the text for
			// enemy battle
			// if it is an enemy, then text file for ENEMY should appear on top of text box
			// image and
			// then they press E again and it sets battle to true

			if (battling == false) {
				battling = true;

				opponent = Board.CharacterAtSpace(Protagonist);
				// pause.battleScene(program);

				Overlay.battleScene(program);
				audio = AudioPlayer.getInstance();
				audio.playSound(MUSIC_FOLDER, SOUND_FILES[0]);

			} else {
				battling = false;
				Overlay.battleOver(program);
				audio.stopSound(MUSIC_FOLDER, SOUND_FILES[0]);

			}
		}

		if (key == KeyEvent.VK_ESCAPE) {
			if (!paused) {
				paused = true;
				Overlay.pause(program);
				play = Overlay.play;
				controls = Overlay.controls;
				quit = Overlay.quit;
				program.remove(controlsImage);
			} else if (paused) {
				paused = false;
				Overlay.unpause(program);
			}
		}
		if (!battling && !paused) {
			if (key == KeyEvent.VK_A || key == KeyEvent.VK_S || key == KeyEvent.VK_D || key == KeyEvent.VK_W) {
				if (moveCount == 8)
					moveCount = 0;

				double lastX, lastY;
				lastX = playerSprite.getX();
				lastY = playerSprite.getY();

				world[0].getBoard().moveCharacter(Protagonist, Protagonist.getLocation());

				if (key == KeyEvent.VK_A) {
					if (checkBounds(playerSprite)) {
						playerSprite.move(-5, 0);

						if (Protagonist.getCharacterType() == CharacterType.WARRIOR) {
							playerSprite.setImage("knight/knight_" + moveCount + ".png");
							playerSprite.setSize(xWidth, yHeight);
							System.out.println(moveCount);
							moveCount++;
						}

						else if (Protagonist.getCharacterType() == CharacterType.ROGUE) {
							playerSprite.setImage("rogue/rogue_" + moveCount + ".png");
							playerSprite.setSize(xWidth, yHeight);
							System.out.println(moveCount);
							moveCount++;
						}

						else if (Protagonist.getCharacterType() == CharacterType.MAGE) {
							playerSprite.setImage("mage/mage_" + moveCount + ".png");
							playerSprite.setSize(xWidth, yHeight);
							System.out.println(moveCount);
							moveCount++;
						}

					} else
						playerSprite.setLocation((Protagonist.getCol()) * (yHeight + 2), lastY);
				}

				if (key == KeyEvent.VK_D) {
					if (checkBounds(playerSprite)) {
						playerSprite.move(5, 0);

						if (Protagonist.getCharacterType() == CharacterType.WARRIOR) {
							playerSprite.setImage("knight/knight_" + moveCount + ".png");
							playerSprite.setSize(xWidth, yHeight);
							System.out.println(moveCount);
							moveCount++;
						}

						else if (Protagonist.getCharacterType() == CharacterType.ROGUE) {
							playerSprite.setImage("rogue/rogue_" + moveCount + ".png");
							playerSprite.setSize(xWidth, yHeight);
							System.out.println(moveCount);
							moveCount++;
						}

						else if (Protagonist.getCharacterType() == CharacterType.MAGE) {
							playerSprite.setImage("mage/mage_" + moveCount + ".png");
							playerSprite.setSize(xWidth, yHeight);
							System.out.println(moveCount);
							moveCount++;
						}
					}

					else 
						playerSprite.setLocation((Protagonist.getCol() - 1) * yHeight, lastY);
				}

				if (key == KeyEvent.VK_W) {
					if (checkBounds(playerSprite)) {
						playerSprite.move(0, -5);

						if (Protagonist.getCharacterType() == CharacterType.WARRIOR) {
							playerSprite.setImage("knight/knight_" + moveCount + ".png");
							playerSprite.setSize(xWidth, yHeight);
							System.out.println(moveCount);
							moveCount++;
						}

						else if (Protagonist.getCharacterType() == CharacterType.ROGUE) {
							playerSprite.setImage("rogue/rogue_" + moveCount + ".png");
							playerSprite.setSize(xWidth, yHeight);
							System.out.println(moveCount);
							moveCount++;
						}

						else if (Protagonist.getCharacterType() == CharacterType.MAGE) {
							playerSprite.setImage("mage/mage_" + moveCount + ".png");
							playerSprite.setSize(xWidth, yHeight);
							System.out.println(moveCount);
							moveCount++;
						}
					} else
						playerSprite.setLocation(lastX, (Protagonist.getRow()) * yHeight);
				}

				if (key == KeyEvent.VK_S) {
					if (checkBounds(playerSprite)) {
						playerSprite.move(0, 5);

						if (Protagonist.getCharacterType() == CharacterType.WARRIOR) {
							playerSprite.setImage("knight/knight_" + moveCount + ".png");
							playerSprite.setSize(xWidth, yHeight);
							System.out.println(moveCount);
							moveCount++;
						} else if (Protagonist.getCharacterType() == CharacterType.ROGUE) {
							playerSprite.setImage("rogue/rogue_" + moveCount + ".png");
							playerSprite.setSize(xWidth, yHeight);
							System.out.println(moveCount);
							moveCount++;
						} else if (Protagonist.getCharacterType() == CharacterType.MAGE) {
							playerSprite.setImage("mage/mage_" + moveCount + ".png");
							playerSprite.setSize(xWidth, yHeight);
							System.out.println(moveCount);
							moveCount++;
						}
					} else
						playerSprite.setLocation(lastX, (Protagonist.getRow() + 1) * yHeight);
				}
			}

			characterLocation(Protagonist);

		} else {

			if (key == KeyEvent.VK_1) {
				Battle.Fight(1, opponent, Protagonist);
				System.out.print("You chose attack \n");

			}

			else if (key == KeyEvent.VK_2) {
				Battle.Fight(2, opponent, Protagonist);
				System.out.print("You chose block \n");
			} else if (key == KeyEvent.VK_3) {
				Battle.Fight(3, opponent, Protagonist);
				System.out.print("You chose defend \n");
			}
		}

	}

	// New Code below this line//

	public void characterLocation(Character c) {
		Space currentLocation = convertXYToSpace(playerSprite.getX() + (xWidth / 2),
				playerSprite.getY() + (yHeight / 2));
		c.setLocation(currentLocation.getRow(), currentLocation.getCol());

		// Testing line, remove after production is set.
		System.out.println("The character's location is now:\nRow: " + c.getLocation().getRow() + "\nColumn: "
				+ c.getLocation().getCol());
	}

	private void drawPlayer(Player p) {
		// TODO implement drawPlayer
		if (p.getCharacterType() == CharacterType.WARRIOR) {
			playerSprite = new GImage("knight/knight_0.png", Character.startSpace.getRow() * xWidth,
					Character.startSpace.getCol() * yHeight);
			playerSprite.setSize(xWidth, yHeight);
			playerSprite.sendToFront();
		} else if (p.getCharacterType() == CharacterType.ROGUE) {
			playerSprite = new GImage("rogue/rogue_0.png", Character.startSpace.getRow() * xWidth,
					Character.startSpace.getCol() * yHeight);
			playerSprite.setSize(xWidth, yHeight);
		} else if (p.getCharacterType() == CharacterType.MAGE) {
			playerSprite = new GImage("mage/mage_0.png", Character.startSpace.getRow() * xWidth,
					Character.startSpace.getCol() * yHeight);
			playerSprite.setSize(xWidth, yHeight);
		}

		// Actually implements the GImage!
		program.add(playerSprite);
	}

	private void drawCharacters(Map m) {
		m.getBoard();
		ListIterator<Character> iterator = current.getCharactersOnMap().listIterator();

		while (iterator.hasNext()) {
			Character toAdd = iterator.next();
			if (toAdd.cType == CharacterType.NPC) {
				sprite = new GImage("npcTemp.png", toAdd.getCol() * xWidth, toAdd.getRow() * yHeight);
				sprite.setSize(xWidth, yHeight);
				sprite.sendToFront();
			}
			else if (toAdd.cType == CharacterType.ENEMY) {
				sprite = new GImage("enemyTemp.png", toAdd.getCol() * xWidth, toAdd.getRow() * yHeight);
				sprite.setSize(xWidth, yHeight);
				sprite.sendToFront();
			}
			// Actually implements the GImage!
			program.add(sprite);
		}

	}

	private boolean checkBounds(GImage obj) {
		if (checkLeft(obj) && checkRight(obj) && checkTop(obj) && checkBottom(obj))
			return true;
		else
			return false;
	}

	private boolean checkLeft(GImage obj) {
		if (obj.getX() >= 0)
			return true;
		else
			return false;
	}

	private boolean checkRight(GImage obj) {
		if ((obj.getX() + xWidth) <= windowWidth)
			return true;
		else
			return false;
	}

	private boolean checkTop(GImage obj) {
		if (obj.getY() >= 0)
			return true;
		else
			return false;
	}

	private boolean checkBottom(GImage obj) {
		if ((obj.getY() + yHeight) <= windowHeight)
			return true;
		else
			return false;
	}

	private void generateWorld() {
		world[0] = Map.getMap(Map.LEVEL_BEGINNER);
		// world[1] = Map.getMapForLevel(Map.LEVEL_INTERMEDIATE);
		// world[2] = Map.getMapForLevel(Map.LEVEL_ADVANCED);
	}

	private void drawLevel(Map m) {
		drawGridLines(m);
	}

	private void loadMap(Map m) {
		drawLevel(m);
		current = m;

		program.add(ground);
		ground.sendToBack();

		world[0].getBoard().addCharacter(Protagonist);

		drawPlayer(Protagonist);
		drawCharacters(m);
	}

	public Space convertXYToSpace(double x, double y) {
		int r = (int) (y / xWidth);
		int c = (int) (x / yHeight);

		Space square = new Space(r, c);
		System.out.printf("Row:%d Column:%d\n", square.getRow(), square.getCol());
		return square;
	}

	private double spaceWidth(Map m) {
		m.getBoard();
		xWidth = (windowWidth) / Board.getNumRows();
		return xWidth;
	}

	private double spaceHeight(Map m) {
		m.getBoard();
		yHeight = (windowHeight) / Board.getNumCols();
		return yHeight;
	}

	private void drawGridLines(Map m) {
		double total = 0;
		int j = 0;

		// horizontal grid lines
		while (total <= windowWidth) {
			double w = j * spaceHeight(m);
			total = total + spaceHeight(m);

			line = new GLine(w, 0, w, windowHeight - 2);
			program.add(line);
			line.setVisible(false);
			j++;
		}

		// vertical grid lines
		total = 0;
		j = 0;

		while (total <= windowHeight) {
			double h = j * spaceWidth(m);
			total = total + spaceWidth(m);

			line = new GLine(0, h, windowWidth - 2, h);
			program.add(line);
			line.setVisible(false);
			j++;
		}
	}

	public int getDistance(Character a, Character b) {
		int col = Math.abs(a.getLocation().getCol() - b.getLocation().getCol());
		int row = Math.abs(a.getLocation().getRow() - b.getLocation().getRow());
		return col + row;
	}

	public void interactions(ArrayList<Character> c) {
		int key = 0;

		//	int player = -1;
		int closest = -1;
		int distance = 0;
		//	for (int i = 0; i < c.size(); i++) {
		//			System.out.println(c.get(i));
		//			if (c.get(i).isPlayer()) {
		//				player = i;
		//				break;
		//			}
		//
		//	}
		//		if (player == -1) {
		//			System.out.println("Error. Player was not found.");
		//			return;
		//		}
		//		else {
		//			System.out.println("Player was found at " + player);
		//		}
		for (int i = 0; i < c.size(); i++) {
			//			if (i == player) {
			//				continue;
			//			}
			int newDistance = getDistance(Protagonist, c.get(i));
			if (closest == -1 || newDistance < distance) {
				distance = newDistance;
				closest = i;
			}
		}
		if (closest == -1) {
			System.out.println("No closest character found");
			return;
		}
		Character cL = c.get(closest);
		URL url = null;
		if (cL.isKing() == true) {
			url = Narrative.class.getClassLoader().getResource("King");
		} else if (cL.cType == CharacterType.ENEMY) {
			url = Narrative.class.getClassLoader().getResource("Enemy");
		} else {
			url = Narrative.class.getClassLoader().getResource("NPC");
		}
		try {
			// System.out.println(url.getPath());
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			String line;
			String text = "";
			while ((line = in.readLine()) != null) {
				System.out.println(line);
				text += line;
			}
			if (!textbox) {
				textbox = true;
				Overlay.showTextbox(program, text);
				play = Overlay.play;
				controls = Overlay.controls;
			} else if (textbox) {
				textbox = false;
				Overlay.hideTextbox(program);
			}
			in.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("Unable to open file: " + url.getPath());
		} catch (NullPointerException e1) {
			System.out.println("Unable To Load Resource");

		}
	}
}
package starter;

import acm.graphics.*;
import java.awt.Color;
import java.awt.Component;
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
	
	// Images
	private static final String BACKGROUND = "controlsImage.jpg";
	private static final String GROUND = "ground.png";
	private static final String GROUND2 = "ground2.png";
	private static final String GROUND3 = "ground3.png";
	private static final String GROUND4 = "ground4.png";
	private static final String MAGE = "Battle Image(Mage).png";
	private static final String WARRIOR = "Battle Image(Warrior).png";
	private static final String ROGUE = "Battle Image(Rogue).png";
	private static final String ENEMY = "Battle Image(Enemy).png";
	private static final String KING = "Battle Image(Boss).png";
	
	// Music 
	public static final String MUSIC_FOLDER = "music";
	/*
	private static final String[] SOUND_FILES = { "BattleMusic.mp3" };
	private static final String[] SOUND_FILES2 = { "backgroundMusic.mp3" };
	private static final String[] SOUND_FILES3 = { "kingTheme.mp3" };
	*/
	private static final String SOUND_BACKGROUND       = "backgroundMusic.mp3";
	private static final String SOUND_BACKGROUND_KING  = "kingTheme.mp3";
	private static final String SOUND_BATTLE           = "BattleMusic.mp3";

		
	// private static AudioPlayer audio;
	private static String currentPlayingAudio;

	private static MainApplication program; // you will use program to get access to
	// all of the GraphicsProgram calls
	private GButton play, controls, quit;
	private GImage ground, ground2, ground3, ground4, background, controlsImage;
	private GLine line;

	// playerSprite Variables
	private GImage playerSprite, sprite;
	private int lMove, rMove;

	static Enemy opponent;

	public static ArrayList<String> speech;

	private static boolean battling;
	private boolean paused;
	private boolean currentStats;
	private boolean textbox;

	protected static Player Protagonist;

	//private static Map map1, map2, map3, map4;
	//protected static Map[] world = { map1, map2, map3, map4 };

	private static float xWidth;
	private static float yHeight;
	private int windowHeight = program.WINDOW_HEIGHT;
	private int windowWidth = program.WINDOW_WIDTH;


	private static GImage win, lose;
	private static GLabel labelW, labelL, bal;
	private static int winlose = 0;

	private static GImage textBox;
	private static GLabel talk;

	public LevelPane(MainApplication app) {
		super();
		program = app;
		background = new GImage(BACKGROUND);
		ground = new GImage(GROUND);
		ground2 = new GImage(GROUND2);
		ground3 = new GImage(GROUND3);
		ground4 = new GImage(GROUND4);

		battling = false;
		paused = false;
		currentStats = false;
		//prologue = false;

		Protagonist = MainApplication.user;

		Protagonist.printPlayer();
		controlsImage = new GImage("controlsImage.jpg");
		generateWorld();
		showContents();
	}

	@Override
	public void showContents() {
		loadMap(Map.getCurrentMap());

		// Show prologue image before starting the game.
		Overlay.showPrologue(program);
		stopAllBackgroundMusic();
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
			else if (Overlay.isLevelUpActive()) {
				Overlay.processLevelupEvent(program, e);
			}
			else if (!Overlay.isLevelUpActive()) {
				Overlay.processLevelupEvent(program, e);
			}
		}
	}

	// Really long and probably overly complicated, but it works.
	@Override
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		System.out.println(Map.getCurrentMap());

		// Overlay for the Prologue right before getting to the grid
		// Press ENTER to close .
		if (key == KeyEvent.VK_ENTER) {
			if (Overlay.isPrologueActive())
			{
				Overlay.hidePrologue(program);
				startBackgroundMusic(SOUND_BACKGROUND);
			}				
		}
		// Overlay for the currentStats
		// Press I to test.
		if (key == KeyEvent.VK_C) {
			if (!currentStats) {
				paused = true;
				currentStats = true;
				Overlay.showcurrentStats(program);
				play = Overlay.play;
				controls = Overlay.controls;
			} else if (currentStats) {
				paused = false;
				currentStats = false;
				Overlay.hidecurrentStats(program);
			}
		}
		//Textbox of the closest npc or character appears
		//set to only read npc file for now
		// Press E to test.
		if (key == KeyEvent.VK_E) {

			if(Map.getCurrentMap().getBoard().spaceCheck(Protagonist) != null)
			{

				if(Map.getCurrentMap().getBoard().spaceCheck(Protagonist).getCharacterType() == CharacterType.ENEMY) {
					opponent = (Enemy) Map.getCurrentMap().getBoard().spaceCheck(Protagonist);
					battling = true;	

					Overlay.battleScene(program);
					startBackgroundMusic(SOUND_BATTLE); // Start battle music
				} 

				else if(Map.getCurrentMap().getBoard().spaceCheck(Protagonist).getCharacterType() == CharacterType.KING) {
					opponent = (Enemy) Map.getCurrentMap().getBoard().spaceCheck(Protagonist);
					battling = true;	

					Overlay.battleScene(program);
					startBackgroundMusic(SOUND_BATTLE); // Start battle music
				}
				
				else
					try {
						if(Map.getCurrentMap().getBoard().spaceCheck(Protagonist).getCharacterType() == CharacterType.NPC) {
							Narrative.print("NPC-1");

							ListIterator<String> iterator = speech.listIterator();

							while (iterator.hasNext()) 
								System.out.println(iterator.next());


							//					dialouge((NPC) Map.getCurrentMap().getBoard().spaceCheck(Protagonist));
							//					System.out.println("NPC is talking");
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
			else {
				System.out.println("Battle not possible since not nearby the opponent");
			}
		}

		if(key == KeyEvent.VK_A || key == KeyEvent.VK_W || key == KeyEvent.VK_S || key == KeyEvent.VK_D) {


			if(winlose == 1){
				removeWin(program);
			}
			else if(winlose == 2) {
				removeLose(program);
			}
			else if (winlose == 3){

				removeDialouge(program);
				System.out.println("Battle not possible since not nearby the opponent");
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
				if (rMove == 8 || lMove == 8) {
					rMove = 0;
					lMove = 0;
				}

				double lastX, lastY;
				lastX = playerSprite.getX();
				lastY = playerSprite.getY();

				if (key == KeyEvent.VK_A) {
					if (checkBounds(playerSprite) && checkContainment(Protagonist)) {
						Map.getCurrentMap().moveCharacter(Protagonist, Protagonist.getLocation());
						playerSprite.move(-20, 0);

						if (Protagonist.getCharacterType() == CharacterType.WARRIOR) {
							playerSprite.setImage("knight/lknight_" + lMove + ".png");
							playerSprite.setSize(xWidth, yHeight);
							System.out.println(lMove);
							lMove++;
						}

						else if (Protagonist.getCharacterType() == CharacterType.ROGUE) {
							playerSprite.setImage("rogue/lrogue_" + lMove + ".png");
							playerSprite.setSize(xWidth, yHeight);
							System.out.println(lMove);
							lMove++;
						}

						else if (Protagonist.getCharacterType() == CharacterType.MAGE) {
							playerSprite.setImage("mage/lmage_" + lMove + ".png");
							playerSprite.setSize(xWidth, yHeight);
							System.out.println(lMove);
							lMove++;
						}
					} 

					else if (checkContainment(Protagonist)) {
						Protagonist.setLocation(Protagonist.getRow(), Protagonist.getCol());
						playerSprite.setLocation((Protagonist.getCol()) * (xWidth + 2), lastY);
					}
				}

				if (key == KeyEvent.VK_D) {
					if (checkBounds(playerSprite) && checkContainment(Protagonist)) {
						Map.getCurrentMap().moveCharacter(Protagonist, Protagonist.getLocation());
						playerSprite.move(20, 0);

						if (Protagonist.getCharacterType() == CharacterType.WARRIOR) {
							playerSprite.setImage("knight/rknight_" + rMove + ".png");
							playerSprite.setSize(xWidth, yHeight);
							System.out.println(rMove);
							rMove++;
						}

						else if (Protagonist.getCharacterType() == CharacterType.ROGUE) {
							playerSprite.setImage("rogue/rrogue_" + rMove + ".png");
							playerSprite.setSize(xWidth, yHeight);
							System.out.println(rMove);
							rMove++;
						}

						else if (Protagonist.getCharacterType() == CharacterType.MAGE) {
							playerSprite.setImage("mage/rmage_" + rMove + ".png");
							playerSprite.setSize(xWidth, yHeight);
							System.out.println(rMove);
							rMove++;
						}
					}

					else if (checkContainment(Protagonist)) {
						Protagonist.setLocation(Protagonist.getRow(), Protagonist.getCol());
						playerSprite.setLocation(Protagonist.getCol() * xWidth, lastY);
					}
				}

				if (key == KeyEvent.VK_W) {
					if (checkBounds(playerSprite) && checkContainment(Protagonist)) {
						Map.getCurrentMap().moveCharacter(Protagonist, Protagonist.getLocation());
						playerSprite.move(0, -20);

						if (Protagonist.getCharacterType() == CharacterType.WARRIOR) {
							playerSprite.setImage("knight/rknight_" + rMove + ".png");
							playerSprite.setSize(xWidth, yHeight);
							System.out.println(rMove);
							rMove++;
						}

						else if (Protagonist.getCharacterType() == CharacterType.ROGUE) {
							playerSprite.setImage("rogue/rrogue_" + rMove + ".png");
							playerSprite.setSize(xWidth, yHeight);
							System.out.println(rMove);
							rMove++;
						}

						else if (Protagonist.getCharacterType() == CharacterType.MAGE) {
							playerSprite.setImage("mage/rmage_" + rMove + ".png");
							playerSprite.setSize(xWidth, yHeight);
							System.out.println(rMove);
							rMove++;
						}
					} 

					else if (checkContainment(Protagonist)) {
						Protagonist.setLocation(Protagonist.getRow(), Protagonist.getCol());
						playerSprite.setLocation(lastX, (Protagonist.getRow()) * yHeight);
					}
				}

				if (key == KeyEvent.VK_S) {
					if (checkBounds(playerSprite) && checkContainment(Protagonist)) {
						Map.getCurrentMap().moveCharacter(Protagonist, Protagonist.getLocation());
						playerSprite.move(0, 20);

						if (Protagonist.getCharacterType() == CharacterType.WARRIOR) {
							playerSprite.setImage("knight/lknight_" + lMove + ".png");
							playerSprite.setSize(xWidth, yHeight);
							System.out.println(lMove);
							lMove++;
						} else if (Protagonist.getCharacterType() == CharacterType.ROGUE) {
							playerSprite.setImage("rogue/lrogue_" + lMove + ".png");
							playerSprite.setSize(xWidth, yHeight);
							System.out.println(lMove);
							lMove++;
						} else if (Protagonist.getCharacterType() == CharacterType.MAGE) {
							playerSprite.setImage("mage/lmage_" + lMove + ".png");
							playerSprite.setSize(xWidth, yHeight);
							System.out.println(lMove);
							lMove++;
						}
					}

					else if (checkContainment(Protagonist)) {
						Protagonist.setLocation(Protagonist.getRow(), Protagonist.getCol());
						playerSprite.setLocation(lastX, (Protagonist.getRow()) * yHeight);
					}
				}
			}

			characterLocation(Protagonist);
			exitCheck(Protagonist.getLocation()); //Checks if Character is on exit space

		} else if(battling){

			if (key == KeyEvent.VK_1) {

				Battle.Fight(1, opponent, Protagonist);
				System.out.print("You chose attack \n");

				winCheck();

			}

			else if (key == KeyEvent.VK_2) {
				Battle.Fight(2, opponent, Protagonist);
				System.out.print("You chose block \n");
				winCheck();

			} 
			else if (key == KeyEvent.VK_3) {
				Battle.Fight(3, opponent, Protagonist);
				System.out.print("You chose screech \n");
				winCheck();
			}
		}

	}


	// New Code below this line//
	
	/*
	 * Stops all background music if any
	 * Sets the current playing audio to null
	 */
	private static void stopAllBackgroundMusic()
	{
		AudioPlayer ap = AudioPlayer.getInstance();
		// Stop All background music
		ap.stopSound(MUSIC_FOLDER, SOUND_BACKGROUND);
		ap.stopSound(MUSIC_FOLDER, SOUND_BACKGROUND_KING);
		ap.stopSound(MUSIC_FOLDER, SOUND_BATTLE);
		currentPlayingAudio = null;
	}
	
	/*
	 * Starts the given background music in a loop
	 * Stops the existing backgound music if any
	 */
	private static void startBackgroundMusic(String audioFile)
	{
		AudioPlayer ap = AudioPlayer.getInstance();
		// Stop current audio and start new audio
		if (currentPlayingAudio != null)
		{
			ap.stopSound(MUSIC_FOLDER, currentPlayingAudio);
		}
		// As this is background music, playForever in a loop
		ap.playSound(MUSIC_FOLDER, audioFile, true);
		// Save the audio file as the latest music file.
		currentPlayingAudio = audioFile;
	}

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
			playerSprite = new GImage("knight/rknight_0.png", Character.startSpace.getRow() * xWidth,
					Character.startSpace.getCol() * yHeight);
			playerSprite.setSize(xWidth, yHeight);
			playerSprite.sendToFront();
		} else if (p.getCharacterType() == CharacterType.ROGUE) {
			playerSprite = new GImage("rogue/rrogue_0.png", Character.startSpace.getRow() * xWidth,
					Character.startSpace.getCol() * yHeight);
			playerSprite.setSize(xWidth, yHeight);
		} else if (p.getCharacterType() == CharacterType.MAGE) {
			playerSprite = new GImage("mage/rmage_0.png", Character.startSpace.getRow() * xWidth,
					Character.startSpace.getCol() * yHeight);
			playerSprite.setSize(xWidth, yHeight);
		}

		// Actually implements the GImage!
		program.add(playerSprite);
	}

	private void drawCharacters(Map m) {
		GImage sprite = null;
		ListIterator<Character> iterator = Map.getCurrentMap().getCharactersOnMap().listIterator();

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
			else if (toAdd.cType == CharacterType.KING) {
				sprite = new GImage("kingTemp.png", toAdd.getCol() * xWidth, toAdd.getRow() * yHeight);
				sprite.setSize(xWidth, yHeight);
				sprite.sendToFront();
				program.add(sprite);
			}
			// Actually implements the GImage!
			program.add(sprite);
		}

	}

	private static void removeCharacter(Space s) {
		int x, y;
		x = (int) ((s.getCol() * xWidth));
		y = (int) ((s.getRow() * yHeight));

		System.out.printf("X pixel: %d\nY pixel: %d\n", x, y);

		GObject image = program.getElementAt(x, y);

		if(image != null) {
			program.remove(image);

			program.remove(program.getElementAt(x, y));
			System.out.println("Should have deleted a character");
		}

		else {
			System.out.println("No character to delete");
		}
	}

	private boolean checkContainment(Character c) {
		int row, col;
		row = c.getRow();
		col = c.getCol();

		if (row >= 0 && row < Map.getCurrentMap().getNumRows() && col >= 0 && col < Map.getCurrentMap().getNumCols()) {
			return true;
		}

		return false;
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

	private boolean exitCheck(Space s) {

		int row, col, eRow, eCol;
		row = s.getRow();
		col = s.getCol();
		eRow = Map.getCurrentMap().getExit().getRow();
		eCol = Map.getCurrentMap().getExit().getCol();

		if (row == eRow && col == eCol) {
			System.out.println("Character on exit!");

			nextMap(Map.getMap(Map.LEVEL_INTERMEDIATE));

			Overlay.showLevelUp(program);

			return true;
		}

		return false;
	}

	private void generateWorld() {
		// Initialize maps
		Map m1 = Map.getCurrentMap();
		/*
		world[0] = Map.getMap(Map.LEVEL_BEGINNER);
		world[1] = Map.getMap(Map.LEVEL_INTERMEDIATE);
		world[2] = Map.getMap(Map.LEVEL_ADVANCED);
		world[3] = Map.getMap(Map.LEVEL_FINAL);
		 */
	}

	private void drawLevel(Map m) {
		drawGridLines(m);
	}

	//Really only used for initial
	//generation of first map displayed
	private void loadMap(Map m) {
		drawLevel(m);
		drawPlayer(Protagonist);
		drawCharacters(m);

		//world[0].addPlayer (Protagonist);
		if (Map.getCurrentLevel() == Map.LEVEL_BEGINNER) {
			program.add(ground);                     //first if statement
			ground.sendToBack();
			

		}
		else if (Map.getCurrentLevel() == Map.LEVEL_INTERMEDIATE) {
			program.add(ground2);                    //second if statement
			ground2.sendToBack();

			
		}
		else if(Map.getCurrentLevel() == Map.LEVEL_ADVANCED) {
			program.add(ground3);                    //third if statement 
			ground3.sendToBack();
			
			
		}
		else if (Map.getCurrentLevel() == Map.LEVEL_FINAL){
			program.add(ground4);                    //fourth if statement 
			ground4.sendToBack();
			stopAllBackgroundMusic();
			startBackgroundMusic(SOUND_BACKGROUND_KING);	
		}

	}


	private void nextMap(Map m) {
		program.removeAll();

		Map.incrementLevel();

		loadMap(Map.getCurrentMap());
	}

	public Space convertXYToSpace(double x, double y) {
		int r = (int) (y / yHeight);
		int c = (int) (x / xWidth);

		Space square = new Space(r, c);
		System.out.printf("X pixel: %f\nY pixel: %f", (float) x, (float) y);
		System.out.printf("\nRow:%d Column:%d\n", square.getRow(), square.getCol());
		return square;
	}

	private float spaceWidth(Map m) {
		//m.getBoard();
		xWidth = (windowWidth) / Map.getCurrentMap().getNumRows();
		return xWidth;
	}

	private float spaceHeight(Map m) {
		//m.getBoard();
		yHeight = (windowHeight) / Map.getCurrentMap().getNumCols();
		return yHeight;
	}

	private void drawGridLines(Map m) {
		double total = 0;
		int j = 0;

		// horizontal grid lines
		while (total <= windowWidth) {
			double w = j * spaceWidth(m);
			total = total + spaceWidth(m);

			line = new GLine(w, 0, w, windowHeight - 2);
			program.add(line);
			line.setVisible(false);
			j++;
		}

		// vertical grid lines
		total = 0;
		j = 0;

		while (total <= windowHeight) {
			double h = j * spaceHeight(m);
			total = total + spaceHeight(m);

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

	public static void battleWin(MainApplication app) {



		if(Protagonist.getHealth() > 0 && opponent.getHealth() <= 0) {

			Protagonist.setBalance(Protagonist.getBalance() + opponent.getBalance());
			//removes chracter sprite

			removeCharacter(opponent.getLocation());
			//removeCharacter(opponent.getLocation());

			// removes the character from board
			Map.getCurrentMap().getBoard().removeCharacter(opponent.getLocation());


			// removes battle overlay
			Overlay.battleOver(app);
			// stopAllBackgroundMusic();
			startBackgroundMusic(SOUND_BACKGROUND);
			//audio.stopSound(MUSIC_FOLDER, SOUND_BATTLE);
			battling = false;

			Protagonist.setHealth(50);
			// creates labels and rects
			win = new GImage("images/winScreen.jpg");


			bal = new GLabel("Balance: " + Protagonist.getBalance(), 130, 200);
			bal.setFont(new Font("Comic Sans", 1, 20));
			bal.setColor(Color.white);

			labelW = new GLabel("YOU WIN!" , 80, 120);
			labelW.setFont(new Font("Comic Sans", 1, 50));
			labelW.setColor(Color.white);

			// adds labels and rects
			app.add(labelW);
			app.add(win);
			app.add(bal);
			labelW.sendToFront();
			bal.sendToFront();
			//counter for keyboard access
			winlose = 1;

		}
	}
	public static void battleLose(MainApplication app) {

		if(Protagonist.getHealth() <= 0 && opponent.getHealth() > 0) {

			Protagonist.setBalance(Protagonist.getBalance() - opponent.getBalance());

			//removes sprite
			removeCharacter(opponent.getLocation());
			//removeCharacter(opponent.getLocation());

			// removes character on board.
			Map.getCurrentMap().getBoard().removeCharacter(opponent.getLocation());


			// closes battle overlay
			Overlay.battleOver(app);
			// stopAllBackgroundMusic();
			startBackgroundMusic(SOUND_BACKGROUND);
			//audio.stopSound(MUSIC_FOLDER, SOUND_BATTLE);
			battling = false;

			Protagonist.setHealth(50);

			// all labels and shapes
			lose = new GImage("images/loseScreen.jpg");

			bal = new GLabel("Balance: " + Protagonist.getBalance(), 130, 200);
			bal.setFont(new Font("Comic Sans", 1, 20));
			bal.setColor(Color.white);

			labelL = new GLabel("YOU LOSE!" , 80, 120);
			labelL.setFont(new Font("Comic Sans", 1, 50));
			labelL.setColor(Color.white);

			// add them
			app.add(labelL);
			app.add(lose);
			app.add(bal);
			labelL.sendToFront();
			bal.sendToFront();


			// counter for keyboard access
			winlose = 2;

		}
	}

	public static void winCheck() {
		if(Protagonist.getHealth() > 0 && opponent.getHealth() <= 0) {
			battleWin(program);
		}
		else if(Protagonist.getHealth() <= 0 && opponent.getHealth() > 0) {
			battleLose(program);
		}
	}
	public static void removeWin(MainApplication app) {

		app.remove(labelW);
		app.remove(win);
		app.remove(bal);

		battling = false;

	}
	public static void removeLose(MainApplication app) {
		app.remove(labelL);
		app.remove(lose);
		app.remove(bal);

		battling = false;
	}
	public static void dialouge(NPC npc) {


		winlose = 3;

		textBox = new GImage("TextBox.png");
		program.add(textBox);

		talk = new GLabel("Hello I am a NPC", 50, 500);
		talk.setFont(new Font("Comic Sans", 1, 60));
		talk.setColor(Color.black);

		program.add(talk);
	}


	public static void removeDialouge(MainApplication program2) {

		program.remove(textBox);
		program.remove(talk);


	}


}
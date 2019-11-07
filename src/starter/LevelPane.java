package starter;

import acm.graphics.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class LevelPane extends GraphicsPane {
	private static final String BACKGROUND = "controlsImage.jpg";

	
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GButton play, controls, quit;
	private GImage background, controlsImage;
	private GLine line;
	private GRect square;
	private GLabel attack;
	
	//playerSprite Variables
	private GImage playerSprite;
	private int moveCount;
	private int escCount;
	
	private Battle battle;
	
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
		
		BattleScreen();
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
	
	public void BattleScreen() {
		background = new GImage("images/BattleStyle.png");
		program.add(background);
		attack = new GLabel("Attack", 10, 10);
		program.add(attack);
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
	}
	
	//New Code below this line//
	
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
	
	private Space convertXYToSpace(double x, double y) {
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
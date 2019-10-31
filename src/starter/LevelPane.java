package starter;

import acm.graphics.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class LevelPane extends GraphicsPane {
	private static final String BACKGROUND = "controlsImage.jpg";
	private static final String[] BLUEKNIGHT = 
		  { "knight/BlueKnight_entity_000_walk_000.png", 
			"knight/BlueKnight_entity_000_walk_001.png", 
			"knight/BlueKnight_entity_000_walk_002.png", 
			"knight/BlueKnight_entity_000_walk_003.png", 
			"knight/BlueKnight_entity_000_walk_004.png", 
			"knight/BlueKnight_entity_000_walk_005.png", 
			"knight/BlueKnight_entity_000_walk_006.png", 
			"knight/BlueKnight_entity_000_walk_007.png", 
			"knight/BlueKnight_entity_000_walk_008.png", 
			"knight/BlueKnight_entity_000_walk_009.png" };
	
	private static final String[] MAGE =
		{ "mage/walk_0.png", "mage/walk_1.png", "mage/walk_2.png", "mage/walk_3.png" };
	
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GButton back;
	private GImage background, warrior, rogue, mage, enemy, npc;
	private GLine line;
	
	//playerSprite Variables
	private GImage playerSprite;
	private double lastX, lastY, newX, newY;
	private Player p = new Player(1, 1, CharacterType.ROGUE);
	private int i;
	
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
		back = new GButton("Back", 0, 0, 25, 25);
		
		
		
		generateWorld();
		
		showContents();
	}

	@Override
	public void showContents() {
		program.add(back);
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
		if (obj == back) {
			back.setFillColor(Color.GRAY);
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == back) {
			back.setFillColor(Color.WHITE);
			hideContents();
			program.switchToMenu();
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {

	    int key = e.getKeyCode();

	    if (key == KeyEvent.VK_A) {
	        playerSprite.move(-5, 0);
	        
	        if(p.getCharacterType() == CharacterType.WARRIOR) {
	        	playerSprite.setImage("knight/BlueKnight_entity_000_walk_00" + i + ".png");
	        	playerSprite.setSize(xWidth, yHeight);
	        	System.out.println(i);
	        	i++;
	        	
		        if(i == 10) {
		        	i = 0;
		        }
	        }
	        
	        else if(p.getCharacterType() == CharacterType.ROGUE) {
	        	playerSprite.setImage("rogue/rogue_" + i + ".png");
	        	playerSprite.setSize(xWidth, yHeight);
	        	System.out.println(i);
	        	i++;
	        	
		        if(i == 8) 
		        	i = 0;
	        }
	        
	        else if(p.getCharacterType() == CharacterType.MAGE) {
	        	playerSprite.setImage("mage/mage_" + i + ".png");
	        	playerSprite.setSize(xWidth, yHeight);
	        	System.out.println(i);
	        	i++;
	        	
		        if(i == 8) 
		        	i = 0;
	        }
	    }

	    if (key == KeyEvent.VK_D) {
	        playerSprite.move(5, 0);
	        
	        if(p.getCharacterType() == CharacterType.WARRIOR) {
	        	playerSprite.setImage("knight/BlueKnight_entity_000_walk_00" + i + ".png");
	        	playerSprite.setSize(xWidth, yHeight);
	        	System.out.println(i);
	        	i++;
	        	
		        if(i == 10) {
		        	i = 0;
		        }
	        }
	        
	        else if(p.getCharacterType() == CharacterType.ROGUE) {
	        	playerSprite.setImage("rogue/rogue_" + i + ".png");
	        	playerSprite.setSize(xWidth, yHeight);
	        	System.out.println(i);
	        	i++;
	        	
		        if(i == 8) 
		        	i = 0;
	        }
	        
	        else if(p.getCharacterType() == CharacterType.MAGE) {
	        	playerSprite.setImage("mage/mage_" + i + ".png");
	        	playerSprite.setSize(xWidth, yHeight);
	        	System.out.println(i);
	        	i++;
	        	
		        if(i == 8) 
		        	i = 0;
	        }
	    }

	    if (key == KeyEvent.VK_W) {
	        playerSprite.move(0, -5);
	        
	        if(p.getCharacterType() == CharacterType.WARRIOR) {
	        	playerSprite.setImage("knight/BlueKnight_entity_000_walk_00" + i + ".png");
	        	playerSprite.setSize(xWidth, yHeight);
	        	System.out.println(i);
	        	i++;
	        	
		        if(i == 10) {
		        	i = 0;
		        }
	        }
	        
	        else if(p.getCharacterType() == CharacterType.ROGUE) {
	        	playerSprite.setImage("rogue/rogue_" + i + ".png");
	        	playerSprite.setSize(xWidth, yHeight);
	        	System.out.println(i);
	        	i++;
	        	
		        if(i == 8) 
		        	i = 0;
	        }
	        
	        else if(p.getCharacterType() == CharacterType.MAGE) {
	        	playerSprite.setImage("mage/mage_" + i + ".png");
	        	playerSprite.setSize(xWidth, yHeight);
	        	System.out.println(i);
	        	i++;
	        	
		        if(i == 8) 
		        	i = 0;
	        }
	    }

	    if (key == KeyEvent.VK_S) {
	        playerSprite.move(0, 5);
	        
	        if(p.getCharacterType() == CharacterType.WARRIOR) {
	        	playerSprite.setImage("knight/BlueKnight_entity_000_walk_00" + i + ".png");
	        	playerSprite.setSize(xWidth, yHeight);
	        	System.out.println(i);
	        	i++;
	        	
		        if(i == 10) {
		        	i = 0;
		        }
	        }
	        
	        else if(p.getCharacterType() == CharacterType.ROGUE) {
	        	playerSprite.setImage("rogue/rogue_" + i + ".png");
	        	playerSprite.setSize(xWidth, yHeight);
	        	System.out.println(i);
	        	i++;
	        	
		        if(i == 8) 
		        	i = 0;
	        }
	        
	        else if(p.getCharacterType() == CharacterType.MAGE) {
	        	playerSprite.setImage("mage/mage_" + i + ".png");
	        	playerSprite.setSize(xWidth, yHeight);
	        	System.out.println(i);
	        	i++;
	        	
		        if(i == 8) 
		        	i = 0;
	        }
	    }
	}
	
	//New Code below this line//
	
	private void drawPlayer(Player p) {
		// TODO implement drawCar
			if(p.getCharacterType() == CharacterType.WARRIOR) {
				playerSprite =  new GImage(BLUEKNIGHT[0], p.startSpace.getRow() * xWidth, p.startSpace.getCol() * yHeight);
				lastX = playerSprite.getX();
				lastY = playerSprite.getY();
				playerSprite.setSize(xWidth, yHeight);
				playerSprite.sendToFront();
			}
			else if(p.getCharacterType() == CharacterType.ROGUE) {
				playerSprite =  new GImage("rogue/rogue_0.png", p.startSpace.getRow() * xWidth, p.startSpace.getCol() * yHeight);
				lastX = playerSprite.getX();
				lastY = playerSprite.getY();
				playerSprite.setSize(xWidth, yHeight);
			}
			else if(p.getCharacterType() == CharacterType.MAGE) {
				playerSprite =  new GImage("mage/mage_0.png", p.startSpace.getRow() * xWidth, p.startSpace.getCol() * yHeight);
				lastX = playerSprite.getX();
				lastY = playerSprite.getY();
				playerSprite.setSize(xWidth, yHeight);
			}
			
		//Actually implements the GImage!
		program.add(playerSprite);
		//player.sendBackward();
	}
	
	private void generateWorld() {
		world[0] = new Map(6, 6);
		world[1] = new Map(10, 10);
		world[2] = new Map(15, 15);
	}

	private void drawLevel(Map m) {
		drawGridLines(m);
		//drawWinningTile();
		//drawCars();
	}
	
	private void loadMap(Map m) {
		drawLevel(m);
		current = m;
		
		drawPlayer(p);
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
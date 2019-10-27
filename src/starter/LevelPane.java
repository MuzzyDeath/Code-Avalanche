package starter;

import acm.graphics.*;
import java.awt.Color;
import java.awt.event.MouseEvent;

public class LevelPane extends GraphicsPane {
	private static final String BACKGROUND = "controlsImage.jpg";
	
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GButton back;
	private GImage background;
	private GLine line;
	private GLabel warrior, rogue, mage, enemy, npc;
	
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
		loadMap(world[1]);
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
	
	//New Code below this line//
	
	private void drawPlayer(Player p) {
		// TODO implement drawCar
		GObject player =  new GImage("warrior_f_walk.gif", 80, 80);
		
			if(p.getCharacterType() == CharacterType.WARRIOR) {
				//player = new GLabel("W", 80, 80);
				program.add(player);
				player.sendToFront();
			}
			else if(p.getCharacterType() == CharacterType.ROGUE) {
				//player = new GImage("auto_vert.png", (v.getStart().getCol() * spaceWidth()), (v.getStart().getRow() * spaceHeight()));
			}
			else if(p.getCharacterType() == CharacterType.MAGE) {
				//player = new GImage("truck_vert.png", (v.getStart().getCol() * spaceWidth()), (v.getStart().getRow() * spaceHeight()));
			}
			
		//Actually implements the GImage!
		program.add(player);
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
		
		Player test = new Player(3, 3);
		drawPlayer(test);
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
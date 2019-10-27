package starter;

import acm.graphics.*;
import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GObject;

public class LevelPane extends GraphicsPane {
	private static final String BACKGROUND = "controlsImage.jpg";
	
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GButton back;
	private GImage background;
	private GLine line;
	
	private Map map1, map2, map3;
	private Map[] world = { map1, map2, map3 };
	
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
		drawLevel(world[0]);
	}

	@Override
	public void hideContents() {
		program.removeAll();
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
			program.switchToMenu();
		}
	}
	
	//New Code below this line//
	private void generateWorld() {
		world[0] = new Map(5, 5);
		world[1] = new Map(10, 10);
		world[2] = new Map(8, 8);
	}

	private void drawLevel(Map m) {
		drawGridLines(m);
		//drawWinningTile();
		//drawCars();
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
		//horizontal grid lines
		for(int i = 1; i <= m.getColumns(); ++i) {
			double w = i * spaceHeight(m);
			
			line = new GLine(w, 0, w, windowHeight-2);
			program.add(line);
		}
		
		//vertical grid lines
		for(int i = 1; i <= m.getRows(); ++i) {
			double h = i * spaceWidth(m);
			
			line = new GLine(0, h, windowWidth-2, h);
			program.add(line);
		}
	}
}
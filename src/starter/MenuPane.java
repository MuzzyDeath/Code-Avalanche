package starter;

import acm.graphics.GImage;
import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GObject;

public class MenuPane extends GraphicsPane {
	private static final String BACKGROUND = "menuImage.jpg";
	
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	
	private GButton newGame, controls, quit;
	private GImage background;
	
	private int windowHeight = program.WINDOW_HEIGHT;
	private int windowWidth = program.WINDOW_WIDTH;

	public MenuPane(MainApplication app) {
		super();
		program = app;
		background = new GImage(BACKGROUND);
		newGame = new GButton("New Game", windowWidth/3, 200, 300, 75);
		controls = new GButton("Controls", windowWidth/3, 300, 300, 75);
		quit = new GButton("Quit", windowWidth/3 , 400, 300, 75);
		
		newGame.setFillColor(Color.WHITE);
		controls.setFillColor(Color.WHITE);
		quit.setFillColor(Color.WHITE);
		
		showContents();
	}

	@Override
	public void showContents() {
		program.add(background);
		program.add(newGame);
		program.add(controls);
		program.add(quit);
	}

	@Override
	public void hideContents() {
		program.removeAll();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == newGame) {
			newGame.setFillColor(Color.GRAY);
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
		if (obj == newGame) {
			newGame.setFillColor(Color.WHITE);
			program.switchToCharacterPane();
		}
		else if (obj == controls) {
			System.out.println("Print controls");
			controls.setFillColor(Color.WHITE);
			
		}
		else if (obj == quit) {
			System.out.println("Quit Game");
			quit.setFillColor(Color.WHITE);
			System.exit(0);
		}
	}
}

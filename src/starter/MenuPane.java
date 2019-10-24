package starter;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GObject;

public class MenuPane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	
	private GButton newGame, controls, quit;
	
	private int windowHeight = program.WINDOW_HEIGHT;
	private int windowWidth = program.WINDOW_WIDTH;

	public MenuPane(MainApplication app) {
		super();
		program = app;
		newGame = new GButton("New Game", windowWidth/3, 200, 300, 75);
		controls = new GButton("Controls", windowWidth/3, 300, 300, 75);
		quit = new GButton("Quit", windowWidth/3 , 400, 300, 75);
		showContents();
	}

	@Override
	public void showContents() {
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
			//Player user = new Player(Player.startSpace.getRow(), Player.startSpace.getCol());
			hideContents();
			program.switchToCharacterPane();
		}
		else if (obj == controls) {
			hideContents();
			System.out.println("Print controls");
			
		}
		else if (obj == quit) {
			System.out.println("Quit Game");
			System.exit(0);
		}
	}
}

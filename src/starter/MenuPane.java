package starter;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GObject;

public class MenuPane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GButton rect;
	private GButton newGame, controls, quit;

	public MenuPane(MainApplication app) {
		super();
		program = app;
		newGame = new GButton("New Game", 200, 200, 200, 75);
		controls = new GButton("Controls", 200, 300, 200, 75);
		quit = new GButton("Quit", 200 , 400, 200, 75);
	}

	@Override
	public void showContents() {
		program.add(newGame);
		program.add(controls);
		program.add(quit);
	}

	@Override
	public void hideContents() {
		program.remove(newGame);
		program.remove(controls);
		program.remove(quit);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == newGame) {
			Player user = new Player(Player.startSpace.getRow(), Player.startSpace.getCol());
		}
		else if (obj == controls) {
			System.out.println("Print controls");
		}
		else if (obj == quit) {
			System.out.println("Quit Game");
			System.exit(0);
		}
	}
}

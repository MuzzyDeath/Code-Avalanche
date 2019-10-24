package starter;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GObject;

public class CharacterPane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GButton warrior, rogue, mage, back;
	
	private int windowHeight = program.WINDOW_HEIGHT;
	private int windowWidth = program.WINDOW_WIDTH;

	public CharacterPane(MainApplication app) {
		super();
		program = app;
		warrior = new GButton("Warrior", (windowWidth * .99), windowHeight/3, 200, 400);
		rogue = new GButton("Rogue", (windowWidth * .66), windowHeight/3, 200, 400);
		mage = new GButton("Mage", (windowWidth * .33), windowHeight/3, 200, 400);
		back = new GButton("Back", 0, 0, 25, 25);
	}

	@Override
	public void showContents() {
		program.add(warrior);
		program.add(rogue);
		program.add(mage);
		program.add(back);
	}

	@Override
	public void hideContents() {
		program.removeAll();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == warrior) {
			System.out.println("Selected Warrior!");
		}
		else if (obj == rogue) {
			System.out.println("Selected Rogue!");
		}
		else if (obj == mage) {
			System.out.println("Selected Mage");
		}
		else if (obj == back) {
			program.switchToMenu();
		}
	}
}

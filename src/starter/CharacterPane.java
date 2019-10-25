package starter;

import java.awt.Color;
import java.awt.event.MouseEvent;
import acm.graphics.*;

public class CharacterPane extends GraphicsPane {
	private static final String BACKGROUND = "characterSelection.jpg";
	
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GButton warrior, rogue, mage, back;
	private GImage background;
	
	private Player user;
	
	private int windowHeight = program.WINDOW_HEIGHT;
	private int windowWidth = program.WINDOW_WIDTH;

	public CharacterPane(MainApplication app) {
		super();
		program = app;
		
		int width = windowWidth/3;
		
		background = new GImage(BACKGROUND);
		warrior = new GButton("Warrior", windowWidth - (windowWidth * .99), windowHeight/6, width - 10, 400);
		rogue = new GButton("Rogue", (windowWidth * .33) + 10, windowHeight/6, width - 10, 400);
		mage = new GButton("Mage", (windowWidth * .66) + 10, windowHeight/6, width - 10, 400);
		back = new GButton("Back", 0, 0, 25, 25);
		
	}

	@Override
	public void showContents() {
		program.add(background);
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
			warrior.setFillColor(Color.GRAY);
		}
		else if (obj == rogue) {
			rogue.setFillColor(Color.GRAY);
		}
		else if (obj == mage) {
			mage.setFillColor(Color.GRAY);
		}
		else if (obj == back) {
			back.setFillColor(Color.GRAY);
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == warrior) {
			warrior.setFillColor(Color.WHITE);
			System.out.println("Selected Warrior!");
			user = new Player(Character.startSpace.getRow(), Character.startSpace.getCol());
			user.cType = CharacterType.WARRIOR;
		}
		else if (obj == rogue) {
			rogue.setFillColor(Color.WHITE);
			System.out.println("Selected Rogue!");
			user = new Player(Character.startSpace.getRow(), Character.startSpace.getCol());
			user.cType = CharacterType.ROGUE;
		}
		else if (obj == mage) {
			mage.setFillColor(Color.WHITE);
			System.out.println("Selected Mage!");
			user = new Player(Character.startSpace.getRow(), Character.startSpace.getCol());
			user.cType = CharacterType.MAGE;
		}
		else if (obj == back) {
			back.setFillColor(Color.WHITE);
			program.switchToMenu();
		}
	}
}

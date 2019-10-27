package starter;

import acm.graphics.GImage;
import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GObject;

public class ControlPane extends GraphicsPane {
	private static final String BACKGROUND = "controlsImage.jpg";
	
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GButton back;
	private GImage background;
	
	private int windowHeight = program.WINDOW_HEIGHT;
	private int windowWidth = program.WINDOW_WIDTH;

	public ControlPane(MainApplication app) {
		super();
		program = app;
		background = new GImage(BACKGROUND);
		back = new GButton("Back", 0, 0, 25, 25);
		
		showContents();
	}

	@Override
	public void showContents() {
		program.add(background);
		program.add(back);
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
			hideContents();
			program.switchToMenu();
		}
	}
}

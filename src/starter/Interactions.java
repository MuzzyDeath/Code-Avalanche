package starter;

import java.net.URL;
import java.util.ArrayList;

import acm.graphics.*;
import acm.program.GraphicsProgram;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Interactions {

	public int getDistance(Character a, Character b) {
		int col = Math.abs(a.getLocation().getCol() - b.getLocation().getCol());
		int row = Math.abs(a.getLocation().getRow() - b.getLocation().getRow());
		return col + row;
	}

	public void keyPressed(KeyEvent e, ArrayList<Character> c, NPC npc, int s) {
		int key = 0;
		if (e != null) {
			key = e.getKeyCode();
		}
		if (e == null || key == KeyEvent.VK_E) {
			int player = -1;
			int closest = -1;
			int distance = 0;
			for (int i = 0; i < c.size(); i++) {
				if (c.get(i).isPlayer()) {
					player = i;
					break;
				}

			}
			if (player == -1) {
				System.out.println("Error. Player was not found.");
				return;
			}
			for (int i = 0; i < c.size(); i++) {
				if (i == player) {
					continue;
				}
				int newDistance = getDistance(c.get(player), c.get(i));
				if (closest == -1 || newDistance < distance) {
					distance = newDistance;
					closest = i;
				}
			}
			if (closest == -1) {
				return;
			}
			Character cL = c.get(closest);
			URL url = null;
			if (cL.isKing() == true) {
				url = Narrative.class.getClassLoader().getResource("King");
			} else if (cL.isHostile() == true) {
				url = Narrative.class.getClassLoader().getResource("Enemy");
			} else {
				url = Narrative.class.getClassLoader().getResource("NPC");
			}
			try {
				//System.out.println(url.getPath());
				BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
				String line;
				while ((line = in.readLine()) != null) {
					System.out.println(line);
				}
				in.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("Unable to open file: " + url.getPath());
			} catch (NullPointerException e1) {
				System.out.println("Unable To Load Resource");
			}
		}
	}

	public static void main(String[] args) {
		Interactions i = new Interactions();
		ArrayList<Character> c = new ArrayList<Character>();
		Character r = new Player(2, 2, CharacterType.MAGE);
		c.add(r);
		r = new Character(3, 3, CharacterType.ENEMY);
		c.add(r);
		r = new Character(1, 1, CharacterType.ENEMY);
		NPC npc = new NPC(5, 5);
		i.keyPressed(null, c, npc, 0);
	}
}

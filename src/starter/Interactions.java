package starter;

public class Interactions {

	public void keyPressed(KeyEvent e, Character c, NPC npc, int s) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_E && ((Math.abs(c.getLocation().getRow() - npc.getLocation().getRow()) == 1) || 
				(Math.abs(c.getLocation().getCol() - npc.getLocation().getCol()) == 1))) {

			if(c.isHostile() == true) {

				URL url = Narrative.class.getClassLoader().getResource("Enemy.txt");
				System.out.println(url.getPath());
			}

			// files for if the character is not hostile (dialogue characters)
			else if(c.isHostile() == false) {

				URL url = Narrative.class.getClassLoader().getResource("NPC.txt");
				System.out.println(url.getPath());
			}

			//files for if the character is the king
			else if(c.isKing() == true) {

				URL url = Narrative.class.getClassLoader().getResource("King.txt");
				System.out.println(url.getPath());
			}


			// file for if the character is the player
			else if(c.isPlayer == true) {
				URL url = Narrative.class.getClassLoader().getResource("Player.txt");
				System.out.println(url.getPath());
			}
		}
	}
}
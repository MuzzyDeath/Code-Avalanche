package starter;

public class LevelUp {
	
	private static int stat;


	public static int getStat() {
		return stat;
	}

	public static void setStat(int stat) {
		LevelUp.stat = stat;
	}
	
	public static void setNewStat(Player c, int which, int s) {
		
		// 1 = strength
		// 2 = charisma
		// 3 = agility
		// 4 = defense
		if(which == 1) {
			int temp = c.getStrength();
			c.setStrength(temp + s);
		}
		else if(which == 2) {
			int temp = c.getCharisma();
			c.setCharisma(temp + s);
		}
		else if(which == 3) {
			int temp = c.getAgility();
			c.setAgility(temp + s);
		}
		else if(which == 4) {
			int temp = c.getStrength();
			c.setDefense(temp + s);
		}
		
	}

}

package starter;

public class Battle {
	private Player c;
	private Enemy e;
	private int eHealth;
	private int cHealth;
	private int eStrength;
	private int cStrength;
	private int eDefense;
	private int cDefense;
	private int eCharisma;
	private int cCharisma;
	private int eMove;
	
	public Battle(Enemy e, Player c)
	{
		eHealth = e.getHealth();
		cHealth = c.getHealth();
		eStrength = e.getStrength();
		cStrength = c.getStrength();
		eDefense = e.getDefense();
		cDefense = c.getDefense();
		eCharisma = e.getCharisma();
		cCharisma = c.getCharisma();
		
		
		// have statements to get what the user wants to do (Attack, defend, screech)
		attack(eHealth, cHealth, x, y, z); // pass the stats to attack if the player chooses attack.
		// call enemy move which will generate a random number to pass into attack for what move the enemy does
		
		// i can have the Attack, defend, and screech methods take the health away
		// this would continue until someone's health reaches 0
		
	}
	public int enemyMove() {
		return eMove;
	}
	
	// attack will get passed both Healths, players Strength, The enemys stat based on their move
	public int attack(int eH, int cH, int cS, int eStat, int enemyMove) {
		if() {
			// enemy attacks
		}
		else if() {
			// enemy screech
		}
		else {
			// enemy blocks
		}
			
	}
	
	public int defend() {
		if() {
			// enemy attacks
		}
		else if() {
			// enemy screech
		}
		else {
			// enemy blocks
		}
	}
	
	public int screech() {
		
		if() {
			// enemy attacks
		}
		else if() {
			// enemy screech
		}
		else {
			// enemy blocks
		}
	}
	
	public int checkSkill() {
		
	}
	
	public String toString() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Character c = new Character(0, 1, CharacterType.WARRIOR);
		Battle b = new Battle(20, c);
		b.attack();
		b.defend();
		b.checkSkill();
		b.run();
		System.out.println(b.toString());

	}

}

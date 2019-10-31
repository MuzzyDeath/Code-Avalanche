package starter;

public class Battle {
	private int attackPoints;
	private int defendPoints;
	private int skillCheck;
	private Character character;
	
	public Battle(int attackPoints, int defendPoints, int skillCheck, Character c)
	{
		this.attackPoints = attackPoints;
		this.defendPoints = defendPoints;
		this.skillCheck = skillCheck;
		this.character = character;
	}
	public int attack()
	{
		attackPoints += 10;
		return attackPoints;
	}
	
	public int defend()
	{
		defendPoints += 5;
		return defendPoints;
	}
	
	public int checkSkill()
	{
		if(attackPoints > 30 && attackPoints > defendPoints)
		{
			skillCheck += 100;
		}
		return skillCheck;
	}
	
	public boolean run()
	{
		if(attackPoints > defendPoints)
		{
			return true;
		}
		return false;
	}
	
	public String toString()
	{
		return "Attack Points: " + attackPoints + ", defend Points: " + defendPoints + ", skill Check: " + skillCheck;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Character c = new Character(0, 1, CharacterType.WARRIOR);
		Battle b = new Battle(20, 30, 40, c);
		b.attack();
		b.defend();
		b.checkSkill();
		b.run();
		System.out.println(b.toString());

	}

}

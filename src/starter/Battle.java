package starter;

public class Battle {
	private int attackPoints;
	private int defendPoints;
	private int skillCheck;
	private Character character;
	
	public Battle(int attackPoints, Character character)
	{
		this.attackPoints = attackPoints;
		defendPoints = character.getDefense();
		skillCheck = character.getAgility();
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
		Battle b = new Battle(20, c);
		b.attack();
		b.defend();
		b.checkSkill();
		b.run();
		System.out.println(b.toString());

	}

}

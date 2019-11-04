package starter;
import java.util.Random;
import java.util.Scanner; 

public class Battle {
	private Player c;
	private Enemy e;


	public Battle(Enemy e, Player c)
	{
		
		
		System.out.println("You are in battle!");


		do{
			System.out.println("Which move will you do: \n1) Attack \n2) Block \n3) Screech");
			Scanner input = new Scanner(System.in);
			int whichMove = input.nextInt();
			
			if(whichMove == 1) {
				attack(c, e, enemyMove());
			}
			else if(whichMove == 2) {
				block(c, e, enemyMove());
			}
			else {
				screech(c, e, enemyMove());
			}
			
			System.out.println("Your Health: " + c.getHealth() + " \nEnemy Health: " + e.getHealth() + "\n");
			
			
		}while(e.getHealth() > 0 && c.getHealth() > 0);
		
		if(c.getHealth() <= 0) {
			System.out.println("You lose!");
			
			c.setBalance(c.getBalance() - 100);
		}
		else {
			System.out.println("You win!");
			
			c.setBalance(c.getBalance() + e.getBalance());
		}
		
		// have statements to get what the user wants to do (Attack, defend, screech)
		//attack(eHealth, cHealth, x, y, z); // pass the stats to attack if the player chooses attack.
		// call enemy move which will generate a random number to pass into attack for what move the enemy does

		// i can have the Attack, defend, and screech methods take the health away
		// this would continue until someone's health reaches 0

	}
	public int enemyMove() {

		Random rand = new Random(); 

		int move = rand.nextInt(3); 

		System.out.println(move);

		return move;
	}

	// attack will get passed both Healths, players Strength, The enemys stat based on their move
	public void attack(Player c, Enemy e, int enemyMove) {

		if(enemyMove == 0) { // enemy attack
			if(c.getStrength() > e.getStrength()) { // if player is > enemy

				e.setHealth(e.getHealth() -2);
				
				System.out.println("Your attack was higher so you hurt him");


			}
			else { //if enemy > player

				c.setHealth(c.getHealth() - 2);
				System.out.println("Your attack was lower so he hurt you");


			}
		}
		else if(enemyMove == 1) { // enemy screech

			e.setHealth(e.getHealth() -2);
			System.out.println("He Screeched so your attack hit him!");

		}
		else if(enemyMove == 2){
			System.out.println("He blocked your attack");
		}


	}

	public void block(Player c, Enemy e, int enemyMove) {

		if(enemyMove == 0) { // enemy attack

			System.out.println("You blocked his attack");

		}
		else if(enemyMove == 1) { // enemy screech

			c.setHealth(c.getHealth() - 1);

			System.out.println("He Screeched so you took damage");

		}
		else if(enemyMove == 2){ // enemy defends

			System.out.println("You both defended, nothing happened");
		}


	}

	public void screech(Player c, Enemy e, int enemyMove) {

		if(enemyMove == 0) { // enemy attack
			
			c.setHealth(c.getHealth() - 2);
			System.out.println("He attacked so you took damage");

		}
		else if(enemyMove == 1) { // enemy screech

			System.out.println("you both screeched");

		}
		else if(enemyMove == 2){ // enemy block
			
			e.setHealth(e.getHealth() - 1);
			System.out.println("He defended and your screech got in his head.");
		}


	}

	public boolean checkSkill(Player c, Enemy e) {
		return true;
	}

	public static void main(String[] args) {
		
		Player c = new Player(0, 1, CharacterType.WARRIOR);
		Enemy e = new Enemy(1,2);
		e.setHealth(10);
		c.setHealth(10);
		
		Battle b = new Battle(e, c);


	}

}

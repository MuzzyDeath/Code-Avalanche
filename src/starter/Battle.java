package starter;
import java.util.Random;

import java.util.Scanner;

import acm.graphics.*;
import acm.program.GraphicsProgram;

import java.awt.Image;


public class Battle extends GraphicsProgram {
	
	private static final String BACKGROUND = "BattleStyle.png";
	private GImage background;
	private GLabel attack;
	private GLabel block;
	private GLabel screech;
	 
	private Player c;
	private Enemy e;

	// higher defense and screech doesn't affect
	// if strength 

	public Battle(Enemy e, Player c)
	{


		//System.out.println("You are in battle!");
		BattleScreen();


//		do{
//			System.out.println("Which move will you do: \n1) Attack \n2) Block \n3) Screech");
//			Scanner input = new Scanner(System.in);
//			int whichMove = input.nextInt();
//
//			if(whichMove == 1) {
//				attack(c, e, enemyMove());
//			}
//			else if(whichMove == 2) {
//				block(c, e, enemyMove());
//			}
//			else {
//				screech(c, e, enemyMove());
//			}
//
//			System.out.println("Your Health: " + c.getHealth() + " \nEnemy Health: " + e.getHealth() + "\n");
//
//
//		}while(e.getHealth() > 0 && c.getHealth() > 0);
//
//		if(c.getHealth() <= 0) {
//			System.out.println("You lose!");
//
//			c.setBalance(c.getBalance() - 100);
//		}
//		else {
//			System.out.println("You win!");
//
//			c.setBalance(c.getBalance() + e.getBalance());
//		}



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
	
	public void BattleScreen() {
		background = new GImage(BACKGROUND);
		add(background);
		attack = new GLabel("Attack", 10, 10);
		add(attack);
		
	}

	
	public static void main(String[] args) {

		Player c = new Player(0, 1, CharacterType.MAGE);
		Enemy e = new Enemy(1,2);
		e.setHealth(10);
		c.setHealth(10);
		
	
		Battle b = new Battle(e, c);
		// b.BattleScreen();


	}

}

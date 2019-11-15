package starter;
import java.util.Random;

import java.util.Scanner;

import acm.graphics.*;
import acm.program.GraphicsProgram;

import java.awt.Image;


public class Battle extends GraphicsProgram {

	// instance variables for health and at end of battle set protag and opponents health to it, then reprint glabel
	private Player c;
	private Enemy e;

	public static GLabel eHealth, cHealth;
	// higher defense and screech doesn't affect
	// if strength 

	public Battle() {

		// default constructor
	}


	public static void Fight(int userMove, Enemy e, Player c) {

		//System.out.println("You are in battle!");

		// make new GLAbel with temps
		
		if(c.getHealth() > 0 && e.getHealth() > 0) {
			if(userMove == 1) {
				attack(c, e, enemyMove());
			}
			else if(userMove == 2) {
				block(c, e, enemyMove());
			}
			else {
				screech(c, e, enemyMove());
			}
			
			MainApplication.user.setHealth(c.getHealth());
			
			Overlay.cHealth.setLabel("Health: " + MainApplication.user.getHealth());
			Overlay.eHealth.setLabel("Health: " + e.getHealth());
			
			
			System.out.println("Your Health: " + c.getHealth() + " \nEnemy Health: " + e.getHealth() + "\n");

		}
		else {
			System.out.println("You or the enemy are out of health");

		}

	}
	public static int enemyMove() {

		Random rand = new Random(); 

		int move = rand.nextInt(3); 

		System.out.println(move);

		return move;
	}

	// attack will get passed both Healths, players Strength, The enemys stat based on their move

	public static void attack(Player c, Enemy e, int enemyMove) {

		if(enemyMove == 0) { // enemy attack

			if(c.getStrength() > e.getStrength()) { // if player is > enemy

				e.setHealth(e.getHealth() - 2);
				// .set("");

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

		if(c.getHealth() < 0 && e.getHealth() > 0) {

			System.out.println("You lose!");

			c.setBalance(c.getBalance() - 100);

			c.setHealth(0);

		}
		else if(c.getHealth() > 0 && e.getHealth() < 0) {

			System.out.println("You win!");

			c.setBalance(c.getBalance() + e.getBalance());

			e.setHealth(0);
		}


	}

	public static void block(Player c, Enemy e, int enemyMove) {

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

		if(c.getHealth() < 0 && e.getHealth() > 0) {

			System.out.println("You lose!");

			c.setBalance(c.getBalance() - 100);

			c.setHealth(0);

		}
		else if(c.getHealth() > 0 && e.getHealth() < 0) {

			System.out.println("You win!");

			c.setBalance(c.getBalance() + e.getBalance());

			e.setHealth(0);
		}


	}

	public static void screech(Player c, Enemy e, int enemyMove) {

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


		if(c.getHealth() < 0 && e.getHealth() > 0) {

			System.out.println("You lose!");

			c.setBalance(c.getBalance() - 100);

			c.setHealth(0);

		}
		else if(c.getHealth() > 0 && e.getHealth() < 0) {

			System.out.println("You win!");

			c.setBalance(c.getBalance() + e.getBalance());

			e.setHealth(0);
		}


	}

	public boolean checkSkill(Player c, Enemy e) {
		return true;
	}

	public void BattleScreen() {

	}	


	//	public static void main(String[] args) {
	//
	//		Player c = new Player(0, 1);
	//		c.cType = CharacterType.MAGE;
	//		Enemy e = new Enemy(1,2);
	//		e.setHealth(10);
	//		c.setHealth(10);
	//		
	//	
	//		Battle b = new Battle();
	//		b.Fight(1, e, c);
	//
	//	}


}

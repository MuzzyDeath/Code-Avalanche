package starter;

import java.util.Scanner;

public class LevelUp {
	
	private static int points;
	private static int level;

	public static int getPoints() {
		return points;
	}

	public static void setPoints(int points) {
		LevelUp.points = points;
	}
	public static int getLevel() {
		return level;
	}
	public static void setLevel(int level) {
		LevelUp.level = level;
	}

	public static void setNewStats(Player c, int total) {
		
		// 1 = strength
		// 2 = charisma
		// 3 = agility
		// 4 = defense
	
		System.out.println("Which stat would you like to increase: \n1) strength \n2) Charisma \n3) Agility \n4) Defense");
		
		Scanner input = new Scanner(System.in);
		int whichStat = input.nextInt();
		
		points = 2;
		
		if(whichStat > 4 || whichStat < 0) {
			
			System.out.println("Invalid input. Input must be 1, 2, 3, or 4.");
			
		}
		else {
			for(int i = total - 1; i >= 0; --i) {
				
				System.out.println("Which stat would you like to increase: \n1) strength \n2) Charisma \n3) Agility \n4) Defense");
				whichStat = input.nextInt();
				
				if(whichStat == 1 && total > 0) {
					int temp = c.getStrength();
					c.setStrength(temp + 1);
					System.out.println("Added one strength.");
					System.out.println("Total left: " + points);
					--points;
				}
				else if(whichStat == 2 && total > 0) {
					int temp = c.getCharisma();
					c.setCharisma(temp + 1);
					System.out.println("Added one Charisma.");
					System.out.println("Total left: " + points);
					--points;
				}
				else if(whichStat == 3 && total > 0) {
					int temp = c.getAgility();
					c.setAgility(temp + 1);
					System.out.println("Added one Agility.");
					System.out.println("Total left: " + points);
					--points;
				}
				else if(whichStat == 4 && total > 0) {
					int temp = c.getDefense();
					c.setDefense(temp + 1);
					System.out.println("Added one Defense.");
					System.out.println("Total left: " + points);
					--points;
				}
			}
		}
		System.out.println("\n----------Your new stats----------");
		c.printCharacter();

	}
}
			

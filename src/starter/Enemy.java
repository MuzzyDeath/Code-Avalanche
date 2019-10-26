package starter;

public class Enemy extends Character {

	public Enemy(int row, int col) {
		super(row, col);
		// TODO Auto-generated constructor stub
		makeEnemy(row, col, 3, 3, 3, 3, 50);
	}
	
//Make an enemy
	public void makeEnemy(int row, int col, int s, int c, int a, int d, int h) {
		this.setHostile();
		this.setLocation(row, col);
		
		this.setStrength(s);
		this.setCharisma(c);
		this.setAgility(a);
		this.setDefense(d);
		this.setHealth(h);
	}

//Set what the king's stats should be here!
	public void makeKing() {
		this.isKing();
		this.setHostile();
		this.setStrength(10);
		this.setCharisma(10);
		this.setAgility(10);
		this.setDefense(10);
		this.setHealth(150);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package starter;
import java.awt.Color;
import java.util.*;
import java.util.ArrayList;

import acm.graphics.GLine;

/**
 * COMP 55: Application Development final Project
 *  @author Nitin Pinnamaneni & Greg Jewell
 */

public class Board {
	private static Character[][] board; // 2D array of characters
	private static ArrayList<Character> characters; // holds all the characters on the board

	private static int rows, cols;

	public static Enemy temp;

	/**
	 * Constructor for the board which sets up an empty grid of size rows by columns
	 * Use the first array index as the rows and the second index as the columns
	 * 
	 * @param rows number of rows on the board
	 * @param cols number of columns on the board
	 */
	public Board(int r, int c) {

		System.out.println("Generating board!");

		rows = r;
		cols = c;

		// Create a 2D array of characters
		board = new Character[rows][cols];
		characters = new ArrayList<Character>();

	}

	/**
	 * @return number of columns the board has
	 */
	public static int getNumCols() {
		return cols;
	}

	/**
	 * @return number of rows the board has
	 */
	public static int getNumRows() {
		return rows;
	}

	/**
	 * Grabs the character present on a particular space if any is there
	 * 
	 * @param s the desired space where you want to look to see if a character is there
	 * @return a pointer to the Character object present on that space, if no Character is present, null is returned
	 */
	public static Character getCharacter(Space s) {
		Character retCharacter = null; 
		// Look for the character at the given space
		if(board[s.getRow()][s.getCol()] != null){
			retCharacter =  board[s.getRow()][s.getCol()]; //Sets the retCharacter to character at that space if it is not null
		}

		return retCharacter;
	}

	public static Character spaceCheck(Player p) {

		Character tempUp = board[p.getRow() - 1][p.getCol()];
		Character tempDown = board[p.getRow() + 1][p.getCol()];
		Character tempRight = board[p.getRow()][p.getCol() + 1];
		Character tempLeft = board[p.getRow()][p.getCol() - 1];


		if(tempUp != null) {
			System.out.println("Enemy above");
			return tempUp;
		}
		else if(tempDown != null) {

			System.out.println("Enemy below");
			return tempDown;
		}
		else if(tempRight != null) {

			System.out.println("Enemy right");
			return tempRight;
		}
		else if(tempLeft != null) {
			System.out.println("Enemy left");
			return tempLeft;
		}
		else {
			return null;
		}



	}

	/**
	 * Checks if any character is present on a particular space if any is there
	 * 
	 * @param s the desired space where you want to look to see if a character is there
	 * @return true if Character object present on that space, if no Character is present, false is returned
	 */

	public boolean isCharacterOnSpace(Space s) {
		if(board[s.getRow()][s.getCol()] != null)
		{
			return true;
		}
		else
			return false;
	}

	//Iterates through board, and adds Characters to ArrayList
	//ArrayList is returnable
	public ArrayList<Character> getCharactersOnBoard() {
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < cols; j++) {
				if(board[i][j] != null)
					characters.add(board[i][j]);
			}

		//		ListIterator<Character> iterator = characters.listIterator();
		//		while(iterator.hasNext()) {
		//			iterator.next().printCharacter();
		//		}

		return characters;
	}

	//This function below is to return a enemy in order to access it in the battle class and levelpane and pause(battlepane)
	// only thing i need help with is setting temp to the enemy in the given space 

	public static Enemy CharacterAtSpace(Player player) {

		Space space = player.getLocation();

		//For testing in passing Enemy object to other class
		temp = new Enemy(3, 2);



		//		  if(board[space.getRow()][space.getCol() + 1] != null) { // checks above the
		//			  	
		//			  	return temp; 
		//			  	}
		////			  	
		//			  	else
		//		 if(board[space.getRow() + 1][space.getCol()] != null){ // enemy is to the
		//		 right of the player return temp; } else if(board[space.getRow() -
		//		 1][space.getCol()] != null) { //enemy is to the left of the player return
		//		 temp; } else { // enemy is below the player return temp; }
		//		 

		//This is purely to show that the temp is being passed!
		//Remove this for real code implementation!
		return temp;
	}


	/**
	 * adds a character to the board. It would be good to do some checks for a legal placement here.
	 * 
	 * @param type type of the character
	 * @param startRow row for location of character's top
	 * @param startCol column for for location of character

	 */
	public void addCharacter(Character character) {
		System.out.println("Checking if Character can be added!");

		int cRow = character.getRow();
		int cCol = character.getCol();

		System.out.println("Row: " + cRow + "\nColumn: " + cCol + "\n");

		//Checking bounds
		if(cRow >= 0 && cRow < rows && cCol >= 0 && cCol < cols) {
			System.out.println("In Limits");
			if(board[cRow][cCol] == null) {
				System.out.println("Character added to Row: " + cRow + "\nCol: " + cCol + "\n");
				board[cRow][cCol] = character;
			}
		}
		else
			System.out.println("Location occuppied! Skipping Character Addition!!!!");
	}

	public boolean canMove(Character c, Space newSpace) {
		//Java short circuits, so it's okay to have everything here.
		if(newSpace.getRow() < rows && newSpace.getCol() < cols)
			if(newSpace.getRow() >= 0 && newSpace.getRow() < rows && newSpace.getCol() >= 0 && newSpace.getCol() < cols)
				if(board[newSpace.getRow()][newSpace.getCol()] == null || board[newSpace.getRow()][newSpace.getCol()] == c )
					return true;

		return false;
	}

	public void moveCharacter(Character c, Space newSpace) {
		if(canMove(c, newSpace)) {
			board[c.getRow()][c.getCol()] = null;

			for(int i = 0; i < rows; i++)
				for(int j = 0; j < cols; j++) {
					if(board[i][j] == c)
						board[i][j] = null;
				}

			addCharacter(c);
		}
		else
			System.out.println("Can't move!");
	}

	//Do not touch this class, I already converted it.
	public String toString() {
		return BoardConverter.createString(this);
	}

	public static void main(String[] args) {
		//Test board
		Board testBoard = new Board(5, 5);

		//		//Add test Character's Below
		//		Player p = new Player(1, 1, CharacterType.MAGE);
		//		Enemy e = new Enemy(3, 4);
		//		
		//		testBoard.addCharacter(e);
		//		testBoard.addCharacter(p);
		//		testBoard.getCharactersOnBoard();
		//		System.out.println(testBoard);
		//		
		//		Space playerSpot = new Space(p.getRow(), p.getCol() + 1);
		//		Space enemySpot = new Space(e.getRow(), e.getCol() - 1);
		//		Space offBoard = new Space(e.getRow(), e.getCol() + 1);
		//		
		//		//Testing canMove()
		//		//Passing
		//		System.out.println(testBoard.canMove(p, playerSpot));
		//		System.out.println(testBoard.canMove(e, enemySpot));
		//		
		//		//Failing
		//		System.out.println(testBoard.canMove(e, offBoard));
		//		
		//		//Testing moveCharacter()
		//		//Passing
		//		testBoard.moveCharacter(p, playerSpot);
		//		testBoard.moveCharacter(e, enemySpot);
		//		
		//		//Failing
		//		testBoard.canMove(e, offBoard);
		//		
		//		System.out.println(testBoard);



		// checks enemy to the right of the player
		//Player p = new Player(2, 2, CharacterType.WARRIOR);
		//		Enemy e = new Enemy(2, 3);
		//		testBoard.addCharacter(p);
		//		testBoard.addCharacter(e);
		//
		//
		//
		//		System.out.println(testBoard);
		//
		//		Character temp = spaceCheck(p);
		//
		//		temp.printCharacter(); 

		//		// checks enemy to the left of the player
		//
		//		Enemy e1 = new Enemy(2, 1);
		//		testBoard.addCharacter(p);
		//		testBoard.addCharacter(e1);
		//
		//
		//
		//		System.out.println(testBoard);
		//
		//		Character temp1 = spaceCheck(p);
		//
		//		temp1.printCharacter(); 


		//		//checks above the player
		//		Enemy e2 = new Enemy(1, 2);
		//		testBoard.addCharacter(p);
		//		testBoard.addCharacter(e2);
		//
		//
		//
		//		System.out.println(testBoard);
		//
		//		Character temp2 = spaceCheck(p);
		//
		//		temp2.printCharacter(); 
		//
		//
		//
		//
		//		//checks below the player
		//
		//		Enemy e3 = new Enemy(3, 2);
		//		testBoard.addCharacter(p);
		//		testBoard.addCharacter(e3);
		//
		//
		//
		//		System.out.println(testBoard);
		//
		//		Character temp3 = spaceCheck(p);
		//
		//		temp3.printCharacter(); 



	}
}

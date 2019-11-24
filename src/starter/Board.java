package starter;
import java.awt.Color;
import java.util.*;
import java.util.ArrayList;

import acm.graphics.GLine;

/**
 * COMP 55: Application Development final Project
 *  @author (Original Writer) Nitin Pinnamaneni
 *  @author (Overhaul Writer) Greg Jewell
 */

public class Board {
	private Character[][] board; // 2D array of characters
	private ArrayList<Character> characters; // holds all the characters on the board

	private int rows, cols;
	
	private Space exit;

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

		this.rows = r;
		this.cols = c;

		// Create a 2D array of characters
		board = new Character[r][c];
		characters = new ArrayList<Character>();

	}


	/**
	 * @return number of columns the board has
	 */
	public int getNumCols()
	{
		return board[0].length;
	}

	/**
	 * @return number of rows the board has
	 */
	public int getNumRows()
	{
		return board.length;
	}
	
	public void setExit(Space s) {
		exit = s;
	}
	
	public Space getExit() {
		return this.exit;
	}

	/**
	 * Grabs the character present on a particular space if any is there
	 * 
	 * @param s the desired space where you want to look to see if a character is there
	 * @return a pointer to the Character object present on that space, if no Character is present, null is returned
	 */
	public Character getCharacter(Space s) {
		Character retCharacter = null; 
		// Look for the character at the given space
		if(board[s.getRow()][s.getCol()] != null){
			retCharacter =  board[s.getRow()][s.getCol()]; //Sets the retCharacter to character at that space if it is not null
		}

		return retCharacter;
	}

	public Character spaceCheck(Player p) {
		

		//Character tempUp = board[p.getRow() - 1][p.getCol()];
		//Character tempDown = board[p.getRow() + 1][p.getCol()];
		Character tempRight = board[p.getRow()][p.getCol() + 1];
		//Character tempLeft = board[p.getRow()][p.getCol() - 1];


//		if(tempUp != null) {
//			System.out.println("Enemy above");
//			return tempUp;
//		}
//		else if(tempDown != null) {
//
//			System.out.println("Enemy below");
//			return tempDown;
//		}
		if(tempRight != null) {

			
			return tempRight;
		}
//		else if(tempLeft != null) {
//			System.out.println("Enemy left");
//			return tempLeft;
//		}
		else {
			Enemy temp = new Enemy(1, 1);
			temp.setStrength(6);
			
			return temp;
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
		for(int i = 0; i < getNumRows(); i++)
			for(int j = 0; j < getNumCols(); j++) {
				if(board[i][j] != null)
					characters.add(board[i][j]);
			}

		//		ListIterator<Character> iterator = characters.listIterator();
		//		while(iterator.hasNext()) {
		//			iterator.next().printCharacter();
		//		}

		return characters;
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
		if(cRow >= 0 && cRow < getNumRows() && cCol >= 0 && cCol < getNumCols()) {
			System.out.println("In Limits");
			if(board[cRow][cCol] == null) {
				System.out.println("Character added to Row: " + cRow + "\nCol: " + cCol + "\n");
				board[cRow][cCol] = character;
			}
		}
		else
			System.out.println("Location occuppied! Skipping Character Addition!!!!");
	}
	
	public void removeCharacter(Space s) {
		int row, col;
		row = s.getRow();
		col = s.getCol();
		
		if (row >= 0 && row < getNumRows() && col >= 0 && col < getNumCols())
			board[row][col] = null;
	}

	public boolean canMove(Character c, Space newSpace) {
		//Java short circuits, so it's okay to have everything here.
		if(newSpace.getRow() < getNumRows() && newSpace.getCol() < getNumCols())
			if(newSpace.getRow() >= 0 && newSpace.getRow() < getNumRows() && newSpace.getCol() >= 0 && newSpace.getCol() < getNumCols())
				if(board[newSpace.getRow()][newSpace.getCol()] == null || board[newSpace.getRow()][newSpace.getCol()] == c )
					return true;

		return false;
	}

	public void moveCharacter(Character c, Space newSpace) {
		if(canMove(c, newSpace)) {
			board[c.getRow()][c.getCol()] = null;

			for(int i = 0; i < getNumRows(); i++)
				for(int j = 0; j < getNumCols(); j++) {
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

				//Add test Character's Below
				Player p = new Player(1, 1, CharacterType.MAGE);
				Enemy e = new Enemy(3, 4);
				
				testBoard.addCharacter(e);
				testBoard.addCharacter(p);
				testBoard.getCharactersOnBoard();
				System.out.println(testBoard);
				
				Space playerSpot = new Space(p.getRow(), p.getCol() + 1);
				Space enemySpot = new Space(e.getRow(), e.getCol() - 1);
				Space offBoard = new Space(e.getRow(), e.getCol() + 1);
				
				//Testing canMove()
				//Passing
				System.out.println(testBoard.canMove(p, playerSpot));
				System.out.println(testBoard.canMove(e, enemySpot));
				
				//Failing
				System.out.println(testBoard.canMove(e, offBoard));
				
				//Testing moveCharacter()
				//Passing
				testBoard.moveCharacter(p, playerSpot);
				testBoard.moveCharacter(e, enemySpot);
				
				//Failing
				testBoard.canMove(e, offBoard);
				
				System.out.println(testBoard);
	}
	
	
//public Character spaceCheck(Player p) {
//		
////		Character tempUp;
////		Character tempDown;
////		Character tempLeft;
//		Character tempRight;
//		
//		
//		
//		
//		
////		if(p.getRow() - 1 <= 0) {
////			tempUp = board[p.getRow() - 1][p.getCol()];
////			if(tempUp.cType == CharacterType.ENEMY) 
////			return tempUp;
////			
////		}
////		else if(p.getRow() + 1 < getNumRows()) {
////			tempDown = board[p.getRow() + 1][p.getCol()];
////			return tempDown;
////		}
////		else if(p.getCol() - 1 <= 0) {
////			tempLeft = board[p.getRow()][p.getCol() - 1];
////			return tempLeft;
////		}
//		if(p.getCol() + 1 < getNumCols()) {
//			tempRight = board[p.getRow()][p.getCol() + 1];
//			
//			if(board[p.getRow()][p.getCol() + 1].cType == CharacterType.ENEMY) {
//			return tempRight;
//			}
//			
//			return null;
//
//		}
//		
////		if(tempUp != null) {
////			System.out.println("Enemy above");
////			
////		}
////		else if(tempDown != null) {
////
////			System.out.println("Enemy below");
////			
////		}
////		else if(tempRight != null) {
////
////			System.out.println("Enemy right");
////			
////		}
////		else if(tempLeft != null) {
////			System.out.println("Enemy left");
////			
////		}
//		else {
//			return null;
//		}
//	}
}

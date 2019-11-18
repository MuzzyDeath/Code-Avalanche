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
	public Board(int rows, int cols) {
		// Create a 2D array of characters
		board = new Character[rows][cols];
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
		

		/*
		 * if(board[space.getRow()][space.getCol() + 1] != null) { // checks above the
		 * player for enemy //temp = new Enemy() return temp; } else
		 * if(board[space.getRow() + 1][space.getCol()] != null){ // enemy is to the
		 * right of the player return temp; } else if(board[space.getRow() -
		 * 1][space.getCol()] != null) { //enemy is to the left of the player return
		 * temp; } else { // enemy is below the player return temp; }
		 */

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
	public boolean addCharacter(Character character) 
	{
		boolean canAdd = true;
		Character toAdd = character; 
		System.out.println("Checking if Character " + character + " can be added");
	
		Space toOccupy = new Space(character.getRow(), character.getCol());
	
		// Check row bounds
		if(toOccupy.getRow() < 0 || toOccupy.getRow() > (getNumRows() - 1) || 
				toOccupy.getCol() < 0 || toOccupy.getCol() > (getNumCols() - 1))
		{
			canAdd = false; // Specified row and column are out of bounds, so cannot add the character
		}
		else if(isCharacterOnSpace(toOccupy))
		{
			canAdd = false; // space at specified index is occupied so can't add character
			System.out.println("Location occuppied! Skipping Character Addition!!!!");
		}
		else {
			// Set the character at specified row and column to the vehicle you want to add
			board[toAdd.getLocation().getRow()][toAdd.getLocation().getCol()] = toAdd;
			// Add it to the characters array list
			characters.add(toAdd);
			System.out.println("Character " + character + " added");
		}
		return canAdd;
	}

	
	public boolean canMove(Character c, Space newSpace) {
		//Java short circuits, so it's okay to have everything here.
		if(newSpace.getRow() < rows && newSpace.getCol() < cols)
			if(board[newSpace.getRow()][newSpace.getCol()] == null && newSpace.getRow() > 0 && newSpace.getRow() < rows && newSpace.getCol() > 0 && newSpace.getCol() < cols) {
				return true;
			}
			else
				return false;
		else
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
	
	
	public Space[] spacesOccupiedOnTrail(Character c, int numSpaces, boolean isHorizontal) {

		// array of spaces that holds what all spaces the character has traveled on to
		// reach its final position
		int absNumSpaces = numSpaces;
		if (numSpaces < 0)
		{
			absNumSpaces = -numSpaces;
		}
		Space[] spaces = new Space[absNumSpaces];

		if(isHorizontal)
		{
			if(numSpaces > 0)
			{
				// Iterate thru the numSpaces and add spaces with (cRow, cCol + i)
				for(int i = 0; i < absNumSpaces; i++)
				{
					spaces[i] = new Space(c.getRow(), c.getCol() + i + 1);
				}
			}
			else {
				// Iterate thru the numSpaces and add spaces with (cRow, cCol - i)
				for(int i = 0; i < absNumSpaces; i++)
				{
					spaces[i] = new Space(c.getRow(), c.getCol() - i - 1);
				}
			}
		}
		else {
			if(numSpaces > 0)
			{
				// Iterate thru the numSpaces and add spaces with (cRow + i, cCol)
				for(int i = 0; i < absNumSpaces; i++)
				{
					spaces[i] = new Space(c.getRow() + i + 1, c.getCol());
				}
			}
			else {
				// Iterate thru the numSpaces and add spaces with (cRow - i, cCol)
				for(int i = 0; i < absNumSpaces; i++)
				{
					spaces[i] = new Space(c.getRow() - i - 1, c.getCol());
				}
			}
		}

		return spaces;	
	}


	/**
	 * checks if the character at the given space can move or not.
	 * 
	 * @param character character
	 * @param nSpaces num of spaces the character needs to move
	 * @param isHorizontal boolean indicating whether the move is horizontal or not
	 * 
	 * @return boolean true if the move can be performed.
	 */
	public boolean canMove(Character character, int nSpaces, boolean isHorizontal)
	{
		// TODO : Check if the character provided is the same as the same as what we have on board
		boolean canMove = true;
		Character toMove = character;
		if(toMove == null)
		{
			canMove = false;
		}
		else {
			// Get the spaces this move will affect
			Space[] spacesTrailed = spacesOccupiedOnTrail(character, nSpaces, isHorizontal);

			// Check that spaces trailed are within bounds of grid and that there are 
			// no characters at these spaces
			for(int i = 0; i < spacesTrailed.length; i++)
			{
				// Check for out of bounds
				if(spacesTrailed[i].getRow() < 0 || spacesTrailed[i].getRow() > (getNumRows() - 1) ||
					spacesTrailed[i].getCol() < 0 || spacesTrailed[i].getCol() > (getNumCols() - 1))
				{
					// space trailed is out of bounds of board, so move can't be performed
					canMove = false;
					break;
				}
				// Check for other characters
				if(getCharacter(spacesTrailed[i]) != null) 
				{
					// Character is present at space i, so the move can't be performed
					canMove = false;
					break;
				}

			}
		}
		return canMove;
	}

	/**
	 * moves the  character at the given space .
	 * 
	 * @param start location of character
	 * @param nSpaces num of spaces the character needs to move
	 * @param isHorizontal boolean indicating whether the move is horizontal or not
	 * 
	 * @return boolean true if the move is performed.
	 */
	public boolean moveNumSpaces(Character c, int numSpaces, boolean isHorizontal)
	{
		boolean retVal = false;

		if(canMove(c, numSpaces, isHorizontal) == true)
		{
			Character toMove = getCharacter(new Space(c.getRow(), c.getCol()));

			// Clear the old space
			// board[start.getRow()][start.getCol()] = null;
			board[toMove.getLocation().getRow()][toMove.getLocation().getCol()] = null;

			int newRow = toMove.getLocation().getRow(), newCol = toMove.getLocation().getCol();

			if(isHorizontal)
			{
				newCol += numSpaces;
			}
			else {
				newRow += numSpaces;
			}


			toMove.setLocation(newRow, newCol);

			// Update board with new location of character
			board[toMove.getLocation().getRow()][toMove.getLocation().getCol()] = toMove;

			retVal = true;

		}
		return retVal;
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
}

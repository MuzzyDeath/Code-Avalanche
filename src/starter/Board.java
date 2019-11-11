package starter;
import java.util.*;
import java.util.ArrayList;

public class Board {
	private static Character[][] board; // 2D array of characters
	ArrayList<Character> characters; // holds all the characters on the board

	public static Enemy temp;
	
	/*
	private Space start = new Space(2, 0);

	 */

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
		if(board[s.getRow()][s.getCol()] != null)
		{
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
		boolean retValue = false;
		if(board[s.getRow()][s.getCol()] != null)
		{
			retValue = true;
		}
		return retValue;
	}

	public ArrayList<Character> getCharactersOnBoard()
	{
		return characters;
	}


	/**
	 * adds a character to the board. It would be good to do some checks for a legal placement here.
	 * 
	 * @param type type of the character
	 * @param startRow row for location of character's top
	 * @param startCol column for for location of character

	 */
	public void addCharacter(CharacterType type, int startRow, int startCol) 
	{
		boolean canAdd = true; 

		// The character you want to add that has the specified parameters
		Character toAdd = new Character(startRow, startCol, type); 

		Space toOccupy = new Space(startRow, startCol);

		// Check row bounds
		if(toOccupy.getRow() < 0 || toOccupy.getRow() > (getNumRows() - 1) || 
				toOccupy.getCol() < 0 || toOccupy.getCol() > (getNumCols() - 1))
		{
			canAdd = false; // Specified row and column are out of bounds, so cannot add the vehicle
		}
		else if(isCharacterOnSpace(toOccupy))
		{
			canAdd = false; // space at specified index is occupied so can't add character
		}
		else {
			// Set the character at specified row and column to the vehicle you want to add
			board[toAdd.getLocation().getRow()][toAdd.getLocation().getCol()] = toAdd;
			// Add it to the characters array list
			characters.add(toAdd);
		}
	}

	/*
	public Space getStart()
	{
		return this.start;
	}



	public void printCharactersOnBoard() {
		ArrayList<Character> list = this.getCharactersOnBoard();

		for(int i = 0; i < list.size(); i++) {
			list.get(i).printCharacter();
		}
	}*/

	public boolean canMove(Space start, int nSpaces, boolean isHorizontal)
	{
		boolean canMove = true;
		// int endRow = 0, endCol = 0;
		Character toMove = getCharacter(start);
		if(toMove == null)
		{
			canMove = false;
		}
		else {
			// Get the spaces this move will affect
			Space[] spacesTrailed = toMove.spacesOccupiedOnTrail(nSpaces, isHorizontal);
			
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

	public boolean moveNumSpaces(Space start, int numSpaces, boolean isHorizontal)
	{
		boolean retVal = false;
		int endRow = 0, endCol = 0;
		
		if(canMove(start, numSpaces, isHorizontal) == true)
		{
			Character toMove = getCharacter(start);
			
			/*
			if(isHorizontal == true)
			{
				endCol += numSpaces;
				endRow = start.getRow();
			}
			else {
				endRow += numSpaces;
				endCol = start.getCol();
			}
			*/
			
			// Clear the old space
			// board[start.getRow()][start.getCol()] = null;
			board[toMove.getLocation().getRow()][toMove.getLocation().getCol()] = null;
			
			// Move the character 
			toMove.move(numSpaces, isHorizontal);
			
			// Update board with new location of character
			board[toMove.getLocation().getRow()][toMove.getLocation().getCol()] = toMove;
			
			retVal = true;
			
		}
		return retVal;
	}


	public void addPlayer(int row, int col, CharacterType cType)
	{
		addCharacter(cType, row, +col);

	}

	public void addNPC(int row, int col) {
		addCharacter(CharacterType.NPC, row, col);

	}

	public void addEnemy(int row, int col) {
		addCharacter(CharacterType.ENEMY, row, col);

	}


	/**
	 * Moves the character at specified location  the given number of spaces
	 * @param space the space at which the character is currently at 
	 * @param numSpaces the number of spaces to move the player
	 * @param isHorizontal if the move has to be horizontal or vertical
	 * @return true if the character  can be moved
	 */
	/*public boolean moveNumSpaces(Space curSpace, int numSpaces, boolean isHorizontal)
	{
		boolean retValue = true;
		// TODO: Implement this
		return retValue;
	}*/


	//Do not touch this class, I already converted it.
	public String toString() {
		return BoardConverter.createString(this);
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

	public static void main(String[] args) {
		Board map1 = new Board(5, 5);
		map1.addPlayer(2, 2, CharacterType.MAGE);
		map1.addNPC(4, 4);
		map1.addNPC(3, 3);
		map1.addEnemy(0, 1);
		System.out.println(map1);

		System.out.println(map1.canMove(new Space(2, 2), 2, true));
		map1.moveNumSpaces(new Space(2, 2), 2, true);
		System.out.println(map1);

		System.out.println(map1.canMove(new Space(2, 4), 2, true));
		map1.moveNumSpaces(new Space(2, 4), 2, true);
		System.out.println(map1);

		//System.out.println(map1.canMove(map1.getStart(), 2));
		//map1.printCharactersOnBoard();
		//testCanMove(b);
		//testMoving(b);
		//System.out.println(b);
	}
}

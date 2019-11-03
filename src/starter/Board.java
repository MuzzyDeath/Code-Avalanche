package starter;
import java.util.*;
import java.util.ArrayList;

public class Board {
	private Character[][] board; // 2D array of characters
	ArrayList<Character> characters; // holds all the characters on the board
	
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
	
	public boolean canMove(Space start, int nSpaces)
	{
		if(start != null && nSpaces >= 0 && nSpaces < getNumRows() && nSpaces < getNumCols())
		{
			return true;
		}
		return false;
	}
	
	public boolean move(Space start, int nSpaces)
	{
		if(start != null && nSpaces >= 0 && nSpaces < getNumRows() && nSpaces < getNumCols())
		{
			return true;
		}
		return false;
	}
	
	public void moveNumSpaces(Space start, int numSpaces, int row, int col)
	{
		if(canMove(start, numSpaces))
		{
			row = start.getRow() + numSpaces;
			col = start.getCol() + numSpaces;

		}
	}
	
	public void addPlayer(int row, int col, CharacterType cType)
	{
		addCharacter(cType, row, col);

	}
	
	public void addNPC(int row, int col) {
		addCharacter(CharacterType.NPC, row, col);

	}
	
	public void addEnemy(int row, int col) {
		addCharacter(CharacterType.ENEMY, row, col);

	}
	
	//Do not touch this class, I already converted it.
	public String toString() {
		return BoardConverter.createString(this);
	}
	
	public static void main(String[] args) {
		Board map1 = new Board(5, 5);
		map1.addPlayer(2, 2, CharacterType.MAGE);
		map1.addNPC(4, 4);
		map1.addEnemy(0, 1);
		map1.addEnemy(3, 1);
		System.out.println(map1);
		
		//System.out.println(map1.canMove(map1.getStart(), 2));
		//map1.printCharactersOnBoard();
		//testCanMove(b);
		//testMoving(b);
		//System.out.println(b);
	}
}

package starter;
import java.util.*;

/**
 * COMP 55: Application Development final Project
 *  @author Nitin Pinnamaneni & Greg Jewell
 */


public class Map {

	public static final int LEVEL_BEGINNER     = 1;
	public static final int LEVEL_INTERMEDIATE = 2;
	public static final int LEVEL_ADVANCED     = 3;
	public static final int MAX_LEVELS         = 3;

	private Board board;
	private boolean isEnemyDefeated = false;
	private Enemy e;
	private Player p;

	private static Map[] levels;
	private static int currentLevel = LEVEL_BEGINNER;
	private Map map;

	//private Space startSpace; // Player starts the level at this space
	//private Space exitSpace;  // Player needs to reach this space to win.
	//private int numMoves;


	// Constructor that takes in a level and initializes the map for that level
	private Map(int level) {
		switch(level) {
		case LEVEL_BEGINNER:
			setupBeginnerMap();
			break;
		case LEVEL_INTERMEDIATE:
			setupIntermediateMap();
			break;
		case LEVEL_ADVANCED:
			setupAdvancedMap();
			break;
		default:
			System.out.println("Invalid level " + level + ". Levels supported are from 0 to " + MAX_LEVELS);
			break;
		}
	}

	/**
	 * @return number of columns the board has
	 */
	public int getNumCols()
	{
		return board.getNumCols();
	}

	/**
	 * @return number of rows the board has
	 */
	public int getNumRows()
	{
		return board.getNumRows();
	}

	/*
	public void setExit(Space s) {
		board.setExit(s);
	}
	 */

	public Space getExit() {
		return board.getExit();
	}

	
//	 * We need to encapsulate baord, we should not give out board.
//	 *  All board methods have to be encoded in Map
	public Board getBoard() {
		return this.board;
	}


	public void moveCharacter(Character c, Space newSpace) {
		board.moveCharacter(c,  newSpace);
	}



	public void addPlayer(Player player) {
		p = player;
		board.addCharacter(player);
	}


	//	/**
	//	 * @return the winning space
	//	 */
	//	public Space getGoalSpace() {
	//		return exitSpace;
	//	}

	/**
	 * add characters for the beginner map
	 * initialize the board, exit position, and number of moves
	 */
	public void setupBeginnerMap() {
		// Add characters and set up exit space.
		// Initialize board with the maxRows and maxCols
		board = new Board(6, 6);

		//startSpace = new Space(1, 1);

		// Winning space for this level is for Player  to reach r4c4
		//exitSpace = new Space(4, 4);

		// Add NPCs to the board
		board.addCharacter(new NPC(0, 5));
		board.addCharacter(new NPC(1, 3));

		e = new Enemy(4, 5);
		board.addCharacter(e);

		board.setExit(new Space(2,3));
	}

	/**
	 * add characters for the intermediate map
	 * initialize the board, exit position, and number of moves
	 */

	public void setupIntermediateMap()
	{
		// Add characters and set up exit space.
		// Initialize board with the maxRows and maxCols
		board = new Board(10, 10);

		//startSpace = new Space(0, 3);

		// Winning space for this level is for Player  to reach r7c7
		board.setExit(new Space(2, 8));

		board.addCharacter(new NPC(0, 5)); 
		board.addCharacter(new NPC(1, 3)); 
		board.addCharacter(new NPC(2, 6)); 
		board.addCharacter(new NPC(3, 0)); 
		board.addCharacter(new NPC(3, 4)); 
		board.addCharacter(new NPC(5, 4));
		board.addCharacter(new NPC(4, 3));
		board.addCharacter(new NPC(6, 7)); 
		board.addCharacter(new NPC(7, 8));
		board.addCharacter(new NPC(8, 7));

		e = new Enemy(7, 6);
		board.addCharacter(e);

	}
	//
	//	/**
	//	 * add characters for the intermediate map
	//	 * initialize the board, exit position, and number of moves
	//	 */
	//	
	public void setupAdvancedMap()
	{
		// Add characters and set up exit space.
		// Initialize board with the maxRows and maxCols
		board = new Board(15, 15);
		//		
		//		// Winning space for this level is for  Player  to reach r4c4


		// Winning space for this level is for Player  to reach r7c7
		board.setExit(new Space(10, 10));

		board.addCharacter(new NPC(0, 5)); 
		board.addCharacter(new NPC(1, 3)); 
		board.addCharacter(new NPC(2, 6)); 
		board.addCharacter(new NPC(3, 0)); 
		board.addCharacter(new NPC(3, 4)); 
		board.addCharacter(new NPC(5, 4));
		board.addCharacter(new NPC(4, 3));
		board.addCharacter(new NPC(12, 1)); 
		board.addCharacter(new NPC(12, 3));
		board.addCharacter(new NPC(13, 2));

		e = new Enemy(11, 2);
		board.addCharacter(e);

	}

	public Enemy getEnemy()
	{
		return e;
	}

	public Character getNearbyCharacter(Player p)
	{
		return board.spaceCheck(p);
	}
	/**
	 * Returns the character at the given space
	 * 
	 * @param space the space at which the vehicle needs to be fetched 
	 * @return the character at the given location
	 */
	public Character getCharacter(Space space)
	{
		return board.getCharacter(space);
	}
	public ArrayList<Character> getCharactersOnMap()
	{
		return board.getCharactersOnBoard();
	}
	/**
	 * Returns map for the given level
	 * 
	 * @return Map for the given level
	 */
	public static Map getMap(int level)
	{
		Map retMap = null;

		if(level > 0 && level <= MAX_LEVELS)
		{
			retMap = new Map(level);
		}
		else {
			System.out.println("Invalid level " + level + ". Levels supported are from 0 to " + MAX_LEVELS);
		}

		return retMap;
	}

	public static Map getCurrentMap()
	{
		if(levels == null)
		{
			// Initialize the maps
			levels = new Map[MAX_LEVELS];
			levels[0] = getMap(LEVEL_BEGINNER);
			levels[1] = getMap(LEVEL_INTERMEDIATE);
			levels[2] = getMap(LEVEL_ADVANCED);
		}
		return levels[currentLevel - 1];
	}

	public static int getCurrentLevel()
	{
		return currentLevel;
	}

	public static void incrementLevel()
	{
		if(currentLevel < MAX_LEVELS)
		{
			currentLevel++;
		}
	}

	public boolean isFacingEnemy()
	{
		boolean retVal = false;
		// TO DO: If player is nearby enemy, return true.
		// Check if enemy is left of the player
		/*System.out.println("Player = " + p);
		System.out.println("Enemy = " + e);*/
		if(e.getRow() == p.getRow() - 1 && p.getCol() == e.getCol())
		{
			retVal = true;
		}
		// Right
		else if(e.getRow() == p.getRow() + 1 && e.getCol() == p.getCol())
		{
			retVal = true;
		}
		// Enemy above of player
		else if(e.getRow() == p.getRow() && e.getCol() == p.getCol() - 1)
		{
			retVal = true;
		}
		// Below
		else if(p.getRow() == e.getRow()  && e.getCol() == p.getCol() + 1)
		{
			retVal = true;
		}

		return retVal;
	}

	public void setEnemyDefeated(boolean isDefeated)
	{
		isEnemyDefeated = isDefeated;
	}


	public boolean isLevelComplete()
	{
		boolean retVal = false;
		if(isEnemyDefeated && p.getRow() == getExit().getRow() && p.getCol() == getExit().getCol())
		{
			// TO DO: Check if the player's current space is the exit space
			retVal = true;
		}
		return retVal;
	}
	/**
	 * Moves the player from his current space the given number of spaces
	 * @param space the space at which the vehicle is currently at 
	 * @param numSpaces the number of spaces to move the player
	 * @param isHorizontal if the move has to be horizontal or vertical
	 * @return true if the character  can be moved
	 */

	//Methods already defined for you
	/**
	 * generates the string representation of the level, including the row and column headers to make it look like
	 * a table
	 * 
	 * @return the string representation
	 */
	public String toString() {
		String result = generateColHeader(board.getNumCols());
		result+=addRowHeader(board.toString());
		return result;
	}

	/**
	 * This method will add the row information
	 * needed to the board and is used by the toString method
	 * 
	 * @param origBoard the original board without the header information
	 * @return the board with the header information
	 */
	private String addRowHeader(String origBoard) {
		String result = "";
		String[] elems = origBoard.split("\n");
		for(int i = 0; i < elems.length; i++) {
			// result += (char)('A' + i) + "|" + elems[i] + "\n"; 
			result += String.format("%2d", (i)) + "|" + elems[i] + "\n"; 
		}
		return result;
	}

	/**
	 * This one is responsible for making the row of column numbers at the top and is used by the toString method
	 * 
	 * @param cols the number of columns in the board
	 * @return if the # of columns is five then it would return "  1  2  3  4  5\n-----\n"
	 */
	private String generateColHeader(int cols) {
		String result = "  ";
		for(int i = 1; i <= cols; i++) {
			result+=String.format("%3d", (i - 1));
		}
		result+="\n  ";
		for(int i = 0; i < cols; i++) {
			result+="---";
		}
		result+="\n";
		return result;
	}
}

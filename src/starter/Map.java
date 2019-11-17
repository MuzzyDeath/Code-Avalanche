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
	//private Map map;
	
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
			//setupIntermediateMap();
			break;
		case LEVEL_ADVANCED:
			//setupAdvancedMap();
			break;
		default:
			System.out.println("Invalid level " + level + ". Levels supported are from 0 to " + MAX_LEVELS);
			break;
		}
	}
	
	public Board getBoard() {
		return this.board;
	}
	
	/**
	 * @return the number of columns on the board
	 */
	public int getColumns() {
		// return the number of columns in the level
		return board.getNumCols();
	}
	/**
	 * @return the number of rows on the board
	 */
	public int getRows() {
		return board.getNumRows();
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

		
		board.addCharacter(new Enemy(4, 5));
	}
	
	/**
	 * add characters for the intermediate map
	 * initialize the board, exit position, and number of moves
	 */
	
//	public void setupIntermediateMap()
//	{
//		// Add characters and set up exit space.
//		// Initialize board with the maxRows and maxCols
//		board = new Board(10, 10);
//		
//		startSpace = new Space(0, 3);
//		
//		// Winning space for this level is for Player  to reach r4c4
//		exitSpace = new Space(7, 7);
//		
//		/*
//		 * board.addNPC(0, 5); board.addNPC(1, 3); board.addNPC(2, 6); board.addNPC(3,
//		 * 0); board.addNPC(3, 4); board.addNPC(5, 4); board.addNPC(4, 3);
//		 * board.addNPC(6, 7); board.addNPC(7, 8); board.addNPC(8, 7);
//		 */
//		
//		//board.addEnemy(7, 6);
//		
//	}
//
//	/**
//	 * add characters for the intermediate map
//	 * initialize the board, exit position, and number of moves
//	 */
//	
//	public void setupAdvancedMap()
//	{
//		// Add characters and set up exit space.
//		// Initialize board with the maxRows and maxCols
//		board = new Board(15, 15);
//		
//		// Winning space for this level is for  Player  to reach r4c4
//		exitSpace = new Space(12, 2);
//		
//		
//		/*
//		 * board.addNPC(0, 5); board.addNPC(1, 3); board.addNPC(2, 6); board.addNPC(3,
//		 * 0); board.addNPC(3, 4); board.addNPC(5, 4); board.addNPC(4, 3);
//		 * board.addNPC(12, 1); board.addNPC(12, 3); board.addNPC(13, 2);
//		 * 
//		 * board.addEnemy(11, 2);
//		 */
//		
//	}

	
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
	
	/**
	 * Returns all the characters on the board
	 * 
	 * @return arraylist of characters on the map
	 */
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
	
	/**
	 * Moves the player from his current space the given number of spaces
	 * @param space the space at which the vehicle is currently at 
	 * @param numSpaces the number of spaces to move the player
	 * @param isHorizontal if the move has to be horizontal or vertical
	 * @return true if the character  can be moved
	 */
	
	/**
	 * Moves the player from his current space the given number of spaces
	 * @param space the space at which the vehicle is currently at 
	 * @param numSpaces the number of spaces to move the player
	 * @param isHorizontal if the move has to be horizontal or vertical
	 * @return true if the character  can be moved
	 */
//	public boolean moveNumSpaces(int numSpaces, boolean isHorizontal)
//	{
//		// TODO: Implement the move
//		// Get the player's current position and perform move if possible
//		//Space curPosition = player.getLocation();
//		
//		// Delegate to board to move the given character
//		//return board.moveNumSpaces(curPosition, numSpaces, isHorizontal);
//	}
	
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
	
//	public static void main(String[] args) {
//		Map mapB = Map.getMapForLevel(LEVEL_BEGINNER);
//		//Map mapI = Map.getMapForLevel(LEVEL_INTERMEDIATE);
//		//Map mapA = Map.getMapForLevel(LEVEL_ADVANCED);
//		
//	
//		// Add the player and make moves to the exit location
//		mapB.addPlayer(CharacterType.WARRIOR);
//		System.out.println(mapB);
//		
////		mapB.moveNumSpaces(1, true);
////		System.out.println("After moving 1 space horizontally \n" + mapB);
////		mapB.moveNumSpaces(-1, false);
////		System.out.println("After moving -1 space vertically \n" + mapB);
////		mapB.moveNumSpaces(3, true);
////		System.out.println("After moving 3 spaces horizontally \n" + mapB);
////		mapB.moveNumSpaces(3, false);
////		System.out.println("After moving 3 space vertically \n" + mapB);
////		mapB.moveNumSpaces(1, true);
////		System.out.println("After moving 1 space horizontally \n" + mapB);
////		mapB.moveNumSpaces(2, false); // Face the enemy
////		System.out.println("After moving 2 spaces vertically \n" + mapB);
////		mapB.moveNumSpaces(-1, true);
////		System.out.println("After moving -1 space horizontally \n" + mapB);
//		
//		//System.out.println(mapI);
//		
//		//System.out.println(mapA);
//		
//		
//		//System.out.println(map1.canMove(map1.getStart(), 2));
//		//map1.printCharactersOnBoard();
//		//testCanMove(b);
//		//testMoving(b);
//		//System.out.println(b);
//	}
	
}

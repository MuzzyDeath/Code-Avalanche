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
	// private Map map;
	
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
	
	public Board getBoard() {
		return this.board;
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
	
	public void setupIntermediateMap()
	{
		// Add characters and set up exit space.
		// Initialize board with the maxRows and maxCols
		board = new Board(10, 10);
		
		//startSpace = new Space(0, 3);
		
		// Winning space for this level is for Player  to reach r4c4
		//exitSpace = new Space(7, 7);
		

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
	 
	
		 board.addCharacter(new Enemy(7, 6));
	  	
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
		
		// Winning space for this level is for  Player  to reach r4c4
		// exitSpace = new Space(12, 2);
		
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
	 
	
		 board.addCharacter(new Enemy(11, 2));

		
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
	
	/**
	 * Moves the player from his current space the given number of spaces
	 * @param space the space at which the vehicle is currently at 
	 * @param numSpaces the number of spaces to move the player
	 * @param isHorizontal if the move has to be horizontal or vertical
	 * @return true if the character  can be moved
	 */
	public boolean moveNumSpaces(Character c, int numSpaces, boolean isHorizontal)
	{
		return board.moveNumSpaces(c, numSpaces, isHorizontal);
	}
	
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
	
	public static void testNavigateBeginnerLevel(Map beginMap)
	{
		Player p = new Player(1, 1, CharacterType.MAGE);
		beginMap.getBoard().addCharacter(p);
		System.out.println(beginMap);
		
		boolean canMove = false;
		
		canMove = beginMap.moveNumSpaces(p, 1, true);
		System.out.println("Move 1 space horizontally - " + canMove + "\n" + beginMap);
		
		canMove= beginMap.moveNumSpaces(p, -1, false);
		System.out.println("Move -1 space vertically - " + canMove + "\n" + beginMap);
		
		canMove = beginMap.moveNumSpaces(p, 2, true);
		System.out.println("Move 2 space horizontally - " + canMove + "\n" + beginMap);
		
		canMove = beginMap.moveNumSpaces(p, 4, false);
		System.out.println("Move 4 space vertically - " + canMove + "\n" + beginMap);
	}
	
	public static void testNavigateIntermediateLevel(Map interMap)
	{
		boolean canMove = false;
		Player p = new Player(1, 1, CharacterType.WARRIOR);
		interMap.getBoard().addCharacter(p);
		System.out.println(interMap);
		
		canMove = interMap.moveNumSpaces(p, 1, true);
		System.out.println("Move 1 space horizontally - " + canMove + "\n" + interMap);
		
		canMove = interMap.moveNumSpaces(p, -1, false);
		System.out.println("Move -1 space vertically - " + canMove + "\n" + interMap);
		
		canMove = interMap.moveNumSpaces(p, 2, true);
		System.out.println("Move 2 space horizontally - " + canMove + "\n" + interMap);
		
		canMove = interMap.moveNumSpaces(p, 2, false);
		System.out.println("Move 2 space vertically - " + canMove + "\n" + interMap);
		
		canMove = interMap.moveNumSpaces(p, 1, true);
		System.out.println("Move 1 space horizontally - " + canMove + "\n" + interMap);

		canMove = interMap.moveNumSpaces(p, 5, false);
		System.out.println("Move 5 space vertically - " + canMove + "\n" + interMap);

	}

	
	public static void testNavigateAdvancedLevel(Map advMap)
	{
		boolean canMove = false;
		Player p = new Player(1, 1, CharacterType.ROGUE);
		advMap.getBoard().addCharacter(p);
		System.out.println(advMap);
		
		canMove = advMap.moveNumSpaces(p, 1, true);
		System.out.println("Move 1 space horizontally - " + canMove + "\n" + advMap);
		
		canMove = advMap.moveNumSpaces(p, -1, false);
		System.out.println("Move -1 space vertically - " + canMove + "\n" + advMap);
		
		canMove = advMap.moveNumSpaces(p, 2, true);
		System.out.println("Move 2 space horizontally - " + canMove + "\n" + advMap);
		
		canMove = advMap.moveNumSpaces(p, 2, false);
		System.out.println("Move 2 space vertically - " + canMove + "\n" + advMap);
		
		canMove = advMap.moveNumSpaces(p, 1, true);
		System.out.println("Move 1 space horizontally - " + canMove + "\n" + advMap);

		canMove = advMap.moveNumSpaces(p, 8, false);
		System.out.println("Move 5 space vertically - " + canMove + "\n" + advMap);
		
		canMove = advMap.moveNumSpaces(p, -3, true);
		System.out.println("Move -3 space horizontally - " + canMove + "\n" + advMap);


	}

	
	public static void main(String[] args) {
		Map mapB = Map.getMap(LEVEL_BEGINNER);
		Map mapI = Map.getMap(LEVEL_INTERMEDIATE);
		Map mapA = Map.getMap(LEVEL_ADVANCED);
		
		// testNavigateBeginnerLevel(mapB);
		
		// testNavigateIntermediateLevel(mapI);
		
		testNavigateAdvancedLevel(mapA);
		
	}
	
		

//		
//		//System.out.println(map1.canMove(map1.getStart(), 2));
//		//map1.printCharactersOnBoard();
//		//testCanMove(b);
//		//testMoving(b);
//		//System.out.println(b);
//	}
	
}

package starter;
import java.util.*;
import java.util.ArrayList;

public class Board {
	private Character[][] board;
	private int numRows;
	private int numCols;
	private Space start = new Space(2, 0);
	
	public Board(int rows, int cols) {
		//TODO finish implementing this constructor
		this.numRows = rows;
		this.numCols = cols;
		this.board = new Character[rows][cols];
	}
	
	public int getNumRows()
	{
		return this.numRows;
	}
	
	public int getNumCols()
	{
		return this.numCols;
	}
	
	public Space getStart()
	{
		return this.start;
	}
	public Character getCharacter(Space s)
	{
		return board[s.getRow()][s.getCol()];
	}
	public Character[][] getBoard() {
		return board;
	}
	
	public boolean characterOnSpace(Space space)
	{
		boolean returnValue = false;
		if(space != null)
		{
			returnValue = true;
		}
		return returnValue;
	}
	
	public ArrayList<Character> getCharactersOnBoard()
	{
		ArrayList<Character> charactersOnBoard = new ArrayList<Character>();
		for(int i = 0; i < numRows; i++){
			for(int j = 0; j < numCols; j++){
				if(board[i][j] != null)
					charactersOnBoard.add(board[i][j]);
			}
		}
		
		return charactersOnBoard;
	}
	public Character getCharacter(Character c)
	{
		if(c.getLocation() != null && c.getLocation().getRow() < numRows && c.getLocation().getCol() < numCols)
		{
			return c;
		}
		return null;
	}
	public void printCharactersOnBoard() {
		ArrayList<Character> list = this.getCharactersOnBoard();
		
		for(int i = 0; i < list.size(); i++) {
			list.get(i).printCharacter();
		}
	}
	
	public boolean canMove(Space start, int nSpaces)
	{
		if(start != null && nSpaces >= 0 && nSpaces < numRows && nSpaces < numCols)
		{
			return true;
		}
		return false;
	}
	
	public boolean move(Space start, int nSpaces)
	{
		if(start != null && nSpaces >= 0 && nSpaces < numRows && nSpaces < numCols)
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
			Space end = new Space(row, col);
		}
	}
	public void addPlayer(int row, int col, CharacterType cType)
	{
		if(characterOnSpace(new Space(row, col))) {
			Player p = new Player(row, col, cType);
		    
		    board[p.getLocation().getRow()][p.getLocation().getCol()] = p;
		}
	}
	
	public void addNPC(int row, int col) {
		if(characterOnSpace(new Space(row, col))) {
			NPC c = new NPC(row, col);
			c.cType = CharacterType.NPC;
			board[c.getLocation().getRow()][c.getLocation().getCol()] = c;
		}
	}
	
	public void addEnemy(int row, int col) {
		if(characterOnSpace(new Space(row, col))) {
			Enemy e = new Enemy(row, col);
			board[e.getLocation().getRow()][e.getLocation().getCol()] = e;
		}
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
		System.out.println(map1);
		System.out.println(map1.canMove(map1.getStart(), 2));
		//map1.printCharactersOnBoard();
		//testCanMove(b);
		//testMoving(b);
		//System.out.println(b);
	}
}

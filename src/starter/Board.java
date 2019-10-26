package starter;
import java.util.*;
import java.util.ArrayList;

public class Board {
	private Character[][] board;
	private int numRows;
	private int numCols;
	private Space start;
	
	public Board(int rows, int cols) {
		//TODO finish implementing this constructor
		this.numRows = rows;
		this.numCols = cols;
		this.board = new Character[rows][cols];
	}
	
	public int getNumRows()
	{
		return numRows;
	}
	
	public int getNumCols()
	{
		return numCols;
	}
	
	public Space getStart()
	{
		return start;
	}
	public Character getCharacter(Space s)
	{
		return board[s.getRow()][s.getCol()];
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
		for(int i = 0; i < numRows; i++)
		{
			for(int j = 0; j < numCols; j++)
			{
				charactersOnBoard.add(board[i][j]);
			}
		}
		return charactersOnBoard;
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
	public void addCharacter(CharacterType type, int row, int col)
	{
		Character c = new Character(row, col);
	    c.setCharacterType();
	    
	    board[c.getLocation().getRow()][c.getLocation().getCol()] = c;
	}
	
	public String toString() {
		return BoardConverter.createString(this);
	}
	
	public static void main(String[] args) {
		Board b = new Board(5, 5);
		b.addCharacter(CharacterType.WARRIOR, 3, 1);
		System.out.println(b);
		//testCanMove(b);
		//testMoving(b);
		//System.out.println(b);
	}
}

package starter;
import java.util.ArrayList;

public class Board {
	private Character[][] board;
	private int numRows;
	private int numCols;
	private Space start;
	
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
	
	public String toString()
	{
		 return "num Rows: " + numRows + " num Cols: " + numCols + " Start space: " + start.toString();
	}
	public Character getCharacter(Space space)
	{
		return new Character(space.getRow(), space.getCol());
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
	public void addCharacter(CharacterType type, int startRow, int startCol)
	{
		Character c = new Character(startRow, startCol);
	    c.setCharacterType();
		for(int i = 0; i < numRows; i++)
		{
			for(int j = 0; j < numCols; j++)
			{
				board[i][j]= c;
			}
		}
	}
}

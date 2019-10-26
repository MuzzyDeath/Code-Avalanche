import starter.Space;
import starter.Character;
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
		if(nSpaces >= 0 && nSpaces < numRows && nSpaces < numCols)
		{
			return true;
		}
		return false;
	}
}

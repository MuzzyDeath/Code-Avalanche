import starter.Space;
import starter.Character;

public class Board {
	private Character[][] board;
	private int numRows;
	private int numCols;
	private Space start;
	
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
}

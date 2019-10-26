import java.util.ArrayList;
import starter.Character;

import starter.Space;

public class Map {
	private Board board;
	private Space nextMap;
	private int numMoves;
	
	public int getNumMoves()
	{
		return numMoves;
	}
	
	public void generateMap(int rows, int cols) {
		nextMap = new Space(rows, cols);
	}
	public void incrementMoves()
	{
		numMoves++;
	}
	
	public int getColumns()
	{
		return board.getNumCols();
	}
	
	public int getRows()
	{
		return board.getNumRows();
	}
	
	public boolean nextLevel()
	{
		if(board.getStart().equals(nextMap))
		{
			return true;
		}
		return false;
	}
	
	public String toString()
	{
		return "Board: " + board.toString() + ", next Map: " + nextMap.toString() + ", number moves: " + numMoves;
	}
	
	/*public Space getGoalSpace()
	{
		
	}*/
	
	public ArrayList<Character> getCharactersOnLevel()
	{
		ArrayList<starter.Character> charactersOnLevel = new ArrayList<Character>();
		for(int i = 0; i < board.getNumRows(); i++)
		{
			for(int j = 0; j < board.getNumCols(); j++)
			{
				charactersOnLevel = board.getCharactersOnBoard();
			}
		}
		return charactersOnLevel;
	}
	
}

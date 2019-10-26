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
	
}

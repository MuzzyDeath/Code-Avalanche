package starter;
import java.util.ArrayList;

/**
 * @author Nitin, revised by Greg Jewell
 *
 */

public class Map {
	private Board map1, map2, map3;
	private Space nextMap;
	private int numMoves;
	
	public int getNumMoves() {
		return numMoves;
	}
	
	public void generateMap(int rows, int cols) {
		nextMap = new Space(rows, cols);
	}
	
	public int getColumns(Board b) {
		return b.getNumCols();
	}
	
	public int getRows(Board b) {
		return b.getNumRows();
	}
	
	public boolean nextLevel(Board b)
	{
		if(b.getStart().equals(nextMap))
		{
			return true;
		}
		return false;
	}
	
	public Space getGoalSpace()
	{
		return nextMap;
	}
	
}

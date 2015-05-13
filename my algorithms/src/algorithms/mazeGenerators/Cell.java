package algorithms.mazeGenerators;

/**
 * <h2>Cell</h2>
 * cell is a class which represents a cell in a maze. it has walls up down left and right and visited boolean datamember
 * @author Hido Pinto
 */
public class Cell {
	private boolean hasRightWall = true;
	private boolean hasLeftWall = true;
	private boolean hasTopWall = true;
	private boolean hasBottomWall = true;
	
	private boolean visited=false;
	
	/**
	 * returns the right wall status
	 * @return hasRightWall
	 */
	public boolean getHasRightWall() {
		return hasRightWall;
	}
	
	/**
	 * sets the right wall status
	 * @param hasRightWall
	 */
	public void setHasRightWall(boolean hasRightWall) {
		this.hasRightWall = hasRightWall;
	}
	
	/**
	 * returns the left wall status
	 * @return hasLeftWall
	 */
	public boolean getHasLeftWall() {
		return hasLeftWall;
	}
	
	/**
	 * sets the left wall status
	 * @param hasLeftWall
	 */
	public void setHasLeftWall(boolean hasLeftWall) {
		this.hasLeftWall = hasLeftWall;
	}
	
	/**
	 * returns the top wall status
	 * @return hasTopWall
	 */
	public boolean getHasTopWall() {
		return hasTopWall;
	}
	
	/**
	 * sets the top wall status
	 * @param hasTopWall
	 */
	public void setHasTopWall(boolean hasTopWall) {
		this.hasTopWall = hasTopWall;
	}
	
	/**
	 * returns the bottom wall status
	 * @return hasBottomWall
	 */
	public boolean getHasBottomWall() {
		return hasBottomWall;
	}
	
	/**
	 * sets the bottom wall status
	 * @param hasBottomWall
	 */
	public void setHasBottomWall(boolean hasBottomWall) {
		this.hasBottomWall = hasBottomWall;
	}
	
	/**
	 * returns if the cell has been visited
	 * @return visited
	 */
	public boolean isVisited() {
		return visited;
	}
	
	/**
	 * sets if the cell has been visited
	 * @param visited
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	
	/**
	 * Cell constructor
	 */
	public Cell()
	{
		super();
	}
}

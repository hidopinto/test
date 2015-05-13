package algorithms.mazeGenerators;


/**
 * <h2>MazeGenerator</h2>
 * maze generator is an interface to create a class that creates matrix
 * @author Hido Pinto
 * @see Cell
 * @see Maze
 */
public interface MazeGenerator {
	
	
	
	/**
	 * generates a maze
	 * @param m maze=matrix of cells
	 * @param i row start index
	 * @param j col start index
	 * @see Maze
	 * @see Cell
	 */
	void generateMaze(Maze m,int i,int j);
}

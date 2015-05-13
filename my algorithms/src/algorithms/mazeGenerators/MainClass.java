package algorithms.mazeGenerators;


/**
 * <h2>MainClass</h2>
 * main. crates mazes and find solution.
 * @author Hido Pinto
 */
public class MainClass {

	public static void main(String[] args) {
		
		Maze maze = new Maze(10, 10);
		MazeGenerator mg = new RandomMazeGenerator();
		mg.generateMaze(maze, 0, 0);
		System.out.println("1:");
		maze.print();
		System.out.println("\n2:");
		maze= new Maze(10,10);
		MazeGenerator mg2 = new MazeGeneratorDFS();
		mg2.generateMaze(maze, 0, 0);
		maze.print();
	}

}

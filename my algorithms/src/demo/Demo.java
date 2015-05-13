package demo;

import java.util.Iterator;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MazeGenerator;
import algorithms.mazeGenerators.MazeGeneratorDFS;
import algorithms.search.Astar;
import algorithms.search.BFS;
import algorithms.search.Heuristics;
import algorithms.search.MazeAirDistance;
import algorithms.search.MazeManhattanDistance;
import algorithms.search.Searcher;
import algorithms.search.State;


/**
 * <h2>Demo</h2>
 * the demo class creates maze, that soles it
 * @author Hido Pinto
 *
 */
public class Demo {
	
	/**
	 * the main function creates maze, that soles it
	 * @param flag represents the heuristics of the maze. true=air distance,false=Manhattan distance
	 */
	public void run() {
		Maze maze= new Maze(10,10);
		MazeGenerator mg2 = new MazeGeneratorDFS();
		mg2.generateMaze(maze, 0, 0);
		maze.print();
		
		System.out.println("\n\n\nBFS:\n\n\nwithout diagonal:\n\n\n");
		
		SearchableMaze sm = new SearchableMaze(maze, false);
		
		Searcher s = new BFS();
		State st;
		Iterator<State> ite = s.search(sm).GetList().iterator();
		while(ite.hasNext()==true)
		{
			st=ite.next();
			System.out.println(st.getS() );
		}
		System.out.println("the number of evaluated nodes is :"+s.getNumberOfNodesEvaluated());
		
		System.out.println("\n\n\nwith diagonal:\n\n\n");
		
		sm = new SearchableMaze(maze, true);
		s = new BFS();
		ite = s.search(sm).GetList().iterator();
		while(ite.hasNext()==true)
		{
			st=ite.next();
			System.out.println(st.getS() );
		}
		System.out.println("the number of evaluated nodes is :"+s.getNumberOfNodesEvaluated());
		
		System.out.println("\n\n\nAstar:\n\n\nwithout diagonal:\n\n\n");
		
		Heuristics h;
		h = new MazeManhattanDistance();
		sm = new SearchableMaze(maze, false);
		s = new Astar(h);
		ite = s.search(sm).GetList().iterator();
		while(ite.hasNext()==true)
		{
			st=ite.next();
			System.out.println(st.getS() );
		}
		System.out.println("the number of evaluated nodes is :"+s.getNumberOfNodesEvaluated());
		
		System.out.println("\n\n\nwith diagonal:\n\n\n");
		
		h = new MazeAirDistance();
		sm = new SearchableMaze(maze, true);
		s = new Astar(h);
		ite = s.search(sm).GetList().iterator();
		while(ite.hasNext()==true)
		{
			st=ite.next();
			System.out.println(st.getS() );
		}
		System.out.println("the number of evaluated nodes is :"+s.getNumberOfNodesEvaluated());
	}
	
	
	public Demo() {
		// TODO Auto-generated constructor stub
		super();
	}
}

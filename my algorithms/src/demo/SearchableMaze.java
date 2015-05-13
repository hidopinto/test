package demo;

import java.util.ArrayList;

import algorithms.mazeGenerators.Cell;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Searchable;
import algorithms.search.State;


/**
 * <h2>SearchableMaze</h2>
 * SearchableMaze is a Comparator for Maze and Searchable
 * @author Hido Pinto
 *
 */
public class SearchableMaze implements Searchable{
	
	Maze maze;
	boolean isDiagonal;
	
	
	/**
	 * constructs a SearchableMaze class
	 * @param m - the maze
	 * @param flag - true=there is a diagonal, false=there isn't a diagonal
	 */
	public SearchableMaze(Maze m, boolean flag) {
		super();
		this.maze = m;
		this.isDiagonal = flag;
	}
	
	/**
	 * returns the start State - a class which describes a position
	 * @see State
	 * @return s
	 */
	@Override
	public State getStartState() {
		State s = new State("0,0",0,null);
		return s;
	}

	
	/**
	 * returns the goal State - a class which describes a position
	 * @see State
	 * @return s
	 */
	@Override
	public State getGoalState() {
		String str = (this.maze.getRows()-1) + "," + (this.maze.getCols()-1);
		State s = new State(str,0,null);
		return s;
	}

	
	/**
	 * returns an ArrayList of all of the possible States
	 * @see State
	 * @see Cell
	 */
	@Override
	public ArrayList<State> getAllPossibleStates(State s) {
		ArrayList<State> a=new ArrayList<State>();		
		String []str = s.getS().split(",");
		int i = Integer.parseInt(str[0]);
		int j =Integer.parseInt(str[1]);
		Cell c = this.maze.getCell(i,j);
		String parentStr;
		Cell diagC;
		
		if(!(s.getParent()==null))
			parentStr = s.getParent().getS();
		else
			parentStr = "0,0";
		
		if(j!=0 && c.getHasLeftWall()==false)
		{
			String ns = i + "," + (j-1);
			if(!ns.equals(parentStr))
				a.add(new State(ns,s.getCost()+10,s));
		}
		if(j!=(this.maze.getCols()-1) && c.getHasRightWall()==false)
		{
			String ns = i + "," + (j+1);
			if(!ns.equals(parentStr))
				a.add(new State(ns,s.getCost()+10,s));
		}
		if(i!=0 && c.getHasTopWall()==false)
		{
			String ns = (i-1) + "," + j;
			if(!ns.equals(parentStr))
				a.add(new State(ns,s.getCost()+10,s));
		}
		if(i!=(this.maze.getRows()-1) && c.getHasBottomWall()==false)
		{
			String ns = (i+1) + "," + j;
			if(!ns.equals(parentStr))
				a.add(new State(ns,s.getCost()+10,s));
		}
		
		if(this.isDiagonal == true){
			if(i!=0 && c.getHasTopWall()==false){
				if(j!=0)
				{
					diagC = this.maze.getCell((i-1), (j-1));
					if(diagC.getHasRightWall()==false)
					{
						String ns = (i-1) + "," + (j-1);
						if(!ns.equals(parentStr))
							a.add(new State(ns,s.getCost()+15,s));
					}
				}
				if(j!=(this.maze.getCols()-1))
				{
					diagC = this.maze.getCell((i-1), (j+1));
					if(diagC.getHasLeftWall()==false)
					{
						String ns = (i-1) + "," + (j+1);
						if(!ns.equals(parentStr))
							a.add(new State(ns,s.getCost()+15,s));
					}
				}
			}
			
			if(i!=(this.maze.getRows()-1) && c.getHasBottomWall()==false){
				if(j!=0)
				{
					diagC = this.maze.getCell((i+1), (j-1));
					if(diagC.getHasRightWall()==false)
					{
						String ns = (i+1) + "," + (j-1);
						if(!ns.equals(parentStr))
							a.add(new State(ns,s.getCost()+15,s));
					}
				}
				if(j!=(this.maze.getCols()-1) )
				{
					diagC = this.maze.getCell((i+1), (j+1));
					if(diagC.getHasLeftWall()==false)
					{
						String ns = (i+1) + "," + (j+1);
						if(!ns.equals(parentStr))
							a.add(new State(ns,s.getCost()+15,s));
					}
				}
			}
			
			if(j!=(this.maze.getCols()-1) && c.getHasRightWall()==false){
				if(i!=0)
				{
					diagC = this.maze.getCell((i-1), (j+1));
					if(diagC.getHasBottomWall()==false)
					{
						String ns = (i-1) + "," + (j+1);
						if(!ns.equals(parentStr))
							a.add(new State(ns,s.getCost()+15,s));
					}
				}
				if(i!=(this.maze.getRows()-1))
				{
					diagC = this.maze.getCell((i+1), (j+1));
					if(diagC.getHasTopWall()==false)
					{
						String ns = (i+1) + "," + (j+1);
						if(!ns.equals(parentStr))
							a.add(new State(ns,s.getCost()+15,s));
					}
				}
			}
			
			if(j!=0 && c.getHasLeftWall()==false){
				if(i!=0)
				{
					diagC = this.maze.getCell((i-1), (j-1));
					if(diagC.getHasBottomWall()==false)
					{
						String ns = (i-1) + "," + (j-1);
						if(!ns.equals(parentStr))
							a.add(new State(ns,s.getCost()+15,s));
					}
				}
				if(i!=(this.maze.getRows()-1))
				{
					diagC = this.maze.getCell((i+1), (j-1));
					if(diagC.getHasTopWall()==false)
					{
						String ns = (i+1) + "," + (j-1);
						if(!ns.equals(parentStr))
							a.add(new State(ns,s.getCost()+15,s));
					}
				}
			}
		}
		
		return a;
	}

}

package algorithms.search;

import java.util.*;

import algorithms.mazeGenerators.Searchable;

/**
 * <h2>CommonSearcher</h2>
 * define all the common between Searchers. implements Searcher
 * @author Hido Pinto
 * @see State
 * @see Searcher
 * @see Searchable
 */
public abstract class CommonSearcher implements Searcher{
	Comparator<State> compare;
	PriorityQueue<State> openList;
	private int evaluatedNodes;
	
	
	
	
	/**
	 * adds State to the State queue
	 * @param s 
	 * @see State
	 */
	protected void addToOpenList(State s)
	{
		this.openList.add(s);
	}
	
	
	/**
	 * returns a State from the State queue
	 * @return openList.poll()
	 * @see State
	 */
	protected State popOpenList() 
	{
		this.evaluatedNodes++;
		return openList.poll();
		
	}
	
	
		
	
	/**
	 * return the minimum cost in the tree
	 * @return min - integer which describes the minimum cost
	 */
	protected int getMinCostState()
	{
		int min = openList.peek().getCost();
		State s;
		Iterator<State> ite = openList.iterator();
		while(ite.hasNext())
		{
			s = ite.next();
			if(s.getCost() < min)
				min = s.getCost();
		}
		return min;
	}
	
	
	/**
	 * returns a solution-path to the Search
	 * @param goalState
	 * @param startState
	 * @return s - Solution
	 */
	protected Solution backTrace(State goalState,State startState)
	{
		Solution s = new Solution();
		s.addToList(goalState);
		State p=goalState.getParent();
		
		while(p.getParent().equals(startState)==false)
		{
			s.addToList(p);
			p=p.getParent();
		}
		s.addToList(p);
		
		s.Reverse();
		return s;
	}
	
	
	/**
	 * updates a State's cost if needed
	 * @param state
	 * @see State
	 */
	
	/**
	 * updates a State's cost if needed
	 * @param state
	 * @see State
	 */
	protected void adjustStateCostOpenList(State state)
	{
		State n;
		Iterator<State> ite = openList.iterator();
		while(ite.hasNext()) 
		{
			n = ite.next();
			if(n.equals(state)) 
			{
				n.setCost(state.getCost());
			}
		}
		return;
	} 
	
	 @Override
	 public abstract Solution search(Searchable s);

	 
	 /**
	  * returns the evaluated nodes number
	  * @return evaluatedNodes
	  */
	 @Override
	 public int getNumberOfNodesEvaluated() {
	  return evaluatedNodes;
	 }
	 
	 
	 /**
	  * CommonSearcher constructor
	  */
	 public CommonSearcher() {
		 super();
		 this.compare = new StateComparator();
		  this.openList=new PriorityQueue<State>(compare);
		  evaluatedNodes=0;
	}


	public int getEvaluatedNodes() {
		return evaluatedNodes;
	}


	public void setEvaluatedNodes(int evaluatedNodes) {
		this.evaluatedNodes = evaluatedNodes;
	}


	
}

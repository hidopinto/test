package algorithms.search;

import algorithms.mazeGenerators.Searchable;


/**
 * <h2>Searcher</h2>
 * define search algorithms functionality
 * @author Hido Pinto
 *
 */
public interface Searcher {
	
	
	/**
	 * the basic function of every searcher - search
	 * returns the solution for the search problem
	 * @param s - a searchable object
	 * @return Solution
	 * @see Solution
	 */
	public abstract Solution search(Searchable s);

	/**
	 * returns the number of nodes evaluated
	 * @return
	 */
	public int getNumberOfNodesEvaluated();
}

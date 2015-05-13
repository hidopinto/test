package algorithms.search;


/**
 * <h2>Heuristics</h2>
 * Heuristics is an interface used in Astar function to calculate path's costs
 * @author Hido Pinto
 * @see Astar
 */
public interface Heuristics {
	
	/**
	 * this function should forecasts the remaining cost for a State
	 * @param s - current State
	 * @param GoalState - final State
	 * @return integer number that forecasts the remained cost
	 */
	public int h(State s, State GoalState);
}

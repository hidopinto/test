package algorithms.search;


/**
 * <h2>MazeManhattanDistance</h2>
 * MazeManhattanDistance is an class which can be used in Astar function to calculate path's costs.
 * implements Heuristics.
 * calculate the path's cost via Manhattan distance calculation based on rows and cols distances.
 * @author Hido Pinto
 *
 */
public class MazeManhattanDistance implements Heuristics {

	
	/**
	 * this function should forecasts the remaining cost for a State
	 * calculate the path's cost via Manhattan distance calculation based on rows and cols distances.
	 * @param s - current State
	 * @param GoalState - final State
	 * @return integer number that forecasts the remained cost
	 */
	public int h(State s, State GoalState) {
		
		String []str = s.getS().split(",");
		int currentI = Integer.parseInt(str[0]);
		int currentJ =Integer.parseInt(str[1]);
		
		String []str1 = GoalState.getS().split(",");
		int goalI = Integer.parseInt(str1[0]);
		int goalJ =Integer.parseInt(str1[1]);
		
		return (Math.abs(goalI-currentI) + Math.abs(goalJ-currentJ))*10;
	}

}

package algorithms.search;


/**
 * <h2>MazeAirDistance</h2>
 * MazeAirDistance is an class which can be used in Astar function to calculate path's costs.
 * implements Heuristics.
 * calculate the path's cost via air distance calculation based on pitagoras's sentence.
 * @author Hido Pinto
 *
 */
public class MazeAirDistance implements Heuristics {

	
	/**
	 * this function should forecasts the remaining cost for a State
	 * calculate the path's cost via air distance calculation based on pitagoras's sentence.
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
		
		return (int) (Math.sqrt(Math.pow(goalI-currentI,2) + Math.pow(goalJ-currentJ, 2) )*10);
	}

}

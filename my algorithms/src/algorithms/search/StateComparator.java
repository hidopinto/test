package algorithms.search;

import java.util.Comparator;


/**
 * <h2>StateComparator</h2>
 * comparator for comparing 2 states
 * @author Hido Pinto
 * @ State
 */
public class StateComparator implements Comparator<State> {

	
	/**
	 * compares between 2 States based on their String s datamember
	 * @return an integer number:
	 * 0-equal
	 * 1-left object smaller then right object
	 * 2-left object bigger then right object
	 */
	@Override
	public int compare(State arg0, State arg1) {
		if(arg0.getCost() < arg1.getCost())
			return -1;
		if(arg0.getCost() > arg1.getCost())
			return 1;
		return 0;
	}

}

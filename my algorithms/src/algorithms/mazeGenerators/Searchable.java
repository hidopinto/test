package algorithms.mazeGenerators;

import java.util.ArrayList;

import algorithms.search.State;


/**
 * <h2>Searchable</h2>
 * defines searchable functionality so searching algorithms would know how to work with them
 * @author Hido Pinto
 * @see State
 */
public interface Searchable {
	State getStartState();
	State getGoalState();
	ArrayList<State> getAllPossibleStates(State s);

}

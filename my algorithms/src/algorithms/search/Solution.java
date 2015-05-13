package algorithms.search;

import java.util.Collections;
import java.util.LinkedList;


/**
 * <h2>Solution</h2>
 * a class which contains a LinkedList of States and the total cost.
 * the States LinkedList (after being reversed) is the Solution.
 * the cost is the total cost which took to get to it.
 * @author Hido Pinto
 *
 */
public class Solution {
	private LinkedList<State> solution;
	private int cost;
	
	
	/**
	 * construct a Solution. setting cost to 0 and allocating free space for our LinkedList<State>- solution. 
	 */
	public Solution() {
		super();
		this.solution = new LinkedList<State>();
		this.cost = 0;
	}
	
	
	/**
	 * returns the total cost
	 * @return cost
	 */
	public int getCost() {
		return cost;
	}

	
	/**
	 * sets a new total cost
	 * @param cost
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}

	
	/**
	 * returns our LinkedList<State>- solution
	 * @return solution
	 */
	public LinkedList<State> GetList()
	{
		return this.solution;
	}
	
	
	/**
	 * adds a new State to our LinkedList<State>- solution
	 * @param s
	 */
	public void addToList(State s)
	{
		solution.add(s);
	}
	
	
	/**
	 * reverses the LinkedList<State> -solution. after that we get a well ordered solution.
	 */
	public void Reverse()
	{
		Collections.reverse(this.solution);
	}
}

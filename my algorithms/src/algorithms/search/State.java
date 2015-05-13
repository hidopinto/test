package algorithms.search;


/**
 * <h2>State</h2>
 * a class which it's target is to define the current state ,and the last state.
 * @author Hido Pinto
 *
 */
public class State {
	private String s;
	private int cost;
	private State parent;
	
	
	/**
	 * constructing a State class with parameters:
	 * @param s(String)-string that outlines the current State
	 * @param cost(int)-total cost to get to the current State
	 * @param parent(State)-previous State
	 */
	public State(String s, int cost, State parent) {
		super();
		this.s=s;
		this.cost=cost;
		this.parent=parent;
	}

	/**
	 * returns String thats outlines the State
	 * @return s
	 */
	public String getS() {
		return s;
	}

	/**
	 * sets s- a String that outlines the State
	 * @param s
	 */
	public void setS(String s) {
		this.s = s;
	}

	/**
	 * return the total cost required to get to the current State
	 * @return cost
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * sets the total cost required to get to the current State 
	 * @param cost
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}

	/**
	 * return the previous State
	 * @return parent
	 */
	public State getParent() {
		return parent;
	}

	/**
	 * sets the Previous State
	 * @param parent
	 */
	public void setParent(State parent) {
		this.parent = parent;
	}
	
	/**
	 * compares between to States
	 * @param s- a State
	 * @return true if equal and false if not
	 */
	@Override
	public boolean equals(Object obj){ // we override Object's equals method
        return this.s.equals(((State)obj).s);
    } 

	
}

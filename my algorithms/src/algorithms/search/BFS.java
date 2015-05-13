package algorithms.search;

import java.util.*;

import algorithms.mazeGenerators.Searchable;


/**
 * <h2>BFS</h2>
 * a class which contains a BFS search method
 * @author Hido Pinto
 * @see CommonSearcher
 * @see Solution
 * @see State
 * @see Searchable
 */
public class BFS extends CommonSearcher{

	
	/**
	 * the BFS search method
	 * @return Solution
	 * @see Solution
	 */
	@Override
	public Solution search(Searchable s) {
		
		
		addToOpenList(s.getStartState());
		  HashSet<State> closedSet=new HashSet<State>();
		  
		  
		  while(openList.size()>0){
			  this.setEvaluatedNodes(this.getEvaluatedNodes()+1);
		    State n=popOpenList();// dequeue
		    closedSet.add(n);

		    if(n.equals(s.getGoalState()))
		      return backTrace(n, s.getStartState()); 
		      // private method, back traces through the parents

		    ArrayList<State> successors=s.getAllPossibleStates(n); //however it is implemented 
		    for(State state : successors){
		      if(!closedSet.contains(state) && ! openList.contains(state)){
		        state.setParent(n);
		        this.openList.add(state);
		      } 
		      else if(state.getCost() < getMinCostState()){
		    	  if(! openList.contains(state))
		    	  {
		    		  state.setParent(n);
		    		  addToOpenList(state);
		    	  }
		    	  else
		    	  {
		    		  adjustStateCostOpenList(state);
		    	  }
		    	  
		      }
		    }
		  }
		  return backTrace(s.getGoalState(), s.getStartState()); //can't get to this line. it's only here to prevent an error.
	}

}

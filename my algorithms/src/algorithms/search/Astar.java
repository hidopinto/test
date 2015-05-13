package algorithms.search;

import java.util.ArrayList;
import java.util.HashSet;

import algorithms.mazeGenerators.Searchable;


/**
 * <h2>Astar</h2>
 * a class which contains an Astar search method
 * @author Hido Pinto
 * @see CommonSearcher
 * @see Solution
 * @see State
 * @see Searchable
 * @see Heuristics
 */
public class Astar extends CommonSearcher{
	
	Heuristics h;
	
	
	/**
	 * creates an Astar object
	 * @param h Heuristics - sets the h() type method
	 * @see Heuristics
	 */
	public Astar(Heuristics h) {
		super();
		this.h=h;
	}
	
	
	/**
	 * the Astar search method
	 * @return Solution
	 * @see Solution
	 */
	@Override
	public Solution search(Searchable s) {
		int g_score,dist,f_score;
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
		    	
		    	dist=Math.abs(state.getCost()-n.getCost());
		    	g_score=n.getCost()-h.h(n, s.getGoalState())+dist;
		    	f_score=g_score+h.h(state, s.getGoalState());
		    	state.setCost(f_score);
		    	
		      if(!closedSet.contains(state) && ! openList.contains(state)){
		        state.setParent(n);
		        addToOpenList(state);
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

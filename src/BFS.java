import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

public class BFS extends ForAlgorithms {

	Queue<Node> frontier;
    HashSet<Integer> frontierSet;
    HashSet<Integer> explored;

	public BFS() {
		super();
		frontier = new LinkedList<>();
		frontierSet = new HashSet<>();
		explored = new HashSet<>();
	}

	public boolean search(Node initialState, Results_inf result) {
		frontier.add(initialState);
		frontierSet.add(initialState.getState());
        while(!frontier.isEmpty()){
            Node state=frontier.poll();
            frontierSet.remove(state.getState());
            explored.add(state.getState());
            
            if(state.getState() == 123456789){
                getGoalNode().setParent(state.getParent());
                result.setNofNodesExpanded(explored.size());
                return true;
            }
            
            for(Node child : state.children()){
                if(!explored.contains(child.getState()) && !frontierSet.contains(child.getState())) {
                	child.setParent(state);
                    frontier.add(child);
                    frontierSet.add(child.getState());
                }
            }
        }
        result.setNofNodesExpanded(explored.size());
        return false;
    }

}

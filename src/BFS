import java.util.*;

public class BFS extends Node {
	
	Queue<Node> frontier;
	HashSet<Integer> explored;
    public BFS(){
        frontier = new LinkedList<>();
        explored = new HashSet<>();
    }
  
    boolean goalTest(Node state) {
    	int stt = state.getState();
    	if(stt == 12345678)
    		return true;
    	return false;
    }
    
    boolean search(Node initialState) {
        frontier.add(initialState);
        while(!frontier.isEmpty()){
            Node state = frontier.poll();
            explored.add(state.getState());
            
            if(goalTest(state)){
                return true;
            }
            
            for(Node child : state.children()){
                if(!explored.contains(child.getState()) && !frontier.contains(child.getState())) {
                	child.setParent(state);
                    frontier.add(child);
                }
            }
        }
        return false;
    }
}

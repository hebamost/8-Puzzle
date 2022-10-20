import java.util.*;



public class DFS extends ForAlgorithms {
    Stack<Node> frontier;
    HashSet<Integer> frontierSet;
    public DFS(){
        super();
        frontier=new Stack<>();
        frontierSet = new HashSet<>();
    }

    @Override
    boolean search(Node initialState, Results_inf result) {
        frontier.push(initialState);
        frontierSet.add(initialState.getState());

        while(!frontier.isEmpty()){
            Node state=frontier.pop();
            frontierSet.remove(state.getState());
            explorerSet.add(state.getState());
            if(ReachedGoal(state)){
                getGoalNode().setParent(state.getParent());
                result.setNofNodesExpanded(explorerSet.size());
                return true;
            }
            for(Node neighbor : state.neighbors(true)){
                if(!explorerSet.contains(neighbor.getState()) && !frontierSet.contains(neighbor.getState())) {
                    neighbor.setParent(state);
                    frontier.add(neighbor);
                    frontierSet.add(neighbor.getState());
                }
            }
        }
        result.setNofNodesExpanded(explorerSet.size());
        return false;
    }

}
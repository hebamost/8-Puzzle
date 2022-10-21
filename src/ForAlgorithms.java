import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public abstract class ForAlgorithms {
    HashSet<Integer> explorerSet;
    Node goalNode;

    //error null pointer
    ForAlgorithms(){
        int goalState= 12345678;
        goalNode=new Node(goalState);
        explorerSet=new HashSet<>();
    }


    //////result
    ////////////CHANGE IT
    public Results_inf solve(Node initialState){
        Results_inf result = new Results_inf();
        // Calculate the running time
        long startTime = System.nanoTime();
        search(initialState, result);
        long endTime = System.nanoTime();
        long timeElapsed = (endTime - startTime);
        result.setTime(timeElapsed / 1000000);
        // Save the solution path
        result.setPath(PathOfNodes());

        return result;
    }


    abstract boolean search(Node initialState,Results_inf result);

    List<Node> PathOfNodes(){
        LinkedList<Node> path=new LinkedList<>();
        Node curr=goalNode;
        while(curr!=null){
            path.addFirst(curr);
            curr=curr.getParent();
        }
        return path;
    }


    public boolean ReachedGoal(Node state){
        return state.equals(goalNode);
    }
    Node getGoalNode(){
        return goalNode;
    }

}

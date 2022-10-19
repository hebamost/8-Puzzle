import java.util.*;

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


    abstract boolean search(Node initialState,Result result);

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

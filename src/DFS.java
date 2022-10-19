import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;




public class DFS extends ForAlgorithms {


    public static Stack<Node> frontier;
    // HashSet<Integer> frontierSet;
    // static HashSet<Node> explorerSet;
    static HashMap<Node, Node> parentMap;
    // static Integer Depth = 0;
    //static Integer NodesExpanded = 0;
    static Node currentNode;
    //static int goalState= 12345678;
    //static Node goalNode=new Node(123345678);
    // static Node initialState=new Node(123345678);

    public DFS() {
        super();
        frontier = new Stack<>();
        parentMap= new HashMap<>();
        System.out.println(" i started HERE");
    }


    public boolean search(Node initialState, Results_inf result) {
       // System.out.println(" i started");
        frontier.push(initialState);          //m4 byd5l hnaaaa leeeeeeeeeh
        //System.out.println("s 1");
        parentMap.put(initialState, initialState);
        // frontierSet.add(initialState.getState());
        while (!frontier.isEmpty()) {
            currentNode = frontier.pop();   //curr node
            explorerSet.add(currentNode.getState());
            // currentNode.state == 12345678
            if (ReachedGoal(currentNode)) {
                getGoalNode().setParent(currentNode.getParent());
                result.setNofNodesExpanded(explorerSet.size());
                System.out.println(" solve");
                return true;  //goal state is reached
            }
            for (Node neighbor : initialState.children()) {
                if (!explorerSet.contains(neighbor.getState()) && !frontier.contains(neighbor.getState())) {
                    neighbor.setParent(currentNode);
                    frontier.add(neighbor);
                    parentMap.put(neighbor, currentNode);

                }


            }


        }
        System.out.println("no solve");
        result.setNofNodesExpanded(explorerSet.size());
        return false;

    }

}


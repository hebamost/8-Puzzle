import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;



public class DFS {


    public static Stack<Node> frontier;
   // HashSet<Integer> frontierSet;
    static HashSet<Node> explorerSet;
    static HashMap<Node, Node> parentMap;
   // static Integer Depth = 0;
    //static Integer NodesExpanded = 0;
    static Node currentNode;
    //static int goalState= 12345678;
    static Node goalNode=new Node(123345678);
   // static Node initialState=new Node(123345678);

   /* Algorithm(){
        int goalState= 12345678;
        goalNode=new Node(goalState);
        explored=new HashSet<>();
    }*/
    /*public DFS(){
        super();
        frontier=new Stack<>();
    }*/




    public static boolean dfs(Node initialState) {
        System.out.println(" i started");
        frontier.push(initialState);          //m4 byd5l hnaaaa leeeeeeeeeh
        System.out.println("s 1");
        parentMap.put(initialState, initialState);
        // frontierSet.add(initialState.getState());
        while (!frontier.isEmpty()) {
            currentNode = frontier.pop();   //curr node
            explorerSet.add(currentNode);
           // currentNode.state == 12345678
            if (goalTest(currentNode)) {
                System.out.println(" solve");
                return true;  //goal state is reached
            }
            for (Node neighbor : initialState.children()) {
                if (!explorerSet.contains(neighbor.getState()) && !frontier.contains(neighbor.getState())) {
                    frontier.add(neighbor);
                    parentMap.put(neighbor, currentNode);

                }


            }


        }
        System.out.println("no solve");
        return false;

    }

    public static boolean goalTest(Node state){
        return state.equals(goalNode);
    }
    Node getGoalNode(){
        return goalNode;
    }


    public static class main{
        public static void main(String[] args){
            /*Scanner in = new Scanner(System.in);
            System.out.print("Enter initial state space or comma separated: ");
            String s = in.nextLine();
            s = s.replaceAll(",", "");
            s = s.replaceAll(" ", "");*/
           // Node node = new Node(Integer.parseInt(s));
            Node node=new Node(120345678);
            dfs(node);


        }
    }
}

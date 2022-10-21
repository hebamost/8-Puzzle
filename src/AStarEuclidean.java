import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class AStarEuclidean extends ForAlgorithms {
    Heuristics getCost = new Heuristics() ;
    PriorityQueue<Node> frontier = new PriorityQueue<>(10,new comparePriority()) ;
    HashMap<Integer ,Double> frontierCosts= new HashMap<>() ;
    private int maxDepth = 0 ;
    private int nodesExpanded = 0 ;
    private int pathCost = 0 ;
    @Override
    public boolean search (Node initialNode,Results_inf result){
        frontier.add(initialNode)  ;
        frontierCosts.put(initialNode.getState(),0.0) ;
        Node currentNode ;
        while(!frontier.isEmpty()) {
            currentNode = frontier.poll() ;
            frontierCosts.remove(currentNode.getState()) ;
            if (explorerSet.contains(currentNode.getState())){
                continue ;
            }
            explorerSet.add(currentNode.getState()) ;
            if (ReachedGoal(currentNode)){
                nodesExpanded = explorerSet.size() ;
                pathCost = currentNode.getDepth() ;
                maxDepth = currentNode.getCost() ;
                System.out.println("Goal Reached Man !") ;
                System.out.println("Search Depth " + maxDepth);
                System.out.println("# of nodes expanded = " + nodesExpanded);
                System.out.println("Cost of Path = "+ pathCost);
                getGoalNode().setParent(currentNode.getParent());
                result.setNofNodesExpanded(explorerSet.size());
                return true ;
            }
            List<Node> children = currentNode.children() ;
            for (Node child : children) {
                if(!explorerSet.contains(child.getState())) {
                    child.setCost(currentNode.getCost() + 1) ;
                    child.setTotalCost(getCost.heuristicCost(child.getState(),false) + child.getCost());
                    child.setParent(currentNode) ;
                    if(frontierCosts.containsKey(child.getState())) {
                        if(child.getTotalCost() < frontierCosts.get(child.getState())) {
                            frontierCosts.put(child.getState(), child.getTotalCost());
                            frontier.remove(child);
                        }else {
                            continue;
                        }
                    }
                    frontier.add(child) ;
                }
            }
        }
        System.out.println("Unsolvable Case !");
        System.out.println("# of nodes expanded = " + (explorerSet.size()));
        return false;
    }
}

import java.util.List;

public class Results_inf {
    //to calculate time
    public Long time;

    public Results_inf() {

    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    //number of expanded nodes from intial state to goal state
    public int nofNodesExpanded=0;

    public int getNofNodesExpanded() {
        return nofNodesExpanded;
    }

    public void setNofNodesExpanded(int nofNodesExpanded) {
        this.nofNodesExpanded = nofNodesExpanded;
    }


    public List<Node> path;

    public List<Node> getPath() {
        return path;
    }

    public void setPath(List<Node> path) {
        this.path = path;
    }

    public int getCost() {
        return nofNodesExpanded- 1;
    }


    public Results_inf(Long time, int nofNodesExpanded , List<Node> path) {
        this.nofNodesExpanded = nofNodesExpanded;
        this.time = time;
        this.path = path;

    }


}

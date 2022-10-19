import java.util.*;

public class Node {
    int state = 0;
    double totalCost ;
    int cost = 0 ;
    Node parent ;
    static final int dimension = 3;
    Node(){
        state=0;
        cost=0;
    }
    public Node(int state){
        this.state=state;

    }

    public void setCost (int cost){
        this.cost = cost ;
    }
    public void setState (int state){
        this.state = state ;
    }
    public void setTotalCost (double totalCost){
        this.totalCost = totalCost ;
    }
    public void setParent (Node parent){
        this.parent = parent ;
    }
    public int getCost (){
        return this.cost ;
    }
    public int getState (){
        return this.state ;
    }
    public double getTotalCost (){
        return this.totalCost ;
    }
    public Node getParent (){
        return this.parent ;
    }

    public List<Node> children (){
        LinkedList<Node> children = new LinkedList<>() ;
        int[] stateArray = new int[9] ;
        String stateString = Integer.toString(this.state) ;
        int indexOfZero = -7 ;
        for (int i=0 ; i<stateString.length() ; i++){
            stateArray[i] = stateString.charAt(i) - '0' ;
            if (stateArray[i] == 0){
                indexOfZero = i ;
            }
        }
        if (indexOfZero >2){     //can go up
            Node child = new Node() ;
            child.setState(this.state);
            child.swap(indexOfZero, indexOfZero-dimension);
            children.add(child);
        }
        if (indexOfZero <6){     //can go down
            Node child = new Node() ;
            child.setState(this.state);
            child.swap(indexOfZero, indexOfZero+dimension);
            children.add(child);
        }
        if (indexOfZero % dimension == 0 || indexOfZero % dimension == 1){     //can go right
            Node child = new Node() ;
            child.setState(this.state);
            child.swap(indexOfZero, indexOfZero+1);
            children.add(child);
        }
        if (indexOfZero % dimension == 1 || indexOfZero % dimension == 2){     //can go left
            Node child = new Node() ;
            child.setState(this.state);
            child.swap(indexOfZero, indexOfZero-1);
            children.add(child);
        }
        return children;
    }




    private void swap (int i, int j) {
        int [] curr = new int[3*3];
        String st = Integer.toString(state);
        if(st.length() != 9) {
            st = '0' + st;
        }
        for (int k=0;k<st.length();k++){
            curr[k] = st.charAt(k) - '0';
        }

        int t = curr[i];
        curr[i] = curr[j];
        curr[j] = t;


        int result = 0;
        for (int k=0;k<st.length();k++){
            result*=10;
            result+=curr[k];
        }


        this.state =result;

    }





}
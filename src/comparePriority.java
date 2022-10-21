import java.util.Comparator;

public class comparePriority implements Comparator<Node> {
    @Override
    public int compare(Node o , Node s) {
        if (o.getTotalCost() < s.getTotalCost()) {
            return -1;
        }
        if (o.getTotalCost() > s.getTotalCost()) {
            return 1;
        }
        return 0;
    }
}

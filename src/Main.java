import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter initial state comma separated: ");
		String initS = in.nextLine();
		initS = initS.replaceAll(",", "");
		Node node = new Node();
		node.setState(Integer.parseInt(initS));
		System.out.println("Choose algorithm to Solve : ");
		System.out.println("1 --> BFS\n2 --> DFS\n3 --> A* Manhattan Distances\n4 --> A* Euclidean Distances");
		int alg = in.nextInt();
		in.close();
		ForAlgorithms m = null;

		switch (alg) {
		case 1:
			m = new BFS();
			break;
		case 2:
			m = new DFS();
			break;
		}

		Results_inf res = m.solve(node);
		System.out.printf("Solved in %d Moves\n", res.getCost());
		System.out.printf("Solved in %d ms\n", res.getTime());
		System.out.println("Nodes Expanded: " + res.getNofNodesExpanded());
		System.out.println("Writing path ro file path.txt ...");
	}
}

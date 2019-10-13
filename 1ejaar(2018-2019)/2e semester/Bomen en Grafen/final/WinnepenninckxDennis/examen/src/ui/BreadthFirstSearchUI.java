package ui;

import java.util.List;

import domain.Graph;

public class BreadthFirstSearchUI {

	public static void main(String[] args) {

		int data[][] = { 	{ 0, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 1, 0, 0, 0, 0 },
				{ 1, 0, 0, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 1, 1, 0 },
				{ 0, 1, 0, 0, 0, 0, 1 },
				{ 0, 0, 0, 0, 0, 0, 1 },
				{ 0, 0, 0, 0, 0, 0, 0 } };
		Graph bfs = new Graph(data);

		System.out.println(bfs.verdeel(1,1000));
	}

	private static String zetPadOmNaarString(int start, int destination, List<Integer> path) {
		if (path.size() == 0)
			return "Er is geen pad van " + start + " naar " + destination;
		else
			return "Kortste pad van " + start + " naar "+ destination + " is " + path.size() + " knopen lang en bestaat uit volgende knopen  : " + path;
	}
}

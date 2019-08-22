package ui;

import domain.BinarySearchTree;

public class BinarySearchTreeDriver {

	public static void main(String[] args) {
		BinarySearchTree<Integer> boom = new BinarySearchTree<>();
		boom.addNode(6);
		boom.addNode(4);
		boom.addNode(8);
		boom.addNode(3);
		boom.addNode(5);
		boom.addNode(7);
		boom.addNode(9);
		// 3 - 9
		//printBoomInfo(boom);
		// Vraag 1
		System.out.println(boom.geefKnopenBinnenInterval(5,8));

		
	}

	private static void printBoomInfo(BinarySearchTree<Integer> boom) {
		if (boom == null) System.out.println("Lege boom");
		else {
			boom.printInOrder();
			System.out.println();
			if (!boom.isEmpty()) {
				System.out.println("De grootste waarde uit deze boom = " + boom.searchGreatest());
				System.out.println("De kleinste waarde uit deze boom = " + boom.searchSmallest());
			}
			System.out.println("Nodes: "+boom.countNodes());
			System.out.println("Remove:"+boom.removeNode(9));
			boom.printInOrder();
			System.out.println("\nNodes: "+boom.countNodes());
			System.out.println(boom.getPath(8));
		}

	}
}

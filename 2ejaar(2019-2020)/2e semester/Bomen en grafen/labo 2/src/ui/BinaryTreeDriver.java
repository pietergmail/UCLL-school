package ui;

import domain.BinaryTree;

public class BinaryTreeDriver {

	public static void main(String[] args) {
		BinaryTree<String> nodeA = new BinaryTree<>("A");
		BinaryTree<String> nodeC = new BinaryTree<>("C");
		BinaryTree<String> nodeE = new BinaryTree<>("E");
		BinaryTree<String> nodeH = new BinaryTree<>("H");


		BinaryTree<String> nodeD = new BinaryTree<>("D",nodeC,nodeE);
		BinaryTree<String> nodeB = new BinaryTree<>("B",nodeA, nodeD);
		BinaryTree<String> nodeI = new BinaryTree<>("I",nodeH, null);
		BinaryTree<String> nodeG = new BinaryTree<>("G",null, nodeI);
		BinaryTree<String> boom = new BinaryTree<>("F",nodeB, nodeG);
		boom.printPreorder();
		System.out.println("\n");
		boom.printinorder();
		System.out.println("\n");
		boom.printpostorder();
		System.out.println("\n");
		System.out.println(boom.aantalKnopen());
		System.out.println("\n");
		System.out.println(boom.diepte());
		System.out.println(boom.countLeaves());
		System.out.println(boom.count('A'));
	}

}

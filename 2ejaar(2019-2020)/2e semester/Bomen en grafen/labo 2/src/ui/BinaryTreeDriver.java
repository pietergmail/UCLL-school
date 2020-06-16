package ui;

import domain.BinaryTree;

public class BinaryTreeDriver {

	public static void main(String[] args) {
		BinaryTree<String> nodeA = new BinaryTree<>("1");
		BinaryTree<String> nodeC = new BinaryTree<>("2");
		BinaryTree<String> nodeE = new BinaryTree<>("3");
		BinaryTree<String> nodeH = new BinaryTree<>("4");


		BinaryTree<String> nodeD = new BinaryTree<>("5",nodeC,nodeE);
		BinaryTree<String> nodeB = new BinaryTree<>("6",nodeA, nodeD);
		BinaryTree<String> nodeI = new BinaryTree<>("7",nodeH, null);
		BinaryTree<String> nodeG = new BinaryTree<>("8",null, nodeI);
		BinaryTree<String> boom = new BinaryTree<>("9",nodeB, nodeG);
		boom.printPreorder();
		System.out.println("\n");
		boom.printinorder();
		System.out.println("\n");
		boom.printpostorder();
		System.out.println("\n");
		System.out.println(boom.aantalKnopen());
		System.out.println("\n");
		System.out.println(boom.diepte());
		System.out.println(boom.countLeaves());//gives weird data because A is not a valid number
		System.out.println(boom.count("F"));
		System.out.println(boom.getNodesAtDistance(3));
		System.out.println(boom.kindersom());
	}

}

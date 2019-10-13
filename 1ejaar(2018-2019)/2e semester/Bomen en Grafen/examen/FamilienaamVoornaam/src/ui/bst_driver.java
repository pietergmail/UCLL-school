package ui;

import domain.BST;

public class bst_driver {

    public static void main(String[] args) {
        BST<Integer> boom = new BST<>();
        boom.addNode(6);
        boom.addNode(4);
        boom.addNode(8);
        boom.addNode(3);
        boom.addNode(5);
        boom.addNode(7);
        boom.addNode(9);

        System.out.println(boom.geefKnopenBinnenInterval(6, 9, false));
    }

}

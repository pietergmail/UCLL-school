package domain;

import java.util.ArrayList;

public class BinaryTree<E> {
	private ArrayList<E> knopen;

	public BinaryTree(ArrayList<E> knopen) {
		if (!isGeldigeKnopenRij(knopen))
			throw new IllegalArgumentException();

		this.knopen = knopen;
	}
	
	/**
	 * gaat na of de gegeven array knopen overeenkomt met een BB
	 * gaat dus na voor elke knoop dat als deze null is er geen kinderen/kleinkinderen/achterkleinkinderen
	 * zijn (deze moet dus ook allemaal null zijn)
	 * @param knopen
	 * @return true indien de gegeven rij een geldige knopen rij is, false anders
	 */
	private boolean isGeldigeKnopenRij(ArrayList<E> knopen) {
		if (knopen == null || knopen.size() == 0) return false;
		return this.isGeldigeKnopenRij(knopen, 0);
	}
	/**
	 * gaat na of de knoop i in de  gegeven array knopen geldig is
	 * gaat dus na of voor de knoop met index i geldt dat als deze null is er geen kinderen/kleinkinderen/achterkleinkinderen
	 * zijn (deze moet dus ook allemaal null zijn)
	 * @param knopen
	 * @return true indien knoop i en zijn nageslacht in de de gegeven rij een geldige knoop is, false anders
	 */
	private boolean isGeldigeKnopenRij(ArrayList<E> knopen, int i) {
		if (i >= knopen.size())
			return true;

		return true;
	}
	
	/**
	 * print de knopen in inOrder uit
	 */
	public void printInOrder() {
		this.printInOrder(0);
	}
	/**
	 * print de deelboom met wortel knoop met index i , in inOrder uit
	 * @param i
	 */
	private void printInOrder(int i) {
		if (i >= 0 && i < this.knopen.size() && this.knopen.get(i) != null) {
			//TO DO
		}

	}

	public void printPreOrder() {
		this.printPreOrder(0);
	}

	private void printPreOrder(int i) {
		if (i >= 0 && i < this.knopen.size() && this.knopen.get(i) != null) {
			// TO DO
		}

	}

	public void printPostOrder() {
		this.printPostOrder(0);
	}

	private void printPostOrder(int i) {
		if (i >= 0 && i < this.knopen.size() && this.knopen.get(i) != null) {
			//TO DO
		}
	}

	public void printBreadthFirst() {
		//TO DO
	}
	
	public int aantalKnopen() {
		//TO DO
		return 0;
	}

	public int diepte() {
			//TO DO
			return 0;
		
	}
	
	private boolean isLeaf(int i){
		//TO DO
		return true;
	}
	public int aantalBladeren() {
		//TO DO
		return 0;
	}

	public boolean isComplete() {
		//TO DO

		return true;
	}

	public BinaryTree<E> maakLinkerBoom() {
		if (this.knopen.size() >= 2 && this.knopen.get(1) != null) {
			ArrayList<E> res = new ArrayList<>();
			res.add(this.knopen.get(1));
			int k = 2;
			int i = 3;
			while (i < this.knopen.size()){
				for (int j = 1 ; j <= k && i < this.knopen.size(); j++) {res.add(this.knopen.get(i));i++;}
				i+= k;
				k*= 2;
			}
			return new BinaryTree<>(res);
		} else
			return null;
	}
	
	public BinaryTree<E> maakRechterBoom() {
		//TO DO
		return null;
	}

	

	
}


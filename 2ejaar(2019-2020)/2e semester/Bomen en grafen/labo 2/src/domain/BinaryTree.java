package domain;

public class BinaryTree<E> {
	private E data;
	private BinaryTree<E> leftTree, rightTree;
	
	public BinaryTree(E data){
		this(data,null,null);
	}
	
	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree){
		if (data == null) {
			throw new IllegalArgumentException();
		}
		this.data= data;
		this.leftTree= leftTree;
		this.rightTree= rightTree;
	}
	
	public void printPreorder(){
			System.out.print(this.data + " ");
			if (this.leftTree != null) this.leftTree.printPreorder();
			if (this.rightTree != null) this.rightTree.printPreorder();
	}
	public void printinorder(){

		if (this.leftTree != null) this.leftTree.printPreorder();
		System.out.print(this.data + " ");
		if (this.rightTree != null) this.rightTree.printPreorder();
	}
	public void printpostorder(){

		if (this.leftTree != null) this.leftTree.printPreorder();

		if (this.rightTree != null) this.rightTree.printPreorder();

		System.out.print(this.data + " ");
	}

	public int aantalKnopen() {
		int totaal = 0;

		if (this.leftTree != null) {
			 totaal += this.leftTree.aantalKnopen();
		}
		if (this.rightTree != null) {
			  totaal += this.rightTree.aantalKnopen();
		}
		return ++totaal;
	}

	public int diepte(){
		int totaalLeftTree = 0;
		int totaalRightTree = 0;
		if (this.leftTree != null) {
			totaalLeftTree += this.leftTree.diepte();
		}
		if (this.rightTree != null) {
			totaalRightTree += this.rightTree.diepte();
		}

		return Math.max(++totaalLeftTree, ++totaalRightTree);
	}
	public boolean isleaf() {
		return this.leftTree == null && this.rightTree == null;
	}
	public  int countLeaves() {
		int data = 0;
		if (this.leftTree != null) this.leftTree.countLeaves();
		data += this.data.hashCode();
		if (this.rightTree != null) this.rightTree.countLeaves();
		return data;
	}

	public  int count(Character data) {
		int count = 0;
		if (this.data.hashCode() == data.hashCode()) count += 1;
		if (this.leftTree != null) count = this.leftTree.count(data);
		if (this.rightTree != null) count = this.rightTree.count(data);
		return count;
	}

}

package domain;

public class BinarySearchTree<E extends Comparable<E>> {
	private E data;
	private BinarySearchTree<E> leftTree, rightTree;

	public BinarySearchTree(){
	}


	private  BinarySearchTree(E data){
		this.data = data;
	}

	public void printInOrder() {
		if (this.data!=null){
			if (leftTree!=null) leftTree.printInOrder();
			System.out.print(this.data + " ");
			if(rightTree!=null) rightTree.printInOrder();
		}
	}

	public boolean isEmpty(){
		return false;
	}

	public boolean loopup(E data){
		if ( data == null || this.data == null) return false;
		else {
			if (data.compareTo(this.data) == 0) return true;
			else if (data.compareTo(this.data) <  0){
				return (this.leftTree == null?false:leftTree.loopup(data));
			}
			else {
				return (this.rightTree == null? false: rightTree.loopup(data));
			}
		}
	}

	public boolean addNode(E data){
		if(data == null){
			return false;
		}else if(this.data ==null){
			this.data = data;
			return true;
		}else{
			if(this.data.compareTo(data) ==0){
				return false;
			}else if(data.compareTo(this.data) <0){
				if(leftTree == null){
					leftTree = new BinarySearchTree<E>(data);
				}else{
					leftTree.addNode(data);
				}
			}else{
				if(rightTree== null){
					rightTree = new BinarySearchTree<E>(data);
				}else{
					rightTree.addNode(data);
				}
			}
			return true;
		}
	}
}
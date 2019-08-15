package domain;

import java.util.ArrayList;

public class BinarySearchTree<E extends Comparable<E>> {
	private BinaryTree<E> root;

	public void printInOrder() {
			if (this.isEmpty()) System.out.println("Geen data in BST");
			else root.printInOrder();
	}
	public void cleanUp(){
		root.cleanUp();
	}
	public boolean isEmpty(){
		return this.root == null;
	}

	public boolean lookup(E data){
			if (this.isEmpty()) return false;
			return root.lookup(data);
	}

	public boolean addNode(E data){
		if (this.isEmpty()) {
			root = new BinaryTree<>(data);
			return true;
		}
		else return root.addNode(data);
	}

	public boolean removeNode(E data){
		if (this.isEmpty()) return false;
		else {
			boolean ok = root.removeNode(data);
			if (ok && root.isEmpty()) root = null;
			return ok;
		}
	}

	public E searchSmallest(){
		if(this.isEmpty()) throw new IllegalStateException();
		return this.root.searchSmallest();
	}

	public E searchGreatest(){
		if (this.isEmpty()) throw new IllegalStateException();
		return this.root.searchGreatest();
	}
	public int countNodes(){
		return root.countNodes();
	}

	public ArrayList<E> getPath( E data){
		return root.getPath(data);
	}

	public ArrayList<E> geefKnopenBinnenInterval(E min, E max){
		ArrayList<E> res = root.geefKnopenBinnenInterval(min,max);
		ArrayList<E> result = new ArrayList<E>();
		int length = res.size();
		for(int k = 0; k < length; k++){
			E laagste = res.get(0);
			int index = 0;
			for(int i = 0; i < res.size(); i++){
				if(res.get(i).compareTo(laagste) == -1){
					laagste = res.get(i);
					index = i;
				}
			}
			result.add(laagste);
			res.remove(index);
		}
		//inefficiënt
		return result;
	}





	private class BinaryTree<E extends Comparable<E>>{
		private E data;
		private BinaryTree<E> leftTree, rightTree;

		public BinaryTree(E data){
			if (data == null) throw new IllegalArgumentException();
			this.data = data;
		}
		public boolean isLeaf(){
			return leftTree == null && rightTree == null;
		}
		public int countNodes(){
			int total=0;
			if (this.leftTree != null)  total += this.leftTree.countNodes();
			if (this.rightTree != null) total += this.rightTree.countNodes();
			return ++total;
		}
		public void printInOrder(){
			if (leftTree != null) leftTree.printInOrder();
			System.out.print(" " + data);
			if (rightTree != null) rightTree.printInOrder();
		}

		public boolean isEmpty() {
			return data == null;
		}

		public boolean lookup(E data){
			if(this.data.compareTo(data) == 0){return true;}
			if(this.data.compareTo(data) == 1){
				if(this.leftTree == null){return false;}else{
					return leftTree.lookup(data);
				}
			}else{
				if(this.rightTree == null){return false;}else{
					return rightTree.lookup(data);
				}
			}
		}

		public boolean addNode(E data){
			if(this.data == null){
				this.data = data;
				return true;
			}else{
				if(this.data.compareTo(data) == 0){return false;}
				if(this.data.compareTo(data) == 1){
					if(this.leftTree == null){
						leftTree = new BinaryTree<>(data);}
					else{
						this.leftTree.addNode(data);
					}
				}else{
					if(this.rightTree == null){
						rightTree = new BinaryTree<>(data);
					}
					else{
						this.rightTree.addNode(data);
					}
				}
			}
			return false;
		}


		public boolean removeNode(E data){
			if(data.compareTo(this.data) == 0){
				if(isLeaf()){this.data = null; return true;}else{
					if(leftTree != null){
						this.data = leftTree.searchAndDeleteGreatest();
						//this.leftTree.deleteBiggest();
						cleanUp();
						return true;
					}
					if(rightTree != null){
						this.data = rightTree.searchAndDeleteSmallest();
						//this.rightTree.deleteSmallest();
						cleanUp();
						return true;
					}

				}
			}else{
				if(this.data.compareTo(data) == 1){
					if(leftTree == null){return false;}
					boolean ok = leftTree.removeNode(data);
					if (ok) cleanUp();
					return ok;
				}
				else if(this.data.compareTo(data) == -1){
					if(rightTree == null){return false;}
					boolean ok = rightTree.removeNode(data);
					if (ok) cleanUp();
					return ok;
				}
			}
			return false;
		}

		private void cleanUp(){
			if (this.leftTree != null) {
				if (this.leftTree.data != null) {
					this.leftTree.cleanUp();
				} else {
					this.leftTree = null;
				}
			}

			if (this.rightTree != null) {
				if (this.rightTree.data != null) {
					this.rightTree.cleanUp();
				} else {
					this.rightTree = null;
				}
			}

		}

		public E searchAndDeleteGreatest() {
			if(rightTree == null){E res = data; data = null; return res;}else{
				return rightTree.searchAndDeleteGreatest();
			}
		}
		public E searchSmallest(){
			if(this.leftTree == null){return data;}else{
				return this.leftTree.searchSmallest();
			}
		}

		public E searchGreatest(){
			if(this.rightTree == null){return data;}else{
				return this.leftTree.searchGreatest();
			}
		}


		public E searchAndDeleteSmallest() {
			if(leftTree == null){E res = data; data = null; return res;}else{
				return leftTree.searchAndDeleteSmallest();

			}
		}
		public ArrayList<E> getPath(E data) {
			if (!lookup(data)) {//data komt niet voor in BST
				return null;
			}
			ArrayList<E> pad = new ArrayList<>();
			if (this.data.compareTo(data) == 0) {
				pad.add(data);
				return pad;
			} else {
				pad.add(this.data);
				if (this.data.compareTo(data) > 0) {//ga links, data komt zeker voor!
					pad.addAll(this.leftTree.getPath(data));
				} else {// ga rechts, data zit daar gegarandeerd
					pad.addAll((this.rightTree.getPath(data)));
				}
			}
			return pad;
		}
		public ArrayList<E> geefKnopenBinnenInterval(E min, E max){
			ArrayList<E> res = new ArrayList<>();

			if((this.data.compareTo(min) == 1 && this.data.compareTo(max) == -1 )|| this.data.compareTo(min) == 0 || this.data.compareTo(max) == 0){			res.add(this.data);
			}
			if(this.leftTree != null) res.addAll(this.leftTree.geefKnopenBinnenInterval(min,max));
			if(this.rightTree != null) res.addAll(this.rightTree.geefKnopenBinnenInterval(min,max));

			return res;
		}
	}
}



package domain;

import java.util.ArrayList;

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

	public void printInorder(){
	    if (this.leftTree != null) this.leftTree.printInorder();
	    System.out.print(this.data + " ");
	    if (this.rightTree != null) this.rightTree.printInorder();
    }

    public void printPostorder(){
        if (this.leftTree != null) this.leftTree.printInorder();
        if (this.rightTree != null) this.rightTree.printInorder();
        System.out.print(this.data + " ");
	}

	public int aantalknopen(){
	    int totaal = 0;
	    if (this.leftTree != null){
	        totaal += this.leftTree.aantalknopen();
	    }
        if (this.rightTree != null){
            totaal += this.rightTree.aantalknopen();
        }
        return ++totaal;
    }

    public int diepte(){
	    int maxdieptelinks = 0;
	    if(this.leftTree != null){
	        maxdieptelinks += this.leftTree.diepte();
        }
        int maxdiepterechts = 0;
	    if(this.rightTree != null){
	        maxdiepterechts += this.rightTree.diepte();
        }
	    return Math.max(++maxdieptelinks, ++maxdiepterechts);
    }

    public boolean isleaf(){return (this.leftTree == null && this.rightTree == null);}

    public int countLeaves(){
	    if (this.isleaf()){
	        return 1;
        } else {
	        return (this.leftTree == null ? 0 : this.leftTree.countLeaves()) +
                    (this.rightTree == null ? 0 : this.rightTree.countLeaves());
        }
    }

    public ArrayList<E> getDataLeaves(){
	    ArrayList<E> res = new ArrayList<>();
	    if (this.isleaf()){
	        res.add(this.data);
        } else {
            res = (this.leftTree == null ? new ArrayList<>() : this.leftTree.getDataLeaves());
            ArrayList<E> rightLeaves = (this.rightTree == null ? new ArrayList<>() : this.rightTree.getDataLeaves());
            res.addAll(rightLeaves);
        }
        return res;
    }

    public boolean contains(E s){
	    if (s == null){
	        return false;
        }else{
	        if(s.equals(data)){
	            return true;
            }else{
	            return leftTree != null && leftTree.contains(s) ? true : rightTree != null && rightTree.contains(s);
            }
        }
    }
}

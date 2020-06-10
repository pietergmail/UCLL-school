package domain;

import java.lang.reflect.Array;
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
	public void printinorder(){
		if (this.leftTree != null) this.leftTree.printPreorder();
		System.out.print(this.data + " ");
		if (this.rightTree != null) this.rightTree.printinorder();
	}
	public void printpostorder(){
		if (this.leftTree != null) this.leftTree.printpostorder();
		if (this.rightTree != null) this.rightTree.printpostorder();
		System.out.print(this.data + " ");
	}

	public int aantalKnopen() {
		int totaal = 0;

		//check left tree
		if(this.leftTree != null){
			totaal += this.leftTree.aantalKnopen();
		}

		//check right tree
		if(this.rightTree != null){
			totaal += this.rightTree.aantalKnopen();
		}

		//return total + 1
		return ++totaal;
	}

	public int diepte(){
		int totaalLeft = 0;
		int totaalRight = 0;
		//check left tree
		if(this.leftTree != null){
		    totaalLeft += this.leftTree.diepte();
		}

		//check righ tree
		if(this.rightTree != null) {
		    totaalRight += this.rightTree.diepte();
		}

		//return bigest of the 2 + 1;
		return Math.max(++totaalLeft, ++totaalRight);
	}

	//checkt of data een leaf is
	public boolean isleaf() {return this.leftTree == null && this.rightTree == null;}

	public int countLeaves(){
		int data = 0;
		//check left tree
		if (this.leftTree != null) this.leftTree.countLeaves();
		// add data
		data += this.hashCode();
		//check right tree
		if (this.rightTree != null) this.rightTree.countLeaves();
		return data;
	}

	//count all certain leave
	public int count(E data){
		int count = 0;
		//count++ als data hetzelfde
		if (this.data.hashCode() == data.hashCode()) count += 1;
		//check left tree
		if (this.leftTree != null) {
            count += this.leftTree.count(data);
        }
        //check right tree
		if (this.rightTree != null) {
            count += this.rightTree.count(data);
        }
		return count;
	}

	public ArrayList<E> getNodesAtDistance(int k) {
	    //returning arraylist
	    ArrayList<E> list = new ArrayList<>();
        if (k == 0) {
            //add data to list if final
            list.add(this.data);
        }else{
            if(this.leftTree != null){
                //check left tree
                list.addAll(this.leftTree.getNodesAtDistance(k - 1));
            }
            if (this.rightTree != null){
                //check right tree
                list.addAll(this.rightTree.getNodesAtDistance(k-1));
            }
        }
        return list;
    }

    public int getDistance(E data, int level){
	    //check if at right level
	    if (this.data == data) {
            return level;
        }
        //calculate sublevel
        int sublevel = 0;
	    if (this.rightTree != null)
	        //bepaal sublevel
            sublevel = this.leftTree.getDistance(data, level+1);
        if (sublevel != 0){
            //als gevonden return
            return sublevel;
        }
        //check rightTree
        if (this.rightTree != null) {
            sublevel = this.rightTree.getDistance(data, level + 1);
        }
        return sublevel;
	}

	
}

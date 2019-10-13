package domain;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BST<E extends Comparable<E>> {
    private E data;
    private BST<E> leftTree, rightTree;
    ArrayList<E> res = new ArrayList<>();
    public boolean gevonden = false;

    public BST(){
    }


    private  BST(E data){
        this.data = data;
    }

    public boolean lookup(E data){
        if ( data == null || this.data == null) return false;
        else {
            if (data.compareTo(this.data) == 0) return true;
            else if (data.compareTo(this.data) <  0){
                return (this.leftTree == null?false:leftTree.lookup(data));
            }
            else {
                return (this.rightTree == null? false: rightTree.lookup(data));
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
                    leftTree = new BST<E>(data);
                }else{
                    leftTree.addNode(data);
                }
            }else{
                if(rightTree== null){
                    rightTree = new BST<E>(data);
                }else{
                    rightTree.addNode(data);
                }
            }
            return true;
        }
    }
    public ArrayList<E> geefKnopenBinnenInterval(E min, E max, boolean gevonden){
        if (this.data == null){
            throw new IllegalArgumentException();
        }
        ArrayList<E> res = new ArrayList<>();//new arraylist genaamd res
        if(this.data != max && gevonden){//wordt inorder toegevoegd
            ArrayList<E> tempres;
                //als er een pad is, zit het in de linkerboom
                if (this.leftTree == null) {
                    //onderaan de boom, geen pad gevonden return null;
                    return null;
                }
                //ga verder met het leftTree
                tempres = this.leftTree.geefKnopenBinnenInterval(min, max, true);
                //als er een pad is, zit het in de rechterboom
                if (this.rightTree == null) { //onderaan de boom, geen pad gevonden return null;
                    return null;
                }
                //ga verder in de rightTree
                tempres = this.rightTree.geefKnopenBinnenInterval(min, max, true);

        }
        if(min.compareTo(this.data) > 0 && !gevonden){//check of min groter is dan data
            if (this.rightTree != null){
            this.rightTree.geefKnopenBinnenInterval(min, max, true);//herhalen in rechter tak (waar de waarden groter zijn)
            }else{
                return null;
            }
        }

        if(min.compareTo(this.data) < 0 && !gevonden){//check of min kleiner is dan data
            if (this.leftTree != null){
                this.leftTree.geefKnopenBinnenInterval(min, max, false);//herhalen in rechter tak (waar de waarden groter zijn)
            }else{
                return null;
            }
        }

        if(min.equals(this.data) && !gevonden){//start data is gevonden

            gevonden = true;
            res.add(this.data);
            this.geefKnopenBinnenInterval(min, max, true);
        }
        return res;
    }

}

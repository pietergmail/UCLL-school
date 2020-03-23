package domain;

import java.util.ArrayList;

public class
BinaryMinHeap<E extends Comparable<E>> {
    private ArrayList<E> values;

    private boolean isEmpty() {
        return values == null || values.size() == 0;
    }

    public void print() {
        if (this.isEmpty())
            System.out.println("De heap is leeg");
        else
            System.out.println(values);
    }

    public E getMin() {
        if (this.values.size() == 0) throw new IllegalStateException();
        else return this.values.get(0);
    }

    public boolean addValue(E value) {
        // geen null toevoegen aan de heap
        if (value == null) throw new IllegalArgumentException();
        // indien de heap leeg is: eerst initialiseren
        if (this.isEmpty())
            values = new ArrayList<E>();

        values.add(value);//achteraan toevoegen
        this.bubbleUp();//bubbleUp vanaf de laatste zie slides theorie
        return true;
    }

    private void bubbleUp() {
        int index = this.values.size() - 1;
        while (hasparent(index) && parent(index).compareTo(values.get(index)) > 0){
            this.swap(index, parentindex(index));
            index = parentindex(index);
        }
    }

    private boolean hasparent(int i){ return i >= 1;}

    private E parent(int i){return values.get(parentindex(i));}

    private int parentindex(int i){return (i-1)/2;}

    private void swap(int i, int j){
        E temp = this.values.get(i);
        this.values.set(i, this.values.get(j));
        this.values.set(j, temp);
    }

    public E removeSmallest() {
        if (this.isEmpty())
            throw new IllegalStateException("Kan niets verwijderen uit een lege boom");
        E res = this.getMin();// res bevat de kleinste = eerste element van de lijst
        this.values.set(0, this.values.get(this.values.size() - 1));// verwissel eerste met de laatste
        this.values.remove(this.values.size() - 1); // verwijder de laatste
        this.bubbleDown(); // bubble down van eerste naar beneden zie theorie
        return res;
    }

    private void bubbleDown() {
        int index = 0;
        while (hasleftchild(index)){
            //zoekt kleinste kind
            int indexsmallestchild = (index);
            if (hasrightchild(index) && values.get(indexsmallestchild).compareTo(values.get(indexrightchild(index))) > 0){
                indexsmallestchild = indexrightchild(index);
            }
            //vergelijkt ouders met het kleinste kind
            if (values.get(index).compareTo(values.get(indexsmallestchild)) > 0){
                this.swap(index, indexsmallestchild);
            }else{
                break;
            }
            index = indexsmallestchild;
        }
    }

    private int indexleftchild(int i){return 2* i +1;}

    private int indexrightchild(int i){return 2*i+2;}

    private boolean hasleftchild(int i){return indexleftchild(i) < values.size();}

    private boolean hasrightchild(int i){ return indexrightchild(i) < values.size();}

    public ArrayList<E> getPath(E value) {
        int index = this.values.indexOf(value);
        if(index == -1){
            return null;
        }else{
            ArrayList<E> pad = new ArrayList<>();
            pad.add(value);
            while (index > 0){
                index = (index - 1)/2;
                pad.add(0, this.values.get(index));
            }
            return pad;
        }
    }
}

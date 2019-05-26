package domain;

import java.util.ArrayList;

public class BinaryMinHeap<E extends Comparable<E>> {
	private ArrayList<E> values = new ArrayList<>();
	
	public void print() {
		System.out.println(values);
	}

	public E getMin() {
		if (this.values.size() == 0){
			throw new IllegalArgumentException();
		} else{
		    return this.values.get(0);
        }
	}
	public boolean addValue(E value){
		if (value == null) throw new IllegalArgumentException();
		values.add(value);
		this.bubbleUp();
		return true;
	}

    private void bubbleUp() {
        int index = this.values.size() - 1; //start met laatste element
            while (heeftOuder(index) && ouder(index).compareTo(values.get(index)) > 0) { //ouder en kind staan in verkeerde volgorde, wissel ze om
                this.wisselOm(index, ouderIndex(index));
                index = ouderIndex(index);
        }
    }
    private boolean heeftOuder(int i) { return i >= 1;
    }
    private E ouder(int i) {
        return values.get(ouderIndex(i));
    }
    private int ouderIndex(int i) { return (i - 1)/2;
    }
    private void wisselOm(int i, int j) {
        //wissel i-de en j-de element in de ArrayList om
        E hulp = this.values.get(i);
        this.values.set(i, this.values.get(j)); this.values.set(j, hulp);
    }
	
	public E removeSmallest(){
			E res = this.getMin();
			this.values.set(0, this.values.get(this.values.size()-1));
			this.bubbleDown();
			return res;
	}

	private void bubbleDown() {
	    int index = 0;
	    while(heeftlinkerkind(index)){
	        //welk kind is het kleinste?
            int indexKleinstekind = indexlinkerkind(index);

            if (heeftRechterKind(index) && values.get(indexKleinstekind).compareTo(values.get(index)) > 0){
                this.wisselOm(index, indexKleinstekind);
            }else {
                break;
            }
            index = indexKleinstekind;
	    }
	}

	private int indexlinkerkind(int i){return 2* i + 1;}
	private int indexrechterkind(int i){return 2*i + 2;}
	private boolean heeftlinkerkind(int i){return indexlinkerkind(i) < values.size();}
    private boolean heeftRechterKind(int i){return indexrechterkind(i) <values.size();}
	public ArrayList<E> getPath(E value) {
		int index = this.values.indexOf(value);
		if (index == -1){
		    return null;
        }else{
		    ArrayList<E> pad = new ArrayList<>();
		    pad.add(value);
		while (index > 0){
		    index = (index -1)/2;
        }
            return pad;
        }
	}
}

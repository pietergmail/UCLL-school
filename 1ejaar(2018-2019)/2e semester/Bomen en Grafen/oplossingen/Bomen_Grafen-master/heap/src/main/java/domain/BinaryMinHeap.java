package domain;

import java.util.ArrayList;

public class BinaryMinHeap<E extends Comparable<E>> {
	private ArrayList<E> values = new ArrayList<>();
	
	public void print() {
		System.out.println(values);
	}

	public E getMin() {//zoek minimum waarde
		if (this.values.size() == 0) {//size is null geef exception
			throw new IllegalStateException();
		} else {//niet null dus geef de root van de boom
			return this.values.get(0);
		}
	}
	public boolean addValue(E value){//voeg waarde toe
		if (value == null){//exception als waarde null is
			throw new IllegalArgumentException();
		}
		values.add(value);//voeg toe aan arraylist
		this.bubbleUp();//stuur waarden omhoog indien nodig (bubble up zorgt ervoot)
		return true;
	}

	private void bubbleUp() {//hersorteert waardes
		int index = this.values.size() - 1; //start met laatste element
		while (heeftOuder(index) && ouder(index).compareTo(values.get(index)) > 0) { //ouder en kind staan in verkeerde volgorde, wissel ze om
			this.wisselOm(index, ouderIndex(index));//swap index met ouder waarde
			index = ouderIndex(index);//ouderindex wordt de nieuwe index
		}
	}
	private boolean heeftOuder(int i) { return i >= 1;}//check t of hij een ouder heeft

	private E ouder(int i) {//geeft waarde van de ouder
		return values.get(ouderIndex(i));
	}
	private int ouderIndex(int i) { return (i - 1)/2;//geeft de index van de ouder
	}
	private void wisselOm(int i, int j) {
        //wissel i-de en j-de element in de ArrayList om
        E hulp = this.values.get(i);//maakt gebruik van een hulpvariabele
		this.values.set(i, this.values.get(j));
		this.values.set(j, hulp);
	}
	public E removeSmallest(){//verwijder kleinste
			E res = this.getMin();// res bevat de kleinste = eerste element van de lijst
			this.values.set(0, this.values.get(this.values.size()-1));// verwissel eerste met de laatste
			this.values.remove(this.values.size()-1); // verwijder de laatste
			this.bubbleDown(); // bubble down van eerste naar beneden zie theorie
			return res;//return de waarde van de kleinste
	}

	private void bubbleDown() {//zet de waarden juist
		int index = 0;
		while(heeftLinkerKind(index)){//welk kind is het kleinste?
			int indexKleinsteKind = indexLinkerKind(index);//bepaalt waarde van het linkerkind

			if (heeftRechterKind(index)//test of hij een rechterkind heeft
					&& values.get(indexKleinsteKind).compareTo(values.get(indexRechterKind(index))) > 0)//en de waarde van het kleinste kind groter is dan de waarde van het rechterkind
			{
				indexKleinsteKind = indexRechterKind(index);//verwissel de twee
			}
			 //vergelijk ouderwaarde met waarde van kleinste kind
			if (values.get(index).compareTo(values.get(indexKleinsteKind)) > 0) { //index is net het kleinste kind
				this.wisselOm(index, indexKleinsteKind);//verwissel index met index kleinsteKind
			} else {
			//volgorde OK, while lus mag stoppen
				break;
			}
			//vertrek nu vanuit de index van het kleinste kind
			index = indexKleinsteKind;//volgende while lus
		}
	}
	private int indexLinkerKind(int i) {//bepaalt waarde van het linkerkind
		return 2 * i + 1;
	}
	private int indexRechterKind(int i) {//bepaalt waarde van rechterkind
		return 2 * i + 2;
	}
	private boolean heeftLinkerKind(int i) {//checkt of node een linkerkind heeft
		return indexLinkerKind(i) < values.size();
	}
	private boolean heeftRechterKind(int i) {//checkt of node een rechterkind heeft
		return indexRechterKind(i) < values.size();
	}
	public ArrayList<E> getPath(E value) {
		int index = this.values.indexOf(value);//maak index de locatie van de gevraagde waarde
		if (index == -1) {
		//value komt niet voor in de heap
			return null;
		} else {
		//value zit in heap, index = plaats van eerste voorkomen
			ArrayList<E> pad = new ArrayList<>(); pad.add(value);
		while (index > 0) {
			//we zijn nog niet aan de wortel
			index = (index - 1)/2; //ouder
			pad.add(0, this.values.get(index));//voeg toen aan pad
		}
			return pad;//returnt arraylist met pad
		}
	}
}

package be.ucll.oop;

import java.util.ArrayList;
import java.util.List;

public class Traiteur {
	private List<Klant> klanten;

	public Traiteur(){
		this.klanten = new ArrayList<>();
	}

	public List<Klant> getKlanten() {
		return klanten;
	}

	public void voegKlantToe(Klant klant){
		this.klanten.add(klant);
	}
}

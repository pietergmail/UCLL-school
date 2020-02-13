package be.ucll.oop.personenvervoer;

import be.ucll.oop.PrijsBerekenbaar;

public abstract class PersonenVervoer implements PrijsBerekenbaar {
	private int aantalPersonen;

	public int getAantalPersonen() {
		return aantalPersonen;
	}

	public void setAantalPersonen(int aantalPersonen) {
		this.aantalPersonen = aantalPersonen;
	}
}

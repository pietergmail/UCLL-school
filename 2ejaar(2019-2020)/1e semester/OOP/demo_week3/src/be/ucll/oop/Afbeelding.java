package be.ucll.oop;

import java.util.ArrayList;
import java.util.List;

public class Afbeelding {
	private List<Figuur> figuren = new ArrayList<>();

	public void addFiguur(Figuur figuur) {
		figuren.add(figuur);
	}

	public double getTotaleOmtrek() {
		double som = 0;
		for (Figuur f : figuren) {
			som += f.getOmtrek();
		}
		return som;
	}
}

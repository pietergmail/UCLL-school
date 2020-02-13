package be.ucll.oop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Reis {
	private List<Activiteit> activiteiten;
	private List<String> passagiers;
	private List<Haven> stops;

	public Reis() {
		this.activiteiten = new ArrayList<>();
		this.passagiers = new ArrayList<>();
		this.stops = new LinkedList<>();
	}

	public List<Activiteit> getActiviteiten() {
		return activiteiten;
	}

	public void setActiviteiten(List<Activiteit> activiteiten) {
		this.activiteiten = activiteiten;
	}

	public List<String> getPassagiers() {
		return passagiers;
	}

	public void setPassagiers(List<String> passagiers) {
		this.passagiers = passagiers;
	}

	public List<Haven> getStops() {
		return stops;
	}

	public void setStops(List<Haven> stops) {
		this.stops = stops;
	}
}

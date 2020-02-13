package be.ucll.oop;

import java.util.ArrayList;
import java.util.List;

public class Klant {
	private String naam;
	private String adres;
	private List<Levering> leveringen;

	public Klant(String naam, String adres) {
		this.leveringen = new ArrayList<>();
		this.naam = naam;
		this.adres = adres;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public List<Levering> getLeveringen() {
		return leveringen;
	}

	public void addLevering(Levering levering) {
		this.leveringen.add(levering);
	}
}

package be.ucll.oop;

public class Klant {
	private String naam;
	private String adres;

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		if (naam == null){
			throw new IllegalArgumentException();
		}
		this.naam = naam;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		if (adres == null){
			throw new IllegalArgumentException();
		}
		this.adres = adres;
	}
}

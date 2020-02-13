package be.ucll.oop;

public class ContractKlant extends Klant {
	private int aantalPersonen;
	private int aantalGangen;

	public int getAantalPersonen() {
		return aantalPersonen;
	}

	public void setAantalPersonen(int aantalPersonen) {
		this.aantalPersonen = aantalPersonen;
	}

	public int getAantalGangen() {
		return aantalGangen;
	}

	public void setAantalGangen(int aantalGangen) {
		this.aantalGangen = aantalGangen;
	}
}

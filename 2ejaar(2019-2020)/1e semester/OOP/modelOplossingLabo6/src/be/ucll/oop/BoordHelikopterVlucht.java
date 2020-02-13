package be.ucll.oop;

public class BoordHelikopterVlucht extends HelikopterVlucht implements BoordActiviteit {
	private String locatie;

	@Override
	public String getLocatie() {
		return locatie;
	}

	@Override
	public void setLocatie(String locatie) {
		this.locatie = locatie;
	}
}

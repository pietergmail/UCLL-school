package be.ucll.oop;

public abstract class BoordActiviteitImpl extends Activiteit implements BoordActiviteit {
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

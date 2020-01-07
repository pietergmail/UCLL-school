package be.ucll.oop.cargo;

import be.ucll.oop.DomainException;
import be.ucll.oop.PrijsBerekenbaar;

public abstract class Cargo implements PrijsBerekenbaar {
	private double hoeveelheid; //Afhankelijk van implementatie in liter of in m3 uitgedrukt
	private String beschrijving;
	private Vrachtwagen vrachtwagen;

	public double getHoeveelheid() {
		return hoeveelheid;
	}

	public void setHoeveelheid(double hoeveelheid) {
		this.hoeveelheid = hoeveelheid;
	}

	public String getBeschrijving() {
		return beschrijving;
	}

	public void setBeschrijving(String beschrijving) {
		this.beschrijving = beschrijving;
	}

	public Vrachtwagen getVrachtwagen() {
		return vrachtwagen;
	}

	public void setVrachtwagen(Vrachtwagen vrachtwagen) throws DomainException {
		vrachtwagen.addCargo(this);
		this.vrachtwagen = vrachtwagen;
	}
}

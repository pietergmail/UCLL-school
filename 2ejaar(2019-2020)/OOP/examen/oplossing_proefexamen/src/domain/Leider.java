package domain;

import util.DomainException;

import java.time.LocalDate;
import java.util.Objects;

public class Leider extends Lid {
	private String functie;

	public Leider(String voornaam, String achternaam, LocalDate geboorteDatum, String functie) throws DomainException {
		super(voornaam, achternaam, geboorteDatum);
		setFunctie(functie);
	}

	public String getFunctie() {
		return functie;
	}

	public void setFunctie(String functie) throws DomainException {
		if (functie == null || functie.isEmpty()) {
			throw new DomainException("Functie mag niet leeg zijn.");
		}
		this.functie = functie;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Leider) {
			Leider l = (Leider) obj;
			return super.equals(obj) && Objects.equals(functie, l.functie);
		}
		return false;
	}
}

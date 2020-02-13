package domain;

import util.DomainException;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.TreeMap;

public class Lid implements Comparable<Lid> {
	private final String voornaam;
	private final String achternaam;
	private final LocalDate geboorteDatum;
	private String woonplaats;

	public Lid(String voornaam, String achternaam, LocalDate geboorteDatum) throws DomainException {
		checkVoornaam(voornaam);
		checkAchternaam(achternaam);
		checkGeboorteDatum(geboorteDatum);
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.geboorteDatum = geboorteDatum;
	}

	private void checkGeboorteDatum(LocalDate geboorteDatum) throws DomainException {
		if (geboorteDatum == null) {
			throw new DomainException("Geboortedatum mag niet leeg zijn.");
		}
	}

	private void checkAchternaam(String achternaam) throws DomainException {
		if (achternaam == null || achternaam.isEmpty()) {
			throw new DomainException("Achternaam mag niet leeg zijn.");
		}
	}

	private void checkVoornaam(String voornaam) throws DomainException {
		if (voornaam == null || voornaam.isEmpty()) {
			throw new DomainException("Voornaam mag niet leeg zijn.");
		}
	}

	public String getVoornaam() {
		return voornaam;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public LocalDate getGeboorteDatum() {
		return geboorteDatum;
	}

	public String getWoonplaats() {
		return woonplaats;
	}

	public void setWoonplaats(String woonplaats) {
		this.woonplaats = woonplaats;
	}

	public int getLeeftijd() {
		return Period.between(geboorteDatum, LocalDate.now()).getYears();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Lid) {
			Lid lid = (Lid) obj;
			return Objects.equals(lid.achternaam, achternaam) && Objects.equals(lid.voornaam, voornaam) && Objects.equals(lid.geboorteDatum, geboorteDatum) && Objects.equals(lid.woonplaats, woonplaats);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return achternaam.hashCode() * 31 + voornaam.hashCode();
	}

	@Override
	public int compareTo(Lid o) {
		return achternaam.compareTo(o.getAchternaam());
	}
}

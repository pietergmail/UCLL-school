package be.ucll.oop;

import java.time.LocalDate;

public class LidmaatschapKlant extends EenmaligeKlant {
	private String frequentie;
	private LocalDate startDatum;
	private LocalDate eindDatum;

	public String getFrequentie() {
		return frequentie;
	}

	public void setFrequentie(String frequentie) {
		if (frequentie == null) {
			throw new IllegalArgumentException();
		}
		this.frequentie = frequentie;
	}

	public LocalDate getStartDatum() {
		return startDatum;
	}

	public void setStartDatum(LocalDate startDatum) {
		this.startDatum = startDatum;
	}

	public LocalDate getEindDatum() {
		return eindDatum;
	}

	public void setEindDatum(LocalDate eindDatum) {
		this.eindDatum = eindDatum;
	}
}

package domain;

import util.DomainException;

public abstract class Locatie {
	private final String naam;
	private final int oppervlakte;

	protected Locatie(String naam, int oppervlakte) throws DomainException {
		if (naam == null || naam.isEmpty()) {
			throw new DomainException("Naam mag niet leeg zijn.");
		}
		this.naam = naam;
		this.oppervlakte = oppervlakte;
	}

	public String getNaam() {
		return naam;
	}

	public int getOppervlakte() {
		return oppervlakte;
	}
}

package domain;

import util.DomainException;

public class OpslagPlaats extends Locatie {
	private String beschrijving;

	protected OpslagPlaats(String naam, int oppervlakte) throws DomainException {
		super(naam, oppervlakte);
	}

	public String getBeschrijving() {
		return beschrijving;
	}

	public void setBeschrijving(String beschrijving) throws DomainException {
		if (beschrijving == null || beschrijving.isEmpty()){
			throw new DomainException("Beschrijving mag niet leeg zijn.");
		}
		this.beschrijving = beschrijving;
	}
}

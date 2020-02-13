package domain;

import util.DomainException;

public class KampeerPlaats extends Locatie {
	public KampeerPlaats(String naam, int oppervlakte) throws DomainException {
		super(naam, oppervlakte);
	}
}

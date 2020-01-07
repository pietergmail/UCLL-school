package domain;

import util.DomainException;

import java.util.*;

public class Afdeling {
	private List<Locatie> locaties;
	private Set<Lid> leden;
	private String naam;

	private Afdeling() {
		this.locaties = new ArrayList<>();
		this.leden = new HashSet<>();
	}

	public Afdeling(String naam, Collection<Lid> initieleLeden) throws DomainException {
		this();
		setNaam(naam);
		laadInitieleLeden(initieleLeden);
	}

	private void laadInitieleLeden(Collection<Lid> initieleLeden) throws DomainException {
		if (initieleLeden != null && !initieleLeden.isEmpty()) {
			for (Lid l : initieleLeden) {
				if (l instanceof Leider) {
					leden.addAll(initieleLeden);
					return;
				}
			}
			throw new DomainException("Er moet minstens 1 leider zijn.");
		}
		throw new DomainException("Leden mag niet leeg zijn.");
	}

	public void voegLocatieToe(Locatie locatie) throws DomainException {
		if (locatie == null) {
			throw new DomainException("Locatie mag niet null zijn.");
		}
		this.locaties.add(locatie);
	}

	public void voegLidToe(Lid lid) throws DomainException {
		if (lid == null) {
			throw new DomainException("Lid mag niet null zijn.");
		}
		if (lid.getLeeftijd() > 18) {
			throw new DomainException("Lid mag niet ouder zijn dan 18 jaar.");
		}
		if (!this.leden.add(lid)) {
			throw new DomainException("Lid is reeds toegevoegd aan de afdeling.");
		}
	}

	public void verwijderLid(Lid lid) {
		this.leden.remove(lid);
	}

	public List<Locatie> getLocaties() {
		return locaties;
	}

	public Set<Lid> getLeden() {
		return leden;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) throws DomainException {
		if (naam == null || naam.isEmpty()) {
			throw new DomainException("Naam mag niet leeg zijn.");
		}
		this.naam = naam;
	}
}

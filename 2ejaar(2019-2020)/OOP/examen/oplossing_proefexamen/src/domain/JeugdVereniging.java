package domain;

import util.DomainException;

import java.util.*;

public class JeugdVereniging {
	private List<Afdeling> afdelingen;
	private List<Locatie> locaties;
	private Map<String, Locatie> locatieMap;

	private JeugdVereniging() {
		this.afdelingen = new ArrayList<>();
		this.locaties = new ArrayList<>();
		this.locatieMap = new HashMap<>();
	}

	public List<Afdeling> getAfdelingen() {
		return afdelingen;
	}

	public List<Locatie> getLocaties() {
		return new ArrayList<>(locatieMap.values());
	}

	public JeugdVereniging(Afdeling eersteAfdeling) throws DomainException {
		this();
		voegAfdelingToe(eersteAfdeling);
	}

	public void voegAfdelingToe(Afdeling afdeling) throws DomainException {
		if (afdeling == null) {
			throw new DomainException("Afdeling mag niet null zijn.");
		}
		afdelingen.add(afdeling);
	}

	public void voegLocatieToe(Locatie locatie) throws DomainException {
		if (locatie == null) {
			throw new DomainException("Locatie mag niet null zijn.");
		}
		this.locatieMap.put(locatie.getNaam(), locatie);
		this.locaties.add(locatie);
	}

	public Locatie getLocatie(String naam){
		return locatieMap.get(naam);
	}

	public void vraagToegangTotLocatie(Afdeling afdeling, Locatie locatie) throws DomainException {
		afdeling.voegLocatieToe(locatie);
	}

	public List<Lid> getLedenTeOudVoorDeelname() {
		List<Lid> leden = new ArrayList<>();
		for (Afdeling afdeling : afdelingen) {
			for (Lid l : afdeling.getLeden()) {
				if (l.getLeeftijd() > 18 && !(l instanceof Leider)) {
					leden.add(l);
				}
			}
		}
		leden.sort(new AchternaamComparator());
		return leden;
	}

	public void promoveerLid(Lid lid, String functie) throws DomainException {
		for (Afdeling afdeling : afdelingen){
			if (afdeling.getLeden().contains(lid)){
				afdeling.verwijderLid(lid);
				Leider leider = new Leider(lid.getVoornaam(), lid.getAchternaam(), lid.getGeboorteDatum(),functie);
				leider.setWoonplaats(lid.getWoonplaats());
				afdeling.voegLidToe(leider);
			}
		}
	}
}

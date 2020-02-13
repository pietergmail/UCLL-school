package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JeugdVereniging {
    private List<Afdeling> afdelingen;
    private List<Locatie> locaties;
    private Map<String, Locatie> locatieMap;

    public List<Afdeling> getAfdelingen() {
        return afdelingen;
    }

    public void setAfdelingen(List<Afdeling> afdelingen) {
        this.afdelingen = afdelingen;
    }

    public List<Locatie> getLocaties() {
        return locaties;
    }

    public void setLocaties(List<Locatie> locaties) {
        this.locaties = locaties;
    }

    public Map<String, Locatie> getLocatieMap() {
        return locatieMap;
    }

    public void setLocatieMap(Map<String, Locatie> locatieMap) {
        this.locatieMap = locatieMap;
    }

    public JeugdVereniging(List<Afdeling> afdelingen, List<Locatie> locaties, Map<String, Locatie> locatieMap) {
        this.afdelingen = afdelingen;
        this.locaties = locaties;
        this.locatieMap = locatieMap;
    }

    public JeugdVereniging(Afdeling eersteAfdeling) throws DomainException {
        voegAfdelingToe(eersteAfdeling);
    }

    public void voegAfdelingToe(Afdeling afdeling) throws DomainException{
        if (afdeling == null){
            throw new DomainException("Afdeling mag niet null zijn.");
        }
        afdelingen.add(afdeling);
    }

    public void verwijderAfdeling(String naam){
        afdelingen.remove(naam);
    }


    public Locatie getLocatie(String naam){return locatieMap.get(naam);}

    public void voegLocatieToe(Locatie locatie) throws DomainException {
        if (locatie == null) {
            throw new DomainException("Locatie mag niet null zijn.");
        }
        this.locatieMap.put(locatie.getNaam(), locatie);
        this.locaties.add(locatie);
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
        return leden;
    }

    public void promoveerLid(Lid lid, String functie) throws DomainException {
        for (Afdeling afdeling : afdelingen){
            if (afdeling.getLeden().contains(lid)){
                afdeling.verwijderLid(lid);
                Leider leider = new Leider(lid.getVoornaam(), lid.getAchternaam(), lid.getGeboortedatum(),functie);
                leider.setWoonplaats(lid.getWoonplaats());
                afdeling.voegLidToe(leider);
            }
        }
    }
}

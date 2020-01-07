package domain;

import domain.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Afdeling {
    private String naam;
    private Set<Lid> leden;
    private List<Locatie> locaties;

    private Afdeling(){
        this.leden = new HashSet<>();
    }

    public void setLeden(Set<Lid> leden) {
        this.leden = leden;
    }

    public Afdeling(String naam, Collection<Lid> initieleLeden) throws DomainException {
        this();
        setNaam(naam);
        laadInitieleLeden(initieleLeden);
    }

    private void laadInitieleLeden(Collection<Lid> initieleLeden) throws DomainException {
        if (initieleLeden != null && !initieleLeden.isEmpty()){
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

    public void voegLidToe(Lid lid) throws DomainException {
        if (lid == null){
            throw new DomainException("Lid mag niet null zijn.");
        }
        if (lid.getLeeftijd() > 18){
            throw new DomainException("Lid mag niet ouder zijn dan 18 jaar.");
        }
        if (!this.leden.add(lid)){
            throw new DomainException("Lid is reeds toegevoegd aan de afdeling");
        }
        leden.add(lid);
    }

    public void voegLocatieToe(Locatie locatie) throws DomainException {
        if (locatie == null) {
            throw new DomainException("locatie mag niet null zijne.");
        }
        this.locaties.add(locatie);
    }

    public void verwijder(Lid lid){this.leden.remove(lid);}

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) throws DomainException {
        if (naam == null || naam.isEmpty()){
            throw new DomainException("Naam mag niet leeg zijn.");
        }
        this.naam = naam;
    }

    public Set<Lid> getLeden(){return leden;}

    public List<Locatie> getLocaties(){return locaties;}

    public void verwijderLid(Lid lid) {
        this.leden.remove(lid);
    }

}

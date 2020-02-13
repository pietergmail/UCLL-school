package domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class Afdeling {
    private String naam;
    private HashSet<Lid> leden;
    private List<Locatie> locaties;

    private Afdeling(){
        this.leden = new HashSet<>();
    }

    public Afdeling(String naam, Collection<Lid> initieleLeden) throws DomainException{
        this();
        setNaam(naam);
        laadInitieleLeden(initieleLeden);
    }

    private void laadInitieleLeden(Collection<Lid> initieleLeden) throws DomainException{
        if (initieleLeden != null && !initieleLeden.isEmpty()){
            for (Lid l : initieleLeden){
                if (l instanceof  Leider){
                    leden.addAll(initieleLeden);
                    return;
                }
            }
            throw new DomainException("Er moet minstens 1 leider zijn.");
        }
        throw new DomainException("Leden mag niet leeg zijn.");
    }

    public void voegLidToe(Lid lid) throws DomainException{
        if (lid == null){
            throw new DomainException("Lid mag niet null zijn.");
        }
        if (lid.getLeeftijd() > 18){
            throw new DomainException("Lid mag niet ouder zijn dan 18 jaar.");
        }
        if (!this.leden.add(lid)){
            throw new DomainException("Lid is reeds toegevoegd aan de afdeling.");
        }
        leden.add(lid);
    }

    public void voegLocatieToe(Locatie locatie) throws DomainException{
        if (locatie == null){
            throw new DomainException("Locatie mag niet null zijn.");
        }
        this.locaties.add(locatie);
    }



    public HashSet<Lid> getLeden() {
        return leden;
    }

    public void setLeden(HashSet<Lid> leden) {
        this.leden = leden;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void verwijderLid(Lid lid){this.leden.remove(lid);}
}

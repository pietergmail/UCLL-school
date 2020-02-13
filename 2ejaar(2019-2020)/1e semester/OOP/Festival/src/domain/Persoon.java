package domain;

import java.time.LocalDate;
import java.util.Objects;

public class Persoon {

    private String naam;
    private String voornaam;
    private LocalDate geboortedatum;

    public Persoon(String naam, String voornaam, LocalDate geboortedatum){
        this.setNaam(naam);
        this.setVoornaam(voornaam);
        this.setGeboortedatum(geboortedatum);
    }

    private void setNaam(String naam) {
        if(Checker.isOngeldigeString(naam)) throw new DomainException("De naam mag niet leeg zijn!");
        this.naam = naam;
    }
    private void setVoornaam(String voornaam) {
        if(Checker.isOngeldigeString(voornaam)) throw new DomainException("De voornaam mag niet leeg zijn!");
        this.voornaam = voornaam;
    }
    private void setGeboortedatum(LocalDate geboortedatum) {
        if(Checker.isOngeldigeGeboortedatum(geboortedatum)) throw new DomainException("De geboortedatum is ongeldig!");
        this.geboortedatum = geboortedatum;
    }

    public String getNaam() {
        return this.naam;
    }
    public String getVoornaam() {
        return this.voornaam;
    }
    public LocalDate getGeboortedatum() {
        return this.geboortedatum;
    }

    @Override
    public String toString() {
        return "Naam: " + this.getNaam() + " " + this.getVoornaam() + "\n" + "Geboortedatum: " + this.getGeboortedatum().toString();
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.naam,this.voornaam,this.geboortedatum);
    }
    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj instanceof Persoon){
            Persoon persoon = (Persoon) obj;
            if(persoon.getNaam().equals(this.getNaam())
                && persoon.getVoornaam().equals(this.getVoornaam())
                && persoon.getGeboortedatum().equals(this.getGeboortedatum())){
                return true;
            }
        }
        return false;
    }
}

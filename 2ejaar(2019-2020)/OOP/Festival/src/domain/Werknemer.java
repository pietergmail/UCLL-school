package domain;

import java.time.*;

public abstract class Werknemer extends Persoon{
    // Abstract gemaakt ookal staat het niet op het UML maar het is logisch
    // Omdat je maar 2 verschillende werknemers hebt en deze hebben allebij een andere klasse en erven over van deze

    private String rijksregisternr;
    private int aantalGewerkteUren;

    public Werknemer(String naam, String voornaam, LocalDate geboortedatum, String rijksregisternr){
        super(naam,voornaam,geboortedatum);
        this.setRijksregisternr(rijksregisternr);
        this.setAantalGewerkteUren(0);
    }

    private void setRijksregisternr(String rijksregisternr) {
        if(Checker.isOngeldigeString(rijksregisternr)) throw new DomainException("Het rijksnummer mag niet leeg zijn!");
        if(Checker.isOngeldigRijksnummer(rijksregisternr)) throw new DomainException("Het rijksnummer is ongeldig! (Formaat klopt niet!)");
        this.rijksregisternr = rijksregisternr;
    }
    public void setAantalGewerkteUren(int aantalGewerkteUren) {
        if(Checker.isOngeldigAantalUrenGewerkt(aantalGewerkteUren)) throw new DomainException("Het aantal uren gewerkt is ongeldig!");
        this.aantalGewerkteUren = aantalGewerkteUren;
    }

    public String getRijksregisternr() {
        return this.rijksregisternr;
    }
    public int getAantalGewerkteUren() {
        return this.aantalGewerkteUren;
    }

    public void pasGewerkteUrenAan(int extrauren){
        int nieuweuren = this.aantalGewerkteUren + extrauren;
        if(Checker.isOngeldigAantalUrenGewerkt(nieuweuren)) throw new DomainException("Het nieuwe aantal uren is ongeldig!");
        this.setAantalGewerkteUren(nieuweuren);
    }
    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj instanceof Werknemer){
            Werknemer werknemer = (Werknemer) obj;
            if(super.equals(werknemer)
                && werknemer.getRijksregisternr().equals(this.getRijksregisternr())
                && werknemer.getAantalGewerkteUren() == this.getAantalGewerkteUren()){
                return true;
            }
        }
        return false;
    }

}

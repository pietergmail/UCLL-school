package domain.model;

import domain.DomainException;

public class Niveaugroep {
    private String naam, omschrijving;
    private double richtsnelheid;

    public Niveaugroep(String naam, String omschrijving, double richtsnelheid) {
        setNaam(naam);
        setOmschrijving(omschrijving);
        setRichtsnelheid(richtsnelheid);
    }

    private boolean isInvalidString(String string) {
        return string == null || string.trim().isEmpty();
    }

    public void setRichtsnelheid(double richtsnelheid) {
        if (richtsnelheid <= 0)
            throw new DomainException("Geen geldige richtsnelheid");
        this.richtsnelheid = richtsnelheid;
    }

    public void setOmschrijving(String omschrijving) {
        if (isInvalidString(omschrijving))
            throw new DomainException("Geen geldige omschrijving");
        this.omschrijving = omschrijving;
    }

    public void setNaam(String naam) {
        if (isInvalidString(naam))
            throw new DomainException("Geen geldige naam");
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public double getRichtsnelheid() {
        return richtsnelheid;
    }
}

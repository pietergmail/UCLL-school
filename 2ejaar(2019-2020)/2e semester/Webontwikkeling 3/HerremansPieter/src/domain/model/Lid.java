package domain.model;

import domain.DomainException;

public class Lid {
    private String email, naam, niveaugroep;

    public Lid(String email, String naam, String niveaugroep) {
        setEmail(email);
        setNaam(naam);
        setNiveaugroep(niveaugroep);
    }

    private boolean isInvalidString(String string) {
        return string == null || string.trim().isEmpty();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (isInvalidString(email))
            throw new DomainException("Geen geldige email");
        this.email = email;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        if (isInvalidString(naam))
            throw new DomainException("Geen geldige naam");
        this.naam = naam;
    }

    public String getNiveaugroep() {
        return niveaugroep;
    }

    public void setNiveaugroep(String niveaugroep) {
        if (isInvalidString(niveaugroep))
            throw new DomainException("Geen geldige niveaugroep");
        this.niveaugroep = niveaugroep;
    }
}

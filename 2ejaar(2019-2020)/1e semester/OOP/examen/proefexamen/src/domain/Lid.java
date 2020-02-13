package domain;

import java.time.LocalDate;
import java.time.Period;

public class Lid {
    private String achternaam;
    private String voornaam;
    private String woonplaats;
    private LocalDate geboortedatum;

    public Lid(String achternaam, String voornaam, LocalDate geboortedatum) {
        this.achternaam = achternaam;
        this.voornaam = voornaam;
        this.geboortedatum = geboortedatum;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public LocalDate getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(LocalDate geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public int getLeeftijd() {
        return Period.between(geboortedatum, LocalDate.now()).getYears();
    }
}

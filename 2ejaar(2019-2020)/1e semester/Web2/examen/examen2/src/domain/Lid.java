package domain;

import java.time.LocalDate;
import java.time.Period;

public class Lid {
    private String achternaam;
    private String voornaam;
    private LocalDate geboorteDatum;
    private String woonplaats;

    public Lid(String achternaam, String voornaam, LocalDate geboorteDatum) {
        this.achternaam = achternaam;
        this.voornaam = voornaam;
        this.geboorteDatum = geboorteDatum;
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

    public LocalDate getGeboorteDatum() {
        return geboorteDatum;
    }

    public void setGeboorteDatum(LocalDate geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public int getLeeftijd(){
        return Period.between(geboorteDatum, LocalDate.now()).getYears();
    }
}

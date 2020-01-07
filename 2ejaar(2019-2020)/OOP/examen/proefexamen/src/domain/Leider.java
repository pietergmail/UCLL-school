package domain;

import java.time.LocalDate;

public class Leider extends Lid {
    private String functie;

    public String getFunctie() {
        return functie;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }

    public Leider(String achternaam, String voornaam, LocalDate geboortedatum, String functie) {
        super(achternaam, voornaam, geboortedatum);
        this.setFunctie(functie);
    }
}

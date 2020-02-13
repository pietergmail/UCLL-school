package domain;

import java.awt.*;
import java.time.LocalDate;

public class Leider extends Lid {
    private String functie;

    public Leider(String achternaam, String voornaam, LocalDate geboorteDatum, String functie) {
        super(achternaam, voornaam, geboorteDatum);
        this.setFunctie(functie);
    }

    public String getFunctie() {
        return functie;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }
}

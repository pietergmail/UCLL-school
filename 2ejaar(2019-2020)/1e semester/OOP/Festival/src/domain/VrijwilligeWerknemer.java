package domain;

import java.time.LocalDate;

public class VrijwilligeWerknemer extends Werknemer implements TeCompenseren{

    private static final int aantalBonnetjesPerUur = 2;

    public VrijwilligeWerknemer(String naam, String voornaam, LocalDate geboortedatum, String rijksregisternr){
        super(naam, voornaam, geboortedatum, rijksregisternr);
    }

    @Override
    public int getAantalGratisBonnetjes() {
        return aantalBonnetjesPerUur*this.getAantalGewerkteUren();
    }
    @Override
    public String toString() {
        String uitvoer = super.toString();
        uitvoer += "\n\tAantal gratis bonnetjes = " + getAantalGratisBonnetjes();
        return uitvoer;
    }
}

package domain;

import java.time.LocalDate;

public class TeBetalenWerknemer extends Werknemer implements TeBetalen{

    private static final int prijsPerUur = 10;

    public TeBetalenWerknemer(String naam, String voornaam, LocalDate geboortedatum, String rijksregisternr){
        super(naam, voornaam, geboortedatum, rijksregisternr);
    }

    @Override
    public double getLoon() {
        return prijsPerUur*this.getAantalGewerkteUren();
    }
}

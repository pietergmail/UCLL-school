package domain;

import java.time.*;

public abstract class Checker {
    // Checker klasse gemaakt voor de makkelijkheid (niet verplicht)

    public static boolean isOngeldigeString(String string){
        if(string == null || string.trim().isEmpty()) return true;
        else return false;
    }

    public static boolean isOngeldigeGeboortedatum(LocalDate geboortedatum){
        if(geboortedatum.isBefore(LocalDate.of(1920,1,1))
            || geboortedatum.isAfter(LocalDate.now().plusDays(1))) return true;
        else return false;
    }

    public static boolean isOngeldigAantalUrenGewerkt(int uren){
        if(uren < 0 || uren > 200) return true;
        else return false;
    }

    public static boolean isOngeldigRijksnummer(String rijksregisternr){
        if(!rijksregisternr.matches("([0-9]{2}\\.){2}[0-9]{2}-[0-9]{3}\\.[0-9]{2}")) return true;
        else return true;
    }

    public static boolean isOngeldigUur(LocalTime uur){
        if(uur.isBefore(LocalTime.of(19,0))
            || uur.isAfter(LocalTime.of(4,0))){
            return true;
        } else return false;
    }

    public static boolean isOngeldigePrijs(double prijs){
        if(prijs < 0) return true;
        else return false;
    }

    public static boolean isOngeldigeFestivalDatum(LocalDate datum){
        if(datum.isBefore(LocalDate.now())) return true;
        else return false;
    }

}

package domain;

import java.time.LocalDate;

public class Hond {
    String naam;
    double gewicht;
    int geboortejaar;

    public Hond(String naam, double gewicht, int geboortejaar) {
        this.naam = naam;
        this.gewicht = gewicht;
        this.geboortejaar = geboortejaar;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public double getGewicht() {
        return gewicht;
    }

    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }

    public int getGeboortejaar() {
        return geboortejaar;
    }

    public void setGeboortejaar(int geboortejaar) {
        this.geboortejaar = geboortejaar;
    }

    public double berekenleftijd() {
        return LocalDate.now().getYear() - geboortejaar;
    }

    public double rekenvoerperdag() {
        if (berekenleftijd() <= 2) {
            return (0.15 + (0.12 * this.gewicht)) * 2;
        } else {
            return 0.15 + (0.12 * this.gewicht);
        }
    }

    public double adoptiekosten(){
        if (berekenleftijd() <= 2) {
            return 250;
        } else if (berekenleftijd() <= 8){
            return 150;
        }else{
            return 0;
        }
    }

    public String geefinfo(){
        return "De hond noemt " + this.getNaam() + " hij heeft een gewicht van " + this.getGewicht() + "kg. En is " + this.berekenleftijd() + " jaar oud.";
    }
}
package domain;
import domain.*;

import java.util.List;

public class Klant {
    private String naam;
    private String adres;
    private List<Levering> leveringen;

    public Klant(String naam, String adres, List<Levering> leveringen) {
        this.naam = naam;
        this.adres = adres;
        this.leveringen = leveringen;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public List<Levering> getLeveringen() {
        return leveringen;
    }

    public void setLeveringen(List<Levering> leveringen) {
        this.leveringen = leveringen;
    }
}

package domain;
import domain.Hond;

import java.util.ArrayList;


public class Asiel {
    private String naam;
    ArrayList<Hond> honden = new ArrayList<>();

    public ArrayList<Hond> getHonden() {
        return honden;
    }

    public void setHonden(ArrayList<Hond> honden) {
        this.honden = honden;
    }

    public Asiel(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public boolean voeghondtoe(Hond vhond){
        honden.add(vhond);
        return true;
        }

    public double rekenVoerPerWeek(){
        double total = 0;
        for (Hond hond: honden){
            total += hond.rekenvoerperdag() * 7;
        }
        return total;
        }

    public double rekenVoerKostenPerWeek(double prijs){
        return this.rekenVoerPerWeek() * prijs;
    }
}

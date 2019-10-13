package domain;

import java.util.ArrayList;
import domain.Auto;

public class Garage {
    ArrayList<Auto> autos = new ArrayList<>();
    String naam;

    public Garage(String naam) {
        this.naam = naam;
    }

    public ArrayList<Auto> getAutos() {
        return autos;
    }

    public void setAutos(ArrayList<Auto> autos) {
        this.autos = autos;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public boolean voegAutoToe(Auto auto){
        autos.add(auto);
        return true;
    }

    public double position(String auto){
        return autos.indexOf(auto);
    }

    public double gemprijs(){
        double total = 0;
        for (Auto auto: autos) total += auto.getPrijs();
        return total/autos.size();
    }

    public double countkleur(String kleur){
        double total = 0;
        for (Auto auto: autos){
            if (auto.getKleur() == kleur){
                total += 1;
            }
        }
        return total;
    }

    public double telTotaalAantalAutosInGarage(){
        return autos.size();
    }
}

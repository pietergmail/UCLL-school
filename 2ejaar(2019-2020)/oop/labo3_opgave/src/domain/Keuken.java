package domain;

import domain.Elektrische_apparaat;

import java.util.ArrayList;
import java.util.List;

public class Keuken {
    private List<Elektrische_apparaat> elektrische = new ArrayList<>();
    private List<Meubel> meubels = new ArrayList<>();

    public void addElektrisch(Elektrische_apparaat elektrische_apparaat){
        elektrische.add(elektrische_apparaat);
    }

    public void addMeubel(Meubel meubel){
        meubels.add(meubel);
    }

    public double totaleprijs(){
        double total = 0;
        for (Elektrische_apparaat elek: elektrische
             ) {
            total += elek.getPrijs();
        }
        for(Meubel meubel: meubels){
            total += meubel.getPrijs();
        }
        return total;
    }

    public double gemprijskwaliteit(){
        double total = 0;
        for (Elektrische_apparaat elek : elektrische){
            total += elek.prijskwaliteitsverhouding();
        }
        return total/elektrische.size();
    }
}

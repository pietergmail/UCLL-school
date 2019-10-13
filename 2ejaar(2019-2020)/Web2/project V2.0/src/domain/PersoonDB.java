package domain;

import domain.Persoon;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class PersoonDB {
private ArrayList<Persoon> personen;
    public PersoonDB() {
       personen = new ArrayList<Persoon>();
        Persoon persoon1 = new Persoon("Pieter", 2000, 8, 7, "Keyboard", true);
        Persoon persoon2 = new Persoon("annemie", 1978, 6, 21, "Accordeon", false);
        Persoon persoon3 = new Persoon("Andre", 1960, 5, 20, "drum", true);
        this.add(persoon1);
        this.add(persoon2);
        this.add(persoon3);
    }

    public void add(Persoon persoon){
        if (persoon == null){
            throw new IllegalArgumentException("no empty persoon");
        }
        personen.add(persoon);
    }

    public void vervang(String naam, String instrument, int Year, int Month, int day, boolean Geslacht){
        for(Persoon persoon : personen){
            if(persoon.getNaam().equals(naam)){
                persoon.setInstrument(instrument);
                persoon.setGeslacht(Geslacht);
                persoon.setGeboortedatum(Year, Month, day);
                break;
            }
        }
    }

    public Persoon getoudste(){
        Persoon oldest = personen.get(0);
        for(Persoon persoon : personen){
            if(persoon.getAge() > oldest.getAge()){
                oldest = persoon;
            }
        }
        return oldest;
    }

    public ArrayList<Persoon> getPersonen() {
        return personen;
    }
}

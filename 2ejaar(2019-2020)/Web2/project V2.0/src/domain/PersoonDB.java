package domain;

import domain.Persoon;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class PersoonDB {
private ArrayList<Persoon> personen;
    public PersoonDB() {
       personen = new ArrayList<Persoon>();
        Persoon persoon1 = new Persoon("Pieter", 19, "Keyboard");
        Persoon persoon2 = new Persoon("annemie", 43, "Accordeon");
        Persoon persoon3 = new Persoon("Andre", 55, "drum");
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

    public void vervang(String naam, int age, String instrument){
        for(Persoon persoon : personen){
            if(persoon.getNaam().equals(naam)){
                persoon.setInstrument(instrument);
                persoon.setAge(age);
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

    public void delete(int index){
        personen.remove(index);
    }


}

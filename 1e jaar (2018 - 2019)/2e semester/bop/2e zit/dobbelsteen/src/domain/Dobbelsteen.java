package domain;

import java.util.Random;



public class Dobbelsteen {
    private int aantalOgen;
    Random rand = new Random();


    public Dobbelsteen() {
        aantalOgen = rand.nextInt(6);
        setAantalOgen(aantalOgen);
    }

    public int getAantalOgen() {
        return aantalOgen;
    }

    public void setAantalOgen(int aantalOgen) {
        this.aantalOgen = aantalOgen;
    }

    public void gooi(){
        aantalOgen = rand.nextInt(6);
        setAantalOgen(aantalOgen);
    }

}

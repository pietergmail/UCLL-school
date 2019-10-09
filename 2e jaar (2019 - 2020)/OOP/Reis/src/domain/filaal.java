package domain;

import domain.Reis;
import domain.Bestemming;

import java.util.ArrayList;

public class filaal {
    private ArrayList<Reis> reizen;
    private String naam;

    public filaal(ArrayList reizen, String naam) {
        setReizen(reizen);
        setNaam(naam);
    }

    public ArrayList getReizen() {
        return reizen;
    }

    public void setReizen(ArrayList reizen) {
        this.reizen = reizen;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    ///public ArrayList Getreizen(){
        
    ///}
    
    public int Getaantalreizen(){
        return this.reizen.size();
    }

    public int Getlangstereis(){
        int langst = 0;
        for (Reis reis: this.reizen) {
            if(reis.getDagen() > langst){
                langst = reis.getDagen();
            }
        }
        return langst;
    }

    public String populairstebestemming(){
        Reis populairste;
        for (Reis reis: this.reizen){

        }
    }
}

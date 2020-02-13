package domain;
import domain.Boek;

import java.net.Authenticator;
import java.util.ArrayList;

public class Bibliotheek {
    ArrayList<Boek> boeken = new ArrayList<>();

    /**
     * Geeft alle boeken die een bepaalde auteur geschreven heeft.
     * @param Autheur de autheur van de boeken die men zoekt.
     * @return geeft een Arraylist met alle boeken van deze auteur.
     */
    public ArrayList<Boek> zoekboek(String Autheur){

        ArrayList<Boek> ret = new ArrayList<>();
        boeken.forEach(boek -> {if(Autheur.equals(boek.auteur)){
            ret.add(boek);
        }});
        return ret;
    }
}

package domain;

import domain.Deelname;
import domain.Verbetercode;

import java.util.ArrayList;

/**
 * De test klasse maakt een test aan en laat toe om de punten te bepalen
 * En een String met de antwoord
 * @author herre
 * @version 1.0
 */

public class Test {
    String naam;
    Verbetercode[] verbetersleutel;
    ArrayList<Deelname> deelnemers = new ArrayList<>();

    public String getNaam() {
        return naam;
    }

    public Verbetercode[] getVerbetersleutel() {
        return verbetersleutel;
    }

    public ArrayList<Deelname> getDeelnemers() {
        return deelnemers;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setVerbetersleutel(Verbetercode[] verbetersleutel) {
        this.verbetersleutel = verbetersleutel;
    }

    public void setDeelnemers(ArrayList<Deelname> deelnemers) {
        this.deelnemers = deelnemers;
    }

    public Test(String naam, Verbetercode[] verbetersleutel) {
        setNaam(naam);
        setVerbetersleutel(verbetersleutel);
    }

    /**
     * Voegt een deelnemer toe aan de test
     * @param deelnemer  de deelnemer die wordt toegevoegd
     */

    public void voegDeelnameToe(Deelname deelnemer){
        deelnemers.add(deelnemer);
    }

    /**
     *Berekent de score op de test
     * @param deelnemer index van de deelnemer van wie de score wordt berekend
     * @return geeft het score percentage terug
     */

    public double berekenScore(int deelnemer){
        double total = 0;
        int max = 0;
        for (int i = 0; i < verbetersleutel.length; i++){
            max += verbetersleutel[i].getAantalPuntenJuist();
            if (verbetersleutel[i].isJuisteAntwoord(deelnemers.get(deelnemer).getAntwoorden()[i])){
                total += verbetersleutel[i].getAantalPuntenJuist();
            }else{
                total += verbetersleutel[i].getAantalPuntenFout();
            }
        }

        return (total/max)*100;//max aantal puntent
    }

    /**
     * Geeft een string met alle waardes.
     * @return geeft de string terug.
     */

    public String toString(){
        String res = "Test: ";
        res += this.getNaam();
        res += "\nAntwoordsleutel:          ";
        for (Verbetercode antwoord: verbetersleutel) {
            res += "|";
            res += antwoord.juisteAntwoord;
        }
        res += "|\nPunten bij goed antwoord: ";
        for (Verbetercode antwoord: verbetersleutel){
            res += "|";
            res += antwoord.aantalPuntenJuist;
        }
        res += "|\nPunten bij fout antwoord: ";
        for (Verbetercode antwoord: verbetersleutel){
            res += "|";
            res += antwoord.aantalPuntenFout;
        }
        res += "|\n\n";

        for (Deelname deelnemer:deelnemers) {
            res += deelnemer.getStudentNummer();
            res += " ";
            res += deelnemer.getStudentNaam();
            res += ":   ";
            for (String antwoord:deelnemer.getAntwoorden()){
                res += "|";
                res += antwoord;
            }
            res += "|   Score:";
            res += Double.toString(this.berekenScore(deelnemers.indexOf(deelnemer)));
            res += "%\n";
        }
        return res;
    }
}

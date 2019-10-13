package domain;

import java.util.ArrayList;

public class Ploeg {
    private String naam;
    private ArrayList<Deelnemer> deelnemers;
    private int score;

    public Ploeg(String naam){
        // TO DO de naam van een ploeg mag niet leeg zijn
        // inititeel geen deelnemers en score 0
        setNaam(naam);
    }

    public void voegDeelnemerToe(Deelnemer deelnemer){
        // TO DO voeg een deelnemer toe mag niet null zijn

    }

    public void verhoogScore(int aantalPunten){
        // TO DO verhoog de score met gegeven aantal punten
        // gegeven aantal punten mag niet negatief zijn
    }

    public int getSCore(){
        return this.score;
    }

    public String getNaam(){
        return this.naam;
    }

    public ArrayList<Deelnemer> geefDeelnemers(){
        return this.deelnemers;
    }

    public String geefStringVorm(){
        String uit = "Ploeg " + this.naam + " heeft een score van " + this.score + " en heeft als deelnemers: \n";
        for (Deelnemer deelnemer: this.deelnemers)
            uit+= "\t- " + deelnemer.geefStringVorm() + "\n";
        return uit;

    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setDeelnemers(ArrayList<Deelnemer> deelnemers) {
        this.deelnemers = deelnemers;
    }

    public void setNaam(String naam) {
        if (naam != null) {this.naam = naam;}
        else throw new IllegalArgumentException("naam mag niet leeg zijn.");
    }
}

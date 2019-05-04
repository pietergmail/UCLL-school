package domain;

public class ScoreBord {
    private Ploeg[] ploegen;

    public ScoreBord(){
        this(3);
    }

    public ScoreBord(int aantalPloegen){
        // TO DO maak een scoreBord waarin de resultaten van
        // aantalPloegen kunnen worden bijgehouden
        // aantalPloegen moet minimaal 3 zijn

    }

    public void voegPloegToe(String naam){
       // TO DO voeg nieuwe ploeg met gegeven naam toe indien mogelijk
    }

    public void voegDeelnemerToe(String ploegNaam, Deelnemer deelnemer){
        // TO DO voeg gegeven deelnemer toe aan ploeg met gegeven naam
    }

    public void voegScoreToe(String ploegNaam, int behaaldePunten){
        // voeg behaaldePunten toe aan de score van ploeg met gegeven naam
        // behaaldePunten moet minimaal 0 zijn

    }

    public Ploeg[] geefTop3(){
        // geef de top 3 ploegen dit wil zeggen deze met met de best behaalde scores
        // op eerste plaats van de resulterende array staat de beste
        // op plaats twee de tweede beste ...

        return null;
    }



    public String geefStringVorm(){
        String uit = "Scorebord:\n";
        for (int i = 1 ; i <= ploegen.length; i++){
            if (this.ploegen[i-1] != null)
                uit+= this.ploegen[i-1].geefStringVorm() + "\n_____________________________________________________________________\n";
        }
        return uit;
    }


    public int geefScore(String s) {
        // TO DO geef de score van de ploeg met gegeven naam
        return 0;
    }
}

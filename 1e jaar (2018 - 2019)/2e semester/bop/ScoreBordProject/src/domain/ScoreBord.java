package domain;

public class ScoreBord {
    private int[] scores;

    public ScoreBord(){
        this(3);
    }

    public ScoreBord(int aantalPloegen){

        // TO DO maak een scoreBord waarin de resultaten van
        // aantalPloegen kunnen worden bijgehouden
        // aantalPloegen moet minimaal 3 zijn
    }

    public void voegScoreToe(int ploegNummer, int behaaldePunten){
        // voeg behaaldePunten toe aan de score van ploeg met nummmer ploegNummer( 1..aantalPloegen)
        // behaaldePunten moet minimaal 0 zijn
    }

    public int[] geefTop3(){
        // geef de ploegnummers van de 3 ploegen met de best behaalde scores
        // op eerste plaats van de resulterende array staat de beste
        // op plaats twee de tweede beste ...
        return null;
    }

    public int[] geeftTop3(int[] gediskwalificeerd){
        // Een aantal ploegen zijn gedeskwalificeerd, de ploegnummers van de
        // gediskalificeerde ploegen worden als parameter meegegeven
        // geef als resultaat de top 3 terug van de best scorende ploegen
        // waarbij de gediskawlificeerde ploegen niet meer mee mogen doen
        // wanneer er geen 3 ploegen meer overblijven maar toch minimaal
        // 1 ploeg overblijft worden de beste teruggeven
        // wanneer alle ploegen gediskwalificeerd zijn wordt null terug gegegevn
        return null;
    }

    public String geefStringVorm(){
        String uit = "Scorebord:\n";
        for (int i = 1 ; i <= scores.length; i++){
            uit+= "Ploegnummer: " + i + " heeft een score van " + this.scores[i-1] + "punten\n";
        }
        return uit;
    }


}

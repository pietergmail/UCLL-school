package ui;

import domain.Deelnemer;
import domain.Ploeg;
import domain.ScoreBord;

import java.util.ArrayList;

public class Appeke {
    public  static void main(String[] args){
        ScoreBord bord = new ScoreBord(5);

        bord.voegPloegToe("De IT'ers");
        bord.voegPloegToe("Pokemons");
        bord.voegPloegToe("Het frietkot");
        bord.voegPloegToe("ok");
        bord.voegPloegToe("nok");

        bord.voegDeelnemerToe("De IT'ers", new Deelnemer("Janssen","Jan"));
        bord.voegDeelnemerToe("De IT'ers", new Deelnemer("Janssen","An"));
        bord.voegDeelnemerToe("De IT'ers", new Deelnemer("Frederiks","Fred"));

        bord.voegDeelnemerToe("Pokemons",new Deelnemer("Muelemans","Tom"));
        bord.voegDeelnemerToe("Pokemons",new Deelnemer("Muelemans","Tim"));

        bord.voegDeelnemerToe("Het frietkot",new Deelnemer("Hendriks","Hendrik"));
        bord.voegDeelnemerToe("Het frietkot",new Deelnemer("Wens","Zoe"));

        bord.voegDeelnemerToe("ok",new Deelnemer("Anders","Andreas"));

        bord.voegDeelnemerToe("nok",new Deelnemer("Bertels","Bert"));

        bord.voegScoreToe("De IT'ers",120);
        bord.voegScoreToe("Pokemons",225);
        bord.voegScoreToe("Het frietkot",55);
        bord.voegScoreToe("ok",123);
        bord.voegScoreToe("nok",77);
        bord.voegScoreToe("nok",33);

        System.out.println(bord.geefStringVorm());

        Ploeg[] deBesten = bord.geefTop3();
        for (int i = 1 ; i <= 3 ; i++){
            String deelnemersString = "[";
            ArrayList<Deelnemer> deelnemers = deBesten[i-1].geefDeelnemers();
            for (Deelnemer d: deelnemers) deelnemersString+= d.geefStringVorm() + ", ";
            deelnemersString = deelnemersString.substring(0,deelnemersString.length()-2) + "]";
            System.out.println("Op plaats " + i + " staat de ploeg met naam " + deBesten[i-1].getNaam() + " en deelnemers " +
                     deelnemersString +
                     " met een score van " + deBesten[i-1].getSCore());
        }
    }
}

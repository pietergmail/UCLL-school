package ui;
import domain.*;

public class Main {

    public static void main(String[] args){
        Fornuis f = new Fornuis(200, 'B');
        Koelkast ko = new Koelkast(150, 'A', true);
        Microgolfoven mi = new Microgolfoven(250, 'E');

        Kast k = new Kast(60);
        Werkblad w = new Werkblad(90);

        Keuken keuken = new Keuken();

        keuken.addElektrisch(f);
        keuken.addElektrisch(ko);
        keuken.addElektrisch(mi);

        keuken.addMeubel(k);
        keuken.addMeubel(w);

        System.out.println(keuken.totaleprijs());
        System.out.println(keuken.gemprijskwaliteit());
    }
}

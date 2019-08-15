package ui;

import domain.Hond;
import domain.Asiel;

public class app{

    public static void main(String[] args){
        Hond hond1 = new Hond("fifi", 15, 2012);
        Hond hond2 = new Hond("dog", 20, 2015);
        Hond hond3 = new Hond("luna", 30, 2008);
        Hond hond4 = new Hond("angle", 25, 2006);
        Hond hond5 = new Hond("fifi", 10, 2016);


        System.out.println(hond1.rekenvoerperdag());

        Asiel asiel = new Asiel("asiel");
        asiel.voeghondtoe(hond1);
        asiel.voeghondtoe(hond2);
        asiel.voeghondtoe(hond3);

        System.out.println(asiel.rekenVoerPerWeek());
        System.out.println(asiel.rekenVoerKostenPerWeek(5));
    }
}


package ui;

import domain.*;

public class StratenloopApp {

    public static void main(String[] args) {
        Stratenloop stratenloop = new Stratenloop("Corrida Leuven",3);
        stratenloop.setAantalKilometer(5);
        stratenloop.setAantalKilometer(10);
        stratenloop.setAantalKilometer(15);

        Loper anne = new Loper("Adams","Anne",15);
        Loper miet = new Loper("Meekers","Miet",5);
        Loper fred = new Loper("Frederiks","Fred",5);
        Loper jef = new Loper("Elders","Jef",5);
        Loper seppe = new Loper("Frederiks","Seppe",5);

        stratenloop.voegLoperToe(anne);
        stratenloop.voegLoperToe(fred);
        stratenloop.voegLoperToe(jef);
        stratenloop.voegLoperToe(miet);
        stratenloop.voegLoperToe(seppe);

        miet.start(new Tijdstip(13,13,13));
        anne.start(new Tijdstip(14,15,0));
        anne.finish(new Tijdstip(15,10,58));
        fred.start(new Tijdstip(12,0,0));
        fred.finish(new Tijdstip(13,58,0));
        seppe.start(new Tijdstip(12,0,0));
        seppe.finish(new Tijdstip(13,57,59));

        System.out.println(stratenloop);

        System.out.println("_______________________________________________________________________________");
        System.out.println("Reeds aangekomen deelnemers voor de 5 km:  ");
        System.out.println(stratenloop.printLopersGefinished(5));
        System.out.println("_______________________________________________________________________________");
        System.out.println("De snelste reeds aangekomen loper voor de 5 km is : \n"
                + stratenloop.snelsteLoper(5).toString());
        System.out.println("\n_______________________________________________________________________________");

        try{
            miet.finish(new Tijdstip(12,12,12));
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

}
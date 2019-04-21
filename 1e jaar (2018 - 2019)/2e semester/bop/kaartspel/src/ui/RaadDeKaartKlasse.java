package ui;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import domain.Kaart;


public class RaadDeKaartKlasse {

    int teller = 0;
    boolean ok = false;
    boolean nummerGeraden = false;
    Kaart teRadenKaart  = new Kaart();// maak een random kaart
    Label invoerLabelType = new Label("Geef het type van de kaart");
    TextField invoerType = new TextField();
    Label invoerLabelNummer = new Label("Geef het nummer van de kaart");
    TextField invoerNummer = new TextField();


    public RaadDeKaartKlasse  (GridPane p) {

        p.add(invoerLabelType,0,0);
        p.add(invoerType,0,1);

        invoerType.setOnAction(eventIngaveInvoerLinks -> {
            if (!ok) {
                p.add(invoerLabelNummer, 1, 0);
                p.add(invoerNummer, 1, 1);
                ok= true;
            }
            if (nummerGeraden){
                Kaart k = new Kaart(invoerType.getText(),Integer.parseInt(invoerNummer.getText()));
                System.out.println(k.geefInfo());
                controleer(k,teller);
            }
        });

        invoerNummer.setOnAction(eventIngaveInvoerRechts -> {
            teller++;
            Kaart k = new Kaart(invoerType.getText(),Integer.parseInt(invoerNummer.getText()));
            System.out.println(k.geefInfo());
            controleer(k,teller);
        });
    }

    private void controleer(Kaart k, int teller){

        if (teRadenKaart.isZelfde(k)) {
            System.out.println("Je hebt de kaart geraden in " + teller + " stappen!!");
            System.exit(0);// programma stopt

        } else if (teRadenKaart.heeftZelfdeType(k)) {
            System.out.println("Het type is correct nu nog het juiste nummer");
            invoerNummer.clear();
            invoerType.setEditable(false);
        } else if (teRadenKaart.heeftZelfdeNummer(k)) {
            System.out.println("Het nummer is correct nu nog het type");
            invoerType.clear();
            invoerNummer.setEditable(false);
            nummerGeraden = true;
        } else {
            System.out.println("Type en nummer niet correct");
            invoerType.clear();
            invoerNummer.clear();
        }
    }



}
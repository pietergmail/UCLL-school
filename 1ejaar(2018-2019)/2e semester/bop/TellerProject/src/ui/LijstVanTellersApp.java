package ui;

import domain.LijstVanTellers;
import domain.Teller;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class LijstVanTellersApp {
    private Button maakTellerKnop, resetAllKnop;
    private LijstVanTellers l;
    private int regelNummer;
    private List<Text> uitvoervelden;

    public LijstVanTellersApp(GridPane root) {
        l = new LijstVanTellers();
        this.uitvoervelden = new ArrayList<>();

        maakTellerKnop = new Button("maak nieuwe teller");
        root.add(maakTellerKnop,0,0);
        resetAllKnop = new Button("reset alle tellers");
        root.add(resetAllKnop,1,0);

        regelNummer = 1;
        maakTellerKnop.setOnAction(eventMaakTellerKnop -> {
            Line  streep1 = new Line(0,regelNummer++,200,regelNummer++);
            root.add(streep1,0,regelNummer++);
            streep1.setStrokeWidth(20);

            Button addKnop = new Button("add");
            Button addMetWaardeKnop = new Button("add met gegeven waarde");
            Button resetKnop = new Button("reset");
            Label addMetWaardeLabel = new Label("geef de waarde waar je de teller mee wilt verhogen");
            TextField invoerAddMetWaarde = new TextField();

            Text uitvoer = new Text();
            this.uitvoervelden.add(uitvoer);

            Teller teller = new Teller();
            l.voegTellerToe(teller);

            root.add(addKnop,0,regelNummer++);
            root.add(addMetWaardeKnop,0,regelNummer++);
            root.add(resetKnop,0,regelNummer++);
            regelNummer+= 2;
            root.add(uitvoer,0,regelNummer++);
            uitvoer.setText("Waarde = " + teller.getWaarde());

            Line  streep2 = new Line(0,regelNummer++,200,regelNummer++);
            root.add(streep2,0,regelNummer++);
            streep2.setStrokeWidth(15);
            regelNummer += 2;
            addKnop.setOnAction(eventAddTeller -> {
                teller.add();
                uitvoer.setText("Waarde = " + teller.getWaarde());
            });

            resetKnop.setOnAction(eventReset -> {
                teller.reset();
                uitvoer.setText("Waarde = " + teller.getWaarde());
            });
            addMetWaardeKnop.setOnAction(eventAddMetWaarde -> {// label en textField toevoegen om waarde in te kunnen geven
                root.add(addMetWaardeLabel,2,0);
                root.add(invoerAddMetWaarde,3,0);

            });
            invoerAddMetWaarde.setOnAction(eventInvoerAddMetWaarde -> {// als de waarde is  ingegeven worden volgende acties uitgevoerd
                int w = Integer.parseInt(invoerAddMetWaarde.getText());
                teller.add(w);
                uitvoer.setText("Waarde = " + teller.getWaarde());
                root.getChildren().remove(addMetWaardeLabel);
                invoerAddMetWaarde.clear();
                root.getChildren().remove(invoerAddMetWaarde);
            });


        });
        resetAllKnop.setOnAction(eventResetAll -> {
            l.resetAll();
            clearAllUitvoervelden();
        });
    }

    private void clearAllUitvoervelden() {
        for (Text t: this.uitvoervelden)
            t.setText("Waarde = 0");
    }
}

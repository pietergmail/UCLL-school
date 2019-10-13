package ui;

import domain.Teller;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class TellerApp {
    private Button maakTellerKnop, addKnop, resetKnop, addMetWaardeKnop;

    private Label addMetWaardeLabel;
    private TextField invoerAddMetWaarde ;

    private TextArea uitvoer;

    private Teller teller;

    public TellerApp(GridPane root) {
        maakTellerKnop = new  Button("Maak nieuwe teller");
        addKnop = new Button("add");
        addMetWaardeKnop = new Button("add met gegeven waarde");
        resetKnop = new Button("reset");
        addMetWaardeLabel = new Label("geef de waarde waar je de teller mee wilt verhogen");
        invoerAddMetWaarde = new TextField();

        uitvoer = new TextArea();

        root.add(maakTellerKnop,0,0);

        maakTellerKnop.setOnAction(eventMaakTeller -> {
            maakTellerKnop.setDisable(true); // je kan maar 1 keer klikken
            teller = new Teller();
            root.add(addKnop,0,1);
            root.add(addMetWaardeKnop,0,2);
            root.add(resetKnop,0,3);
            root.add(uitvoer,0,4);
            uitvoer.setText("Waarde = " + teller.getWaarde());
        });

        addKnop.setOnAction(eventAddTeller -> {
            teller.add();
            uitvoer.setText("Waarde = " + teller.getWaarde());
        });

        resetKnop.setOnAction(eventReset -> {
            teller.reset();
            uitvoer.setText("Waarde = " + teller.getWaarde());
        });
        addMetWaardeKnop.setOnAction(eventAddMetWaarde -> {// label en textField toevoegen om waarde in te kunnen geven
            root.add(addMetWaardeLabel,4,2);
            root.add(invoerAddMetWaarde,5,2);

        });
        invoerAddMetWaarde.setOnAction(eventInvoerAddMetWaarde -> {// als de waarde is  ingegeven worden volgende acties uitgevoerd
            int w = Integer.parseInt(invoerAddMetWaarde.getText());
            teller.add(w);
            uitvoer.setText("Waarde = " + teller.getWaarde());
            root.getChildren().remove(addMetWaardeLabel);
            invoerAddMetWaarde.clear();
            root.getChildren().remove(invoerAddMetWaarde);
        });
    }
}

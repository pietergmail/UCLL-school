import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

public class AantalCijfersInGetalKlasse{
    public AantalCijfersInGetalKlasse(FlowPane p) {

        Label invoerLabel = new Label("Geef een getal");
        TextField invoer = new TextField();

        p.getChildren().add(invoerLabel);
        p.getChildren().add(invoer);

        invoer.setOnAction(eventIngaveInvoer -> {

            int getalWaarde = Integer.parseInt(invoer.getText());
            int hulp = Math.abs(getalWaarde);
            int aantal = 1;
            while (hulp >= 10){
                aantal++;
                hulp = hulp / 10;
            }

            System.out.println("Het aantal cijfers in " + getalWaarde + " = " + aantal);

        });
    }


}
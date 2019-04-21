import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class EvenOfOneven extends Application {
    @Override
    public void start(Stage primaryStage) {
        FlowPane root = new FlowPane();
        Scene scene = new Scene(root, 300, 250);

        Label invoerLabel = new Label("Geef een getal");
        TextField invoer  = new TextField();

        root.getChildren().add(invoerLabel);
        root.getChildren().add(invoer);

        TextArea uitvoer = new  TextArea();
        uitvoer.setPrefColumnCount(80);
        uitvoer.setPrefRowCount(10);
        invoer.setOnAction(eventIngaveInvoer -> {

                    int getalWaarde = Integer.parseInt(invoer.getText());
                    // schrijf hier de java code
            switch (getalWaarde % 2 == 0)
            {
                String regel1 = "Het getal: " + invoer.getText() + " is even";
                uitvoer.setText(regel1);
                uitvoer.setEditable(false);
                root.getChildren().add(uitvoer);
            }
            else
            {
                String regel1 = "het getal: " + invoer.getText() + " is oneven";
                uitvoer.setText(regel1);
                uitvoer.setEditable(false);
                root.getChildren().add(uitvoer);
            }





		 // om na te gaan of getalWaarde al dan niet even is en 
		// een gepaste boodschap uit te schrijven
                });



        primaryStage.setScene(scene);
        primaryStage.setTitle("Even of oneven?");
        primaryStage.show();
    }


    public static void main(String[] args){
        launch(args);
    }
}

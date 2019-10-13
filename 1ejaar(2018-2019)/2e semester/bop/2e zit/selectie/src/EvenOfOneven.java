import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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

        invoer.setOnAction(eventIngaveInvoer -> {

            int getalWaarde = Integer.parseInt(invoer.getText());
            if (getalWaarde % 2 == 0){
                System.out.println(getalWaarde + " is een even getal.");
            }
            else {
                System.out.println(getalWaarde + " is een oneven getal.");
            }
        });



        primaryStage.setScene(scene);
        primaryStage.setTitle("Hallo");
        primaryStage.show();
    }


    public static void main(String[] args){
        launch(args);
    }
}

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class FxAantalCijfersInGetal extends Application {
    @Override
    public void start(Stage primaryStage) {
        FlowPane root = new FlowPane();
        Scene scene = new Scene(root, 300, 250);

        new AantalCijfersInGetalKlasse(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Aantal cijfers = ");
        primaryStage.show();
    }


    public static void main(String[] args){
        launch(args);
    }
}

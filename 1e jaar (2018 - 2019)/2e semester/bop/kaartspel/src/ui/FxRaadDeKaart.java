package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class FxRaadDeKaart extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        Scene scene = new Scene(root, 300, 250);

        new RaadDeKaartKlasse(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("raad de kaart ");
        primaryStage.show();
    }


    public static void main(String[] args){
        launch(args);
    }
}
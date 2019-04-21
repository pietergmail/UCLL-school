package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FxLijstVanTellersApp extends Application {


    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        Scene scene = new Scene(root);
        new LijstVanTellersApp(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Lijst van tellers App");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

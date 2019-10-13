package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FxTellerApp extends Application {


    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        Scene scene = new Scene(root);
        new TellerApp(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Teller App");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package launcher;

import domain.Product;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import ui.ProductUI;

public class Main extends Application {

    public static void main(String[] args) {
        //if javafx then launch, else make ProductUI
        ProductUI p = new ProductUI();
        //launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane root = new GridPane();
        ProductUI ProductUI = new ProductUI(root);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Labo ");
        primaryStage.show();
    }
}

package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        FlowPane root = new FlowPane();
        Scene scene = new Scene(root, 325, 500);

        Label TitleLabel = new Label("Geef de titel van het boek              ");
        TextField invoertitel = new TextField();

        Label auteurLabel = new Label("Geef de naam van de auteur van het boek");
        TextField invoerAuteur = new TextField();

        Label paginaLabel = new Label("Geef het aantal pagina's van het boek");
        TextField invoerPagina = new TextField();

        Label hoofdstukLabel = new Label("Geef het aantal hoofdstukken in het boek");
        TextField invoerhoofdstuk = new TextField();

        Label TitleLabel2 = new Label("Geef de titel van het tweede boek");
        TextField invoertitel2 = new TextField();

        Label auteurLabel2 = new Label("Geef de naam van de auteur van het tweede boek");
        TextField invoerAuteur2 = new TextField();

        Label paginaLabel2 = new Label("Geef het aantal pagina's van het tweede boek");
        TextField invoerPagina2 = new TextField();

        Label hoofdstukLabel2 = new Label("Geef het aantal hoofdstukken in het tweede boek");
        TextField invoerhoofdstuk2 = new TextField();

        TextArea uitvoer = new  TextArea();
        uitvoer.setPrefColumnCount(80);
        uitvoer.setPrefRowCount(10);


        root.getChildren().add(TitleLabel);
        root.getChildren().add(invoertitel);

        invoertitel.setOnAction(eventIngaveTitel -> {

            root.getChildren().add(auteurLabel);
            root.getChildren().add(invoerAuteur);
        });

        invoerAuteur.setOnAction(eventIngaveAuteur -> {
            root.getChildren().add(paginaLabel);
            root.getChildren().add(invoerPagina);
        });

        invoerPagina.setOnAction(eventIngavePagina -> {
            root.getChildren().add(hoofdstukLabel);
            root.getChildren().add(invoerhoofdstuk);
        });

        invoerhoofdstuk.setOnAction(eventIngavehoofdstuk -> {

                    root.getChildren().add(TitleLabel2);
                    root.getChildren().add(invoertitel2);
        });

        invoertitel2.setOnAction(eventIngavetitel2 -> {

            root.getChildren().add(auteurLabel2);
            root.getChildren().add(invoerAuteur2);
        });

        invoerAuteur2.setOnAction(eventIngaveAuteur2 -> {
            root.getChildren().add(paginaLabel2);
            root.getChildren().add(invoerPagina2);
        });

        invoerPagina2.setOnAction(eventIngavePagina2 -> {
            root.getChildren().add(hoofdstukLabel2);
            root.getChildren().add(invoerhoofdstuk2);
        });


        invoerhoofdstuk2.setOnAction(eventIngavehoofdstuk2 -> {


            double getalpagina = Double.parseDouble(invoerPagina.getText());
            double getalhoofdstuk = Double.parseDouble(invoerhoofdstuk.getText());
            double gemiddelde = getalpagina / getalhoofdstuk;


            double getalpagina2 = Double.parseDouble(invoerPagina2.getText());
            double getalhoofdstuk2 = Double.parseDouble(invoerhoofdstuk2.getText());
            double gemiddelde2 = getalpagina2 / getalhoofdstuk2;

            double sompaginas = getalpagina + getalpagina2;

            String regel1 = "\nJe bent het boek " + invoertitel.getText() + " van auteur " + invoerAuteur.getText() + "\naan het lezen. Dit boek is " + invoerPagina.getText() + " pagina's dik.";
            String regel2 = "\nHet gemiddelde aantal pagina's per hoofdstuk zal " + gemiddelde + " zijn.";

            String regel3 = "\n\nJe bent het boek " + invoertitel2.getText() + " van auteur " + invoerAuteur2.getText() + "\naan het lezen. Dit boek is " + invoerPagina2.getText() + " pagina's dik.";
            String regel4 = "\nHet gemiddelde aantal pagina's per hoofdstuk zal " + gemiddelde2 + " zijn.";

            String regel5 = "\nDe twee boeken samen zijn " + sompaginas + " pagina's dik";

            uitvoer.setText(regel1 + regel2 + regel3 + regel4 + regel5);
            uitvoer.setEditable(false);
            root.getChildren().add(uitvoer);
        });


        primaryStage.setScene(scene);
        primaryStage.setTitle("Hallo");
        primaryStage.show();
    }


    public static void main(String[] args){
        launch(args);
    }
}
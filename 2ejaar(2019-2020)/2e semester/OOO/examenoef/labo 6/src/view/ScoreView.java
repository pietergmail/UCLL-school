package view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Game;
import model.Observer;

public class ScoreView implements Observer {
    private Stage stage = new Stage();
    private Scene scoreScene;
    private Label scoreLabel;
    private Game game;
    public ScoreView(Game game){

        this.game = game;
        game.addObserver(this);
        scoreLabel = new Label();
        scoreLabel.setStyle("-fx-font-family: \"Courier new\"; -fx-font-size: 12; -fx-text-fill: darkred;");

        layoutComponents();
        stage.setScene(scoreScene);
        stage.setTitle("Overzicht scores");
        stage.setResizable(false);
        stage.setX(100);
        stage.setY(400);
        stage.show();
    }

    private void layoutComponents() {
        VBox root = new VBox();
        scoreScene = new Scene(root,400,200);
        root.getChildren().add(scoreLabel);
    }

    private void voegScoreLijnToe(String scoreLijn){
        scoreLabel.setText(scoreLabel.getText()+"\n"+scoreLijn);
    }

    @Override
    public void update(int[] e, int nummer, Observer o,int total) {
        voegScoreLijnToe("Speler " + nummer + ": " + e[0] + " - " + e[1] + "total: " + total);
    }

}

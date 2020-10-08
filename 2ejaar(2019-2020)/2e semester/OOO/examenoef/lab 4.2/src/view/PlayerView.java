package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Game;
import model.Observer;

public class PlayerView implements Observer {
	private Stage stage = new Stage();
	private Scene playerScene;
	private Label diceLabel;
	private Button playButton;
	private Label messageLabel;

	private int spelerNummer;
	Game game;

	public PlayerView(int i, Game game){
		this.game = game;
		game.addObserver(this);
		this.spelerNummer = i;
		diceLabel = new Label("beurt 1: ");
		playButton = new Button("Werp dobbelstenen");
		playButton.setOnAction(new ThrowDicesHandler());
		playButton.setDisable(true);
		messageLabel = new Label("Spel nog niet gestart");
		layoutComponents();
		stage.setScene(playerScene);
		stage.setTitle("Speler "+spelerNummer);
		stage.setResizable(false);
		stage.setX(100+(spelerNummer-1) * 350);
		stage.setY(200);
		stage.show();
	}

	private void layoutComponents() {
		VBox root = new VBox(10);
		playerScene = new Scene(root,250,100);
		root.getChildren().add(playButton);
		root.getChildren().add(diceLabel);
		root.getChildren().add(messageLabel);
	}

	public void isAanBeurt(boolean aanBeurt){
		playButton.setDisable(!aanBeurt);
	}

	@Override
	public void update(int[] e, int nummer, Observer o, int total) {
		//if (this = observer){isaanbeurt(true);}
		messageLabel.setText("player: " + nummer + ": " + e[0] + " - " +e[1] + ":" + total);
		if (this == o){isAanBeurt(true);}else{isAanBeurt(false);}

	}


	class ThrowDicesHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			//todo game.werpdobbelsteen (play)
			game.play();
		}
	}
}

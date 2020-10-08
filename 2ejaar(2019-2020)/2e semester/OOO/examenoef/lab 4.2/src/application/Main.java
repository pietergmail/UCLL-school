package application;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Game;
import model.Player;
import view.PlayerView;
import view.ScoreView;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Game game = new Game();
		new ScoreView(game);
		Player player1 = new Player(1);
		Player player2 = new Player(2);
		Player player3 = new Player(3);

		game.addPlayer(player1);
		game.addPlayer(player2);
		game.addPlayer(player3);

		PlayerView pv3 = new PlayerView(2,game);
		PlayerView pv2 = new PlayerView(3,game);
		PlayerView pv1 = new PlayerView(1,game);
		pv1.isAanBeurt(true);
	}

	public static void main(String[] args) {
		launch(args);

	}
}

package model;

import view.PlayerView;
import view.ScoreView;

import java.util.ArrayList;

public class Game implements Subject {
    private ArrayList<Observer> observers;
    private ArrayList<Player> players;
    private int ronde = 0;
    private Player currentPlayer;
    private int[] vorigeWorp = new int[2];

    public Game(){
        observers = new ArrayList<>();
        players = new ArrayList<>();
        vorigeWorp[0] = 0;
        vorigeWorp[1] = 0;
    }

    public void addPlayer(Player p){
        this.players.add(p);
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void deleteObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(int[] e, int total) {
        int i = players.indexOf(currentPlayer);
        ArrayList<Observer> playerViews = new ArrayList<>();
        ArrayList<Observer> ScoreViews = new ArrayList<>();

        for (Observer o : observers) {
            if (o instanceof PlayerView) {
                playerViews.add(o);
            }
        }

        for (Observer o : observers) {
            if (o instanceof ScoreView)
                ScoreViews.add(o);
        }

        for (Observer o: playerViews){
            o.update(e, currentPlayer.getNummer(), playerViews.get(i), total);
        }

        for (Observer o: ScoreViews){
            o.update(e, currentPlayer.getNummer(), ScoreViews.get(0), total);
        }
    }

    public void play(){
        if (currentPlayer == null){
            currentPlayer = players.get(0);
        }

        if (ronde <= 4){
            int[] worp = currentPlayer.gooi();
            notifyObservers(worp, berekenScore(worp));
            if (players.indexOf(currentPlayer) == players.size() - 1){
                ronde++;
                if (ronde < 4){
                    currentPlayer = players.get(0);
                }
            }else{
                currentPlayer = players.get(players.indexOf(currentPlayer)+1);
            }
        }
    }

    private int berekenScore(int[] worp){
        int res = totaal(worp);
        if (worp[0] == worp[1]){
            res *= 2;
        }
        if (totaal(vorigeWorp) == totaal(worp)){
            res += 5;
        }
        return res;
    }

    private int totaal(int[] worp){
        return worp[0] + worp[1];
    }
}

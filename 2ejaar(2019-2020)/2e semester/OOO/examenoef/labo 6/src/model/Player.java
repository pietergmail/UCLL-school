package model;

import java.util.Random;

public class Player {
    private int nummer;
    private int score;

    public Player(int nummer){this.nummer = nummer;}
    public int[] gooi(){
        int[] res = new int[2];
        Random n = new Random();
        res[0] = n.nextInt(6)+1;
        res[1] = n.nextInt(6)+1;
        return res;
    }

    public int getNummer(){ return nummer;}

    public int getScore(){return score;}
    public void addScore(int i){score += 1;}

    @Override
    public String toString(){return nummer + " " + score;}
}

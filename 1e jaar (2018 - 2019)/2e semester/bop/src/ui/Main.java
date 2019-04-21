package ui;
import domain.punt2D;

public class Main {

    public static void main(String[] args) {

        punt2D punt = new punt2D(1, 5);
        punt.movehorizontal(1);
        punt.movevertical(1);
        punt.hoger(8);
        punt.ligt_lings(5);
        punt.zelfde(6, 5);
        System.out.println(punt.info());
    }
}

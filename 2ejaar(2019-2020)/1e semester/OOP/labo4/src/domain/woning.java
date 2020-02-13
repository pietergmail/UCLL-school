package domain;

public class woning extends Lening{
    private static double interest = 0.03;

    public woning(String naam, double bedrag, double duur) {
        super(naam, bedrag, duur);
    }
}

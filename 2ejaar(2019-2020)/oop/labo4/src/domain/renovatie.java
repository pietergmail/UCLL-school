package domain;

public class renovatie extends Lening{
    private static double interest = 0.04;


    public renovatie(String naam, double bedrag, double duur) {
        super(naam, bedrag, duur);
    }
}

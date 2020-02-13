package domain;
import domain.Rekening;

public class Spaar extends Rekening {
    private static double rente = 2.1;

    public Spaar(String naam, double bedrag, double duur) {
        super(naam);
    }

    @Override
    public double getRente() {
        return rente;
    }
}

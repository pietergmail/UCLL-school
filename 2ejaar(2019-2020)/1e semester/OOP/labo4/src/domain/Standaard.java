package domain;

public class Standaard extends Rekening{
    private static double rente = 0.7;

    public Standaard(String naam) {
        super(naam);
    }

    @Override
    public double getRente() {
        return rente;
    }
}

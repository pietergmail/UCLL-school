package domain.PersonenVervoer;

public class MiniBus extends PersonenVervoer {
    public static final double MINIBUS_PRIJS = 100;

    @Override
    public double berekenPrijs(int afstand) {
        return MINIBUS_PRIJS*Math.ceil((double) afstand/100);
    }
}

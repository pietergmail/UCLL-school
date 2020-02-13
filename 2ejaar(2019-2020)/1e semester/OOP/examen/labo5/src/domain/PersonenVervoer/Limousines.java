package domain.PersonenVervoer;

public class Limousines extends PersonenVervoer {
    public static final double LIMOUSINES_PRIJS = 100;

    @Override
    public double berekenPrijs(int afstand) {
        return LIMOUSINES_PRIJS*Math.ceil((double) afstand/100);
    }
}

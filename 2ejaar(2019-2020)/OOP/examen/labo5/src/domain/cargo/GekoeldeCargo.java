package domain.cargo;

public class GekoeldeCargo extends Cargo {
    public static final double GEKOELD_PRIJS = 50;

    public GekoeldeCargo(double hoeveelheid, String beschrijving, Vrachtwagen vrachtwagen) {
        super(hoeveelheid, beschrijving, vrachtwagen);
    }

    @Override
    public double berekenPrijs(int afstand) {
        return GEKOELD_PRIJS * getHoeveelheid() * Math.ceil((double) afstand / 100);
    }
}

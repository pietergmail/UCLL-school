package domain.cargo;

public class StandaardCargo extends Cargo {
    public static final double STANDAARD_PRIJS = 30;

    public StandaardCargo(double hoeveelheid, String beschrijving, Vrachtwagen vrachtwagen) {
        super(hoeveelheid, beschrijving, vrachtwagen);
    }

    @Override
    public double berekenPrijs(int afstand) {
        return STANDAARD_PRIJS * getHoeveelheid() * Math.ceil((double) afstand / 100);
    }
}

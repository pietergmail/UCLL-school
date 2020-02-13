package domain.cargo;

public class GasCargo extends Cargo implements GasOfVloeistofCargo {
    public static final double GAS_PRIJS = 20;
    public static final double GAS_VASTE_PRIJS = 25;

    public GasCargo(double hoeveelheid, String beschrijving, Vrachtwagen vrachtwagen) {
        super(hoeveelheid, beschrijving, vrachtwagen);
    }

    @Override
    public double berekenPrijs(int afstand) {
        double afstandPer100km = Math.ceil((double) afstand / 100);
        return GAS_PRIJS * Math.ceil(getHoeveelheid() / 100) * afstandPer100km + GAS_VASTE_PRIJS * afstandPer100km;
    }
}

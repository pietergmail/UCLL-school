package domain.cargo;

public class VloeistofCargo extends Cargo implements GasOfVloeistofCargo {
    public static final double VLOEISTOF_PRIJS = 10;
    public static final double VLOEISTOF_VASTE_PRIJS = 30;

    public VloeistofCargo(double hoeveelheid, String beschrijving, Vrachtwagen vrachtwagen) {
        super(hoeveelheid, beschrijving, vrachtwagen);
    }

    @Override
    public double berekenPrijs(int afstand) {
        double afstandPer100km = Math.ceil((double) afstand / 100);
        return VLOEISTOF_PRIJS * Math.ceil(getHoeveelheid() / 100) * afstandPer100km + VLOEISTOF_VASTE_PRIJS * afstandPer100km;
    }
}

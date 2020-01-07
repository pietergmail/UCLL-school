package domain.cargo;

public class GevaarlijkeVloeistof extends Cargo  implements GasOfVloeistofCargo{
    public static final double GEVAARLIJKE_VLOEISTOF_PRIJS = 16;
    public static final double GEVAARLIJKE_VLOEISTOF_VASTE_PRIJS = 35;

    public GevaarlijkeVloeistof(double hoeveelheid, String beschrijving, Vrachtwagen vrachtwagen) {
        super(hoeveelheid, beschrijving, vrachtwagen);
    }

    @Override
    public double berekenPrijs(int afstand) {
        double afstandPer100km = Math.ceil((double) afstand / 100);
        return GEVAARLIJKE_VLOEISTOF_PRIJS *Math.ceil(getHoeveelheid() / 100)* afstandPer100km + GEVAARLIJKE_VLOEISTOF_VASTE_PRIJS * afstandPer100km;
    }
}

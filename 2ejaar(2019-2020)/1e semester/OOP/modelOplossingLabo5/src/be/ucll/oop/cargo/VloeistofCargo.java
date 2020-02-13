package be.ucll.oop.cargo;

public class VloeistofCargo extends Cargo implements GasOfVloeistofCargo {
	public static final double VLOEISTOF_PRIJS = 10;
	public static final double VLOEISTOF_VASTE_PRIJS = 30;

	@Override
	public double berekenPrijs(int afstand) {
		double afstandPer100km = Math.ceil((double) afstand / 100);
		return VLOEISTOF_PRIJS * Math.ceil(getHoeveelheid() / 100) * afstandPer100km + VLOEISTOF_VASTE_PRIJS * afstandPer100km;
	}
}

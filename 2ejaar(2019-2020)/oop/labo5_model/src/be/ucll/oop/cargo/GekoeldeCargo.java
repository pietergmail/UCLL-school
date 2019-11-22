package be.ucll.oop.cargo;

public class GekoeldeCargo extends Cargo {
	public static final double GEKOELD_PRIJS = 50;

	@Override
	public double berekenPrijs(int afstand) {
		return GEKOELD_PRIJS * getHoeveelheid() * Math.ceil((double) afstand / 100);
	}
}

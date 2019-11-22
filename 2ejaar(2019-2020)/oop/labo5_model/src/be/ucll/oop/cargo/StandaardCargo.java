package be.ucll.oop.cargo;

public class StandaardCargo extends Cargo {
	public static final double STANDAARD_PRIJS = 30;

	@Override
	public double berekenPrijs(int afstand) {
		return STANDAARD_PRIJS * getHoeveelheid() * Math.ceil((double) afstand / 100);
	}
}

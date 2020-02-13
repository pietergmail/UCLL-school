package be.ucll.oop.personenvervoer;

public class Bus extends PersonenVervoer {
	public static final double BUS_PRIJS = 80;

	@Override
	public double berekenPrijs(int afstand) {
		return BUS_PRIJS * Math.ceil((double) afstand / 100);
	}
}

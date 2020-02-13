package be.ucll.oop.personenvervoer;

public class Limousine extends PersonenVervoer {
	public static final double LIMOUSINE_PRIJS = 150;

	@Override
	public double berekenPrijs(int afstand) {
		return LIMOUSINE_PRIJS * Math.ceil((double) afstand / 100);
	}
}

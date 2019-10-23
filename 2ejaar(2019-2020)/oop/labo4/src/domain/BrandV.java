package domain;

public class BrandV extends Verzekering {
    private static double premie = 0.02;

    public BrandV(String naam, double waarde) {
        super(naam, waarde);
    }

    public static double getPremie() {
        return premie;
    }
}

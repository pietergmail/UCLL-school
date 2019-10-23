package domain;

public class diefstal extends Verzekering{
    private static double premie = 0.04;

    public diefstal(String naam, double waarde) {
        super(naam, waarde);
    }

    public static double getPremie() {
        return premie;
    }
}

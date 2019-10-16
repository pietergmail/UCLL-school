package domain;

import domain.Elektrische_apparaat;

public class Koelkast extends Elektrische_apparaat{
    private double prijs;
    private char energielabel;
    private boolean diepvriezer;


    @Override
    public double prijskwaliteitsverhouding() {
        return 0;
    }
}

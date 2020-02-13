package domain;

import domain.Elektrische_apparaat;

public class Microgolfoven extends Elektrische_apparaat{
    private double prijs;
    private char Energielabel;

    public Microgolfoven(double prijs, char energielabel) {
        super(prijs, energielabel);
    }

    @Override
    public double prijskwaliteitsverhouding() {
        switch (this.getEnergielabel()){
            case 'A':
                return this.getPrijs()/200;
            case 'B':
                return this.getPrijs()/160;
            case 'C':
                return this.getPrijs()/110;
            case 'D':
                return this.getPrijs()/80;
            case 'E':
                return this.getPrijs()/70;
            case 'F':
                return this.getPrijs()/60;
            default:
                throw new IllegalStateException("Unexpected value: " + this.getEnergielabel());
        }
    }
}

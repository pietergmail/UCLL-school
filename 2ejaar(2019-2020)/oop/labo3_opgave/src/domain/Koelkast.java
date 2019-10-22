package domain;

import domain.Elektrische_apparaat;

public class Koelkast extends Elektrische_apparaat{
    private double prijs;
    private char energielabel;
    private boolean diepvriezer;

    public Koelkast(double prijs, char energielabel, boolean diepvriezer) {
        super(prijs, energielabel);
        this.setDiepvriezer(diepvriezer);
    }

    public boolean isDiepvriezer() {
        return diepvriezer;
    }

    public void setDiepvriezer(boolean diepvriezer) {
        this.diepvriezer = diepvriezer;
    }

    @Override
    public double prijskwaliteitsverhouding() {
        switch (this.getEnergielabel()){
            case 'A':
                return this.getPrijs()/300;
            case 'B':
                return this.getPrijs()/230;
            case 'C':
                return this.getPrijs()/180;
            case 'D':
                return this.getPrijs()/150;
            case 'E':
                return this.getPrijs()/130;
            case 'F':
                return this.getPrijs()/100;
            default:
                throw new IllegalStateException("Unexpected value: " + this.getEnergielabel());
        }
    }
}

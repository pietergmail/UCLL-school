package domain;

public abstract class Elektrische_apparaat {
    private double prijs;
    private char energielabel;

    public Elektrische_apparaat(double prijs, char energielabel) {
        this.setPrijs(prijs);
        this.setEnergielabel(energielabel);
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public char getEnergielabel() {
        return energielabel;
    }

    public void setEnergielabel(char energielabel) {
        this.energielabel = energielabel;
    }

    public abstract double prijskwaliteitsverhouding();
}

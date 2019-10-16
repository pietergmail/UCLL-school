package domain;

public abstract class Meubel {
    private double prijs;

    public Meubel(double prijs) {
        this.setPrijs(prijs);
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }
}

package domain;

public abstract class Verzekering {
    private String naam;
    private double waarde;

    public double getWaarde() {
        return waarde;
    }

    public void setWaarde(double waarde) {
        this.waarde = waarde;
    }

    public Verzekering(String naam, double waarde) {
        this.setNaam(naam);
        this.setWaarde(waarde);
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}

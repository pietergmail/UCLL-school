package domain;

public class Varken implements Dier {
    int gewicht;
    boolean geslacht;
    int vlees;

    public Varken(int gewicht, boolean geslacht, int vlees) {
        this.gewicht = gewicht;
        this.geslacht = geslacht;
        this.vlees = vlees;
    }

    public int getGewicht() {
        return gewicht;
    }

    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }

    public boolean isGeslacht() {
        return geslacht;
    }

    public void setGeslacht(boolean geslacht) {
        this.geslacht = geslacht;
    }

    public int getVlees() {
        return vlees;
    }

    public void setVlees(int vlees) {
        this.vlees = vlees;
    }

    @Override
    public String tostring() {
        return null;
    }
}

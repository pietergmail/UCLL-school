package domain;

public class Koe implements Dier {
    int gewicht;
    int melk;

    public Koe(int gewicht, int melk) {
        this.gewicht = gewicht;
        this.melk = melk;
    }

    public int getGewicht() {
        return gewicht;
    }

    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }

    public int getMelk() {
        return melk;
    }

    public void setMelk(int melk) {
        this.melk = melk;
    }

    @Override
    public String tostring() {
        return null;
    }
}

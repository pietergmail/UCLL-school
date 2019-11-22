package domain;

public class kip implements dier {
    int gewicht;
    int eiren;
    int vlees;

    public int getGewicht() {
        return gewicht;
    }

    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }

    public int getEiren() {
        return eiren;
    }

    public void setEiren(int eiren) {
        this.eiren = eiren;
    }

    public int getVlees() {
        return vlees;
    }

    public void setVlees(int vlees) {
        this.vlees = vlees;
    }

    public kip(int gewicht, int eiren, int vlees) {
        this.gewicht = gewicht;
        this.eiren = eiren;
        this.vlees = vlees;
    }

    @Override
    public String tostring() {
        return null;
    }
}

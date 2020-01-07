package domain.cargo;

import domain.*;

import domain.PrijsBerekenbaar;

public abstract class Cargo implements PrijsBerekenbaar {
    private double hoeveelheid;
    private String beschrijving;
    private Vrachtwagen vrachtwagen;

    public Cargo(double hoeveelheid, String beschrijving, Vrachtwagen vrachtwagen) {
        this.hoeveelheid = hoeveelheid;
        this.beschrijving = beschrijving;
        this.vrachtwagen = vrachtwagen;
    }

    public double getHoeveelheid() {
        return hoeveelheid;
    }

    public void setHoeveelheid(double hoeveelheid) {
        this.hoeveelheid = hoeveelheid;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public Vrachtwagen getVrachtwagen() {
        return vrachtwagen;
    }

    public void setVrachtwagen(Vrachtwagen vrachtwagen) throws DomainException{
        vrachtwagen.addCargo(this);
        this.vrachtwagen = vrachtwagen;
    }
}

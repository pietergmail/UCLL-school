package domain;

public class Opslagplaats extends Locatie {
    private String beschrijving;

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public Opslagplaats(String naam, int oppervlakte, String beschrijving) {
        super(naam, oppervlakte);
        this.setBeschrijving(beschrijving);
    }
}

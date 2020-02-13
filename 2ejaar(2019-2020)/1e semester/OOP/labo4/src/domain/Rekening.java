package domain;

public abstract class Rekening {
    private static double rente;
    private String naam;

    public double getRente() {
        return rente;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Rekening(String naam) {
        this.setNaam(naam);
    }

    public Double overzichtrente(){
        return 0.1;//placeholder
    }
}

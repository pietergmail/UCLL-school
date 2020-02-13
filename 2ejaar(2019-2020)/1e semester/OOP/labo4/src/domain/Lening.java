package domain;

public abstract class Lening {
    private String naam;
    private static double interest;
    private double bedrag;
    private double duur;

    public double getDuur() {
        return duur;
    }

    public void setDuur(double duur) {
        if (duur > 5) throw new IllegalArgumentException("De duur van de lening moet minstens 5 jaar zijn.");
        this.duur = duur;
    }

    public Lening(String naam, double bedrag, double duur){
        this.setNaam(naam);
        this.setBedrag(bedrag);
        this.setDuur(duur);
    }

    public String getNaam(){
        return naam;
    }

    public double getBedrag() {
        return bedrag;
    }

    public void setBedrag(double bedrag) {
        if (bedrag < 5000) throw new IllegalArgumentException("Een lening moet minstens 5000 euro zijn");
        this.bedrag = bedrag;
    }

    public void setNaam(String naam){
        this.naam = naam;
    }
}

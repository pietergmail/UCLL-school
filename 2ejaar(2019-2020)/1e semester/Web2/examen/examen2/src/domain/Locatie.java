package domain;

public abstract class Locatie {
    private String naam;
    private int oppervlakte;

    public Locatie(String naam, int oppervlakte){
        this.naam = naam;
        this.oppervlakte = oppervlakte;
    }

    public String getNaam(){return naam;}

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getOppervlakte() {
        return oppervlakte;
    }

    public void setOppervlakte(int oppervlakte) {
        this.oppervlakte = oppervlakte;
    }
}

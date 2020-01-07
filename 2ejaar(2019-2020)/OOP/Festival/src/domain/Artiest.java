package domain;

public class Artiest implements TeBetalen{

    private String naam;
    private double prijs;

    public Artiest(String naam, double prijs){
        this.setNaam(naam);
        this.setPrijs(prijs);
    }

    private void setNaam(String naam) {
        this.naam = naam;
    }
    private void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public String getNaam() {
        return this.naam;
    }
    @Override
    public double getLoon() {
        return this.prijs;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj instanceof Artiest){
            Artiest artiest = (Artiest) obj;
            if(artiest.getNaam().equals(this.getNaam())) {
                return true;
            }
        }
        return false;
    }
}

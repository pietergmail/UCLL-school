package domain;
import domain.Bestemming;
public class Reis {
    private Bestemming bestemming;
    private int personen;
    private int dagen;
    private int prijs;

    public Reis(Bestemming bestemming, int personen, int dagen, int prijs) {
        setBestemming(bestemming);
        setPersonen(personen);
        setDagen(dagen);
        setPrijs(prijs);
    }

    public int getPrijs() {
        return prijs;
    }

    public void setPrijs(int prijs) {
        this.prijs = prijs;
    }

    public Bestemming getBestemming() {
        return bestemming;
    }

    public void setBestemming(Bestemming bestemming) {
        this.bestemming = bestemming;
    }

    public int getPersonen() {
        return personen;
    }

    public void setPersonen(int personen) {
        this.personen = personen;
    }

    public int getDagen() {
        return dagen;
    }

    public void setDagen(int dagen) {
        this.dagen = dagen;
    }

    public String toString(){
        return "placeholder";
    }
}

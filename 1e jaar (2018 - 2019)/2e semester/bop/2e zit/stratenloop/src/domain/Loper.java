package domain;
import domain.Tijdstip;

public class Loper {
    String naam;
    String voornaam;
    Tijdstip startijd;
    Tijdstip eindtijd;
    int kilometers;

    public Loper(String naam, String voornaam, int kilometers) {
        this.naam = naam;
        this.voornaam = voornaam;
        this.kilometers = kilometers;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        if(naam == null){ throw new IllegalArgumentException("Naam mag niet leeg zijn.");}
        this.naam = naam;
    }

    public String getVoornaam() {
         return voornaam;
    }

    public void setVoornaam(String voornaam) {
        if(naam == null){throw new IllegalArgumentException("Voornaam mag niet leeg zijn.");}
        this.voornaam = voornaam;
    }

    public Tijdstip getStartijd() {
        return startijd;
    }

    public void start(Tijdstip startijd) {
        if (this.startijd == null){this.startijd = startijd;}
    }

    public Tijdstip getEindtijd() {
        return eindtijd;
    }

    public void finish(Tijdstip eindtijd) {
        if (this.startijd == null && this.eindtijd != null){
            throw new IllegalArgumentException("Er is nog geen starttijd of de eindtijd is al bepaald");
        }
        this.eindtijd = eindtijd;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        if(kilometers < 0){throw new IllegalArgumentException("De afstand kan niet negatief zijn.");}
        this.kilometers = kilometers;
    }

    public boolean isalgestard(){
        return this.startijd != null;
    }

    public boolean isalaangekomen(){
        return this.eindtijd != null;
    }

    public int looptijd(){
        return this.getStartijd().verschil(this.getEindtijd()).getSec() + this.getStartijd().verschil(this.getEindtijd()).getMin()
                + this.getStartijd().verschil(this.getEindtijd()).getHours();
    }

    public boolean isSneller(Loper loper){
        return this.looptijd() < loper.looptijd();
    }

}

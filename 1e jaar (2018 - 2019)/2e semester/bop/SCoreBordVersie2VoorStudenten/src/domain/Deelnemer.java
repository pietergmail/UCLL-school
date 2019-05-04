package domain;

public class Deelnemer {
    private String naam, voornaam;

    public void setVoornaam(String voornaam) {
        if (voornaam != null) {this.voornaam = voornaam;}
        else throw new IllegalArgumentException("voornaam mag niet leeg zijn.");
    }

    public void setNaam(String naam) {
        if (naam != null) {this.naam = naam;}
        else throw new IllegalArgumentException("naam mag niet leeg zijn.");
    }

    public Deelnemer(String voornaam, String naam){
        // TO DO
        // naam en voornaam mogen niet leeg zijn
        setNaam(naam);
        setVoornaam(voornaam);
    }

    public String geefStringVorm(){
        return this.naam + " " + this.voornaam;
    }
}

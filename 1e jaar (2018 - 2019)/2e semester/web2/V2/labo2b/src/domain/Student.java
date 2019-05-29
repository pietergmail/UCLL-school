package domain;

public class Student {
    private String naam, voornaam;
    private String richting;
    private int leeftijd;


    public Student(String naam, String voornaam, String richting, int leeftijd){
        setLeeftijd(leeftijd);
        setNaam(naam);
        setVoornaam(voornaam);
        setRichting(richting);
    }

    public static boolean isValidString(String input){
        return (input != null) && !(input.trim().isEmpty());
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getRichting() {
        return richting;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public String getNaam() {
        return naam;
    }

    public void setLeeftijd(int leeftijd) {
        this.leeftijd = leeftijd;
    }

    public void setRichting(String richting) {
        this.richting = richting;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}

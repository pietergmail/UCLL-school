package domain.model;

public class Student {
    private String naam, voornaam;
    private String studierichting;
    private int leeftijd;

    public Student(String naam, String voornaam, String studierichting, int leeftijd) {
        setNaam(naam);
        setVoornaam(voornaam);
        setStudierichting(studierichting);
        setLeeftijd(leeftijd);
    }

    public static boolean isValidString(String input) {
        return (input != null) && !(input.trim().isEmpty());
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        if (isValidString(naam))
            this.naam = naam;
        else throw new IllegalArgumentException("No valid name");
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        if (isValidString(voornaam))
            this.voornaam = voornaam;
        else throw new IllegalArgumentException("No valid first name");
    }

    public String getStudierichting() {
        return studierichting;
    }

    public void setStudierichting(String studierichting) {
        if (isValidString(studierichting))
            this.studierichting = studierichting;
        else throw new IllegalArgumentException("No valid studierichting");
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public static boolean isValidLeeftijd(int leeftijd) {
        return leeftijd > 0;
    }

    public void setLeeftijd(int leeftijd) {
        if (isValidLeeftijd(leeftijd))
            this.leeftijd = leeftijd;
        else throw new IllegalArgumentException("No valid leeftijd");
    }
}

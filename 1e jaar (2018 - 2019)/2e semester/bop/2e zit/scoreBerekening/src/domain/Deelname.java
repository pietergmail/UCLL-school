package domain;

/**
 * De klasse deelname individueel de antwoorden van een student bij
 * en laat toe deze te bewerken of op te bragen
 *
 * @author herre
 * @version 1.0
 */

public class Deelname {
    private String studentNaam;
    private String studentNummer;
    private String[] antwoorden;

    /**
     * Deze methode declareert het Deelname object
     * @param studentNaam naam van de student die deelneemt
     * @param studentNummer Studentenummer van de student die deelneemt
     * @param pantwoorden Hoeveel antwoorden de student heeft
     */
    public Deelname(String studentNaam, String studentNummer, int pantwoorden) {
        this.studentNaam = studentNaam;
        this.studentNummer = studentNummer;
        antwoorden = new String[pantwoorden];
    }

    /**
     * Geeft de naam terug van een student
     * @return de naam van de student
     */

    public String getStudentNaam() {
        return studentNaam;
    }

    public String getStudentNummer() {
        return studentNummer;
    }

    public String[] getAntwoorden() {
        return antwoorden;
    }

    public void setStudentNaam(String studentNaam) {
        this.studentNaam = studentNaam;
    }

    public void setStudentNummer(String studentNummer) {
        if(studentNummer.charAt(0) != 'r'|| studentNummer.charAt(0) != 'R') throw new IllegalArgumentException("Het studentenummer moet beginnen met r.");
        this.studentNummer = studentNummer;
    }

    /**
     * Zet het antwoord op een bepaalde plaats in de antwoorden array
     * @param pantwoorden de locatie in de array waar het antwoord komt
     * @param antwoord Het antwoord op de vraag
     */
    public void setAntwoorden(int pantwoorden, String antwoord) {
        antwoorden[pantwoorden] = antwoord;
    }
}

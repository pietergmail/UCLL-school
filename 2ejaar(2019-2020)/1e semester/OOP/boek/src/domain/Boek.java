package domain;

/**
 * Klasse die informatie over een boek bijhoudt
 * @author Pieter Herremans
 * @version 1.0.0
 * @since 1.0.0
 */

public class Boek {
    int bladzijden;
    String auteur;
    String ISBN;

    /**
     * Maakt een nieuw boek aan met bladzijden, auteur en ISBN nummer
     * @param bladzijden aantal bladzijden van het boek
     * @param auteur auteur van het boek
     * @param ISBN ISBN nummer van het boek
     * @since 1.0.0
     */
    public Boek(int bladzijden, String auteur, String ISBN) {
        this.setBladzijden(bladzijden);
        this.setAuteur(auteur);
        this.setISBN(ISBN);
    }

    /**
     * Maakt een nieuw boek aan zoner het aantal bladzijden te specifieeren
     * @param auteur auteur van het boek
     * @param ISBN ISBN nummer van het boek
     * @since 1.0.0
     */

    public Boek(String auteur, String ISBN) {
        this.setAuteur(auteur);
        this.setISBN(ISBN);
    }

    public int getBladzijden() {
        return bladzijden;
    }

    /**
     * Zet het aantal bladzijden van het boek juist.
     * Kijkt ook of dit aantal niet negatief is, want een boek kan geen negatieve bladzijden hebben.
     * @param bladzijden aantal bladzijden van het boek.
     * @since 1.0.0
     */
    public void setBladzijden(int bladzijden) {
        if (this.bladzijden < 0){
            throw new IllegalArgumentException("Bladzijden mag niet negatief zijn.");
        }else {
            this.bladzijden = bladzijden;
        }
    }

    public String getAuteur() {
        return auteur;
    }

    /**
     * Zet de auteur van het boek juist.
     * @param auteur auteur van het boek.
     * @since 1.0.0
     */
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getISBN() {
        return ISBN;
    }

    /**
     * Zet het ISBN nummer van het boek juist.
     * @param ISBN ISBN nummer van het boel.
     * @since 1.0.0
     */

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String geefinfo(){
        return "Autheur:" + this.getAuteur() + " pagina's: " + this.getBladzijden() + " ISBN-nummer: " +
    }
}

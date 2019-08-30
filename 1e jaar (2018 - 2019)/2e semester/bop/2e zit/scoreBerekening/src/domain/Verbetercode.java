package domain;

/**
 *De verbetercode houdt de juiste antwoorden bij en laat toe ze vergelijken met de antwoorden van deelnemers
 * @version 1.0
 * @author herre
 */
public class Verbetercode {
    String juisteAntwoord;
    int aantalPuntenJuist;
    double aantalPuntenFout;

    public Verbetercode(String juisteAntwoord, int aantalPuntenJuist, double aantalPuntenFout) {
        if (aantalPuntenFout > 0) throw  new IllegalArgumentException("Het aantal punten moet minder dan 0 zijn.");
        this.aantalPuntenFout = aantalPuntenFout;
        setAantalPuntenJuist(aantalPuntenJuist);
        setJuisteAntwoord(juisteAntwoord);
    }

    public Verbetercode(String juisteAntwoord) {
        this.juisteAntwoord = juisteAntwoord;
    }

    public String getJuisteAntwoord() {
       return juisteAntwoord;
    }

    public void setJuisteAntwoord(String juisteAntwoord) {
        if (juisteAntwoord.isEmpty()) throw  new IllegalArgumentException("Juiste antwoord mag niet leeg zijn.");
        this.juisteAntwoord = juisteAntwoord;
    }

    public void setAantalPuntenJuist(int aantalPuntenJuist) {
        if (aantalPuntenJuist < 1) throw new IllegalArgumentException("Het aantal punten mag niet minder dan 1 zijn.");
        this.aantalPuntenJuist = aantalPuntenJuist;
    }

    public int getAantalPuntenJuist() {
        return aantalPuntenJuist;
    }

    public double getAantalPuntenFout() {
        return aantalPuntenFout;
    }

    /**
     * checkt of het antwood juist is.
     * @param antwoord Het antwoord.
     * @return returnd of het antwoord juist of fout is
     */

    public boolean isJuisteAntwoord(String antwoord){
        return antwoord.equals(juisteAntwoord);
    }
}

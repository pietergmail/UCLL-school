package be.ucll.oop;

public class Schip {
    private String code;
    private int maximumPassagiers;
    private String naam;
    private Haven haven;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getMaximumPassagiers() {
        return maximumPassagiers;
    }

    public void setMaximumPassagiers(int maximumPassagiers) {
        this.maximumPassagiers = maximumPassagiers;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Haven getHaven() {
        return haven;
    }

    public void setHaven(Haven haven) {
        this.haven = haven;
    }
}

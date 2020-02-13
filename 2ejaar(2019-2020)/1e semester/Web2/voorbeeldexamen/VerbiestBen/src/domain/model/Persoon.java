package domain.model;

public class Persoon {
    private String naam;
    private double bedrag;
    private double hoogte;

    public Persoon(String naam, double bedrag, double hoogte) {
        if (naam.trim().isEmpty() || naam == null) {
            throw new IllegalArgumentException("Vul een naam in om verder te gaan.");
        }
        setNaam(naam);
        if (bedrag < 0) {
            throw new IllegalArgumentException("Ongeldige waarde voor het bedrag.");
        }
        setBedrag(bedrag);
        if (hoogte >= 0 && hoogte <= 1000) {
            setHoogte(hoogte);
        }
    }

    public Persoon(String naam) {
        if (naam.trim().isEmpty() || naam == null) {
            throw new IllegalArgumentException("Vul een naam in om verder te gaan.");
        }
        setNaam(naam);
        setBedrag(0);
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setBedrag(double bedrag) {
        this.bedrag = bedrag;
    }

    public void setHoogte(double hoogte) {
        this.hoogte = hoogte;
    }

    public String getNaam() {
        return naam;
    }

    public double getBedrag() {
        return bedrag;
    }

    public double getHoogte() {
        return hoogte;
    }

    public void verhoogBedrag(double bedrag) {
        if (bedrag <= 0) {
            throw new IllegalArgumentException("Je kan je bedrag enkel verhogen.");
        }
        this.bedrag += bedrag;
    }
}

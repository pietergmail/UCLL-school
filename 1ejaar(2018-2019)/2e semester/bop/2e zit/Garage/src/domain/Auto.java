package domain;

public class Auto {
    String type;
    String kleur;
    double prijs;

    public Auto(String type, String kleur, double prijs) {
        this.type = type;
        this.kleur = kleur;
        this.prijs = prijs;
    }

    public String getType() {
        return type;
    }

    private void setType(String type) {
        if(type.equals("BMW") || type.equals("Audi") || type.equals("Mercedes")) {
            this.type = type;
        }else{
            throw new IllegalArgumentException("Dit type van Auto bestaat niet");
        }

    }

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        if(kleur.equals("zwart") || kleur.equals("wit") || kleur.equals("rood") || kleur.equals("zilver") || kleur.equals("blauw")) {
            this.kleur = kleur;
        }else{
            throw new IllegalArgumentException("Dit type van Auto bestaat niet");
        }
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        if (prijs >= 25000){
            this.prijs = prijs;
        }else{
            throw new IllegalArgumentException("de prijs moet minstens 25000 euro zijn.");
        }
    }
}

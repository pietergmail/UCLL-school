package domain;

public class Patient {
    String naam;
    double gewicht;
    double lengte;

    public void setLengte(double lengte) {
        this.lengte = lengte;
    }

    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public double getLengte() {
        return lengte;
    }

    public double getGewicht() {
        return gewicht;
    }

    public String getNaam() {
        return naam;
    }

    public Patient(String pnaam, double pgewicht, double plengte){
        setGewicht(pgewicht);
        setLengte(plengte);
        setNaam(pnaam);
    }

    public double berekenBMI(){
        return gewicht/(lengte*lengte);
    }

    public String BMIafgerond(){
        double temp = Math.round(berekenBMI()*10);
        return "" + temp/10;
    }

    public String printPatient(){
        return naam + " | gewicht: " + gewicht + "kg | lengte: "
                + lengte + "m | BMI: " + BMIafgerond();
    }

}

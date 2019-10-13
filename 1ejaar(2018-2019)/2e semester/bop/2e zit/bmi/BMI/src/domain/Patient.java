package domain;

public class Patient {

    String naam;
    double gewicht;
    double lengte;

    public Patient(String naamPatient, double gewichtPatient, double lengtePatient){
        naam = naamPatient;
        gewicht = gewichtPatient;
        lengte = lengtePatient;
    }

    public double berekenBMI(){
        return  gewicht / (lengte*lengte);
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

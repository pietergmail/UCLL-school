package domain;

import domain.Patient;

public class Praktijk {

    Patient p1, p2, p3;

    public Praktijk(Patient patient1, Patient patient2, Patient patient3){
        p1 = patient1;
        p2 = patient2;
        p3 = patient3;
    }

    public double berekenGemiddeleBMI(){
        return (p1.berekenBMI() + p2.berekenBMI() + p3.berekenBMI() ) / 3;
    }

    public String gemiddeldeBMIafgerond(){
        double temp = Math.round(berekenGemiddeleBMI()*10);
        return "" + (temp/10);
    }

    public int aantalPatientenMetOvergewicht(){
        int aantal = 0;
        if (p1.berekenBMI() >= 30) aantal++;
        if (p2.berekenBMI() >= 30) aantal++;
        if (p3.berekenBMI() >= 30) aantal++;

        return aantal;
    }

    public String printPatienten(){
        return "\t- " + p1.printPatient() + "\n"
                + "\t- " + p2.printPatient() + "\n"
                + "\t- " + p3.printPatient();
    }

    public String printPraktijk(){
        return "De patienten van de praktijk zijn:\n"
                    + printPatienten() + "\n"
                + "Het gemiddelde BMI is " + gemiddeldeBMIafgerond() + "\n"
                + "Aantal patienten met overgewicht: "
                    + aantalPatientenMetOvergewicht();
    }
}

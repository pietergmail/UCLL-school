package domain;

import domain.Patient;

public class praktijk {
    Patient p1;
    Patient p2;
    Patient p3;


    public void setP3(Patient p3) {
        this.p3 = p3;
    }

    public void setP2(Patient p2) {
        this.p2 = p2;
    }

    public void setP1(Patient p1) {
        this.p1 = p1;
    }

    public Patient getP3() {
        return p3;
    }

    public Patient getP2() {
        return p2;
    }

    public Patient getP1() {
        return p1;
    }

    public praktijk(Patient patient1, Patient patient2, Patient patient3) {
        setP1(patient1);
        setP2(patient2);
        setP3(patient3);
    }

    public double gemBMI(){
        return (p1.berekenBMI() + p2.berekenBMI() + p3.berekenBMI() ) / 3;
    }
}

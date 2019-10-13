package ui;

import domain.Patient;
import domain.praktijk;

public class PraktijkApp {

    public static void main(String[] args){

        Patient jos = new Patient("Jos", 108,1.80);
        Patient jef = new Patient("Jef", 80, 1.60);
        Patient maria = new Patient("Maria", 65, 1.68);

        praktijk mijnPraktijk = new praktijk(jos, jef, maria);

        System.out.println(mijnPraktijk.gemBMI());
    }
}

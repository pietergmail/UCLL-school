package domain;

import java.time.LocalDate;
import java.time.Period;

public class Persoon {
    private String naam;
    private int age;
    private String Instrument;

    public Persoon(String naam, int age, String instrument) {
        this.setNaam(naam);
        this.setAge(age);
        this.setInstrument(instrument);
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        age = age;
    }

    public String getInstrument() {
        return Instrument;
    }

    public void setInstrument(String instrument) {
        Instrument = instrument;
    }

}

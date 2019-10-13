package domain;

import java.time.LocalDate;
import java.time.Period;

public class Persoon {
    private String naam;
    private LocalDate Geboortedatum;
    private String Instrument;
    private boolean Geslacht;

    public Persoon(String naam, int year, int month, int days, String instrument, boolean geslacht) {
        this.setNaam(naam);
        this.setGeboortedatum(year, month, days);
        this.setInstrument(instrument);
        this.setGeslacht(geslacht);
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public LocalDate getGeboortedatum() {
        return Geboortedatum;
    }

    public void setGeboortedatum(int year, int month, int days) {
        Geboortedatum = LocalDate.of(year, month, days);
    }

    public String getInstrument() {
        return Instrument;
    }

    public void setInstrument(String instrument) {
        Instrument = instrument;
    }

    public boolean isGeslacht() {
        return Geslacht;
    }

    public void setGeslacht(boolean geslacht) {
        Geslacht = geslacht;
    }

    public Integer getAge(){
        return Period.between(this.getGeboortedatum(), LocalDate.now()).getDays();
    }

    public boolean getgeslacht(){
        return this.Geslacht;
    }

    public String getStringgeslacht(){
        if (this.getgeslacht()){
            return "Man";
        }else{
            return "Vrouw";
        }
    }
}

package domain;

public class Persoon {
    private String naam;
    private int age;
    private String Instrument;

    public Persoon(String naam, int age, String instrument) {
        this.setNaam(naam);
        this.setAge(age);
        this.setInstrument(instrument);
    }

    public Persoon(String naam, String instrument){
        this.setNaam(naam);
        this.setInstrument(instrument);
        this.setAge(0);
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

    public String sAge(){
        return Integer.toString(this.getAge());
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getInstrument() {
        return Instrument;
    }

    public void setInstrument(String instrument) {
        Instrument = instrument;
    }

}

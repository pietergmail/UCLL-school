package domain;

public class vak {

    String naam;
    int studiePunten;

    public vak(String naamVak, int studiePuntenVak) {
        naam = naamVak;
        studiePunten = studiePuntenVak;
    }

    public int BerekenweekUren(){
        return studiePunten * 25/16;
    }
}

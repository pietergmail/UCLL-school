package domain.PersonenVervoer;

import domain.PrijsBerekenbaar;

public abstract class PersonenVervoer implements PrijsBerekenbaar {
    private int aantalPersonen;

    public int getAantalPersonen(){return aantalPersonen;}

    public void setAantalPersonen(int aantalPersonen){this.aantalPersonen = aantalPersonen;}
}

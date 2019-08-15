package domain;
import domain.Loper;
import java.util.ArrayList;

public class Stratenloop {
    private String naam;
    private int[] route;
    private ArrayList<Loper> lopers = new ArrayList<>();

    public Stratenloop(String naam) {
        this.naam = naam;
    }

    public Stratenloop(String naam, int proutes) {
        this.naam = naam;
        setRoutes(proutes);
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int[] getRoutes() {
        return route;
    }

    private void setRoutes(int proutes) {
        route = new int[proutes];
    }

    public ArrayList<Loper> getLopers() {
        return lopers;
    }

    public void setLopers(ArrayList<Loper> lopers) {
        this.lopers = lopers;
    }

    public void setAantalKilometer(int waarde){
         route[route.length] = waarde;
    }

    public void voegLoperToe(Loper loper){
        lopers.add(loper);
    }

    public String printLopersGefinished(){

    }
}

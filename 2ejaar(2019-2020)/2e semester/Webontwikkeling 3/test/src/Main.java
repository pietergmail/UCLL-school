import domain.*;

public class Main {

    public static void main(String[] args) {
        Radio radio = new Radio(12);
        CD cd = new CD();
        Movie movie = new Movie();

        System.out.println(radio.play());
        System.out.println(cd.play());
        System.out.println(movie.play());
    }
}

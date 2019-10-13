package ui;

import domain.car;
import domain.Garage;
public class carapp {

    public static void main(String[] args){
        car car1 = new car("car1", 1);
        car car2 = new car("car2", 2);

        Garage gar1 = new Garage("garage", 5, car1, car2);

        gar1.work(5, car1);
        gar1.work(4, car2);

        System.out.println(gar1.income(car1));
        System.out.println(gar1.income(car2));
    }
}

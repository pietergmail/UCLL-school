package domain;

import domain.car;

public class Garage {
    String name;
    int Price;
    car car1;
    car car2;

    public void setCar2(car car2) {
        this.car2 = car2;
    }

    public void setCar1(car car1) {
        this.car1 = car1;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public car getCar2() {
        return car2;
    }

    public car getCar1() {
        return car1;
    }

    public int getPrice() {
        return Price;
    }

    public String getName() {
        return name;
    }

    public Garage(String pname, int pprice, car pcar1, car pcar2) {
        setName(pname);
        setPrice(pprice);
        setCar1(pcar1);
        setCar2(pcar2);
    }

    public void work(int hours, car Car){
        Car.work(hours);
    }

    public int income(car Car){
        return Car.getHours() * this.getPrice();
    }
}

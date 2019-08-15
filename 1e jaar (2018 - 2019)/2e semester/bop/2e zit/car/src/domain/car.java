package domain;

public class car {
    String name;
    int number;
    int hours;

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public car(String pname, int pnumber) {
        setName(pname);
        setNumber(pnumber);
        setHours(0);
    }

    public void work(int time){
        hours += time;
    }
}

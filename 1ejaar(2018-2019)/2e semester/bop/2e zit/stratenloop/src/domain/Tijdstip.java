package domain;

public class Tijdstip {
    int min;
    int sec;
    int hours;

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public Tijdstip() {
        setMin(0);
        setHours(0);
        setSec(0);
    }

    public Tijdstip(int hours) {
        this.hours = hours;
    }

    public Tijdstip(int min, int hours) {
        this.min = min;
        this.hours = hours;
    }

    public Tijdstip(int min, int sec, int hours) {
        this.min = min;
        this.sec = sec;
        this.hours = hours;
    }

    public Tijdstip add(Tijdstip t){
        this.min += t.min;
        this.hours += t.hours;
        this.sec += t.sec;
        return this;
    }

    public boolean isMinder(Tijdstip t){
        if (this.getHours() < t.getHours()){
            return true;
        }else if(this.getMin() < t.getMin()){
            return true;
        }else return this.getSec() < t.getSec();
    }

    public String tostring(){
        return String.format("%02d", this.getHours()) + ":" + String.format("%02d", this.getMin()) + ":" + String.format("%02d", this.getSec());
    }

    public Tijdstip verschil(Tijdstip anderTijdstip){
        int hours = this.getHours() - anderTijdstip.getHours();
        int minutes = this.getMin() - anderTijdstip.getMin();
        int seconds = this.getSec() - anderTijdstip.getSec();
        return new Tijdstip(hours, minutes, seconds);
    }

}

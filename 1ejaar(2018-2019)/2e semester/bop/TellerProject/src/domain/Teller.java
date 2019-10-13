package domain;

public class Teller {
    private int waarde;

    public Teller(){

    }

    public void add(){
        this.waarde++;
    }

    public void add(int w){
        this.waarde+=w;
    }

    public void reset(){
        this.waarde = 0;
    }

    public int getWaarde() {
        return waarde;
    }
}

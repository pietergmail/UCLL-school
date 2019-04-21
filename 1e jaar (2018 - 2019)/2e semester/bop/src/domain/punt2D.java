package domain;

public class punt2D {
    public int x;
    public int y;


    public punt2D(){
        setX(0);
        setY(0);
    }
    public punt2D(int x, int y){
        setX(x);
        setY(y);
    }

    public void movehorizontal(int move){
           setX(x + move);
    }

    public void movevertical(int move){
        setX(y + move);
    }

    public boolean ligt_lings(int px) {
        return(px > x);
    }

    public boolean ligt_rechts(int px) {
        return(px < x);
    }

    public boolean hoger(int py){
        return(py > y);
    }

    public boolean lager(int py){
        return(py < y);
    }

    public boolean zelfde(int px, int py){
        return(px == x && py == y);
    }

    public String info(){
        return ("(" + x + ", " + y + ")");
    }

    private void setX(int x) {
        if (x < 0) {throw new IllegalArgumentException("X mag niet kleiner zijn dan nul.");}
        this.x = x;
    }

    private void setY(int y) {
        if (y < 0) {throw new IllegalArgumentException("Y mag niet kleiner zijn dan nul.");}
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}

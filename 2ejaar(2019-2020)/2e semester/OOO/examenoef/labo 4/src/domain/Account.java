package domain;

public class Account {
    private int index;
    private double saldo;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Account(int index, double saldo){
        this.index = index;
        this.saldo = saldo;
    }
    @Override
    public String toString(){
        return this.index + " " + this.saldo;
    }

    protected void storten(double saldo){
        if (saldo < 1){
            System.out.println("saldo moet hoger zijn dan 0.");
        }else{
            this.saldo += saldo;
        }
    }

    protected void afhalen(double saldo) {
        if (saldo < 1) {
            System.out.println("saldo moet hoger zijn dan 0");
        }else{
            this.saldo-=saldo;
        }
    }
}

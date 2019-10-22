package domain;

public abstract class wagen {
    private int bereik;

    public wagen(int bereik) {
        this.setBereik(bereik);
    }

    public void setBereik(int bereik) {
        this.bereik = bereik;
    }

    public int getBereik(){
        return this.bereik;
    }

}

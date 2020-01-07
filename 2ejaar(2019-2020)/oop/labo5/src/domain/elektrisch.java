package domain;

public class elektrisch implements wagen{
    private int brandstof;
    private int vervuiling;
    int bereik;

    public int getBrandstof() {
        return brandstof;
    }

    public void setBrandstof(int brandstof) {
        this.brandstof = brandstof;
    }

    public int getVervuiling() {
        return vervuiling;
    }

    public void setVervuiling(int vervuiling) {
        this.vervuiling = vervuiling;
    }

    public elektrisch(int bereik, int vervuiling, int brand){
        this.setVervuiling(vervuiling);
        this.setBrandstof(brandstof);
    }

    @Override
    public int getBereik() {
        return 0;
    }

    @Override
    public void setBereik(int age) {
        this.bereik = bereik;
    }
}

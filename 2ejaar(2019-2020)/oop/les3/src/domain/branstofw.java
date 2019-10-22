package domain;

public class branstofw extends wagen{
    private int brandstof;
    private int vervuiling;

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

    public branstofw(int bereik, int vervuiling, int brand){
        super(bereik);
        this.setVervuiling(vervuiling);
        this.setBrandstof(brandstof);
    }
}

package domain;

import java.util.concurrent.ThreadLocalRandom;

public class Kaart {
    private String soort;
    private int nummer;

    public Kaart(){
        nummer = ThreadLocalRandom.current().nextInt(1, 10+1);
        int soortnum = ThreadLocalRandom.current().nextInt(1, 4+1);
        switch(soortnum){
            case 1: {soort = "harten";}
            case 2: {soort = "klaveren";}
            case 3: {soort = "schoppen";}
            case 4: {soort = "koeken";}
        }
    }

    private void setNummer(int nummer) {
        if(nummer >= 1 && nummer <= 10)
            this.nummer = nummer;
        else
            throw new IllegalArgumentException("ongeldig nummer");
    }

    private void setSoort(String soort) {
        if (soort != "harten" || soort != "klaveren" || soort != "schoppen" || soort != "koeken"){
            throw new IllegalArgumentException("ongeldige soort van kaart");
        }else {
            this.soort = soort;
        }
    }

    private String getSoort() {
        return soort;
    }

    private int getNummer() {
        return nummer;
    }

    public Kaart(String psoort, int pnummer){
        setNummer(pnummer);
        setSoort(psoort);
    }

    public boolean heeftZelfdeType(Kaart pkaart){
        return this.getSoort().equals(pkaart.getSoort());
    }

    public boolean heeftZelfdeNummer(Kaart pkaart){
        return this.getSoort().equals(pkaart.getSoort());
    }

    public boolean isZelfde(Kaart pkaart){
        return (heeftZelfdeNummer(pkaart) && heeftZelfdeType(pkaart));
    }

    public String geefInfo(){
        return "deze kaart is van de soort " + this.getSoort() + " en heeft het nummer "
                + this.getNummer() + ".";
    }
}

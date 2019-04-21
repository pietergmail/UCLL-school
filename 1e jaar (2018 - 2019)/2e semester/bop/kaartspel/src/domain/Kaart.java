package domain;
import java.util.concurrent.ThreadLocalRandom;

public class Kaart{
    private String soort;
    private int nummer;

    public Kaart(){
        nummer = ThreadLocalRandom.current().nextInt(1, 10 + 1);
        int soortnum = ThreadLocalRandom.current().nextInt(1, 4 + 1);
        switch (soortnum){
            case 1: {soort = "harten";}
            case 2: {soort = "klaveren";}
            case 3: {soort = "schoppen";}
            case 4: {soort = "koeken";}
        }
    }

    public Kaart(String psoort, int pnummer){
        soort = psoort;
        nummer = pnummer;
    }

    public String getSoort() {
        return soort;
    }

    public int getNummer(){
        return nummer;
    }

    public boolean heeftZelfdeType(String Kaart1){
        return (kaart1 .equals kaart2);
    }

    public boolean heeftZelfdeNummer(){
        return (kaart1 == kaart2);
    }

    public boolean isZelfde(int )
}
package domain;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Lening> leningen = new ArrayList<>();
    private List<Rekening> rekeningen = new ArrayList<>();
    private List<Verzekering> verzekeringen = new ArrayList<>();

    public void addLening(Lening lening){
        leningen.add(lening);
    }

    public void addrekening(Rekening rekening){
        rekeningen.add(rekening);
    }

    public void addverzekering(Verzekering verzekering){
        verzekeringen.add(verzekering);
    }
}

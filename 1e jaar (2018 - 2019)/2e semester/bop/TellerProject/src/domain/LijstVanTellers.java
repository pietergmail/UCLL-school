package domain;

import java.util.ArrayList;
import java.util.List;

public class LijstVanTellers {

private List<Teller> tellers ;

    public LijstVanTellers() {
        this.tellers = new ArrayList<>();
    }

    public void voegTellerToe(Teller t){
        if (t != null)
            this.tellers.add(t);
    }

    public Teller getTeller(int i){
        if (i >= 0 && i < this.tellers.size())
            return this.tellers.get(i);
        else return null;
    }

    public void  resetAll(){
        for(Teller t: this.tellers) t.reset();
    }
}

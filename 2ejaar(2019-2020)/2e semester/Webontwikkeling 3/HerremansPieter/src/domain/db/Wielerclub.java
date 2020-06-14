package domain.db;

import domain.model.Niveaugroep;
import domain.model.Lid;

import java.util.List;
import java.util.Properties;

public class Wielerclub {
    private LedenDB ledenDB;
    private NiveaugroepenDB niveaugroepenDB;

    public Wielerclub(Properties properties) {
        ledenDB = new LedenDBSQL(properties);
        niveaugroepenDB = new NiveaugroepenDBSQL(properties);
    }

    public LedenDB getLedenDB() {
        return ledenDB;
    }

    public NiveaugroepenDB getNiveaugroepenDB() {
        return niveaugroepenDB;
    }

    public Lid geefPersoon(String email) {
        return getLedenDB().geefLid(email);
    }

    public Niveaugroep geefNiveaugroep(String naam) {
        return getNiveaugroepenDB().geefNiveaugroep(naam);
    }

    public List<Lid> geefAlleLeden() {
        return getLedenDB().geefAlleLeden();
    }

    public List<Niveaugroep> geefAlleNiveaugroepen() {
        return getNiveaugroepenDB().geefAlleNiveaugroepen();
    }
}

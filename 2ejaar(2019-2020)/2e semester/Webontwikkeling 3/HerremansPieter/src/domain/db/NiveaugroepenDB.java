package domain.db;

import domain.model.Niveaugroep;

import java.util.List;

public interface NiveaugroepenDB {
    Niveaugroep geefNiveaugroep(String naam);

    List<Niveaugroep> geefAlleNiveaugroepen();
}

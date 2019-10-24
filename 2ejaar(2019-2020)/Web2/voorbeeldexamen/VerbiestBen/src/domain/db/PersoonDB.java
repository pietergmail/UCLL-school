package domain.db;

import domain.model.Persoon;

import java.util.ArrayList;

public class PersoonDB {
    private ArrayList<Persoon> personen = new ArrayList<>();
    //private PersoonDB mensen = new PersoonDB();

    public PersoonDB() {
        this.addPersoon(new Persoon("Tomas More", 24.95, 15));
        this.addPersoon(new Persoon("marco Polo", 6.50, 200));
        this.addPersoon(new Persoon("Johnny Bravo", 0 , 950));
    }

    public ArrayList<Persoon> personenlijst() {
        return personen;
    }

    public void addPersoon(Persoon persoon) {
        if (persoon != null) {
            personen.add(persoon);
        } else {
            throw new IllegalArgumentException("Foutieve Persoon.");
        }
    }

    public Persoon hoogsteBedrag() {
        if (personen.get(0) == null) {
            throw new IllegalArgumentException("Er zijn nog geen mensen toegevoegd aan de lijst.");
        }
        Persoon meestBetaalt = personen.get(0);
        for (Persoon p:personen) {
            if (meestBetaalt.getBedrag() < p.getBedrag()) {
                meestBetaalt = p;
            }
        }
        return meestBetaalt;
    }

    public ArrayList<Persoon> getPersonen() {
        return personen;
    }

    public double gemiddeldeAfstand() {
        double totaal = 0;
        for (Persoon p:personen) {
            totaal += p.getHoogte();
        }
        double uitkomst = totaal / personen.size();
        return uitkomst;
    }
}

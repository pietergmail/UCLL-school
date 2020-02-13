package be.ucll.oop;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Levering {
	private String vertrekAdres;
	private String aankomstAdres;
	private int afstand;
	private LocalDate aanmaakDatum;
	private LocalDate leveringsDatum;

	private List<PrijsBerekenbaar> vervoersItems;

	public Levering(String vertrekAdres, String aankomstAdres, int afstand, LocalDate aanmaakDatum, LocalDate leveringsDatum) {
		this.vervoersItems = new ArrayList<>();
		setVertrekAdres(vertrekAdres);
		setAankomstAdres(aankomstAdres);
		setAfstand(afstand);
		setAanmaakDatum(aanmaakDatum);
		setLeveringsDatum(leveringsDatum);
	}

	public String getVertrekAdres() {
		return vertrekAdres;
	}

	public void setVertrekAdres(String vertrekAdres) {
		this.vertrekAdres = vertrekAdres;
	}

	public String getAankomstAdres() {
		return aankomstAdres;
	}

	public void setAankomstAdres(String aankomstAdres) {
		this.aankomstAdres = aankomstAdres;
	}

	public int getAfstand() {
		return afstand;
	}

	public void setAfstand(int afstand) {
		this.afstand = afstand;
	}

	public LocalDate getAanmaakDatum() {
		return aanmaakDatum;
	}

	public void setAanmaakDatum(LocalDate aanmaakDatum) {
		this.aanmaakDatum = aanmaakDatum;
	}

	public LocalDate getLeveringsDatum() {
		return leveringsDatum;
	}

	public void setLeveringsDatum(LocalDate leveringsDatum) {
		this.leveringsDatum = leveringsDatum;
	}

	public void addVervoersItem(PrijsBerekenbaar item) {
		this.vervoersItems.add(item);
	}

	public List<PrijsBerekenbaar> getVervoersItems() {
		return vervoersItems;
	}

	public double getTotalePrijs() {
		double totaal = 0;
		for (PrijsBerekenbaar p : vervoersItems) {
			totaal += p.berekenPrijs(afstand);
		}
		if (Period.between(aanmaakDatum, leveringsDatum).getDays() == 5) {
			totaal *= 1.1;
		}
		return totaal;
	}
}

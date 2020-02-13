package be.ucll.oop;

import java.time.LocalDateTime;

public abstract class Activiteit {
	private LocalDateTime datumEnTijd;
	private int duurInUren;
	private int maximumDeelnemers;

	public LocalDateTime getDatumEnTijd() {
		return datumEnTijd;
	}

	public void setDatumEnTijd(LocalDateTime datumEnTijd) {
		this.datumEnTijd = datumEnTijd;
	}

	public int getDuurInUren() {
		return duurInUren;
	}

	public void setDuurInUren(int duurInUren) {
		this.duurInUren = duurInUren;
	}

	public int getMaximumDeelnemers() {
		return maximumDeelnemers;
	}

	public void setMaximumDeelnemers(int maximumDeelnemers) {
		this.maximumDeelnemers = maximumDeelnemers;
	}
}

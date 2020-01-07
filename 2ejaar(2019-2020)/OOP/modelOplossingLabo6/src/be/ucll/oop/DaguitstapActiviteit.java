package be.ucll.oop;

public class DaguitstapActiviteit extends Activiteit implements HavenActiviteit {
	private Haven haven;

	@Override
	public Haven getHaven() {
		return haven;
	}

	@Override
	public void setHaven(Haven haven) {
		this.haven = haven;
	}
}

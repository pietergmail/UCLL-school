package be.ucll.oop;

public class HavenHelikopterVlucht extends HelikopterVlucht implements HavenActiviteit {
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

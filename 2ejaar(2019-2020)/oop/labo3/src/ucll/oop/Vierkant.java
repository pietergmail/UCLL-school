package ucll.oop;

import java.awt.*;

public class Vierkant extends Figuur {
	private int zijde;

	public Vierkant(int x, int y, Color kleur, int zijde) {
		super(x, y, kleur);
		this.setZijde(zijde);
	}

	@Override
	public double getOppervlakte() {
		return zijde * zijde;
	}

	@Override
	public double getOmtrek() {
		return zijde * 4;
	}

	public int getZijde() {
		return zijde;
	}

	public void setZijde(int zijde) {
		this.zijde = zijde;
	}
}

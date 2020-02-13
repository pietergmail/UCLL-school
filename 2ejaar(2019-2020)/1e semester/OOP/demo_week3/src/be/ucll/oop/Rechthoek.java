package be.ucll.oop;

import java.awt.*;

public class Rechthoek extends Figuur {
	private int breedte;
	private int hoogte;

	public Rechthoek(int x, int y, Color kleur, int breedte, int hoogte) {
		super(x, y, kleur);
		setBreedte(breedte);
		setHoogte(hoogte);
	}

	@Override
	public double getOppervlakte() {
		return breedte * hoogte;
	}

	@Override
	public double getOmtrek() {
		return 2 * (breedte + hoogte);
	}

	public int getBreedte() {
		return breedte;
	}

	public void setBreedte(int breedte) {
		this.breedte = breedte;
	}

	public int getHoogte() {
		return hoogte;
	}

	public void setHoogte(int hoogte) {
		this.hoogte = hoogte;
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Rechthoek) {
			Rechthoek r = (Rechthoek) object;
			return r.breedte == breedte && r.hoogte == hoogte && super.equals(object);
		} else {
			return false;
		}
	}
}

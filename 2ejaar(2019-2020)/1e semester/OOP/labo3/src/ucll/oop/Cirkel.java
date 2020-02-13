package ucll.oop;

import java.awt.*;

public class Cirkel extends Figuur {
	private int straal;

	public Cirkel(int x, int y, Color kleur, int straal) {
		super(x, y, kleur);
		setStraal(straal);
	}

	@Override
	public double getOppervlakte() {
		return Math.PI * straal * straal;
	}

	@Override
	public double getOmtrek() {
		return 2 * straal * Math.PI;
	}

	public int getStraal() {
		return straal;
	}

	public void setStraal(int straal) {
		this.straal = straal;
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Cirkel) {
			Cirkel c = (Cirkel) object;
			return c.straal == straal && super.equals(object);
		} else {
			return false;
		}
	}
}

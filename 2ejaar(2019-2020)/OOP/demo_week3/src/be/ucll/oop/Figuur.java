package be.ucll.oop;

import java.awt.*;

public abstract class Figuur {
	private int x;
	private int y;
	private Color kleur;

	public Figuur(int x, int y, Color kleur) {
		setX(x);
		setY(y);
		setKleur(kleur);
	}

	public Figuur() {
		this(0, 0, Color.WHITE);
	}

	public abstract double getOppervlakte();

	public abstract double getOmtrek();

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getKleur() {
		return kleur;
	}

	public void setKleur(Color kleur) {
		this.kleur = kleur;
	}

	public void setPositie() {
		this.setPositie(0, 0);
	}

	public void setPositie(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Figuur) {
			Figuur f = (Figuur) obj;
			return f.x == x && f.y == y && f.kleur.equals(kleur);
		} else {
			return false;
		}
	}
}

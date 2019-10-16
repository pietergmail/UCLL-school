package ucll.oop;

import java.awt.*;

public class Main {

	public static void main(String[] args) {
		Figuur f = new Rechthoek(50, 50, Color.WHITE, 100, 50);
		Figuur f2 = new Cirkel(100, 100, Color.BLACK, 50);
		Figuur f3 = new Cirkel(100, 100, Color.BLACK, 50);
		Figuur f4 = f2;

		System.out.println(f2.equals(f3));
		System.out.println(f2.equals(f4));

		Afbeelding a = new Afbeelding();

		a.addFiguur(f);
		a.addFiguur(f2);
	}
}

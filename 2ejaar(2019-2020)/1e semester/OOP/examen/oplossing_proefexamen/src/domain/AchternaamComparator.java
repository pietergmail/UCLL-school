package domain;

import java.util.Comparator;

public class AchternaamComparator implements Comparator<Lid> {
	@Override
	public int compare(Lid o1, Lid o2) {
		return o1.getAchternaam().compareTo(o2.getAchternaam());
	}
}

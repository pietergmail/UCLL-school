package domain;

import java.util.Comparator;

public class ComparatorByPrijsArtiest implements Comparator<Optreden> {

    @Override
    public int compare(Optreden o1, Optreden o2) {
        if(o1.equals(o2)) return 0;
        return Double.compare(o2.getArtiest().getLoon()
                            , o1.getArtiest().getLoon());
    }
}
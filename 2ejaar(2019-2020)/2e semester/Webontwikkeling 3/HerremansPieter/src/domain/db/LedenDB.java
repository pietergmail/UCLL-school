package domain.db;

import domain.model.Lid;

import java.util.List;

public interface LedenDB {
    Lid geefLid(String email);

    List<Lid> geefAlleLeden();

    List<Lid> getSortedLeden();
}

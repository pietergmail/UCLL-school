package domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class lijst {
    List<Boek> boeken;

    public void wegschrijven() throws DomainException {
        File file = new File("data.txt");
        try {
            PrintWriter writer = new PrintWriter(file);
            boeken.forEach(boek -> {
                writer.println(boek);
            });
            writer.close();
        } catch (FileNotFoundException ex) {
            throw new DomainException(ex.getMessage(), ex);
        }
    }


}

package domain;

import util.DomainException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class LocatieIO {
	public void writeLocaties(Collection<Locatie> locaties, String path) {
		try (PrintWriter printWriter = new PrintWriter(new File(path))) {
			for (Locatie locatie : locaties) {
				printWriter.println(locatie.getNaam() + ";" + locatie.getOppervlakte());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Collection<Locatie> readLocaties(String path) {
		Collection<Locatie> locaties = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File(path))) {
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				if(line.trim().isEmpty()){
					continue;
				}
				Scanner lineScanner = new Scanner(line);
				lineScanner.useDelimiter(";");
				String naam = lineScanner.next();
				int oppervlakte =Integer.parseInt( lineScanner.next());
				locaties.add(new KampeerPlaats(naam, oppervlakte));
			}
		} catch (FileNotFoundException | DomainException e) {
			e.printStackTrace();
		}
		return locaties;
	}
}

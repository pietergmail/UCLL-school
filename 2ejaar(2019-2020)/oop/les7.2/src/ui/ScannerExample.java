package ui;

import java.io.*;
import java.util.*;

public class ScannerExample{
    public static void main(String[] args) throws DomainException {
        File file= new File("boerderij.txt");
        Map<String, String> map = new HashMap<>();
        try{
            Scanner scanner= new Scanner(file);
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line != null && !line.isEmpty()){
                    Scanner lineScanner = new Scanner(line);
                    lineScanner.useDelimiter(";");
                    String key = lineScanner.next();
                    String value = lineScanner.next();
                    map.put(key, value);
                    lineScanner.close();
                }
            }scanner.close();
            for (String i : map.keySet()){
                System.out.println(i + ";" + map.get(i));
            }
        } catch (FileNotFoundException ex){
    throw new DomainException("Fout bij wegschrijven", ex);
        }

    }
}
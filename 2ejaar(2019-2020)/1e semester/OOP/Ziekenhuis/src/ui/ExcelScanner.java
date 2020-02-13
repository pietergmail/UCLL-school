package ui;

import domain.DomainException;
import domain.Operatie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExcelScanner {

    public static void main(String[] args) {

        File excel =new File("operaties.csv");

        Map<String, Operatie> collector =  new HashMap<>();

        try{

            Scanner sc1 = new Scanner(excel);

            while (sc1.hasNext()){
                String line = sc1.nextLine();

                if (line != null || !line.isEmpty()) {

                    Scanner lineScanner = new Scanner(line);
                    lineScanner.useDelimiter(";");

                    //System.out.println(line);

                    //toevoegen aan hash

                    String key = lineScanner.next();

                    Operatie value = new Operatie(key, lineScanner.next(), Integer.parseInt(lineScanner.next()), lineScanner.next());
                    //String value = lineScanner.next();
                    collector.put(key, value);

                    //ALLE VALUES
                   System.out.println(value.toString());

                    //System.out.println(collector.size());

                    lineScanner.close();

                }
            }

/*
            System.out.println(collector);
            for (Operatie o : collector.values()){
                System.out.println(o);
            }
*/
            sc1.close();

        }catch (FileNotFoundException ex){
            throw new DomainException("fout", ex);
        }
    }
}

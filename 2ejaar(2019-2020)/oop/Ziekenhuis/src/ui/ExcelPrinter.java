package ui;

import domain.DomainException;
import domain.Operatie;
import domain.Patient;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ExcelPrinter {
    public static void main(String[] args) {

        ArrayList<Patient> patients = new ArrayList<>();

        Map<String, Operatie> map = new HashMap<>();

        Patient p1 = new Patient("Jo", "Jan", LocalDate.of(2000, 01, 20),
                LocalDateTime.of(2018, 12, 2, 12, 23, 00), "123456",
                "Knie", "55268");

        Patient p2 = new Patient("Red", "Omega", LocalDate.of(1952, 5, 6),
                LocalDateTime.of(2018, 12, 20, 17, 30, 00), "12563248",
                "Chemo", "44683");

        Patient p3 = new Patient("Strange", "Doctor", LocalDate.of(1963, 11, 5),
                LocalDateTime.of(2020, 2, 15, 10, 30, 00), "789654123",
                "Pychotherapie", "10025");

        Patient p4 = new Patient("Octopus", "Doctor", LocalDate.of(2000, 6, 5),
                LocalDateTime.of(2020, 3, 15, 10, 30, 00), "565155",
                "Rugoperatie", "34020");

        Patient p5 = new Patient("Joker", "The", LocalDate.of(6666, 6, 6),
                LocalDateTime.of(2030, 3, 13, 18, 20, 00), "000000",
                "Pyscho", "62436");


        patients.add(p1);
        patients.add(p2);
        patients.add(p3);
        patients.add(p4);
        patients.add(p5);

        File excel = new File("patients.csv");
        try {

            PrintWriter writer = new PrintWriter(excel);



            for (Patient p : patients){
                writer.println(p.toString());
                System.out.println(p.toString());
            }


            writer.close();
        }catch (FileNotFoundException ex){
            throw new DomainException("fout", ex);
        }
    }

}

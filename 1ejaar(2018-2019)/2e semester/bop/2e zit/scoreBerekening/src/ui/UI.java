package ui;
import domain.*;
public class UI {

    public static void main(String[] args){
        Verbetercode een = new Verbetercode("A", 1, -0.25);
        Verbetercode twee = new Verbetercode("B", 1, -0.25);
        Verbetercode drie = new Verbetercode("C", 2, -0.75);
        Verbetercode vier = new Verbetercode("D", 1, -0.25);
        Verbetercode vijf = new Verbetercode("B", 3, -1.0);

        Deelname Zoe = new Deelname("Zoe Zino", "r12345", 5);
        Deelname Yanni = new Deelname("Yanni Yoke", "r12346", 5);
        Deelname Xavier = new Deelname("Xavier Xin", "r12347", 5);

        Zoe.setAntwoorden(0, "A");
        Zoe.setAntwoorden(1, "B");
        Zoe.setAntwoorden(2, "C");
        Zoe.setAntwoorden(3, "D");
        Zoe.setAntwoorden(4, "A");

        Yanni.setAntwoorden(0, "A");
        Yanni.setAntwoorden(1, "C");
        Yanni.setAntwoorden(2, "C");
        Yanni.setAntwoorden(3, "D");
        Yanni.setAntwoorden(4, "A");

        Xavier.setAntwoorden(0, "?");
        Xavier.setAntwoorden(1, "?");
        Xavier.setAntwoorden(2, "C");
        Xavier.setAntwoorden(3, "?");
        Xavier.setAntwoorden(4, "B");

        Test test = new Test("Eindexamen", new Verbetercode[]{een, twee, drie, vier, vijf});
        test.voegDeelnameToe(Zoe);
        test.voegDeelnameToe(Yanni);
        test.voegDeelnameToe(Xavier);

        System.out.println(test.toString());
    }
}

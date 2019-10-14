package domain;

import java.util.ArrayList;

public class StudentDB {
    ArrayList<Student> students;

    Student greetje = new Student("Jongen", "Greetje", "Toegepaste Informatica", 23);
    Student kristien = new Student("Melaerts", "Kristien", "Chemie", 21);
    Student elke = new Student("Steegmans", "Elke", "Vroedkunde", 16);
    Student jan = new Student("Van Hee", "Jan", "Verpleegkunde", 18);
    // inject: Student Dennis = new Student("<script>window.location.replace('https://www.google.com');</script>", "Dennis", "ok", 18);

    public StudentDB(){
        students = new ArrayList<>();

        students.add(greetje);
        students.add(kristien);
        students.add(elke);
        students.add(jan);
        //students.add(Dennis);

    }
    public void addStudent(Student s){
        students.add(s);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}

package domain.DB;

import domain.model.Student;

import java.util.ArrayList;

public class StudentDB {


    private ArrayList<Student> lijst;

    public StudentDB(){

        this.lijst = new ArrayList<>();
    }

    public ArrayList getStudenten(){

        return this.lijst;
    }

    public void voegStudentToe(Student s){

        lijst.add(s);
    }

    public Student getStudent(String naam, String voornaam){

        for(Student user: lijst)
        {
            if(user.getNaam().equalsIgnoreCase(naam) && user.getVoornaam().equalsIgnoreCase(voornaam))return user;
        }
        throw new IllegalArgumentException("naam niet gevonden");
    }

/*
    public int getLength(){

        return this.lijst.size();
    }

  */

    public boolean bestaandeStudent(String naam, String voornaam){

        for (Student s: lijst){
            if (s.getNaam().equalsIgnoreCase(naam) && s.getVoornaam().equalsIgnoreCase(voornaam)){

                return true;
            }
        }

        return false;

    }

}

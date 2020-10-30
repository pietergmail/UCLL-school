package domain;

import java.util.Date;

public class Person {

    private String firstName;
    private String lastname;
    private String date;
    private String room;
    private String email;
    private String gsm;

    public Person(String email, String firstName, String lastname, String date, String room, String gsm) {
        setDate(date);
        setEmail(email);
        setFirstName(firstName);
        setGsm(gsm);
        setLastname(lastname);
        setRoom(room);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }
}

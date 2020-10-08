package domain;

import java.util.Date;

public class Person {

    private String userId;
    private String firstName;
    private String lastname;
    private Date date;
    private String room;
    private String email;
    private String gsm;

    public Person(String userId, String firstName, String lastname, Date date, String room, String gsm) {
        setDate(date);
        setEmail(email);
        setFirstName(firstName);
        setGsm(gsm);
        setLastname(lastname);
        setRoom(room);
        setUserId(userId);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

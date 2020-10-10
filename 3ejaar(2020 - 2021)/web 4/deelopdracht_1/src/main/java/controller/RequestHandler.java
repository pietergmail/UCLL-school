package main.java.controller;

import main.java.db.PersonRepository;
import main.java.db.PersonRepositoryStub;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class RequestHandler {
    public PersonRepositoryStub persons;

    public PersonRepositoryStub getService(){
        return persons;
    }

    public void setPersons(PersonRepositoryStub persons){
        this.persons = persons;
    }

    public abstract void handleRequest(HttpServletRequest request, HttpServletResponse response);

    public void setModel(PersonRepositoryStub persons){
        this.persons = persons;
    }
}

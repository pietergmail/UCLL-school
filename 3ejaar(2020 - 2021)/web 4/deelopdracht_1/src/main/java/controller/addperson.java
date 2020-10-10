package main.java.controller;

import main.java.domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addperson extends RequestHandler{
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String GSM = request.getParameter("GSM");
        String date = request.getParameter("date");
        String room = request.getParameter("room");
        Person person = new Person(email, fname, lname, date, room, GSM);
        try {
            persons.add(person);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}



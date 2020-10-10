package main.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class search extends RequestHandler{
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String Jsearch = null;
        try {
            Jsearch = persons.toJson(persons.search(request.getParameter("date"), request.getParameter("room")));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        response.setContentType("application/json");
        try{
            response.getWriter().write(String.valueOf(Jsearch));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

package main.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class getpersons extends RequestHandler{
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String Jpersons;
        Jpersons = persons.toJson();
        response.setContentType("application/json");
        try {
            response.getWriter().write(String.valueOf(Jpersons));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

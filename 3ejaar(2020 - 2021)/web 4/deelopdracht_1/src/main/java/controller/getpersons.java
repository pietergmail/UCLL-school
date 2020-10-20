package main.java.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class getpersons extends RequestHandler{
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String Jpersons;
        Jpersons = toJson(persons.getAll());
        response.setContentType("application/json");
        try {
            response.getWriter().write(String.valueOf(Jpersons));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String toJson(ArrayList<Person> people){
        try {
            final ByteArrayOutputStream out = new ByteArrayOutputStream();
            final ObjectMapper mapper = new ObjectMapper();


            mapper.writeValue(out, people);

            final byte[] data = out.toByteArray();
            return new String(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

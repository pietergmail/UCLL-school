package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class search extends RequestHandler{
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String Jsearch = null;
        try {
            Jsearch = toJson(persons.search(request.getParameter("date"), request.getParameter("room")));
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

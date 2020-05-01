package ui.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.util.TreeMap;

public class activiteiten extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TreeMap<LocalTime, String> Tmap = (TreeMap<LocalTime, String>) request.getSession().getAttribute("pages");
        request.setAttribute("activities", Tmap);
        return "activiteiten.jsp";
    }
}

package ui.handler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.util.TreeMap;

public class activiteitenHandler extends RequestHandler{

    public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
        TreeMap<LocalTime, String> Tmap = (TreeMap<LocalTime, String>) request.getSession().getAttribute("pages");
        request.setAttribute("activities", Tmap);
        try {
            RequestDispatcher view = request.getRequestDispatcher("activiteiten.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

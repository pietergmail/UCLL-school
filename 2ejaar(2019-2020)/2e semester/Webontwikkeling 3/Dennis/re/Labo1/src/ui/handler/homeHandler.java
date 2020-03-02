package ui.handler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class homeHandler extends RequestHandler {

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

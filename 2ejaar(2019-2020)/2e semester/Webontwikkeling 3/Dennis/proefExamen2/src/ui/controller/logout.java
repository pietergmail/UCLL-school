package ui.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class logout extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("user",null);
        request.setAttribute("userRole", null);
        request.setAttribute("username", null);
        RequestHandler Home = new Home();
        Home.handleRequest(request,response);
    }
}

package ui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogInSubmitHandler extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String role = request.getParameter("role");

        request.getSession().setMaxInactiveInterval(3600);
        HttpSession session = request.getSession();
        session.setAttribute("user", role);

        return "logIn.jsp";
    }
}

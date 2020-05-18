package ui.controller;

import domain.model.Role;
import domain.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogIn extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        User user = getUsers().getUserIfAuthenticated(request.getParameter("name"),
                request.getParameter("password"));
        if (user == null) {
            request.setAttribute("error","No matching name/password");
        }
        else {
            request.getSession().setAttribute("user", user);
        }
        return "index.jsp";
    }
}

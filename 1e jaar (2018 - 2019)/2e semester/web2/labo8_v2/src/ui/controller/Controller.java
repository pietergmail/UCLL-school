package ui.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controller")
public class Controller extends HttpServlet {

    public Controller() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = "home";
        if (request.getParameter("command") != null) {
            command = request.getParameter("command");
        }
        String destination;
        switch(command) {
            case "home" :
                destination = home(request, response);
                break;
            case "more" :
                destination = more(request, response);
                break;
            case "quote":
                destination = quote(request, response);
            default :
                destination = home(request, response);
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private String home (HttpServletRequest request, HttpServletResponse response) {
            if (getQuoteCookie(request) != null) {
                Cookie cookie = getQuoteCookie(request);
                String value = cookie.getValue();
                request.setAttribute("value", value);
            } else {
                request.setAttribute("value", "value");
            }
        return "index.jsp";

    }

    private String more (HttpServletRequest request, HttpServletResponse response) {
        return "more.jsp";
    }

    private String quote (HttpServletRequest request, HttpServletResponse response){
        String quote = request.getParameter("quote");
        Cookie quoteCookie = new Cookie("quoteCookie", quote);
        quoteCookie.setMaxAge(-1);
        response.addCookie(quoteCookie);
        String value = quoteCookie.getValue();

        request.setAttribute("value", value);
        return "index.jsp";
    }

    private Cookie getQuoteCookie(HttpServletRequest request){
        for(Cookie cookie : request.getCookies()){
            if (cookie.getName().equals("quoteCookie")){
               return cookie;
            }
        }
        return null;
    }
}


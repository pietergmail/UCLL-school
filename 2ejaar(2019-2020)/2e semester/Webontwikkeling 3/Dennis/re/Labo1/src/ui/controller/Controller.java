package ui.controller;

import domain.model.Person;
import domain.model.Product;
import domain.model.ShopService;
import org.openqa.selenium.remote.server.Session;
import ui.handler.HandlerFactory;
import ui.handler.RequestHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.*;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
    ShopService service;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext context = getServletContext();
        Properties properties = new Properties();
        properties.setProperty("user", context.getInitParameter("user"));
        properties.setProperty("password", context.getInitParameter("password"));
        properties.setProperty("ssl", context.getInitParameter("ssl"));
        properties.setProperty("sslfactory", context.getInitParameter("sslfactory"));
        properties.setProperty("sslmode", context.getInitParameter("sslmode"));
        properties.setProperty("url", context.getInitParameter("url"));
        service = new ShopService(properties);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //session stuff
        HttpSession session = request.getSession();
        TreeMap<LocalTime, String> Tmap;
        if (session.getAttribute("pages") == null) {
            Tmap = new TreeMap<LocalTime, String>();
        } else {
            Tmap = (TreeMap<LocalTime, String>) session.getAttribute("pages");
        }
        String command = request.getParameter("command");
        if (command == null) {
            command = "home";
        }

        Tmap.put(LocalTime.now(), command);
        session.setAttribute("pages", Tmap);
        //end sessino stuff

        try {
            RequestHandler handler = HandlerFactory.getHandler(request,response,service);

            handler.setService(service);
            handler.handleRequest(request,response);
        } catch (Exception e) {
            throw new ServletException(e.getMessage(), e);
        }

    }
}

package ui.controller;

import domain.model.Product;
import domain.model.ShopService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Properties;
import java.util.TreeMap;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ShopService service;
    ArrayList<Product> cart = new ArrayList<>();
    private ControllerFactory handlerFactory = new ControllerFactory();

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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        TreeMap<LocalTime, String> Tmap;
        if (session.getAttribute("pages") == null) {
            Tmap = new TreeMap<LocalTime, String>();
        } else {
            Tmap = (TreeMap<LocalTime, String>) session.getAttribute("pages");
        }
        try {
            String command = request.getParameter("command");
            if(command == null) {
                Tmap.put(LocalTime.now(), "home");
            }else{
                Tmap.put(LocalTime.now(), command);
            }
            session.setAttribute("pages", Tmap);
            RequestHandler handler = handlerFactory.getHandler(command, service);
            String destination = handler.handleRequest(request, response);
            RequestDispatcher view = request.getRequestDispatcher(destination);
            view.forward(request, response);
        }catch (Exception e){
            throw new ServletException(e.getMessage(), e);
        }
    }
}

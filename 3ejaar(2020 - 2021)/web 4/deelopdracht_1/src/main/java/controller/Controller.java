package main.java.controller;

import main.java.db.PersonRepository;
import main.java.db.PersonRepositoryStub;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
    PersonRepositoryStub persons = new PersonRepositoryStub();
    private ControllerFactory handlerFactory = new ControllerFactory();

    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response){
        try{
            String command = request.getParameter("command");
            RequestHandler handler = handlerFactory.getHandler(command, persons);
            handler.handleRequest(request, response);
        }catch (Exception e){
            try {
                throw new ServletException(e.getMessage(), e);
            } catch (ServletException servletException) {
                servletException.printStackTrace();
            }
        }
    }
}

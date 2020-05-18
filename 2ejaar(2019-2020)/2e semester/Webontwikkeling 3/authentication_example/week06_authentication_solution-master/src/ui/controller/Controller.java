package ui.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.db.Users;
import domain.model.Role;
import domain.model.User;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
    private Users users = new Users();
    ControllerFactory controllerFactory = new ControllerFactory();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String destination = "index.jsp";
        if (action == null || action.isEmpty())
            action = "Home";
        RequestHandler handler = controllerFactory.getController(action);
        handler.setUsers(users);

        destination = handler.handleRequest(request, response);

        RequestDispatcher view = request.getRequestDispatcher(destination);
        view.forward(request, response);

    }


}

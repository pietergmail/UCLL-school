package ui.controller;

import domain.db.DbException;
import domain.db.ProductDbInMemory;
import domain.model.DomainException;
import domain.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
    private ProductDbInMemory productDb = new ProductDbInMemory();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destination;
        String command = request.getParameter("command");
        switch (command) {
            case "overview":
                destination = showOverview(request, response);
                break;
            case "addToCart":
                destination = addToCart(request, response);
                break;
            case "cart":
                destination = showCart(request, response);
                break;
            case "removeFromCart":
                destination = removeFromCart(request, response);
                break;
            default:
                destination = showHome(request, response);
                break;
        }
        RequestDispatcher view = request.getRequestDispatcher(destination);
        view.forward(request, response);


    }

    private String removeFromCart(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    private String showCart(HttpServletRequest request, HttpServletResponse response) {
        return "cart.jsp";
    }

    private String addToCart(HttpServletRequest request, HttpServletResponse response) {
        return "productOverview.jsp";
    }

    private String showHome(HttpServletRequest request, HttpServletResponse response) {
        return "index.jsp";
    }


    private String showOverview(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("products", productDb.getAll());
        return "productOverview.jsp";
    }
}

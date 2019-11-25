package ui;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet")
public class Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest Request, HttpServletResponse Response) throws ServletException, IOException {
        String command = "home";
        if(Request.getParameter("command") != null){
            command = Request.getParameter("command");
        }
        String destination= "";
        switch (command){
            case "home":
                destination = home(Request, Response);
                break;
            case "read_more":
                destination = more(Request, Response);
                break;
            default:
                destination = home(Request, Response);
        }
        Request.getRequestDispatcher(destination).forward(Request, Response);
    }

    private String more(HttpServletRequest request, HttpServletResponse response) {
        return "more.jsp";
    }

    private String home(HttpServletRequest request, HttpServletResponse response) {
        return "index.jsp";
    }
}
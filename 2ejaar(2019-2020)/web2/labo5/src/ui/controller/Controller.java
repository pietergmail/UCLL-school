package ui.controller;


import domain.db.StudentDB;
import domain.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StudentDB klas =new StudentDB();
       
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	processRequest(request, response);
	}
	private void processRequest(HttpServletRequest Request, HttpServletResponse Response) throws  ServletException, IOException {
		String command = "home";
		if (Request.getParameter("command") != null) {
			command = Request.getParameter("command");
		}
		String destination = "";
		switch (command) {
			case "home":
				destination = home(Request, Response);
				break;
			case "overview":
				destination = overview(Request, Response);
				break;
			case "add":
				destination = add(Request, Response);
				break;
			case "addstudent":
				destination = addstudent(Request, Response);
				break;
			case "search":
				destination = search(Request, Response);
				break;
			case "searchstudent":
				destination = searchstudent(Request, Response);
				break;
			default:
				destination = home(Request, Response);

		}
		Request.getRequestDispatcher(destination).forward(Request, Response);
	}
	private String home(HttpServletRequest Request, HttpServletResponse Response) {
	return "index.jsp";
	}

	private String overview(HttpServletRequest Request, HttpServletResponse Response) {
	Request.setAttribute("studenten", klas.getKlas());
	return "studentOverview.jsp";
	}

	private String add(HttpServletRequest Request, HttpServletResponse Response) {
		return "studentForm.jsp";
	}

	private String addstudent(HttpServletRequest Request, HttpServletResponse Response) {
		String naam = Request.getParameter("naam");
		String voornaam = Request.getParameter("voornaam");
		String leeftijd = Request.getParameter("leeftijd");
		String studierichting = Request.getParameter("studierichting");

		String destination = "index.html";

		if (naam.isEmpty() || voornaam.isEmpty() || leeftijd.isEmpty() || studierichting.isEmpty()) {
			destination = "studentForm.jsp";
		}
		else {
			Student student = new Student(naam, voornaam, Integer.parseInt(leeftijd), studierichting);
			klas.voegToe(student);
			Request.setAttribute("studenten", klas.getKlas());
			destination = "studentOverview.jsp";
		}
		return destination;
	}

	private String search(HttpServletRequest Request, HttpServletResponse Response){

    	return "zoekForm.jsp";
	}

	private String searchstudent(HttpServletRequest Request, HttpServletResponse Response) {
		String naam=Request.getParameter("naam");
		String voornaam=Request.getParameter("voornaam");
		String destination="";

		if (naam==null || voornaam== null) {
			destination="nietGevonden.jsp";
		}
		else {
			Student student=klas.vind(naam, voornaam);
			if (student==null) {
				destination="nietGevonden.jsp";
			}
			else {
				destination="gevonden.jsp";
				Request.setAttribute("student", student);
			}
		}
	return destination;
	}
}
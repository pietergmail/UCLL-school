package ui.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.db.DierDB;
import domain.model.Dier;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DierDB db = new DierDB();

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
			case "overview" :
				destination = overview(request, response);
				break;
			case "add" :
				destination = add(request, response);
				break;
			default :
				destination = home(request, response);
		}
		request.getRequestDispatcher(destination).forward(request, response);		
	}

	private String home (HttpServletRequest request, HttpServletResponse response) {
		Dier meestHongerigeDier = db.getMeestHongerigeDier();
		request.setAttribute("meestHongerige", meestHongerigeDier);
		return "index.jsp";
	}
	
	private String overview (HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("dieren", db.getAlle());
		return "overview.jsp";
	}
	
	private String add (HttpServletRequest request, HttpServletResponse response) {
		ArrayList<String> errors = new ArrayList<String>();
		
		Dier dier = new Dier();
		setNaam(dier, request, errors);
		setSoort(dier, request, errors);
		setVoedsel(dier, request, errors);
		
		if (errors.size() == 0) {
			try {
				db.voegToe(dier);
				return overview(request, response);
			}
			catch (IllegalArgumentException exc) {
				request.setAttribute("error", exc.getMessage());
				return "add.jsp";
			}
		}
		else {
			request.setAttribute("errors", errors);
			return "add.jsp";
		}
	}
	
	private void setNaam (Dier dier, HttpServletRequest request, ArrayList<String> errors) {
		String naam = request.getParameter("naam");
		try {
			dier.setNaam(naam);
			request.setAttribute("naamClass", "has-success");
			request.setAttribute("naamPreviousValue", naam);
		}
		catch (IllegalArgumentException exc) {
			errors.add(exc.getMessage());
			request.setAttribute("naamClass", "has-error");
		}
	}
	
	private void setSoort (Dier dier, HttpServletRequest request, ArrayList<String> errors) {
		String soort = request.getParameter("soort");
		try {
			dier.setSoort(soort);
			request.setAttribute("soortClass", "has-success");
			request.setAttribute("soortPreviousValue", soort);
		}
		catch (IllegalArgumentException exc) {
			errors.add(exc.getMessage());
			request.setAttribute("soortClass", "has-error");
		}
	}
	
	private void setVoedsel (Dier dier, HttpServletRequest request, ArrayList<String> errors) {
		String voedsel = request.getParameter("voedsel");
		try {
			dier.setVoedsel(Integer.parseInt(voedsel));
			request.setAttribute("voedselClass", "has-success");
			request.setAttribute("voedselPreviousValue", voedsel);
		}
		catch (NumberFormatException exc) {
			errors.add("Vul een nummer in voor voedsel.");
			request.setAttribute("voedselClass", "has-error");
		}
		catch (IllegalArgumentException exc) {
			errors.add(exc.getMessage());
			request.setAttribute("voedselClass", "has-error");
		}
	}	

}

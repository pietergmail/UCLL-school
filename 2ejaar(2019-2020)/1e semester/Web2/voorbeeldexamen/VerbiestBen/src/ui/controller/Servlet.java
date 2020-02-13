package ui.controller;

import domain.model.Persoon;
import domain.db.PersoonDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    private PersoonDB database = new PersoonDB();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String naam = request.getParameter("naam");
        String bedragFromParameter = request.getParameter("amount");
        double bedrag = Double.parseDouble(bedragFromParameter);
        String hoogteFromParamater = request.getParameter("hight");
        double hoogte = Double.parseDouble(hoogteFromParamater);

        if (hoogte < 0 || hoogte > 1000) {
            request.setAttribute("foutieveHoogte", hoogte);
            request.getRequestDispatcher("afstand.jsp").forward(request,response);
        } else {

        Persoon persoon = new Persoon(naam, bedrag, hoogte);
        database.addPersoon(persoon);
        request.setAttribute("persoon", persoon);
        doGet(request,response);}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("database", database.personenlijst());
        request.setAttribute("meestBetaald", database.hoogsteBedrag().getNaam());
        request.setAttribute("hoogsteBedrag", database.hoogsteBedrag().getBedrag());
        request.setAttribute("gemiddeldeAfstand", database.gemiddeldeAfstand());
        request.getRequestDispatcher("overzicht.jsp").forward(request, response);
    }
}

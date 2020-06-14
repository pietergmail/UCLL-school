package ui.controller;

import domain.db.Wielerclub;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NiveauGroepenHandler extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("groepen", wielerclub.getNiveaugroepenDB().geefAlleNiveaugroepen());
        return "niveaugroepenOverview.jsp";
    }
}

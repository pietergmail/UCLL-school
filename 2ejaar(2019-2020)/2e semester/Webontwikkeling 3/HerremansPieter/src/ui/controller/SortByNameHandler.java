package ui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SortByNameHandler extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("leden", wielerclub.getLedenDB().getSortedLeden());
        return "ledenOverview.jsp";
    }
}

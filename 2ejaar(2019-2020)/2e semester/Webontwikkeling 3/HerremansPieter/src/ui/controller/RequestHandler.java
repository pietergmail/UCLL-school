package ui.controller;

import domain.db.Wielerclub;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class RequestHandler {
    Wielerclub wielerclub;

    public Wielerclub getWielerclub() {
        return wielerclub;
    }

    public void setWielerclub(Wielerclub wielerclub) {
        this.wielerclub = wielerclub;
    }

    public abstract String handleRequest(HttpServletRequest request, HttpServletResponse response);
}

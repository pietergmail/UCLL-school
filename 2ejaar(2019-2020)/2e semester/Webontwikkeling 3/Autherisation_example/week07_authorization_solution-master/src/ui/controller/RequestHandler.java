package ui.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class RequestHandler {


    public abstract void handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;








}

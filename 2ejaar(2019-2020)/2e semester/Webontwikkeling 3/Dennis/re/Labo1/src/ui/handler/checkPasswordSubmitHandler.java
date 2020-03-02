package ui.handler;

import domain.model.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class checkPasswordSubmitHandler extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        Person p = service.getPerson(id);
        boolean awnser = false;
        try {
            System.out.println(p.getPassword());
            System.out.println(password);
            awnser = p.isCorrectPasswordHashed(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        request.setAttribute("awnser", awnser);

        RequestHandler handler = new overviewHandler();
        handler.setService(getService());
        handler.handleRequest(request, response);
    }
}

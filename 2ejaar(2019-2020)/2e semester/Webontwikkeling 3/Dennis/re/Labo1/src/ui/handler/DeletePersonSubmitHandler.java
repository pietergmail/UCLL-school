package ui.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeletePersonSubmitHandler extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");

        service.deletePerson(id);
        RequestHandler handler = new overviewHandler();
        handler.setService(getService());
        handler.handleRequest(request, response);
    }
}

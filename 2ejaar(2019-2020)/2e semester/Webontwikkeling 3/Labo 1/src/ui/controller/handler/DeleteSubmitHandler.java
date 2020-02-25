package ui.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteSubmitHandler extends RequestHandler{
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");

        service.deleteProduct(id);
        RequestHandler handler = new productenHandler();
        handler.setService(getService());
        handler.handleRequest(request, response);    }
}

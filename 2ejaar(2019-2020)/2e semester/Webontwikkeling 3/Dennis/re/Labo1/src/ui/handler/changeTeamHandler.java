package ui.handler;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class changeTeamHandler extends RequestHandler{
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Cookie c = findCookie(request.getCookies(), "IndexPicture");
        if (c == null) {
            c = new Cookie("IndexPicture", "yes");
        } else {
            if (c.getValue().equals("yes")) {
                c.setValue("no");
            } else {
                c.setValue("yes");
            }
        }
        request.setAttribute("IndexPicture", c.getValue());
        response.addCookie(c);
        RequestHandler handler = new homeHandler();
        handler.setService(getService());
        handler.handleRequest(request, response);
    }
    protected Cookie findCookie(Cookie[] cookies, String key) {
        for (Cookie c : cookies) {
            if (c.getName().equals(key)) {
                return c;
            }
        }
        return null;
    }

}

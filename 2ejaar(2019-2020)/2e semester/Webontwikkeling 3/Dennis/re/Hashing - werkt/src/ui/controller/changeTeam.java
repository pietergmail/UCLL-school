package ui.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class changeTeam extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        request.getRequestDispatcher("index.jsp").forward(request, response);
        return null;
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

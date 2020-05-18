package ui.controller;

import domain.model.Role;
import domain.model.User;

import javax.servlet.http.HttpServletRequest;

public class Utility {
    /**
     * Checks if the role of the user stored in request.getSession() has one of the given roles
     * @throws NotAuthorizedException if the role of the user does not correspond with one of the given roles
     */
    public static void checkRole(HttpServletRequest request, Role[] roles) {
        // read user from session
        // if users role is different from given roles
        //      throw NotAuthorizedException
        boolean found = false;
        User user = (User) request.getSession().getAttribute("user");
        if (user != null)
            for (Role role : roles) {
                if (user.getRole().equals(role))
                    found = true;

            }
        if (!found)
            throw new NotAuthorizedException();

    }

}

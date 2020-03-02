package domain.model;

import ui.controller.NotAuthorizedException;

import javax.servlet.http.HttpServletRequest;

public class Utility {

    public static void checkRole(HttpServletRequest request, Role[] roles){

        Role userRole = (Role) request.getSession().getAttribute("user");
        if (userRole == null){
            throw new NotAuthorizedException("You are not authorized to view this page");
        }
        boolean check = false;
        for (Role role:roles){
            if (role.getStringValue().equals(userRole.getStringValue())){
                check=true;
                break;
            }
        }
        if (!check){
            throw new NotAuthorizedException("You are not authorized to view this page");
        }
    }
}

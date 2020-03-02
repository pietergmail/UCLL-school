package domain.model;

import ui.controller.NotAuthorizedException;

public class Utility {

    public static void checkRole(Role[] roles, Role role){
        if (role == null){
            throw new NotAuthorizedException("You are not allowed to view this page");
        }
        boolean found = false;
        for (Role subrole:roles){
            if (subrole.getStringValue().equals(role.getStringValue())){
                found=true;
            }
        }
        if (!found){
            throw new NotAuthorizedException("You are not allowed to view this page");
        }
    }
}

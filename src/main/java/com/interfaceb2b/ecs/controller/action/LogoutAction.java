package com.interfaceb2b.ecs.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutAction implements Action {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

            request.getSession().invalidate(); // Login user.
            return ""; // Redirect to home page.        
 
    }

}


package com.interfaceb2b.ecs.controller.action;

import java.util.NoSuchElementException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.interfaceb2b.ecs.user.User;
import com.interfaceb2b.ecs.user.UserDAO;
import com.interfaceb2b.ecs.util.PasswordUtils;

public class LoginAction implements Action {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {        
        try {
        		String username = request.getParameter("username");
        		String password = request.getParameter("password");

        		UserDAO userDAO = new UserDAO();
        		Optional<User> optUser = userDAO.find(username);
        		
        		//if(optUser.isPresent()) {
        			User user = optUser.get();
        			if (!PasswordUtils.verifyPassword(password, user.getPasswordKey(), user.getSalt())) {
        				throw new NoSuchElementException();
        			}
        		//}
                
                request.getSession().setAttribute("CURRENT_USER", user); // save user to session
                return "dashboard";
  
        } catch (NoSuchElementException e) {
        	 request.setAttribute("error", "Invalid username/password. Please retry.");
        	 request.getSession().removeAttribute("user");
             return "login";
        }
    }

}


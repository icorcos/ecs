package com.interfaceb2b.ecs.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.interfaceb2b.ecs.controller.action.Action;
import com.interfaceb2b.ecs.controller.action.ActionFactory;
import com.interfaceb2b.ecs.user.User;

public class FrontControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 330302136862897230L;

	// /** Handles the HTTP <code>GET</code> method.
	// * @param request servlet request
	// * @param response servlet response
	// */
	// @Override
	// protected void doGet(HttpServletRequest request, HttpServletResponse
	// response) throws ServletException, IOException {
	// processRequest(request, response);
	// }
	//
	// /** Handles the HTTP <code>POST</code> method.
	// * @param request servlet request
	// * @param response servlet response
	// */
	// @Override
	// protected void doPost(HttpServletRequest request, HttpServletResponse
	// response) throws ServletException, IOException {
	// processRequest(request, response);
	// }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Check for a valid session before executing requested Action
			HttpSession session = request.getSession(false);
			String view = "";

			// if (session == null) { // no active session, go to login without action
			// System.err.println("No valid session, login required");
			// session = request.getSession(true);
			// view = "login";
			// } else { // check for user in the session before proceeding with requested
			// action
			// User user = (User) session.getAttribute("user");
			//
			// if (user != null) { // valid user session, proceed with action
			// Action action = ActionFactory.getAction(request);
			// view = action.execute(request, response);
			// } else { // no user found in session
			// if (request.getPathInfo().contains("login")) {
			// Action action = ActionFactory.getAction(request);
			// view = action.execute(request, response);
			// } else { // no user and action is not login, force login
			// view = "login";
			// }
			// }
			// }

			Action action = ActionFactory.getAction(request);
			view = action.execute(request, response);
			if (view != null) {
				dispatch(request, response, view);
			}

		} catch (Exception e) {
			throw new ServletException("Executing action failed.", e);
		}
	}

	protected void dispatch(HttpServletRequest request, HttpServletResponse response, String view)
			throws javax.servlet.ServletException, java.io.IOException {
		// RequestDispatcher dispatcher =
		// getServletContext().getRequestDispatcher("/WEB-INF/" + view + ".jsp");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/" + view + ".jsp");
		dispatcher.forward(request, response);
	}

	// Initializes the servlet.
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	// Destroys the servlet.
	public void destroy() {
	}

	/** Returns a short description of the servlet */
	public String getServletInfo() {
		return "Front Controller Pattern" + " Servlet Front Strategy Example";
	}

}

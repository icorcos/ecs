package com.interfaceb2b.ecs.controller.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {

	private static Map<String, Action> actions = null;

	static {
		actions = new HashMap<String, Action>();
		actions.put("POST/login", new LoginAction());
		actions.put("GET/logout", new LogoutAction());
		actions.put("GET/dashboard", new DashboardAction());
		actions.put("GET/settings", new SettingsAction());
	}

	public static Action getAction(HttpServletRequest request) {
		String method = request.getMethod();
		String path = request.getPathInfo();
		System.out.println("Action to fetch : " + method + path);
		return actions.get(method + path);
	}

}

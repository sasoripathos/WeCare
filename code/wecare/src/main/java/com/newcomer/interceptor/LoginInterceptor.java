package com.newcomer.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	/**
	 * Handler run before the request, check login state and do proper redirection.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute("user") == null) {
			// If not login, redirect to welcome page
			System.out.println("PreHandle false");
			response.sendRedirect("/");
			return false;
		}
		// If login, do nothing
		System.out.println("PreHandle true");
		return true;
	}

}

package com.swclass.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{
	String allowedPath = "/todoexam/login.do";
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpSession session = httpRequest.getSession();
		
		String uri = httpRequest.getRequestURI();
		String key = String.valueOf(session.getAttribute("key"));
		
		boolean isAllowed = false;
		if (!"null".equals(key)) {
            isAllowed = true;
		} else {
			if (uri.equals(allowedPath)) {
				isAllowed = true;
			}
		}
		
		if (isAllowed) {
			chain.doFilter(request, response);
		} else {
            ((HttpServletResponse) response).sendRedirect("/todoexam/login.do");
        }
		
	}
	
}

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
	public class CheckerFilter implements Filter {
	    private String[] excludePathes = { "/main.do", "/login/login" };
	    @Override
	    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	            throws IOException, ServletException {
	        HttpServletRequest httpRequest = ((HttpServletRequest) request);
	        String uri = httpRequest.getRequestURI();
	        HttpSession session = httpRequest.getSession();
	        String key = String.valueOf(session.getAttribute("key"));
	        boolean isExecute = false;
	        if (!"null".equals(key)) {
	            isExecute = true;
	        } else {
	            for (int i = 0; i < this.excludePathes.length; i++) {
	                if (this.excludePathes[i].equals(uri)) {
	                    isExecute = true;
	                    break;
	                }
	            }
	        }
	        if (isExecute) {
	            chain.doFilter(request, response);
	        } else {
	            ((HttpServletResponse) response).sendRedirect("/login/login");
	        }
	    }
	}

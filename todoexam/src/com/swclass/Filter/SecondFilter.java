package com.swclass.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondFilter implements Filter{
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("2nd Filter Inin....");
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("2nd doFilter ȣ�� ��----------->");
		chain.doFilter(req, res);
		System.out.println("2nd doFilter ȣ�� ��<-----------");
	}
	@Override
	public void destroy() {
		System.out.println("2nd Filter destroy...");
	}

}

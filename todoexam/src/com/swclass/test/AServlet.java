package com.swclass.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/AServlet.do")
public class AServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
	PrintWriter out = res.getWriter();	
	
	out.print("<html>이것은 한글이다 세종대왕이 만들었지</html>");
	}
}

package com.swclass.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		
		req.getSession().invalidate();
		
		PrintWriter out = res.getWriter();
		out.print("���� �α׾ƿ� ó�� �Ǿ����ϴ�");
		out.print("<html>");
		out.print("<head><meta charset='UTF-8'</head>");
		out.print("<body>");
		out.print("<br/><br/>"
				+ "<a href = /todoexam/login.do><input type = 'button' value = 'Ȩ����'/> <br/>");
		out.print("</body>");
		out.print("</html>");
	}
}

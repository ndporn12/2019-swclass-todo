package com.swclass.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = res.getWriter();
		out.print("<html>");
		out.print("<head><meta charset='UTF-8'> <title></title></head>");
		out.print("<body>");
		out.print("	<form action='/todoexam/login.do' method='post'>");
		out.print("		ID : <input type ='text' name='id'><br/>");
		out.print("		PW : <input type ='password' name='pwd'><br/>");
		out.print("		<input type='submit' value ='로그인'><br/>");
		out.print("	</form>");
		out.print("</body>	");
		out.print("</html>");
		out.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");

		String id = req.getParameter("id");
		HttpSession session = req.getSession();
		session.setAttribute("key", id);
		
		System.out.println("계정 : " +id + "에 대한 로그인 성공");
		
		res.sendRedirect("/todoexam/mainPage.do");
	}
}

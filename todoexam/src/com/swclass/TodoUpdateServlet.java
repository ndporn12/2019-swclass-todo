package com.swclass;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TodoUpdateServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.print("<html>");
		out.print("<head><meta charset=UTF-8> <title> </title> </head>");
		out.print("<body>");
		out.print("	<form action = '/todoexam/todoUpdate.do' method = 'post'>");
		out.print("		할 일<input type ='text' name='todo'/><br/>");
		out.print("		DATE<input type ='text' name='date'/><br/>");
		out.print("		설명<textarea name='text'></textarea><br/>");
		out.print("		<input type='submit' name='등록'/><br/>");
		out.print("		<input type='reset' name='지우기'/><br/>");
		out.print("	</form>");
		out.print("</body>");
		out.print("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		
		String jobTodo = req.getParameter("todo");
		String date = req.getParameter("date");
		String text = req.getParameter("text");
		System.out.println(jobTodo +","+ date +","+ text +"를 성공적으로 등록.");
		
		res.sendRedirect("/todoexam/todoList.do");
	}
}

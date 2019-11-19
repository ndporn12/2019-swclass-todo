package com.swclass;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TodoEditServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req , HttpServletResponse res)
			throws ServletException,IOException{
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		out.print("<html>");
		out.print("<head><meta charset=UTF-8> <title> </title> </head>");
		out.print("<body>");
		out.print("	<form action = '/todoexam/todoEdit.do' method = 'post'>");
		out.print("		<h1>수정페이지</h1> <br/>");
		out.print("		할 일<input type ='text' name='todo'/><br/>");
		out.print("		DATE<input type ='text' name='date'/><br/>");
		out.print("		설명<textarea name='text'></textarea><br/>");
		out.print("		<input type='submit' value='등록'/><br/>");
		out.print("	</form>");
		out.print("</body>");
		out.print("</html>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req , HttpServletResponse res)
			throws ServletException,IOException{
		String editTodo = req.getParameter("todo");
		String editDate = req.getParameter("date");
		String editText = req.getParameter("text");
		System.out.print(editTodo + editDate + editText);
		System.out.println("를 성공적으로 수정");
		
		res.sendRedirect("/todoexam/todoList.do");
	}
}

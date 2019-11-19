package com.swclass.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewServlet")
public class ViewServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req , HttpServletResponse res)
			throws ServletException,IOException{
		String data = String.valueOf(req.getAttribute("data"));
				
		PrintWriter out = res.getWriter();
		out.print("<html>");
		out.print("<head> </head>");
		out.print("<body>");
		out.print("<h1>"+ data +"</h1>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}
}

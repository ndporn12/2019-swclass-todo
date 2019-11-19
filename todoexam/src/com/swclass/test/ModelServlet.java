package com.swclass.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/modelServlet")
public class ModelServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req ,HttpServletResponse res)
			throws ServletException,IOException{
		String data = "ABCDE";
		
		req.setAttribute("data", data);
		
		RequestDispatcher rd = req.getRequestDispatcher("/viewServlet");
		rd.forward(req, res);
	}
}

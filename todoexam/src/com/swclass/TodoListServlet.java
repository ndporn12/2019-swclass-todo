package com.swclass;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/todoList.do")
public class TodoListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		List<Todo> newList = getData();

		out.print("<html>");
		out.print("<head> <meta charset=UTF-8> </head>");
		out.print("<body>");
		out.print("	<table border='3'>");
		for (int i = 0; i < newList.size(); i++) {
			out.print("	<tr>");
			out.print("		<td>" + (newList.get(i).getTextNo()) + "</td>");
			out.print("		<td>" + (newList.get(i).getTodo()) + "</td>");
			out.print("		<td>" + (newList.get(i).getText()) + "</td>");
			out.print("		<td>" + (newList.get(i).getDate()) + "</td>");
			out.print("	</tr>");
		}
		out.print("	</table>");
		out.print("<a href = '/todoexam/todoUpdate.do'>" + "<input type = 'button' value = '등록'> </a>");
		out.print("<a href = '/todoexam/todoEdit.do'>" + "<input type = 'button' value = '수정'> </a>");
		out.print("<a href = '/todoexam/todoDelete.do?no=10'>" + "<input type = 'button' value = '삭제'> </a>");
		out.print("</body>");
		out.print("</html>");
	}

	public List<Todo> getData() {
		List<Todo> list = new ArrayList<>();
		String sql = "SELECT TEXTNO,TODO,TEXT,POST_DATE FROM TODO_LIST";

		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/mybatis");
			Connection connection = ds.getConnection();
			
			/*
			 * Class.forName("oracle.jdbc.driver.OracleDriver");
			 * 
			 * conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
			 * "mybatis", "mybatis$");
			 */
				
			Statement statement = connection.createStatement();
			 
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				int textNo = resultSet.getInt("TEXTNO");
				String todo = resultSet.getString("TODO");
				String text = resultSet.getString("TEXT");
				String date = resultSet.getDate("POST_DATE").toString();

				Todo object = new Todo(textNo, todo, text, date);

				System.out.println(object.toString());

				list.add(object);
			}

			resultSet.close();
			statement.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}

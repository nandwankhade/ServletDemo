package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Student;
import com.service.DataService;
import com.util.DBTransaction;

/**
 * Servlet implementation class Operations
 */
@WebServlet("/Operations")
public class AddData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public AddData() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		PrintWriter pw = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");

		Student std = new Student();
		std.setId(id);
		std.setName(name);
		System.out.println(id);
		System.out.println(name);

		DataService dc = new DataService();
		int x = dc.addData(std);

		if (x > 0) {
			pw.print("<h1>Record inserted...!</h1>");
			request.getRequestDispatcher("index.jsp").include(request, response);
		} else {
			request.setAttribute("id", id);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}

}

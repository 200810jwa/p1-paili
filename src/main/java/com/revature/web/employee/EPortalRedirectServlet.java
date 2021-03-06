package com.revature.web.employee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/EmployeeHome")
public class EPortalRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1014072281024881184L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("/static/EmployeePortal.html").forward(request, response);
	}
}

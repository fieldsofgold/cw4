package pl.altkom;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String make = request.getParameter("make");

		if (make.equalsIgnoreCase("ford")) {
			response.sendRedirect("http://www.ford.com/");
		}
		if (make.equalsIgnoreCase("fiat")) {
			response.sendRedirect("http://www.fiat.com/");
		}
		if (make.equalsIgnoreCase("renault")) {
			response.sendRedirect("http://www.renault.com/");
		}
	}
}

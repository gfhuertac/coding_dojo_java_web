package com.codingdojo.simple.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String retrieveOrUnknown(HttpServletRequest request, String parameter) {
		String value = request.getParameter(parameter);
		if (value == null || value.length() == 0) {
			value = "Unknown";
		}
		return value;
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = retrieveOrUnknown(request, "firstName");
		String lastName = retrieveOrUnknown(request, "lastName");
		String favoriteLanguage = retrieveOrUnknown(request, "favoriteLanguage");
		String homeTown = retrieveOrUnknown(request, "homeTown");

		// Sets the content type of the response
        response.setContentType("text/html");
        // writes the response
		PrintWriter out = response.getWriter();
		// print the output
		out.write("<h1>Welcome, " + firstName + " " + lastName + "</h1>");
		out.write("<h3>Your favorite language is " + favoriteLanguage + "</h3>");
		out.write("<h3>Your hometown is " + homeTown + "</h3>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

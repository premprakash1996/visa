package com.visa.training.web;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/addtocart")
public class AddToCartServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] ids = request.getParameterValues("pid");
		HttpSession session = request.getSession();
		Set<Integer> selectedIds = (Set<Integer>) session.getAttribute("selectedIds");
		if(selectedIds == null){
			selectedIds = new TreeSet<>();
		}
		Set<Integer> idsInt = Stream.of(ids).map(Integer::parseInt).collect(Collectors.toSet());
		selectedIds.addAll(idsInt);
		session.setAttribute("selectedIds", selectedIds);
		response.setContentType("text/html");
		response.getWriter().println("<a href=home.html>Back to home</a>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

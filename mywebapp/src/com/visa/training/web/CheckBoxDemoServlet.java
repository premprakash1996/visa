package com.visa.training.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/checkboxdemo")
public class CheckBoxDemoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] selected = request.getParameterValues("itemid");
		List<String> l = new ArrayList<>(Arrays.asList(selected));
		response.setContentType("text/plain");
		response.getWriter().println(Arrays.asList(selected));
	}

}

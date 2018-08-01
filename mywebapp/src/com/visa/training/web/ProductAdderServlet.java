package com.visa.training.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.visa.training.dal.ProductDAO;
import com.visa.training.domain.Product;


@WebServlet("/addproduct")
public class ProductAdderServlet extends HttpServlet {
	
	ProductDAO dao = new ProductDAO();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		float price = Float.parseFloat(request.getParameter("price"));
		int qoh = Integer.parseInt(request.getParameter("qoh"));
		Product p = new Product(name, price, qoh);
		Product created = dao.addNew(p);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("Product created with id : "+created.getId()+"<br>");
		out.println("<a href=home.html> Back to Home page </a>");
		out.println("</body></html>");
	}

}

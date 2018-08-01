package com.visa.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.visa.training.dal.ProductDAO;
import com.visa.training.domain.Product;

@WebServlet("/viewproducts")
public class ProductViewerServlet extends HttpServlet {

	ProductDAO dao = new ProductDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		List<Product> all = dao.findAll();

		request.setAttribute("listOfProducts", all);
		
		RequestDispatcher rd = request.getRequestDispatcher("productlist2.jsp");
		rd.forward(request, response);
		
		/*response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");

		out.println("Here are all the products : <br>");
		out.println("<form action=addtocart method=post>");
		out.println("<table border=0>");
		out.println("<tr> <th>Id</th> <th>Name</th> <th>Price</th> <th>QoH</th> <th>Select</th></tr>");
		Iterator<Product> it = all.iterator();
		while (it.hasNext()) {
			Product p = it.next();
			out.println("<tr>");
			out.println("<td>" + p.getId() + "</td>");
			out.println("<td>" + p.getName() + "</td>");
			out.println("<td>" + p.getPrice() + "</td>");
			out.println("<td>" + p.getQoh() + "</td>");
			out.println("<td> <input type=checkbox name=pid value='" + p.getId() + "'></td>");
			out.println("</tr>");

		}
		out.println("</table>");
		out.println("<input type=submit value=Add Selected to Cart>");
		out.println("<a href=home.html> Back to Home page </a>");
		out.println("</body></html>");*/
	}

}

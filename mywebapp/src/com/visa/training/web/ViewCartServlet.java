package com.visa.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.visa.training.dal.ProductDAO;
import com.visa.training.domain.Product;


@WebServlet("/viewcart")
public class ViewCartServlet extends HttpServlet {
	
	ProductDAO dao = new ProductDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		HttpSession session = request.getSession();
		Set<Integer> ids = (Set<Integer>) session.getAttribute("selectedIds");
		if(ids == null){
			out.println("<h3>Your Cart is Empty!!</h3>");
		}else{
			List<Product> all = ids.stream().map(dao::findOne).collect(Collectors.toList()) ;
			out.println("<table border=0>");
			out.println("<tr> <th>Id</th> <th>Name</th> <th>Price</th> <th>QoH</th> </tr>");
			for (Product p : all) {
				out.println("<tr>");
				out.println("<td>" + p.getId() + "</td>");
				out.println("<td>" + p.getName() + "</td>");
				out.println("<td>" + p.getPrice() + "</td>");
				out.println("<td>" + p.getQoh() + "</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("<a href=home.html> Back to Home page </a>");
			out.println("</body></html>");
		}
	}

}

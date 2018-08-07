package com.visa.training.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.visa.training.domain.Product;
import com.visa.training.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public String productList(Map<String,Object> requestAttributes){
		List<Product> all = service.findAll();
		requestAttributes.put("products", all);
		return "showproducts";
	}

	@RequestMapping(value="/products/{id}",method=RequestMethod.GET)
	public String productDetail(Map<String,Object> requestAttributes,@PathVariable("id")int id){
		Product p = service.findOne(id);
		requestAttributes.put("product", p);
		return "showproductdetail";
	}
}











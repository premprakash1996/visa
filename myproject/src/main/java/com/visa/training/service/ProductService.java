package com.visa.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.visa.training.dal.MySqlProductDAO;
import com.visa.training.dal.ProductDAO;
import com.visa.training.domain.Product;
@Component("service")
@Transactional
public class ProductService {
	
	ProductDAO dao;// = new MySqlProductDAO();
	
	@Autowired
	public void setDao(ProductDAO dao) {
		this.dao = dao;
		System.out.println("[From within service. Get object of DAO]");
	}


	public void delete(int pid) {
		dao.delete(pid);

	}

	public void changePrice(int id, float newPrice) {
		dao.changePrice(id, newPrice);
	}

	public List<Product> findAll() {
		return dao.findAll();
	}

	public Product findOne(int id) {
		return dao.findOne(id);
	}

	public Product addNew(Product p) {
		if(p.getPrice() * p.getQoh() >= 10000){
			return dao.addNew(p);
		}else{
			throw new InsufficientValueException("The value (price*qty) must at least be 10000");
		}
	}
	

}

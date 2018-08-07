package com.visa.training.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.visa.training.domain.Product;


@Component
@Transactional
public class MySqlProductDAO implements ProductDAO {
	
	@Autowired
	EntityManager em;
	
	
	
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public void delete(int id){
		
	}
	
	@Override
	public void changePrice(int id,float newPrice){
		
	}
	
	@Override
	public List<Product> findAll(){
		
		Query q = em.createQuery("select p from Product p");
		List<Product> all = q.getResultList();
		return all;
	}
	
	@Override
	public Product findOne(int id){
		Product p = em.find(Product.class, id);
		return p;
	}
	
	
	@Override
	public Product addNew(Product p){
		em.persist(p);
		return p;
	}

}

package com.visa.training.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.visa.training.domain.Product;
import com.visa.training.util.JpaUtil;

public class ProductDAO {
	
	public void delete(int id){
		
	}
	
	public void changePrice(int id,float newPrice){
		
	}
	
	public List<Product> findAll(){
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		Query q = em.createQuery("select p from Product p");
		List<Product> all = q.getResultList();
		em.close();
		return all;
	}
	
	public Product findOne(int id){
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		Product p = em.find(Product.class, id);
		em.close();
		return p;
	}
	
	
	public Product addNew(Product p){
		EntityManagerFactory emf = JpaUtil.getEmf();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(p);
		
		tx.commit();
		em.close();
		return p;
	}

}

package com.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Product;

@Repository
public class ProductDao {

	@Autowired
	SessionFactory sessionFactory;

	public void insert(Product product) {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(product);
			transaction.commit();
			session.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	
	public List search() {

		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Product");

		List ls = q.list();
		session.close();

		return ls;
	}
	
	public void delete(Product product) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(product);
		transaction.commit();
		session.close();

	}

	public List edit(Product product) {

		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Product where id=" + product.getId());
		List ls = q.list();
		session.close();

		return ls;
	}
	

}


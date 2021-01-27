package com.mohamed.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mohamed.springdemo.entity.Customer;

@Repository // handle Exception and Translations
public class CustomerDAOimpl implements CustomerDAO {
	
	@Autowired // AutoWire with myDataSource bean which contain jdbcURL and Driver Class.
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomerList() {

		Session session = sessionFactory.getCurrentSession();

		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
		
		return query.getResultList();
	}

	@Override
	public void saveCustomer(Customer customer) {

		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		return session.get(Customer.class, id);
	}

	@Override
	public void deleteCustomer(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("delete from Customer where id=:customerId");
		
		query.setParameter("customerId", id);
		
		query.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomer(String searchCustomer) {
		Session session = sessionFactory.getCurrentSession();

		Query query = null;
		
		if(searchCustomer != null && searchCustomer.trim().length()> 0) {
			query = session.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
			
			query.setParameter("theName", "%" + searchCustomer.toLowerCase() + "%"); // wildCard mean %starts with (search tolower case)  ends with%
		}else {
			query = session.createQuery("from Customer", Customer.class);
		}
				
		return query.getResultList();
	}
	
}



package com.aurionpro.springdemo.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aurionpro.springdemo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		Session currentSession = sessionFactory.getCurrentSession();
		List<Customer> resultList = currentSession.createQuery("from Customer c order by c.id", Customer.class)
				.getResultList();
		return resultList;
	}

	@Override
	public Customer getCustomerByID(int customerID) {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(Customer.class, customerID);

	}

	@Override
	public void addCustomers(Customer customer) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(customer);
		
	}

	@Override
	public void deleteCustomerByID(int customerID) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query deleteCustomer = currentSession.createQuery("delete Customer c where c.id= :param1");
		deleteCustomer.setParameter("param1", customerID);

		deleteCustomer.executeUpdate();
		
	
	
	}

}

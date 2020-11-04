package com.cg.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import com.cg.entity.Customer;
import com.cg.exception.CustomerNotFoundException;


public class CustomerRepoImpl implements ICustomerRepo {

	EntityManager manager;
	public CustomerRepoImpl() {
		EntityManagerFactory f = Persistence.createEntityManagerFactory("JPA-PU");
		manager= f.createEntityManager();
	}
	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.persist(customer);
		manager.getTransaction().commit();
		return customer;

	}

	@Override
	public Customer updateCustomer(Customer customer) {
		manager.getTransaction().begin();
		manager.merge(customer);
		manager.getTransaction().commit();


		return customer;
	}

	@Override
	public Customer deleteCustomer(Customer customer) throws CustomerNotFoundException {
		// TODO Auto-generated method stub	
		if(customer==null) {
			throw new CustomerNotFoundException("Customer Not Found");
		}
		manager.getTransaction().begin();
		manager.remove(customer);
		manager.getTransaction().commit();
		return customer;

	}

	@Override
	public Customer fetchCustomer(int custId) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		Customer customer = manager.find(Customer.class,custId);
		if (customer == null) {
			throw new CustomerNotFoundException("Customer Not found");
		}
		return customer;

		
	}

	@Override
	public List<Customer> fetchAllCustomers() {
		// TODO Auto-generated method stub
		TypedQuery<Customer> query = manager.createQuery("from Customer", Customer.class);
		List<Customer> customerList = query.getResultList();
		return customerList;
	}

}
	
	



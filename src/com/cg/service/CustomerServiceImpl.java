package com.cg.service;

import java.util.List;

import com.cg.entity.Customer;
import com.cg.exception.CustomerNotFoundException;
import com.cg.repository.CustomerRepoImpl;
import com.cg.repository.ICustomerRepo;

public class CustomerServiceImpl implements ICustomerService {
	ICustomerRepo customerRepo;
	public CustomerServiceImpl() {
		customerRepo=new CustomerRepoImpl();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepo.saveCustomer(customer);
	}

	@Override
	public Customer editCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepo.updateCustomer(customer);
	}

	@Override
	public Customer removeCustomer(Customer customer) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		return customerRepo.deleteCustomer(customer);
	}

	@Override
	public Customer viewCustomer(int custid) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		return customerRepo.fetchCustomer(custid);
	}

	@Override
	public List<Customer> listAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepo.fetchAllCustomers();
	}

}

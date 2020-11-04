package com.cg.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cg.entity.Customer;
import com.cg.exception.CustomerNotFoundException;
import com.cg.service.CustomerServiceImpl;
import com.cg.service.ICustomerService;

public class CustomerServiceImplTest {
	private ICustomerService customerService;
	
	@Before
	public void init() {
		customerService = new CustomerServiceImpl();
	}

	@Test
	public void testAddCustomer() {
		Customer customer=new Customer();
		customer.setCustName("Rithvik");
		customer.setCity("Pune");
		customer.setEmail("rithvik@gmail.com");
		customer.setMobile("99999999999");
		customer.setPassword("rithvik");
		assertEquals(customer,customerService.addCustomer(customer));
	}

	@Test
	public void testEditCustomer() throws CustomerNotFoundException {
		Customer customer=new Customer();
		customer.setCustName("Rithvik");
		customer.setCity("Pune");
		customer.setEmail("rithvik@gmail.com");
		customer.setMobile("99999989999");
		customer.setPassword("rithvik");
		assertEquals(customer,customerService.editCustomer(customer));
	}

	@Test
	public void testRemoveCustomer() throws CustomerNotFoundException {
		Customer customer=new Customer();
		customer.setCustName("Rithvik");
		assertNotNull(customerService.removeCustomer(customer));
	}

	@Test(expected =CustomerNotFoundException.class)
	public void testViewCustomer() throws CustomerNotFoundException {
		assertNotNull(customerService.viewCustomer(5));
	}

	@Test
	public void testListAllCustomers() {
		List<Customer> customerList = new ArrayList<>();
		customerList =customerService.listAllCustomers();
		assertNotNull(customerList);
	}

}

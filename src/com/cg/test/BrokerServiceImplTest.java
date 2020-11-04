package com.cg.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cg.entity.Broker;
import com.cg.exception.BrokerNotFoundException;
import com.cg.service.BrokerServiceImpl;
import com.cg.service.IBrokerService;

public class BrokerServiceImplTest {
	private IBrokerService brokerService;
	
	@Before
	public void init() {
		brokerService=new BrokerServiceImpl();
	}

	@Test
	public void testAddBroker() {
		Broker broker=new Broker();
		broker.setBroName("Bhanu");
		broker.setCity("Pune");
		broker.setEmail("rithvik@gmail.com");
		broker.setMobile("99999999999");
		broker.setPassword("rithvik");
		assertEquals(broker,brokerService.addBroker(broker));
	}

	@Test
	public void testEditBroker() throws BrokerNotFoundException {
		Broker broker=new Broker();
		broker.setBroName("Rithvik");
		broker.setCity("Pune");
		broker.setEmail("rithvik@gmail.com");
		broker.setMobile("99999989999");
		broker.setPassword("rithvik");
		assertEquals(broker,brokerService.editBroker(broker));
	}

	@Test(expected = BrokerNotFoundException.class)
	public void testRemoveBroker() throws BrokerNotFoundException {
		assertNotNull(brokerService.removeBroker(2));
	}

	@Test(expected = BrokerNotFoundException.class)
	public void testViewBroker() throws BrokerNotFoundException {
		assertNotNull(brokerService.viewBroker(5));
	}

	@Test
	public void testListAllBrokers() {
		List<Broker> brokerList = new ArrayList<>();
		brokerList = brokerService.listAllBrokers();
		assertNotNull(brokerList);
	}

}

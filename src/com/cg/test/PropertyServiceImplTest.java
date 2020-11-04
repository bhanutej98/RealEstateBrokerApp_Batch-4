package com.cg.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cg.entity.Property;
import com.cg.exception.PropertyNotFoundException;
import com.cg.pojo.PropertyCriteria;
import com.cg.service.IPropertyService;
import com.cg.service.PropertyServiceImpl;

public class PropertyServiceImplTest {
	private IPropertyService propertyService;
	
	@Before
	public void init() {
		propertyService = new PropertyServiceImpl();
	}

	@Test
	public void testAddProperty() {
		Property property=new Property();
		property.setAddress("Bangalore");
		property.setAreaSqft(3000);
		property.setCity("Bangalore");
		property.setConfiguration("Flat");
		property.setOfferCost(60000);
		assertEquals(property,propertyService.addProperty(property));
	}



	@Test
	public void testEditProperty() {
		Property property=new Property();
		property.setAddress("Bangalore");
		property.setAreaSqft(4000);
		property.setCity("Bangalore");
		property.setConfiguration("Flat");
		property.setOfferCost(60000);
		assertEquals(property,propertyService.editProperty(property));

	}

	@Test(expected = PropertyNotFoundException.class)
	public void testRemoveProperty() throws PropertyNotFoundException {
		assertNotNull(propertyService.removeProperty(2));
	}

	@Test(expected = PropertyNotFoundException.class)
	public void testViewProperty() throws PropertyNotFoundException {
		assertNotNull(propertyService.viewProperty(55));
	}

	@Test
	public void testListAllProperties() {
		List<Property> listProperty= new ArrayList<>();
		listProperty=propertyService.listAllProperties();
		assertNotNull(listProperty);
	}

	@Test
	public void testListPropertyByCriteria() {
		PropertyCriteria criteria=new PropertyCriteria();
		criteria.setCity("Bangalore");
		criteria.setConfig("Flat");
		criteria.setMaxCost(500000);
		criteria.setMinCost(300);
		criteria.setOffer("Rent");
		List<Property> listProperty= new ArrayList<>();
		listProperty=propertyService.listPropertyByCriteria(criteria);
		assertNotNull(listProperty);
	}

}

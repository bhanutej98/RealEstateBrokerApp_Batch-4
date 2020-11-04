package com.cg.service;

import java.util.List;

import com.cg.entity.Property;
import com.cg.exception.PropertyNotFoundException;
import com.cg.pojo.PropertyCriteria;
import com.cg.repository.IPropertyRepo;
import com.cg.repository.PropertyRepoImpl;

public class PropertyServiceImpl implements IPropertyService{
	IPropertyRepo propertyRepo;
	
	/**
	 * 
	 */
	public PropertyServiceImpl() {
		propertyRepo=new PropertyRepoImpl();
	}

	@Override
	public Property addProperty(Property property) {
		// TODO Auto-generated method stub
		return propertyRepo.saveProperty(property);
	}

	@Override
	public Property editProperty(Property property) {
		// TODO Auto-generated method stub
		return propertyRepo.updateProperty(property);
	}

	@Override
	public Property removeProperty(int propId) throws PropertyNotFoundException {
		// TODO Auto-generated method stub
		return propertyRepo.deleteProperty(propId);
	}

	@Override
	public Property viewProperty(int propId) throws PropertyNotFoundException {
		return propertyRepo.fetchProperty(propId);
	}

	@Override
	public List<Property> listAllProperties() {
		return propertyRepo.fetchAllProperties();
	}

	@Override
	public List<Property> listPropertyByCriteria(PropertyCriteria criteria) {
		// TODO Auto-generated method stub
		return propertyRepo.fetchPropertyByCriteria(criteria);
	}

}

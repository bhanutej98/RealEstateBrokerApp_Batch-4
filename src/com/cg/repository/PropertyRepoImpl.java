package com.cg.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cg.entity.Property;
import com.cg.exception.PropertyNotFoundException;
import com.cg.pojo.PropertyCriteria;

public class PropertyRepoImpl implements IPropertyRepo {
	EntityManager manager;
	public PropertyRepoImpl() {
		EntityManagerFactory f = Persistence.createEntityManagerFactory("JPA-PU");
		manager= f.createEntityManager();

	}

	@Override
	public Property saveProperty(Property property) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.persist(property);
		manager.getTransaction().commit();
		return property;
	
	}

	@Override
	public Property updateProperty(Property property) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.merge(property);
		manager.getTransaction().commit();
		return property;

	}

	@Override
	public Property deleteProperty(int propId) throws PropertyNotFoundException {
		// TODO Auto-generated method stub
		Property property=manager.find(Property.class,propId);
		if(property==null) {
			throw new PropertyNotFoundException("Property Not Found");
		}
		manager.getTransaction().begin();
		manager.remove(property);
		manager.getTransaction().commit();
		return property;

	}

	@Override
	public Property fetchProperty(int propId) throws PropertyNotFoundException {
		Property property = manager.find(Property.class,propId);
		if (property == null) {
			throw new PropertyNotFoundException("Property Not found");
		}
		return property;

	}

	@Override
	public List<Property> fetchAllProperties() {
		TypedQuery<Property> query = manager.createQuery("from Property", Property.class);
		List<Property> properties = query.getResultList();
		return properties;
	}

	@Override
	public List<Property> fetchPropertyByCriteria(PropertyCriteria criteria) {
		// TODO Auto-generated method stub
		String qStr="SELECT property FROM Property property WHERE property.configuration=:config OR"
				+ " property.offerType=:offer OR property.city=:city OR (property.offerCost BETWEEN :minCost AND :maxCost)";
		TypedQuery<Property> query = manager.createQuery(qStr, Property.class);
		query.setParameter("config", criteria.getConfig());
		query.setParameter("offer", criteria.getOffer());
		query.setParameter("city", criteria.getCity());
		query.setParameter("minCost", criteria.getMinCost());
		query.setParameter("maxCost", criteria.getMaxCost());
		
		List<Property> properties=query.getResultList();
		return properties;
		
	}
	
	

}

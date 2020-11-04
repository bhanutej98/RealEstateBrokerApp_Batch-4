package com.cg.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.cg.entity.Deal;



public class DealRepositoryImpl implements IDealRepo {
	EntityManager manager;
	public DealRepositoryImpl() {
		EntityManagerFactory f = Persistence.createEntityManagerFactory("JPA-PU");
		manager= f.createEntityManager();
	}

	@Override
	public Deal saveDeal(Deal deal) {
		manager.getTransaction().begin();
//		property=manager.find(Property.class,property.getPropId());
//		customer=manager.find(Customer.class,customer.getCustId());
//		manager.persist(property);
//		manager.persist(customer);
		manager.persist(deal);
		manager.getTransaction().commit();
		return deal;
	}

	@Override
	public List<Deal> fetchAllDeals() {
		TypedQuery<Deal> query = manager.createQuery("from Deal", Deal.class);
		List<Deal> Deals = query.getResultList();
		return Deals;
	}

}

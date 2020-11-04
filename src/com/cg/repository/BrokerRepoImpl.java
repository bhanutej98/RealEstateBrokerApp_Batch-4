package com.cg.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import com.cg.entity.Broker;
import com.cg.exception.BrokerNotFoundException;


public class BrokerRepoImpl implements IBrokerRepo {

	
		EntityManager manager;
		public BrokerRepoImpl() {
			EntityManagerFactory f = Persistence.createEntityManagerFactory("JPA-PU");
			manager= f.createEntityManager();
		}
	@Override
	public Broker saveBroker(Broker bro) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.persist(bro);
		manager.getTransaction().commit();
		return bro;

	}

	@Override
	public Broker updateBroker(Broker bro) {
		manager.getTransaction().begin();
		manager.merge(bro);
		manager.getTransaction().commit();


		return bro;
	}

	@Override
	public Broker deleteBroker(int broId) throws BrokerNotFoundException {
		// TODO Auto-generated method stub
		Broker broker=manager.find(Broker.class,broId);
		if(broker==null) {
			throw new BrokerNotFoundException("Broker Not Found");
		}
		manager.getTransaction().begin();
		manager.remove(broker);
		manager.getTransaction().commit();
		return broker;

	}

	@Override
	public Broker fetchBroker(int broId) throws BrokerNotFoundException {
		// TODO Auto-generated method stub
		Broker broker = manager.find(Broker.class,broId);
		if (broker == null) {
			throw new BrokerNotFoundException("Broker Not found");
		}
		return broker;

		
	}

	@Override
	public List<Broker> fetchAllBrokers() {
		// TODO Auto-generated method stub
		TypedQuery<Broker> query = manager.createQuery("from Broker", Broker.class);
		List<Broker> brokerList = query.getResultList();
		return brokerList;
	}
	
	

}

package com.cg.service;

import java.util.List;

import com.cg.entity.Broker;
import com.cg.exception.BrokerNotFoundException;
import com.cg.repository.BrokerRepoImpl;
import com.cg.repository.IBrokerRepo;


public class BrokerServiceImpl implements IBrokerService {
	IBrokerRepo brokerRepo;
	public BrokerServiceImpl() {
		brokerRepo=new BrokerRepoImpl();
	}

	@Override
	public Broker addBroker(Broker bro) {
		// TODO Auto-generated method stub
		return brokerRepo.saveBroker(bro);
	}

	@Override
	public Broker editBroker(Broker bro) throws BrokerNotFoundException {
		// TODO Auto-generated method stub
		return brokerRepo.updateBroker(bro);
	}

	@Override
	public Broker removeBroker(int broId) throws BrokerNotFoundException {
		// TODO Auto-generated method stub
		return brokerRepo.deleteBroker(broId);
	}

	@Override
	public Broker viewBroker(int broId) throws BrokerNotFoundException {
		// TODO Auto-generated method stub
		return brokerRepo.fetchBroker(broId);
	}

	@Override
	public List<Broker> listAllBrokers() {
		// TODO Auto-generated method stub
		return brokerRepo.fetchAllBrokers();
	}

}

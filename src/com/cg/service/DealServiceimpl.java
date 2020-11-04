package com.cg.service;

import java.util.List;
import com.cg.entity.Deal;
import com.cg.repository.DealRepositoryImpl;
import com.cg.repository.IDealRepo;

public class DealServiceimpl implements IDealService {
     IDealRepo dealRepo;
     
     
	public DealServiceimpl() {
		dealRepo=new DealRepositoryImpl();
		
	}

	@Override
	public Deal addDeal(Deal deal) {
		
		return dealRepo.saveDeal(deal);
	}

	@Override
	public List<Deal> listAllDeals() {
		
		return dealRepo.fetchAllDeals();
	}

}

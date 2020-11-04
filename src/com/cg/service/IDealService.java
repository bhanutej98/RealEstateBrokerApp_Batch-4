package com.cg.service;

import java.util.List;
import com.cg.entity.Deal;


public interface IDealService {

	public Deal addDeal(Deal deal);
	
	public List<Deal> listAllDeals();
}

package com.cg.repository;

import java.util.List;
import com.cg.entity.Deal;


public interface IDealRepo {

	public Deal saveDeal(Deal deal);
	
	public List<Deal> fetchAllDeals();
	
}

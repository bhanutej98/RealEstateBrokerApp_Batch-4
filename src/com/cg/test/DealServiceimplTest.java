package com.cg.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cg.entity.Deal;
import com.cg.service.DealServiceimpl;
import com.cg.service.IDealService;

public class DealServiceimplTest {
	private IDealService dealService;
	
	@Before
	public void init() {
		dealService=new DealServiceimpl();
	}
	@Test
	public void testAddDeal() {
		Deal deal = new Deal();
		deal.setDealCost(500000);
		assertEquals(deal,dealService.addDeal(deal));
	}

	@Test
	public void testListAllDeals() {
		List<Deal> dealList=new ArrayList<>();
		dealList=dealService.listAllDeals();
		assertNotNull(dealList);
 	}

}

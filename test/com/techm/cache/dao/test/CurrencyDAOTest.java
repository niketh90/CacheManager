package com.techm.cache.dao.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techm.cache.dao.CurrencyDAO;
import com.techm.cache.dao.impl.CurrencyDAOImpl;
import com.techm.cache.dto.Currency;
import com.techm.cache.main.CacheManager;
import com.techm.cache.main.GenerateObjects;

public class CurrencyDAOTest {
	@Before
	public void init(){
		GenerateObjects gen=new GenerateObjects();
		gen.createCurrency();		
	}
	
	@Test
	public void CurrencyTest1(){
		CurrencyDAO dao=new CurrencyDAOImpl();
		Object testObj=dao.getCurrency(1L);
		Assert.assertNotNull(testObj);
	}
	
	@Test
	public void CurrencyTest2(){
		CurrencyDAO dao=new CurrencyDAOImpl();
		Object testObj=dao.getCurrency(9L);
		Assert.assertNull(testObj);
	}
	
	@Test
	public void CurrencyTest3(){
		CurrencyDAO dao=new CurrencyDAOImpl();
		Object testObj=dao.getCurrency(null);
		Assert.assertNull(testObj);
	}
	
	@Test
	public void CurrencyTest4(){
		CurrencyDAO dao= new CurrencyDAOImpl();
		dao.getCurrency(3L);
		Assert.assertTrue(CacheManager.getInstance().existInCache(3L,Currency.class));
	}
	
	@After
	public void destroy(){
		CurrencyDAOImpl CurrencyDAOImpl=new CurrencyDAOImpl();
		CurrencyDAOImpl.getCurrencyDataMap().clear();
		CacheManager.getInstance().cleanCache();
	}
}

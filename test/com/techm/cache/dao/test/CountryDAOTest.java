package com.techm.cache.dao.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techm.cache.dao.CountryDAO;
import com.techm.cache.dao.impl.CountryDAOImpl;
import com.techm.cache.dto.Country;
import com.techm.cache.main.CacheManager;
import com.techm.cache.main.GenerateObjects;

public class CountryDAOTest {

	
	@Before
	public void init(){
		GenerateObjects gen=new GenerateObjects();
		gen.createCountry();		
	}
	
	@Test
	public void CountryTest1(){
		CountryDAO dao=new CountryDAOImpl();
		Object testObj=dao.getCountry(1L);
		Assert.assertNotNull(testObj);
	}
	
	@Test
	public void CountryTest2(){
		CountryDAO dao=new CountryDAOImpl();
		Object testObj=dao.getCountry(9L);
		Assert.assertNull(testObj);
	}
	
	@Test
	public void CountryTest3(){
		CountryDAO dao=new CountryDAOImpl();
		Object testObj=dao.getCountry(null);
		Assert.assertNull(testObj);
	}
	
	@Test
	public void CountryTest4(){
		CountryDAO dao= new CountryDAOImpl();
		dao.getCountry(3L);
		Assert.assertTrue(CacheManager.getInstance().existInCache(3L,Country.class));
	}
	
	@After
	public void destroy(){
		CountryDAOImpl countryDAOImpl=new CountryDAOImpl();
		countryDAOImpl.getCountryDataMap().clear();
		CacheManager.getInstance().cleanCache();
	}
}

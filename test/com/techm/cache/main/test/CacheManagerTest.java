package com.techm.cache.main.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techm.cache.dao.impl.CurrencyDAOImpl;
import com.techm.cache.dto.Currency;
import com.techm.cache.main.CacheManager;
import com.techm.cache.main.GenerateObjects;

public class CacheManagerTest {

	@Before
	public void init(){
		GenerateObjects gen=new GenerateObjects();
		gen.createCurrency();
		CacheManager.getInstance().addToCache(1L,(CurrencyDAOImpl.getCurrencyDataMap()).get(1L));
	}
	
	@Test
	public void CacheTest1(){
		Assert.assertTrue(CacheManager.getInstance().existInCache(1L, Currency.class));
	}
	
	@Test
	public void CacheTest2(){
		Assert.assertFalse(CacheManager.getInstance().existInCache(2L, Currency.class));
	}
	
	@Test
	public void CacheTest3(){
		Assert.assertEquals(null,CacheManager.getInstance().addToCache(2L, (CurrencyDAOImpl.getCurrencyDataMap()).get(2L)));
	}
	
	@Test
	public void CacheTest4(){
		CacheManager.getInstance().addToCache(3L,(CurrencyDAOImpl.getCurrencyDataMap()).get(3L));
		Assert.assertEquals((CurrencyDAOImpl.getCurrencyDataMap()).get(3L),CacheManager.getInstance().addToCache(3L, (CurrencyDAOImpl.getCurrencyDataMap()).get(3L)));
	}
	
	@Test
	public void CacheTest5(){
		Object obj=CacheManager.getInstance().getCacheObject(1L, Currency.class);
		Assert.assertNotNull(obj);
	}
	
	@Test
	public void CacheTest6(){
		Object obj=CacheManager.getInstance().getCacheObject(8L, Currency.class);
		Assert.assertNull(obj);
	}
}

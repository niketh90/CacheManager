package com.techm.cache.dao.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techm.cache.dao.HolidayDAO;
import com.techm.cache.dao.impl.HolidayDAOImpl;
import com.techm.cache.dto.Holiday;
import com.techm.cache.main.CacheManager;
import com.techm.cache.main.GenerateObjects;

public class HolidayDAOTest {
	@Before
	public void init(){
		GenerateObjects gen=new GenerateObjects();
		gen.createHoliday();		
	}
	
	@Test
	public void HolidayTest1(){
		HolidayDAO dao=new HolidayDAOImpl();
		Object testObj=dao.getHoliday(1L);
		Assert.assertNotNull(testObj);
	}
	
	@Test
	public void HolidayTest2(){
		HolidayDAO dao=new HolidayDAOImpl();
		Object testObj=dao.getHoliday(9L);
		Assert.assertNull(testObj);
	}
	
	@Test
	public void HolidayTest3(){
		HolidayDAO dao=new HolidayDAOImpl();
		Object testObj=dao.getHoliday(null);
		Assert.assertNull(testObj);
	}
	
	@Test
	public void HolidayTest4(){
		HolidayDAO dao= new HolidayDAOImpl();
		dao.getHoliday(3L);
		Assert.assertTrue(CacheManager.getInstance().existInCache(3L,Holiday.class));
	}
	
	@After
	public void destroy(){
		HolidayDAOImpl HolidayDAOImpl=new HolidayDAOImpl();
		HolidayDAOImpl.getHolidayDataMap().clear();
		CacheManager.getInstance().cleanCache();
	}
}

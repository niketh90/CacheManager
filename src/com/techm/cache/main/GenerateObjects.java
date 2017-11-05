package com.techm.cache.main;

import java.util.Date;

import com.techm.cache.dao.impl.CountryDAOImpl;
import com.techm.cache.dao.impl.CurrencyDAOImpl;
import com.techm.cache.dao.impl.HolidayDAOImpl;
import com.techm.cache.dto.Country;
import com.techm.cache.dto.Currency;
import com.techm.cache.dto.Holiday;

/**
 * Data initializer.
 * @author Niks
 *
 */
public class GenerateObjects {

	public void createCountry()
	{
		Country count1=new Country(1L,"IND","India",0,new Date(),9123);
		Country count2=new Country(2L,"AUS","Australia",0,new Date(),9123);
		Country count3=new Country(3L,"CAN","Canada",0,new Date(),9123);
		Country count4=new Country(4L,"US","USA",0,new Date(),9123);
		Country count5=new Country(5L,"NDH","Netherlands",0,new Date(),9123);
		Country count6=new Country(6L,"NZ","New Zealand",0,new Date(),9123);
		CountryDAOImpl dao=new CountryDAOImpl();
		dao.getCountryDataMap().put(1L,count1);
		dao.getCountryDataMap().put(2L,count2);
		dao.getCountryDataMap().put(3L,count3);
		dao.getCountryDataMap().put(4L,count4);
		dao.getCountryDataMap().put(5L,count5);
		dao.getCountryDataMap().put(6L,count6);
	}
	
	public void createCurrency()
	{
		Currency curr1=new Currency(1L,"RE","Rupee","Rs", 0,new Date(), 1234);
		Currency curr2=new Currency(2L,"US","Dollar","USD", 0,new Date(), 1234);
		Currency curr3=new Currency(3L,"AU","AU Dollar","AUSD", 0,new Date(), 1234);
		Currency curr4=new Currency(4L,"CN","Yen","YN", 0,new Date(), 1234);
		Currency curr5=new Currency(5L,"DN","Dinar","DR", 0,new Date(), 1234);
		Currency curr6=new Currency(6L,"CD","CA Dollar","CAD", 0,new Date(), 1234);
		CurrencyDAOImpl dao=new CurrencyDAOImpl();
		dao.getCurrencyDataMap().put(1L, curr1);
		dao.getCurrencyDataMap().put(2L, curr2);
		dao.getCurrencyDataMap().put(3L, curr3);
		dao.getCurrencyDataMap().put(4L, curr4);
		dao.getCurrencyDataMap().put(5L, curr5);
		dao.getCurrencyDataMap().put(6L, curr6);
	}
	
	public void createHoliday(){
		Holiday hol1=new Holiday(1L,"NY","New Year",0,new Date(2017,01,01), new Date(),9898);
		Holiday hol2=new Holiday(2L,"TG","Thanks Giving",0,new Date(2017,07,05), new Date(),9898);
		Holiday hol3=new Holiday(3L,"CM","Christmas",0,new Date(2017,12,25), new Date(),9898);
		HolidayDAOImpl dao=new HolidayDAOImpl();	
		dao.getHolidayDataMap().put(1L,hol1);
		dao.getHolidayDataMap().put(2L,hol2);
		dao.getHolidayDataMap().put(3L,hol3);
		
	}
}



package com.techm.cache.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.techm.cache.dao.CountryDAO;
import com.techm.cache.dto.Country;
import com.techm.cache.main.CacheManager;

public class CountryDAOImpl implements CountryDAO{

	private static Map<Long,Country> countryDataMap=new HashMap<Long,Country>();
	
	@Override
	public Country getCountry(Long id) {
		CacheManager.getInstance();
		if(CacheManager.getInstance().existInCache(id, Country.class)){
			return (Country) CacheManager.getInstance().getCacheObject(id, Country.class);
		}
		Country countObj=countryDataMap.get(id);
		if(null!=countObj){
			CacheManager.getInstance().addToCache(id, countObj);
		}
		return countObj;
	}

	public Map<Long, Country> getCountryDataMap() {
		return countryDataMap;
	}

	
}

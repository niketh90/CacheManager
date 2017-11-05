package com.techm.cache.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.techm.cache.dao.CurrencyDAO;
import com.techm.cache.dto.Currency;
import com.techm.cache.main.CacheManager;

public class CurrencyDAOImpl implements CurrencyDAO {

	private static Map<Long,Currency> currencyDataMap=new HashMap<Long,Currency>();
	
	@Override
	public Currency getCurrency(Long id) {
		if(CacheManager.getInstance().existInCache(id, Currency.class)){
			return (Currency) CacheManager.getInstance().getCacheObject(id, Currency.class);
		}
		Currency currObj=currencyDataMap.get(id);
		if(null!=currObj){
			CacheManager.getInstance().addToCache(id, currObj);
		}
		return currObj;
	}


	public static Map<Long, Currency> getCurrencyDataMap() {
		return currencyDataMap;
	}

	
	

}

package com.techm.cache.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.techm.cache.dao.HolidayDAO;
import com.techm.cache.dto.Holiday;
import com.techm.cache.main.CacheManager;

public class HolidayDAOImpl implements HolidayDAO {
	
	private static Map<Long,Holiday> holidayDataMap=new HashMap<Long,Holiday>();

	@Override
	public Holiday getHoliday(Long id) {
		if(CacheManager.getInstance().existInCache(id, Holiday.class)){
			return (Holiday) CacheManager.getInstance().getCacheObject(id, Holiday.class);
		}
		Holiday holObj=holidayDataMap.get(id);
		if(null!=holObj){
			CacheManager.getInstance().addToCache(id, holObj);
		}
		return holObj;
	}

	public Map<Long, Holiday> getHolidayDataMap() {
		return holidayDataMap;
	}


}

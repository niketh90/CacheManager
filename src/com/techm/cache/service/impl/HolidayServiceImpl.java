package com.techm.cache.service.impl;

import com.techm.cache.dao.HolidayDAO;
import com.techm.cache.dao.impl.HolidayDAOImpl;
import com.techm.cache.dto.Holiday;
import com.techm.cache.service.HolidayService;

public class HolidayServiceImpl implements HolidayService {

	HolidayDAO holidayDAO=new HolidayDAOImpl();
	@Override
	public Holiday getHoliday(Long id) {
		return holidayDAO.getHoliday(id);
	}

}

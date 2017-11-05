package com.techm.cache.service.impl;

import com.techm.cache.dao.CountryDAO;
import com.techm.cache.dao.impl.CountryDAOImpl;
import com.techm.cache.dto.Country;
import com.techm.cache.service.CountryService;

public class CountryServiceImpl implements CountryService{

	private CountryDAO countryDao= new CountryDAOImpl();
	@Override
	public Country getCountry(Long id) {
		return countryDao.getCountry(id);
	}

}

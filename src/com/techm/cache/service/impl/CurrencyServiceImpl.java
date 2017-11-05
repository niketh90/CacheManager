package com.techm.cache.service.impl;

import com.techm.cache.dao.CurrencyDAO;
import com.techm.cache.dao.impl.CurrencyDAOImpl;
import com.techm.cache.dto.Currency;
import com.techm.cache.service.CurrencyService;

public class CurrencyServiceImpl implements CurrencyService{

	CurrencyDAO currDAO= new CurrencyDAOImpl();
	@Override
	public Currency getCurrency(Long id) {
		return currDAO.getCurrency(id);
	}

}

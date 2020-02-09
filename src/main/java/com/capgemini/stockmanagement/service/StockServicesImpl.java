package com.capgemini.stockmanagement.service;

import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.stockmanagement.dao.StocksDao;
import com.capgemini.stockmanagement.dto.StockInfoBean;
import com.capgemini.stockmanagement.exception.StockException;
@Service
public class StockServicesImpl implements StockServices{

	@Autowired
	StocksDao dao;
	@Override
	public boolean addStock(StockInfoBean bean) {
		try {
		if(dao.findStockByName(bean.getCompanyName()).getCompanyId()==0) {
			try{if(dao.addStock(bean)) {
				return true;
			}
		}catch (Exception e) {
			throw new StockException("Something Went Wrong!!!");
		}
			}
		}catch (Exception e) {
			throw new StockException("Company Already Exists!!!!");
		}
		return false;
	}

	@Override
	public boolean deleteStock(int id) {

		
		return false;
	}

	@Override
	public boolean updateStock(StockInfoBean bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public StockInfoBean findStock(int beanId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockInfoBean findStockByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StockInfoBean> findAllStocks() throws LoginException {

		try {
		return	dao.findAllStocks();
		}catch (Exception e) {
		throw new LoginException("NO Records Found!!!");
		}
		
	}

}

package com.capgemini.stockmanagement.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.stockmanagement.dto.StockInfoBean;

@Repository
public interface StocksDao {
	

	public boolean addStock(StockInfoBean bean);
	public boolean deleteStock(int id);
	public boolean updateStock(StockInfoBean bean);
	public StockInfoBean findStock(int beanId);
	public StockInfoBean findStockByName(String name);
	public StockInfoBean findStockByCompanyId(int id);
	public List<StockInfoBean> findAllStocks();
	
}

package com.capgemini.stockmanagement.service;

import java.util.Date;
import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.stockmanagement.dao.StocksDao;
import com.capgemini.stockmanagement.dao.TransactionDao;
import com.capgemini.stockmanagement.dto.StockInfoBean;
import com.capgemini.stockmanagement.dto.TransactionBean;
import com.capgemini.stockmanagement.dto.TransactionDetails;
@Service
public class TransactionServicesImpl implements TransactionServices {

	@Autowired
	TransactionDao dao;
	@Autowired
	StocksDao stockDao;
	
	@Override
	public boolean addTransaction(StockInfoBean bean,int id) throws LoginException {

		try {
			TransactionBean transactionBean=new TransactionBean();
			transactionBean.setAmount(bean.getCurrentPrice()*bean.getNoOfStocks());
			transactionBean.setCompanyId(bean.getCompanyId());
			transactionBean.setDate(new Date());
			transactionBean.setInvestorId(id);
			transactionBean.setNoOfShares(bean.getNoOfStocks());
			dao.addTransaction(transactionBean);
			bean.setAvailableStocks(bean.getAvailableStocks()-bean.getNoOfStocks());
			bean.setNoOfStocks(0);
			stockDao.updateStock(bean);
			
			return true;
		
		}catch (Exception e) {
			throw new LoginException(e.getMessage());
		}
	}

	

	@Override
	public List<TransactionBean> getAllTranscation() throws LoginException {

	try {
		List<TransactionBean> beans=dao.getAllTranscation();
		return beans;
	}
	catch (Exception e) {
		throw new LoginException("No Entries Found!!!");
	}
	}

	@Override
	public List<TransactionBean> getAllTransactionOfInvestor(int id) throws LoginException {
		try {
			List<TransactionBean> beans=dao.getAllTransactionOfInvestor(id);
			return beans;
		}
		catch (Exception e) {
			throw new LoginException("No Entries Found!!!");
		}
	}

	@Override
	public List<TransactionBean> getAllTransactionOfCompany(int id) throws LoginException {
		try {
			List<TransactionBean> beans=dao.getAllTransactionOfCompany(id);
			return beans;
		}
		catch (Exception e) {
			throw new LoginException("No Entries Found!!!");
		}
	}

	@Override
	public TransactionBean findTransaction(int id) throws LoginException {
		try {
			TransactionBean beans=dao.findTransaction(id);
			return beans;
		}
		catch (Exception e) {
			throw new LoginException("No Entries Found!!!");
		}
	}



	@Override
	public boolean deleteTransaction(TransactionDetails details) throws LoginException {
		try {
			TransactionBean bean=dao.findTransaction(details.getTransactionId());
			if(dao.deleteTransaction(details.getTransactionId()))
			{
				StockInfoBean stockBean=stockDao.findStockByCompanyId(details.getCompanyId());
				stockBean.setAvailableStocks(stockBean.getAvailableStocks()+bean.getNoOfShares());
				stockDao.updateStock(stockBean);
				return true;
			}
			else {
				return false;
			} 
		}catch (Exception e) {
		
		throw new LoginException(e.getMessage());
		}
	
	}
	
	
	

}

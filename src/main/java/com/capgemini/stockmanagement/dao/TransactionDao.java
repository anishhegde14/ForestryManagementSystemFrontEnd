package com.capgemini.stockmanagement.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.stockmanagement.dto.StockInfoBean;
import com.capgemini.stockmanagement.dto.TransactionBean;

@Repository
public interface TransactionDao {

	
	public boolean addTransaction(TransactionBean bean);
	public boolean deleteTransaction(int id);
	public TransactionBean findTransaction(int id); 
	public List<TransactionBean> getAllTranscation();
	public List<TransactionBean> getAllTransactionOfInvestor(int id);
	public List<TransactionBean> getAllTransactionOfCompany(int id);
}

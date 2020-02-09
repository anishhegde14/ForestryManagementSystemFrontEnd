package com.capgemini.stockmanagement.service;

import java.util.List;

import javax.security.auth.login.LoginException;

import com.capgemini.stockmanagement.dto.StockInfoBean;
import com.capgemini.stockmanagement.dto.TransactionBean;
import com.capgemini.stockmanagement.dto.TransactionDetails;

public interface TransactionServices {
	public boolean addTransaction(StockInfoBean bean,int id) throws LoginException;
	public boolean deleteTransaction(TransactionDetails details) throws LoginException;
	public List<TransactionBean> getAllTranscation() throws LoginException;
	public List<TransactionBean> getAllTransactionOfInvestor(int id) throws LoginException;
	public List<TransactionBean> getAllTransactionOfCompany(int id) throws LoginException;
	public TransactionBean findTransaction(int id) throws LoginException;
}

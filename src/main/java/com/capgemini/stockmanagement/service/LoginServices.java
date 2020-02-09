package com.capgemini.stockmanagement.service;


import com.capgemini.stockmanagement.dto.LoginBean;
import com.capgemini.stockmanagement.exception.LoginException;

public interface LoginServices {
	
	
	
	public LoginBean findCredentials(LoginBean bean) throws LoginException;
	public boolean add(LoginBean bean) throws LoginException;
	public boolean delete(int id) throws LoginException;
	public boolean update(LoginBean bean) throws LoginException;
	public int auth(LoginBean bean) throws LoginException;
}


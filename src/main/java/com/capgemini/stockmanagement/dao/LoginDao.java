package com.capgemini.stockmanagement.dao;

import com.capgemini.stockmanagement.dto.LoginBean;

public interface LoginDao {

	
	public LoginBean findCredentials(LoginBean bean);
	public boolean add(LoginBean bean);
	public boolean delete(int id);
	public boolean update(LoginBean bean);
	public LoginBean findAccount(int id);
}

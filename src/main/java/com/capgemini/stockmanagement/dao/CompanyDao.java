package com.capgemini.stockmanagement.dao;

import java.util.List;

import com.capgemini.stockmanagement.dto.CompanyBean;

public interface CompanyDao {

	
	public boolean addCompany(CompanyBean bean);
	public boolean deleteCompany(int id);
	public CompanyBean findCompany(int id);
	public List<CompanyBean> getAllCompany();
	public CompanyBean findCompanyByName(String name);
}

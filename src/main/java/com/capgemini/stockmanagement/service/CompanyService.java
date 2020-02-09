package com.capgemini.stockmanagement.service;

import java.util.List;

import com.capgemini.stockmanagement.dto.CompanyBean;

public interface CompanyService {
	
	public boolean addCompany(CompanyBean bean);
	public boolean deleteCompany(int id);
	public CompanyBean findCompany(int id);
	public List<CompanyBean> getAllCompany();
	public CompanyBean findCompanyByName(String name);
}

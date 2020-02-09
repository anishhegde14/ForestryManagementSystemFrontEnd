package com.capgemini.stockmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.stockmanagement.dao.CompanyDao;
import com.capgemini.stockmanagement.dto.CompanyBean;
import com.capgemini.stockmanagement.exception.CompanyException;
@Service
public class CompanyServiceImpl implements CompanyService{
	@Autowired
	CompanyDao dao;
	
	@Override
	public boolean addCompany(CompanyBean bean) {
		
		try{
			if(findCompanyByName(bean.getCompanyName()) == null) {
			
			if(dao.addCompany(bean)) {
			return true;
			}
		return false;	
		}
		
		}catch (Exception e) {
					throw new CompanyException("Company Already Exists");
		}
		return false;	
	}
	@Override
	public boolean deleteCompany(int id) {

	try {	if(findCompany(id)!=null) {
			if(dao.deleteCompany(id)) {
				return true;
			}
			else {
				return false;
			}
		}
	}
catch (Exception e) {
			throw new CompanyException("Company Doesnt Exists");
		}
	return false;
		
	}

	@Override
	public CompanyBean findCompany(int id) {

		try {
			CompanyBean bean=dao.findCompany(id);
			return bean;
		}
		catch (Exception e) {
			throw  new CompanyException("Company Not Found");
		}
		
	}

	@Override
	public List<CompanyBean> getAllCompany() {
		try {
		List<CompanyBean> beans=dao.getAllCompany();
		return beans;
		}
		catch (Exception e) {
			throw new CompanyException("No Companies Found Please Contact The Admin For Furth"
					+ "er Queries");
		}
	}

	@Override
	public CompanyBean findCompanyByName(String name) {
		try {
			CompanyBean bean=dao.findCompanyByName("name");
			return bean;
		}
		catch (Exception e) {
			throw new CompanyException("Company Not Found !!!! Please enter Valid Name");
		}
	}
	
	

}

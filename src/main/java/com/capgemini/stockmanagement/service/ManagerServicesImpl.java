package com.capgemini.stockmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.stockmanagement.dao.ManagerDao;
import com.capgemini.stockmanagement.dto.ManagerBean;
import com.capgemini.stockmanagement.exception.ManagerException;
@Service
public class ManagerServicesImpl implements ManagerServices {
	@Autowired
	private ManagerDao dao;
	private LoginServices services=new LoginServicesImpl();
	@Override
	public boolean addManager(ManagerBean bean) {
	try {

		
		
		if(findManager(bean.getId())==null) {
			dao.addManager(bean);
			return true;
		}
	}
	catch (Exception e) {
		throw new ManagerException("Manager Account Already Exists!!!!!");
	}
		return false;
	}

	@Override
	public boolean deleteManager(int id) {

		try {
			if(findManager(id).getId()!=0) {
				dao.deleteManager(id);
				return true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ManagerException("Manager Account Doesn't Exists!!!!!");
		}
			return false;
			
		}

	@Override
	public ManagerBean findManager(int id) {

		try {
		ManagerBean bean=dao.findManager(id);
		System.out.println(bean);
		return bean;
		}
		catch (Exception e) {

		throw new ManagerException("No Manager Found!!");
		}
		
		
	}

	@Override
	public ManagerBean findManagerByName(String name) {

		try {
			ManagerBean bean=dao.findManagerByName(name);
			return bean;
		}
		catch (Exception e) {

		throw new ManagerException("No Manager Found!!!!!!");
		}
	}

	@Override
	public List<ManagerBean> findAllManager() {

		try {
			return dao.findAllManager();
		}
		catch (Exception e) {
			throw new ManagerException("NO MANAGERS ARE PRESENT!!! Please add any");
		}
		
	}

	@Override
	public boolean updateManager(ManagerBean bean) {
		try {
			if(findManager(bean.getId()).getId()!=0) {
				if(dao.updateManager(bean)) {
					return true;
				}
			}
		}catch (Exception e) {
			
		throw new ManagerException(e.getMessage());
		}
		
		return false;
	}

}

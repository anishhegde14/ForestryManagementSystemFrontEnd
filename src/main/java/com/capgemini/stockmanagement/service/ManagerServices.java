package com.capgemini.stockmanagement.service;

import java.util.List;

import com.capgemini.stockmanagement.dto.ManagerBean;

public interface ManagerServices  {

	public boolean addManager(ManagerBean bean);
	public boolean deleteManager(int id);
	public ManagerBean findManager(int id);
	public ManagerBean findManagerByName(String name);
	public List<ManagerBean> findAllManager();
	public boolean updateManager(ManagerBean bean);
}

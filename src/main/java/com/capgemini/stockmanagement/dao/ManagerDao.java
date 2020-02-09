package com.capgemini.stockmanagement.dao;

import java.util.List;


import com.capgemini.stockmanagement.dto.ManagerBean;

public interface ManagerDao {

	public boolean addManager(ManagerBean bean);
	public boolean deleteManager(int id);
	public ManagerBean findManager(int id);
	public ManagerBean findManagerByName(String name);
	public List<ManagerBean> findAllManager();
	public boolean updateManager(ManagerBean bean);
}

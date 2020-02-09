package com.capgemini.stockmanagement.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.stockmanagement.dto.LoginBean;
import com.capgemini.stockmanagement.dto.ManagerBean;

@SpringBootTest
public class ManagerServiceImplTest {

	
	@Autowired
	ManagerServices dao;
	
	
	
//	@Test
//	void addManager()
//	{
//		ManagerBean bean=new ManagerBean();
//		bean.setId(8);
//		bean.setAddress("jsjjd");
//		bean.setCompanyName("sad");
//		bean.setEmailId("adsd");
//		bean.setManagerName("ada");
//		
//		assertTrue(dao.addManager(bean));
//	}
	@Test
	void findManagertest()
	{
		assertNotNull(dao.findManager(2));
	}
	@Test
	void deleteManagerTest() {
		
		assertTrue(dao.deleteManager(2));
	}
}

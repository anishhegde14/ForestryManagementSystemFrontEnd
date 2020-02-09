package com.capgemini.stockmanagement.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.stockmanagement.dto.LoginBean;
import com.capgemini.stockmanagement.dto.ManagerBean;

@SpringBootTest
public class ManagerDaoImplTest {

	
	@Autowired
	ManagerDao dao;
	
	
	
//	@Test
//	void addManager()
//	{
//		ManagerBean bean=new ManagerBean();
//		bean.setId(87);
//		bean.setAddress("jsjjd");
//		bean.setCompanyName("sad");
//		bean.setEmailId("adsd");
//		bean.setManagerName("ada");
//		
//		assertTrue(dao.addManager(bean));
//	}
//	
	
	@Test
	void updateManager() {
		
		ManagerBean bean=new ManagerBean();
		bean.setId(87);
		bean.setAddress("jsjjd");
		bean.setCompanyName("happy");
		bean.setEmailId("adsd");
		bean.setManagerName("aada");
		
		assertTrue(dao.updateManager(bean));
		
	}
//	@Test
//	void findManagertest()
//	{
//		assertNotNull(dao.findManager(8));
//	}
//	@Test
//	void deleteManagerTest() {
//		
//		assertTrue(dao.deleteManager(87));
//	}


}

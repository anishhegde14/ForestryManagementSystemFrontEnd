package com.capgemini.stockmanagement.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.stockmanagement.dto.LoginBean;

@SpringBootTest
public class LoginDaoImplTest {

	
	@Autowired
	LoginDao dao;
	
	
	
//	@Test
//	void addLogin()
//	{
//		LoginBean bean=new LoginBean();
//		bean.setEmailId("anishhegde14@gmail.com");
//		bean.setPassword("12345");
//		bean.setRole(2);
//		assertTrue(dao.add(bean));
//	}
	@Test
	void deleteLogin() {
		assertTrue(dao.delete(2));
	}
}

package com.capgemini.stockmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.stockmanagement.dto.BeanResponse;
import com.capgemini.stockmanagement.dto.LoginBean;
import com.capgemini.stockmanagement.service.LoginServices;
@CrossOrigin()
@RestController
public class LoginController {

	
	@Autowired
	LoginServices services;
	
	@PostMapping(path = "/login" , produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
	public BeanResponse authentication(@RequestBody LoginBean bean) {
		BeanResponse beanResponse=new BeanResponse();
		
		try {
			if(services.auth(bean)==1)
			{
				beanResponse.setStatusCode(200);
				beanResponse.setMessage("Admin");
				beanResponse.setDescription("Credentials are valid");
			}
			else if(services.auth(bean)==1)
			{
				beanResponse.setStatusCode(200);
				beanResponse.setMessage("Manager");
				beanResponse.setDescription("Credentials are valid");
			}
			else if(services.auth(bean)==1)
			{
				beanResponse.setStatusCode(200);
				beanResponse.setMessage("Investor");
				beanResponse.setDescription("Credentials are valid");
			}
			return beanResponse;
			}
		catch (Exception e) {

			beanResponse.setStatusCode(500);
			beanResponse.setMessage(e.getMessage());
			return beanResponse;
		}
	}
	
	

	
}

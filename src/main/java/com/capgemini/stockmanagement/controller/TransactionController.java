package com.capgemini.stockmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.stockmanagement.dto.BeanResponse;
import com.capgemini.stockmanagement.dto.StockInfoBean;
import com.capgemini.stockmanagement.dto.TransactionDetails;
import com.capgemini.stockmanagement.service.TransactionServices;

@RestController
public class TransactionController {

	
	@Autowired
	TransactionServices services;
	
	@PostMapping(path = "/buyStocks/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public BeanResponse buyStocks(@RequestBody StockInfoBean bean,@PathVariable("id") int id) {
		BeanResponse beanResponse=new BeanResponse();
		try {
			if(services.addTransaction(bean, id)) {
				beanResponse.setStatusCode(200);
				beanResponse.setMessage("Stock Bought");
				beanResponse.setDescription("Stocks Added to table");
			}else
			{
				beanResponse.setStatusCode(400);
				beanResponse.setMessage("Stock Couldn't Be Bought");
				beanResponse.setDescription("Stocks Couldn't be Added to table");
			}
			return beanResponse;
		}catch (Exception e) {
			beanResponse.setStatusCode(500);
			beanResponse.setMessage("Stock Couldn't Be Bought");
			beanResponse.setDescription("Stocks Couldn't be Added to table");
		return beanResponse;
		
		}
		
		
	}
	@PostMapping(path = "/sellStocks", produces = MediaType.APPLICATION_JSON_VALUE)
	public BeanResponse sellStocks(@RequestBody TransactionDetails bean) {
		BeanResponse beanResponse=new BeanResponse();
		try {
			if(services.deleteTransaction(bean)) { 
				beanResponse.setStatusCode(200);
				beanResponse.setMessage("Stock Sold");
				beanResponse.setDescription("Stocks Added to table");
			}else
			{
				beanResponse.setStatusCode(400);
				beanResponse.setMessage("Stock Couldn't Be Bought");
				beanResponse.setDescription("Stocks Couldn't be Added to table");
			}
			return beanResponse;
		}catch (Exception e) {
			beanResponse.setStatusCode(500);
			beanResponse.setMessage("Stock Couldn't Be Bought");
			beanResponse.setDescription("Stocks Couldn't be Added to table");
		return beanResponse;
		
		}
		
		
	}
}

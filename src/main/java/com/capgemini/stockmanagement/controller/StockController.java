package com.capgemini.stockmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.stockmanagement.dto.BeanResponse;
import com.capgemini.stockmanagement.dto.StockInfoBean;
import com.capgemini.stockmanagement.service.StockServices;
@CrossOrigin(origins ="*",allowedHeaders = "*",allowCredentials = "true" )
@RestController
public class StockController {

	
	@Autowired
	StockServices services;
	
	@PostMapping(path = "/addStock",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public BeanResponse addStock(@RequestBody StockInfoBean bean) {
		
		BeanResponse beanResponse=new BeanResponse();
		try {
				if(services.addStock(bean)) {
					beanResponse.setStatusCode(200);
					beanResponse.setMessage("Stock Added");
					beanResponse.setDescription("Stocks Added to table");
				}else
				{
					beanResponse.setStatusCode(400);
					beanResponse.setMessage("Stocks Couldnt Be added");
					beanResponse.setDescription("Something Went Wrong");
				}
				
			return beanResponse;
		}catch (Exception e) {
			beanResponse.setStatusCode(500);
			beanResponse.setMessage(e.getMessage());
			beanResponse.setDescription("Please Check The Message");
			return beanResponse;
		}
	}
	
	@PostMapping(path = "/updateStock",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public BeanResponse updateStock(@RequestBody StockInfoBean bean) {
		
		BeanResponse beanResponse=new BeanResponse();
		try {
				if(services.updateStock(bean)) {
					beanResponse.setStatusCode(200);
					beanResponse.setMessage("Stock updated");
					beanResponse.setDescription("Stocks updated in table");
				}else
				{
					beanResponse.setStatusCode(400);
					beanResponse.setMessage("Stocks Couldnt Be updated");
					beanResponse.setDescription("Something Went Wrong");
				}
				
			return beanResponse;
		}catch (Exception e) {
			beanResponse.setStatusCode(500);
			beanResponse.setMessage(e.getMessage());
			beanResponse.setDescription("Please Check The Message");
			return beanResponse;
		}
	}
	
	@DeleteMapping(path = "/deleteStock/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public BeanResponse deleteStock(@PathVariable("id") int id) {
		
		BeanResponse beanResponse=new BeanResponse();
		try {
				if(services.deleteStock(id)) {
					beanResponse.setStatusCode(200);
					beanResponse.setMessage("Stock deleted");
					beanResponse.setDescription("Stocks deleted in table");
				}else
				{
					beanResponse.setStatusCode(400);
					beanResponse.setMessage("Stocks Couldnt Be deleted");
					beanResponse.setDescription("Something Went Wrong");
				}
				
			return beanResponse;
		}catch (Exception e) {
			beanResponse.setStatusCode(500);
			beanResponse.setMessage(e.getMessage());
			beanResponse.setDescription("Please Check The Message");
			return beanResponse;
		}
	}
	
	@GetMapping(path = "/getAllStocks", produces = MediaType.APPLICATION_JSON_VALUE)
	public BeanResponse getAllStock() {
		
		BeanResponse beanResponse=new BeanResponse();
		try {
			List<StockInfoBean> bean=services.findAllStocks();
				if(!bean.isEmpty()) {
					beanResponse.setStatusCode(200);
					beanResponse.setMessage("Stock found");
					beanResponse.setDescription("Stocks displayed in table");
					beanResponse.setStockList(bean);
				}else
				{
					beanResponse.setStatusCode(400);
					beanResponse.setMessage("Stocks Couldnt Be found");
					beanResponse.setDescription("Something Went Wrong");
				}
				
			return beanResponse;
		}catch (Exception e) {
			beanResponse.setStatusCode(500);
			beanResponse.setMessage(e.getMessage());
			beanResponse.setDescription("Please Check The Message");
			return beanResponse;
		}
	}
}

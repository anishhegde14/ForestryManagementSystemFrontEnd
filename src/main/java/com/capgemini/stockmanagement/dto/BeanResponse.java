package com.capgemini.stockmanagement.dto;

import java.util.List;

public class BeanResponse {

	
	private int statusCode;
	private String message;
	private String description;
	private LoginBean bean;
	private List<ManagerBean> managerList;
	private List<StockInfoBean> stockList;
	public List<ManagerBean> getManagerList() {
		return managerList;
	}
	public void setManagerList(List<ManagerBean> managerList) {
		this.managerList = managerList;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public List<StockInfoBean> getStockList() {
		return stockList;
	}
	public void setStockList(List<StockInfoBean> stockList) {
		this.stockList = stockList;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LoginBean getBean() {
		return bean;
	}
	public void setBean(LoginBean bean) {
		this.bean = bean;
	}
	
}

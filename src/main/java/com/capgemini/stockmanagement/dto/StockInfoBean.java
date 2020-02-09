package com.capgemini.stockmanagement.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Stock")
public class StockInfoBean {
	@Id
	@GeneratedValue
	@Column
	private int id;
	@Column
	private int companyId;
	@Column
	private String companyName;
	@Column
	private double highPrice;
	@Column
	private double lowPrice;
	@Column
	private double currentPrice;
	@Column
	private double volume;
	@Column
	private Date date;
	@Column
	private int availableStocks;
	@Column
	private int noOfStocks;
	public int getNoOfStocks() {
		return noOfStocks;
	}
	public void setNoOfStocks(int noOfStocks) {
		this.noOfStocks = noOfStocks;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public double getHighPrice() {
		return highPrice;
	}
	public void setHighPrice(double highPrice) {
		this.highPrice = highPrice;
	}
	public double getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(double lowPrice) {
		this.lowPrice = lowPrice;
	}
	public double getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getAvailableStocks() {
		return availableStocks;
	}
	public void setAvailableStocks(int availableStocks) {
		this.availableStocks = availableStocks;
	}
	
	
	
	
}

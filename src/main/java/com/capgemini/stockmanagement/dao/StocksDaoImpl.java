package com.capgemini.stockmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.stockmanagement.dto.StockInfoBean;
import com.capgemini.stockmanagement.exception.LoginException;
import com.capgemini.stockmanagement.exception.StockException;
@Repository
public class StocksDaoImpl implements StocksDao{

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	@Override
	public boolean addStock(StockInfoBean bean) {
		try{
			EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(bean);
		entityTransaction.commit();
		entityManager.close();
		return true;
		}
		catch (Exception e) {
			throw new StockException("Stock Already Exists!!!");
		}
	}

	@Override
	public boolean deleteStock(int id) {
		try{
			EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		String jpql="delete from LoginBean where id=:id";
		Query query=entityManager.createQuery(jpql);
		query.setParameter("id", id);
		int i=query.executeUpdate();
		entityTransaction.commit();
		entityManager.close();
		if(i!=1) {
			return false;
		}
		else
		{
			return true;
		}
		
		}
		catch (Exception e) {
			throw new StockException("Stock Id Dosent exist");
		}
	}

	@Override
	public boolean updateStock(StockInfoBean bean) {
		try{
			EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		StockInfoBean bean2=entityManager.find(StockInfoBean.class, bean.getCompanyId());
		bean2.setCompanyName(bean.getCompanyName());
		bean2.setCurrentPrice(bean.getCurrentPrice());
		bean2.setDate(bean2.getDate());
		bean2.setHighPrice(bean.getHighPrice());
		bean2.setLowPrice(bean.getLowPrice());
		bean2.setVolume(bean.getVolume());
		bean2.setAvailableStocks(bean.getAvailableStocks());
		entityTransaction.commit();
		entityManager.close();
		
		return true;
	}
		catch (Exception e) {
			throw new StockException("Invalid Credentials");
		}

		
		
	}

	@Override
	public StockInfoBean findStock(int beanId) {
		try {

			EntityManager entityManager=entityManagerFactory.createEntityManager();
			StockInfoBean bean=entityManager.find(StockInfoBean.class, beanId);
			entityManager.close();
			return bean;
			
		}catch (Exception e) {
			return new StockInfoBean();
		}
	}

	@Override
	public StockInfoBean findStockByName(String name) {

		try {

			EntityManager entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from StockInfoBean where companyName=:companyName";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("companyName", name);
			StockInfoBean bean = (StockInfoBean) query.getSingleResult();
			return bean;
		} catch (Exception e) {
			return new StockInfoBean();
		}
	}

	@Override
	public List<StockInfoBean> findAllStocks() {

		try {

			EntityManager entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from StockInfoBean";
			Query query = entityManager.createQuery(jpql);
			List<StockInfoBean> bean = query.getResultList();
			return bean;
		} catch (Exception e) {
			throw new LoginException("Stock Not Found");
		}
	}

	@Override
	public StockInfoBean findStockByCompanyId(int id) {

		try {

			EntityManager entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from StockInfoBean where companyId=:companyId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("companyId", id);
			StockInfoBean bean = (StockInfoBean) query.getSingleResult();
			return bean;
		} catch (Exception e) {
			throw new LoginException("Company Id Not Found");
		}
	}
	}



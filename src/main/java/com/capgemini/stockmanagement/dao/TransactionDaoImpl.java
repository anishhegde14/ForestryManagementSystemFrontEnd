package com.capgemini.stockmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.capgemini.stockmanagement.dto.TransactionBean;
import com.capgemini.stockmanagement.exception.LoginException;
import com.capgemini.stockmanagement.exception.StockException;
@Service
public class TransactionDaoImpl implements TransactionDao{

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	
	
	@Override
	public boolean addTransaction(TransactionBean bean) {
		try {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(bean);
		entityTransaction.commit();
		entityManager.close();
		return true;}
		catch (Exception e) {
			throw new StockException("Transaction Already Exists!!!");
		}
	}
		


	@Override
	public boolean deleteTransaction(int id) {
		try{
			EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		String jpql="delete from TransactionBean where transactionId=:id";
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
			throw new StockException("Tra Id Dosent exist");
		}
	
	}

	@Override
	public List<TransactionBean> getAllTranscation() {
		try {

			EntityManager entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from TransactionBean";
			Query query = entityManager.createQuery(jpql);
			List<TransactionBean> bean = query.getResultList();
			entityManager.close();
			return bean;
		} catch (Exception e) {
			throw new LoginException("User Id Not Found");
		}
		}

	@Override
	public List<TransactionBean> getAllTransactionOfCompany(int id) {
		try {

			EntityManager entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from TransactionBean where companyId=:id";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("id", id);
			List<TransactionBean> bean = query.getResultList();
			entityManager.close();
			return bean;
		} catch (Exception e) {
			throw new LoginException("Company Id Not Found");
		}
		}	

	@Override
	public List<TransactionBean> getAllTransactionOfInvestor(int id) {

		try {

			EntityManager entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from TransactionBean where investorId=:id";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("id", id);
			List<TransactionBean> bean = query.getResultList();
			entityManager.close();
			return bean;
		} catch (Exception e) {
			throw new LoginException("Investor Id Not Found");
		}
	}



	@Override
	public TransactionBean findTransaction(int id) {
		try {

			EntityManager entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from TransactionBean where transactionId=:id";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("id", id);
			TransactionBean bean = (TransactionBean) query.getSingleResult();
			entityManager.close();
			return bean;
		} catch (Exception e) {
			throw new LoginException("Investor Id Not Found");
		}
	}

}

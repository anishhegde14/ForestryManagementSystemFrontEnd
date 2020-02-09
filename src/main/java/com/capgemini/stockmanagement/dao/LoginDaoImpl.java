package com.capgemini.stockmanagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.stockmanagement.dto.LoginBean;
import com.capgemini.stockmanagement.exception.LoginException;
@Repository
public class LoginDaoImpl implements LoginDao{

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	
	@Override
	public LoginBean findCredentials(LoginBean bean) {
		try {
			
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			String jpql="from LoginBean where emailId=:emailId";
			Query query=entityManager.createQuery(jpql);
			query.setParameter("emailId", bean.getEmailId());
			LoginBean bean2=(LoginBean) query.getSingleResult();
			return bean2;
			}
		catch(Exception e)
		{
			throw new LoginException("Email Id Not Found");
		}
		
	}

	@Override
	public boolean add(LoginBean bean) {
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
			throw new LoginException("Email Id Already Exists");
		}
		
	}

	@Override
	public boolean delete(int id) {
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
			throw new LoginException("Email Id Dosent exist");
		}
	}

	@Override
	public boolean update(LoginBean bean) {
		try{
			EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		LoginBean bean2=entityManager.find(LoginBean.class, bean.getId());
		bean2.setPassword(bean.getPassword());
		entityTransaction.commit();
		entityManager.close();
		
		return true;
	}
		catch (Exception e) {
			throw new LoginException("Invalid Credentials");
		}

}
	
	public LoginBean findAccount(int id) {
try {
			
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			LoginBean bean=entityManager.find(LoginBean.class, id);
			entityManager.close();
			return bean;
			}
		catch(Exception e)
		{
			throw new LoginException("Email Id Not Found");
		}
	}
}